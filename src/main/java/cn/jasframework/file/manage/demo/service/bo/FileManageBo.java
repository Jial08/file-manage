//package cn.jasframework.file.manage.demo.service.bo;
//
//import java.sql.Blob;
//
//import cn.jasframework.file.manage.common.commonUtil;
//import cn.jasframework.file.manage.demo.domain.entity.FileBlock;
//import cn.jasframework.file.manage.demo.domain.entity.FileInServer;
//import cn.jasframework.file.manage.demo.domain.entity.TempFileInServer;
//
//public class FileManageBo {
//	private static final long serialVersionUID = 1L;
//	private String objectId;
//	private String fileName; 	 // 文件名
//	private long fileSize;	 // 文件大小，单位KB
//	private int total;			 // 文件分块总片数
//	private int index;			 // 当前是第几片
//	private String md5;			 // 文件MD5
//	private String fileType; 	 // 文件格式
//	private String fileSavePath; // 文件存储路径
//	private String tempFilePath; // 分块文件临时存储路径
//	private Blob fileBlob;		 // 文件以blob存储到数据库 	
//	private String createUser; 	 // 文件存储人
//	private String createTime; 	 // 文件存储时间
//	private String modifyUser; 	 // 文件修改人
//	private String modifyTime; 	 // 文件修改时间
//	private String active; 		 // 删除标识：1存在，0删除
//	// 自带参数
//	private String chunks;
//	private String chunk;
//	private String size;
//	private String name;
//	private String type;
//	private String id;
//	private String ext;
//	public String getObjectId() {
//		return objectId;
//	}
//	public void setObjectId(String objectId) {
//		this.objectId = objectId;
//	}
//	public String getFileName() {
//		return fileName;
//	}
//	public void setFileName(String fileName) {
//		this.fileName = fileName;
//	}
//	public long getFileSize() {
//		return fileSize;
//	}
//	public void setFileSize(long fileSize) {
//		this.fileSize = fileSize;
//	}
//	public int getTotal() {
//		return total;
//	}
//	public void setTotal(int total) {
//		this.total = total;
//	}
//	public int getIndex() {
//		return index;
//	}
//	public void setIndex(int index) {
//		this.index = index;
//	}
//	public String getMd5() {
//		return md5;
//	}
//	public void setMd5(String md5) {
//		this.md5 = md5;
//	}
//	public String getFileType() {
//		return fileType;
//	}
//	public void setFileType(String fileType) {
//		this.fileType = fileType;
//	}
//	public String getFileSavePath() {
//		return fileSavePath;
//	}
//	public void setFileSavePath(String fileSavePath) {
//		this.fileSavePath = fileSavePath;
//	}
//	public String getTempFilePath() {
//		return tempFilePath;
//	}
//	public void setTempFilePath(String tempFilePath) {
//		this.tempFilePath = tempFilePath;
//	}
//	public Blob getFileBlob() {
//		return fileBlob;
//	}
//	public void setFileBlob(Blob fileBlob) {
//		this.fileBlob = fileBlob;
//	}
//	public String getCreateUser() {
//		return createUser;
//	}
//	public void setCreateUser(String createUser) {
//		this.createUser = createUser;
//	}
//	public String getCreateTime() {
//		return createTime;
//	}
//	public void setCreateTime(String createTime) {
//		this.createTime = createTime;
//	}
//	public String getModifyUser() {
//		return modifyUser;
//	}
//	public void setModifyUser(String modifyUser) {
//		this.modifyUser = modifyUser;
//	}
//	public String getModifyTime() {
//		return modifyTime;
//	}
//	public void setModifyTime(String modifyTime) {
//		this.modifyTime = modifyTime;
//	}
//	public String getActive() {
//		return active;
//	}
//	public void setActive(String active) {
//		this.active = active;
//	}
//	public String getChunks() {
//		return chunks;
//	}
//	public void setChunks(String chunks) {
//		this.chunks = chunks;
//	}
//	public String getChunk() {
//		return chunk;
//	}
//	public void setChunk(String chunk) {
//		this.chunk = chunk;
//	}
//	public String getSize() {
//		return size;
//	}
//	public void setSize(String size) {
//		this.size = size;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getType() {
//		return type;
//	}
//	public void setType(String type) {
//		this.type = type;
//	}
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public String getExt() {
//		return ext;
//	}
//	public void setExt(String ext) {
//		this.ext = ext;
//	}
//	/**
//	 * <p>功能描述：bo转为FileInServer基本类型。</p>
//	 * <p>贾亮 </p>	
//	 * @param bo
//	 * @return
//	 * @since JDK1.8。
//	 * <p>创建日期:2017年4月17日 下午4:53:09。</p>
//	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
//	 */
//	public static FileInServer converToFileInserver(FileManageBo bo) {
//		FileInServer entity = new FileInServer();
//		entity.setObjectId(bo.getObjectId());
//		entity.setMd5(bo.getMd5());
//		entity.setFileName(bo.getFileName());
//		if (bo.getFileSavePath() != null) {
//			entity.setFileSize(commonUtil.handleFileSize(bo.getFileSize()));
//		}
//		entity.setFileType(bo.getFileType());
//		entity.setFileSavePath(bo.getFileSavePath());
//		entity.setCreateUser(bo.getCreateUser());
//		if (bo.getCreateTime() != null && !"".equals(bo.getCreateTime())) {
//			entity.setCreateTime(commonUtil.getDateFromDateString(bo.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
//		}
//		entity.setModifyUser(bo.getModifyUser());
//		if (bo.getModifyTime() != null && !"".equals(bo.getModifyTime())) {
//			entity.setModifyTime(commonUtil.getDateFromDateString(bo.getModifyTime(), "yyyy-MM-dd HH:mm:ss"));
//		}
//		if (bo.getActive() != null && !"".equals(bo.getActive())) {
//			entity.setActive(Integer.valueOf(bo.getActive()));
//		}
//		return entity;
//	}
//	
//	/**
//	 * <p>功能描述：bo转为FileInDb基本类型。</p>
//	 * <p>贾亮 </p>	
//	 * @param bo
//	 * @return
//	 * @since JDK1.8。
//	 * <p>创建日期:2017年4月17日 下午4:53:09。</p>
//	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
//	 */
//	public static FileBlock converToFileInDb(FileManageBo bo) {
//		FileBlock entity = new FileBlock();
//		entity.setObjectId(bo.getObjectId());
//		entity.setMd5(bo.getMd5());
//		entity.setFileName(bo.getFileName());
//		if (bo.getFileSavePath() != null) {
//			entity.setFileSize(commonUtil.handleFileSize(bo.getFileSize()));
//		}
//		entity.setFileType(bo.getFileType());
//		entity.setFileBlob(bo.getFileBlob());
//		entity.setCreateUser(bo.getCreateUser());
//		if (bo.getCreateTime() != null && !"".equals(bo.getCreateTime())) {
//			entity.setCreateTime(commonUtil.getDateFromDateString(bo.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
//		}
//		entity.setModifyUser(bo.getModifyUser());
//		if (bo.getModifyTime() != null && !"".equals(bo.getModifyTime())) {
//			entity.setModifyTime(commonUtil.getDateFromDateString(bo.getModifyTime(), "yyyy-MM-dd HH:mm:ss"));
//		}
//		if (bo.getActive() != null && !"".equals(bo.getActive())) {
//			entity.setActive(Integer.valueOf(bo.getActive()));
//		}
//		return entity;
//	}
//	
//	/**
//	 * <p>功能描述：bo转为TempFileInServer基本类型。</p>
//	 * <p>贾亮 </p>	
//	 * @param bo
//	 * @return
//	 * @since JDK1.8。
//	 * <p>创建日期:2017年4月22日 下午4:55:09。</p>
//	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
//	 */
//	public static TempFileInServer converToTempFileInServer(FileManageBo bo) {
//		TempFileInServer entity = new TempFileInServer();
//		entity.setMd5(bo.getMd5());
//		entity.setTempFilePath(bo.getTempFilePath());
//		entity.setTotal(bo.getTotal());
//		entity.setIndex(bo.getIndex());
//		return entity;
//	}
//
//}
