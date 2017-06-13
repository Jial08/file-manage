package cn.jasframework.file.manage.demo.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import cn.jasframework.file.manage.demo.domain.entity.FileBlock;
import cn.jasframework.file.manage.demo.service.bo.FileChunkBo;

public interface IFileManageService {
	public boolean checkChunk(FileBlock entity);
	public boolean recordChunk(MultipartFile file, FileChunkBo bo) throws IOException;

}
