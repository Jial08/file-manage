package cn.jasframework.file.manage.demo.domain.entity;

public class FileBlock {
	private static final long serialVersionUID = 1L;
	
	private String fileId;	// 分块儿对应文件id
	private String fileMd5;	// 分块儿文件MD5
	private int chunk;		// 分块儿文件下标
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getFileMd5() {
		return fileMd5;
	}
	public void setFileMd5(String fileMd5) {
		this.fileMd5 = fileMd5;
	}
	public int getChunk() {
		return chunk;
	}
	public void setChunk(int chunk) {
		this.chunk = chunk;
	}

}
