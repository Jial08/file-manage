package cn.jasframework.file.manage.demo.domain;

import cn.jasframework.file.manage.demo.domain.entity.FileBlock;
import cn.jasframework.file.manage.demo.domain.entity.FileInServer;

public interface IFileManageDao {
	
	/**
	 * <p>功能描述：获取文件存储信息，用于秒传。</p>
	 * <p>Jial </p>	
	 * @param entity
	 * @return
	 * @since JDK1.8。
	 * <p>创建日期:2017年7月1日 下午3:39:38。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public FileInServer checkFile(FileInServer entity);
	
	/**
	 * <p>功能描述：检查分块儿文件是否已上传。</p>
	 * <p>Jial </p>	
	 * @param entity
	 * @return
	 * @since JDK1.8。
	 * <p>创建日期:2017年6月30日 下午3:35:52。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public String checkChunk(FileBlock entity);
	
	/**
	 * <p>功能描述：上传文件。</p>
	 * <p>Jial </p>	
	 * @param entity
	 * @return
	 * @since JDK1.8。
	 * <p>创建日期:2017年6月30日 下午3:36:09。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public int recordChunk(FileBlock entity);
	
	/**
	 * <p>功能描述：存储文件信息。</p>
	 * <p>Jial </p>	
	 * @param entity
	 * @return
	 * @since JDK1.8。
	 * <p>创建日期:2017年6月30日 下午3:36:31。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public int saveFileInfo(FileInServer entity);
	
	/**
	 * <p>功能描述：文件保存成功后删除分块儿信息。</p>
	 * <p>Jial </p>	
	 * @param fileId
	 * @return
	 * @since JDK1.8。
	 * <p>创建日期:2017年7月1日 下午7:14:20。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public int deleteChunkInfo(String fileId);

}
