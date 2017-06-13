package cn.jasframework.file.manage.demo.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.jasframework.file.manage.demo.domain.IFileManageDao;
import cn.jasframework.file.manage.demo.domain.entity.FileBlock;
import cn.jasframework.file.manage.demo.service.IFileManageService;
import cn.jasframework.file.manage.demo.service.bo.FileChunkBo;

@Service
@Transactional(rollbackFor = Exception.class)
public class FileManageServiceImpl implements IFileManageService {
	@Resource
	private IFileManageDao fileManageDao;

	/**
	 * <p>功能描述：查询分块是否已上传。</p>
	 * <p>贾亮 </p>	
	 * @param entity
	 * @return
	 * @since JDK1.8。
	 * <p>创建日期:2017年5月5日 下午7:46:40。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public boolean checkChunk(FileBlock entity) {
		entity.setChunk(entity.getChunk() + 1);
		int num = fileManageDao.checkChunk(entity);
		if (num == 1) {
			return true;
		}
		return false;
	}

	/**
	 * <p>功能描述：分块儿文件保存到本地并记录分块儿信息。</p>
	 * <p>贾亮 </p>	
	 * @param file
	 * @param bo
	 * @return
	 * @throws IOException
	 * @since JDK1.8。
	 * <p>创建日期:2017年5月5日 下午8:01:07。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public boolean recordChunk(MultipartFile file, FileChunkBo bo) throws IOException {
		RandomAccessFile targetFile = new RandomAccessFile("D:/文件管理" + File.separator + file.getOriginalFilename(), "rw");
		if (targetFile.length() == 0) {
			targetFile.setLength(bo.getTotal());
		}
		targetFile.seek(bo.getStartSize());
		byte[] buff = file.getBytes();
		targetFile.write(buff);
		if (targetFile != null) {
			targetFile.close();
		}
		FileBlock entity = new FileBlock();
		entity.setFileMd5(bo.getFileMd5());
		entity.setChunk(bo.getChunk() + 1);
		int num = fileManageDao.recordChunk(entity);
		if (num == 1) {
			return true;
		}
		return false;
	}

}
