package cn.jasframework.file.manage.demo.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import cn.jasframework.file.manage.demo.domain.entity.FileBlock;
import cn.jasframework.file.manage.demo.domain.entity.FileInServer;
import cn.jasframework.file.manage.demo.service.bo.FileChunkBo;

public interface IFileManageService {
	
	/**
	 * <p>功能描述：检查文件是否已上传，用于秒传。</p>
	 * <p>Jial </p>	
	 * @param entity
	 * @return
	 * @since JDK1.8。
	 * <p>创建日期:2017年7月1日 下午3:38:11。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public boolean checkFile(FileInServer entity);
	
	/**
	 * <p>功能描述：检查分块儿文件是否已上传。</p>
	 * <p>Jial </p>	
	 * @param entity
	 * @return
	 * @since JDK1.8。
	 * <p>创建日期:2017年6月30日 下午3:33:22。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public String checkChunk(FileBlock entity);
	
	/**
	 * <p>功能描述：文件上传。</p>
	 * <p>Jial </p>	
	 * @param file
	 * @param bo
	 * @return
	 * @throws IOException
	 * @since JDK1.8。
	 * <p>创建日期:2017年6月30日 下午3:33:26。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public String recordChunk(MultipartFile file, FileChunkBo bo) throws IOException;
	
	/**
	 * <p>功能描述：存储文件信息。</p>
	 * <p>Jial </p>	
	 * @param entity
	 * @return
	 * @since JDK1.8。
	 * <p>创建日期:2017年6月30日 下午3:35:01。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public boolean saveFileInfo(FileInServer entity);

}
