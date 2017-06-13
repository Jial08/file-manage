package cn.jasframework.file.manage.demo.service.bo;

public class FileChunkBo {
	private static final long serialVersionUID = 1L;

	private String fileMd5; // 分块儿文件MD5
	private int chunk;		// 分块儿文件下标
	private int chunks;		// 总分块儿数
	private long startSize;	// 分块儿文件开始位置
	private long endtSize;	// 分块儿文件结束位置
	private long total;		// 文件长度
	private String ifExist;// 分块儿文件是否存在
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
	public long getStartSize() {
		return startSize;
	}
	public void setStartSize(long startSize) {
		this.startSize = startSize;
	}
	public long getEndtSize() {
		return endtSize;
	}
	public void setEndtSize(long endtSize) {
		this.endtSize = endtSize;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public String getIfExist() {
		return ifExist;
	}
	public void setIfExist(String ifExist) {
		this.ifExist = ifExist;
	}
	

}
