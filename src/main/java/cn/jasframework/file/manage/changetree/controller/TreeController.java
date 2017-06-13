package cn.jasframework.file.manage.changetree.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jasframework.file.manage.changetree.service.ITreeService;
/**
 * <p>类描述：管线树管理控制层。</p>
 * @author贾亮
 * @version v1.0.0.1。
 * @since JDK1.8。
 *<p>创建日期：2017年3月1日 上午9:06:01。</p>
 */
@RestController
@RequestMapping(value = "/pipemanage")
public class TreeController {
	private static final Logger log = LoggerFactory.getLogger(TreeController.class);
	
	@Resource
	private ITreeService treeService;
	
	// 树的改变改变数据库
	@GetMapping(value = "/changeTree")
	public Object changeTree() {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			treeService.getChildss();
		} catch (Exception e) {
			
		}
		return result;
	}

}
