package cn.jasframework.file.manage.changetree.domain.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.jasframework.file.manage.changetree.domain.ITreeDao;
/**
 * <p>类描述：树管理功能数据操作层接口实现。</p>
 * @author贾亮
 * @version v1.0.0.1。
 * @since JDK1.8。
 *<p>创建日期：2017年3月1日 上午9:37:50。</p>
 */
@Repository
public class TreeDaoImpl implements ITreeDao {

	@Resource
    private JdbcTemplate jdbcTemplate;
	
	// 树的改变改变数据库
	public void getChildss() {
		String sql = "SELECT DISTINCT t.object_id AS id FROM pipeline t WHERE t.active=1";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		List childList = new ArrayList();
		if (list.size() > 0) {
			for (Map<String, Object> map : list) {
				String objectid = (String) map.get("id");
				//如果objectid下没有子节点，那么该id所在节点即为最底层节点
				String sql1 = "SELECT t.object_id AS id FROM pipeline t WHERE t.active=1 AND t.parent_id='" + objectid + "'";
				List temp = jdbcTemplate.queryForList(sql1);
				if (temp.size() == 0) {
					childList.add(map);
				}
			}
		}
		changeTree(childList);
	}
	
	public void changeTree(List list) {
		String str = "";
		for(int i = 0; i < list.size(); i++) {
			Map map = (Map) list.get(i);
			String id = map.get("id").toString();
			str += "'" + id + "',";
		}
		str = str.substring(0, str.lastIndexOf(","));
		String sql1 = "UPDATE pipeline t SET t.tree_type='file' WHERE t.object_id IN (" + str + ")";
		String sql2 = "UPDATE pipeline t SET t.tree_type='default' WHERE t.object_id NOT IN (" + str + ")";
		int num1 = jdbcTemplate.update(sql1);
		int num2 = jdbcTemplate.update(sql2);
	}
	

}
