package cn.jasframework.file.manage.demo.domain.entity;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class FileInServer {
	private static final long serialVersionUID = 1L;
	private String objectId;
	private String md5;				// 文件刚开始5M的MD5
	private String fileName;		// 文件名
	private String fileSize;		// 文件大小，单位KB
	private String fileType;		// 文件格式
	private String filePath;		// 文件存储路径
	private Date lastModifiedDate;	// 文件最后修改日期
	private String createUser;		// 文件存储人
	private Date createTime;		// 文件存储时间
	private String modifyUser;		// 文件修改人
	private Date modifyTime;		// 文件修改时间
	private int active;				// 删除标识：1存在，0删除
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getModifyUser() {
		return modifyUser;
	}
	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}

}
