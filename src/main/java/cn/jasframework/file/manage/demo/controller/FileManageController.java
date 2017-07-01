package cn.jasframework.file.manage.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.jasframework.file.manage.common.commonUtil;
import cn.jasframework.file.manage.demo.domain.entity.FileBlock;
import cn.jasframework.file.manage.demo.domain.entity.FileInServer;
import cn.jasframework.file.manage.demo.service.IFileManageService;
import cn.jasframework.file.manage.demo.service.bo.FileChunkBo;

@RestController
@RequestMapping(value = "/filemanage")
public class FileManageController {
	@Resource
	private IFileManageService fileManageService;
	
	private static final Logger log = LoggerFactory.getLogger(FileManageController.class);
	
	/**
	 * <p>功能描述：检查文件是否已上传，用于秒传。</p>
	 * <p>Jial </p>	
	 * @param entity
	 * @return
	 * @since JDK1.8。
	 * <p>创建日期:2017年7月1日 下午3:37:10。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	@PostMapping(value = "/checkFile")
	public Object checkFile(@RequestBody FileInServer entity) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			boolean bl = fileManageService.checkFile(entity);
			result.put("success", 1);
			result.put("result", bl);
		} catch (Exception e) {
			log.error("校验文件是否已上传出错", e);
			result.put("success", -1);
			result.put("result", false);
		}
		return result;
	}
	
	/**
	 * <p>功能描述：检查分块是否已上传，用于断点续传。</p>
	 * <p>Jial </p>	
	 * @param bo
	 * @return
	 * @since JDK1.8。
	 * <p>创建日期:2017年5月5日 下午7:12:26。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	@GetMapping(value = "/checkChunk")
	public Object checkChunk(FileBlock entity) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String fileId = fileManageService.checkChunk(entity);
			if (commonUtil.hasText(fileId)) {
				result.put("success", 1);
				result.put("fileId", fileId);
			} else {
				result.put("success", -1);
			}
		} catch (Exception e) {
			log.error("检查分块是否已上传失败", e);
			result.put("success", -1);
			result.put("msg", "检查分块是否已上传失败");
		}
		return result;
	}
	
	/**
	 * <p>功能描述：上传文件。</p>
	 * <p>Jial </p>	
	 * @param file
	 * @param bo
	 * @return
	 * @since JDK1.8。
	 * <p>创建日期:2017年5月5日 下午7:13:07。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	@PostMapping(value = "/uploadFile")
	public Object uploadFile(MultipartFile file, FileChunkBo bo) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String filePath = fileManageService.recordChunk(file, bo);
			if (commonUtil.hasText(filePath)) {
				result.put("success", 1);
			} else {
				result.put("success", -1);
			}
		} catch (Exception e) {
			log.error("文件上传出错", e);
			result.put("success", -1);
		}
		return result;
	}
	
	/**
	 * <p>功能描述：上传成功后保存文件信息，删除分块儿信息。</p>
	 * <p>Jial </p>	
	 * @param entity
	 * @return
	 * @since JDK1.8。
	 * <p>创建日期:2017年6月30日 下午3:02:15。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	@PostMapping(value = "/saveFileInfo")
	public Object saveFileInfo(@RequestBody FileInServer entity) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			boolean bl = fileManageService.saveFileInfo(entity);
			result.put("success", 1);
			result.put("result", bl);
			return result;
		} catch (Exception e) {
			log.error("保存文件信息出错", e);
			result.put("success", -1);
			result.put("result", false);
			return result;
		}
	}

}
