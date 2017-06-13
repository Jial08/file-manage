package cn.jasframework.file.manage.demo.domain.entity;

public class TempFileInServer {
	private static final long serialVersionUID = 1L;
	private String md5;				// 文件MD5
	private String tempFilePath;	// 文件分块临时存放地址
	private int total;				// 文件分块数量
	private int index;				// 当前分块数
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public String getTempFilePath() {
		return tempFilePath;
	}
	public void setTempFilePath(String tempFilePath) {
		this.tempFilePath = tempFilePath;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	

}
