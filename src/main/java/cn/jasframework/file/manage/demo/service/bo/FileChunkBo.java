package cn.jasframework.file.manage.demo.service.bo;

public class FileChunkBo {
	private static final long serialVersionUID = 1L;

	private String fileMd5; // 分块儿文件MD5
	private int chunk;		// 分块儿文件下标
	private int chunks;		// 总分块儿数
	private long start;		// 分块儿文件开始位置
	private long end;		// 分块儿文件结束位置
	private long size;		// 文件长度
	private String fileType;// 文件类型
	private String filePath;// 文件存储路径
	private String uuid;	// 文件名(唯一标识)
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
	public int getChunks() {
		return chunks;
	}
	public void setChunks(int chunks) {
		this.chunks = chunks;
	}
	public long getStart() {
		return start;
	}
	public void setStart(long start) {
		this.start = start;
	}
	public long getEnd() {
		return end;
	}
	public void setEnd(long end) {
		this.end = end;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
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
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
