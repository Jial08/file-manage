package cn.jasframework.file.manage.demo.domain;

import cn.jasframework.file.manage.demo.domain.entity.FileBlock;

public interface IFileManageDao {
	public int checkChunk(FileBlock entity);
	public int recordChunk(FileBlock entity);

}
