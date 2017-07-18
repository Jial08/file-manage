package cn.jasframework.file.manage.demo.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.jasframework.file.manage.demo.domain.IFileManageDao;
import cn.jasframework.file.manage.demo.domain.entity.FileBlock;
import cn.jasframework.file.manage.demo.domain.entity.FileInServer;
import cn.jasframework.file.manage.demo.service.IFileManageService;
import cn.jasframework.file.manage.demo.service.bo.FileChunkBo;

@Service
@Transactional(rollbackFor = Exception.class)
public class FileManageServiceImpl implements IFileManageService {
	@Resource
	private IFileManageDao fileManageDao;
	@Value("${filePath}")
	private String filePath; // 文件存储路径

	@Override
	public boolean checkFile(FileInServer entity) {
		FileInServer fileInServer = fileManageDao.checkFile(entity);
		if (fileInServer != null) {
			// 如果存在文件则在数据库中新建一条记录
			String objectId = UUID.randomUUID().toString();
			fileInServer.setObjectId(objectId);
			fileInServer.setFileName(entity.getFileName());
			fileInServer.setActive(1);
			fileManageDao.saveFileInfo(fileInServer);
			return true;
		}
		return false;
	}
	
	/**
	 * <p>功能描述：查询分块是否已上传。</p>
	 * <p>Jial </p>	
	 * @param entity
	 * @return
	 * @since JDK1.8。
	 * <p>创建日期:2017年5月5日 下午7:46:40。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public String checkChunk(FileBlock entity) {
		entity.setChunk(entity.getChunk());
		return fileManageDao.checkChunk(entity);
	}

	/**
	 * <p>功能描述：分块儿文件保存到本地并记录分块儿信息。</p>
	 * <p>Jial </p>	
	 * @param file
	 * @param bo
	 * @return
	 * @throws IOException
	 * @since JDK1.8。
	 * <p>创建日期:2017年5月5日 下午8:01:07。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public String recordChunk(MultipartFile file, FileChunkBo bo) throws IOException {
		// 如果文件存储路径不存在则创建
		File path = new File(filePath);
		if (!path.exists()) {
			path.mkdirs();
		}
		String fileName = filePath + "/" + bo.getUuid() + "." + bo.getFileType();
		RandomAccessFile targetFile = new RandomAccessFile(fileName, "rw");
		if (targetFile.length() == 0) {
			targetFile.setLength(bo.getSize());
		}
		targetFile.seek(bo.getStart());
		byte[] buff = file.getBytes();
		targetFile.write(buff);
		if (targetFile != null) {
			targetFile.close();
		}
		// 存储分块儿信息，方便断点续传
		FileBlock entity = new FileBlock();
		entity.setFileMd5(bo.getFileMd5());
		entity.setChunk(bo.getChunk());
		entity.setFileId(bo.getUuid());
		int num = fileManageDao.recordChunk(entity);
		if (num == 1) {
			return fileName;
		}
		return "";
	}

	@Override
	public boolean saveFileInfo(FileInServer entity) {
		entity.setActive(1);
		String fileName = entity.getFileName();
		String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
		entity.setFileType(fileType);
		String savePath = filePath + "/" + entity.getObjectId() + "." + fileType;
		File file = new File(savePath);
		if (!file.exists()) {
			return false;
		}
		// 设置文件最后修改日期
		long time = entity.getLastModifiedDate().getTime();
		file.setLastModified(time);
		entity.setFilePath(savePath);
		int num = fileManageDao.saveFileInfo(entity);
		if (num > 0) {
			// 删除分块儿信息
			fileManageDao.deleteChunkInfo(entity.getObjectId());
			return true;
		} else {
			return false;
		}
	}

}
