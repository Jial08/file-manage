package cn.jasframework.file.manage.changetree.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jasframework.file.manage.changetree.domain.ITreeDao;
import cn.jasframework.file.manage.changetree.service.ITreeService;
/**
  *<p>类描述：用户管理功能服务层接口实现。</p>
  * @author JiaLiang                                      
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class TreeServiceImpl implements ITreeService {

	@Resource
	private ITreeDao treeDao;
	
	public void getChildss() {
		treeDao.getChildss();
	}
	
}

