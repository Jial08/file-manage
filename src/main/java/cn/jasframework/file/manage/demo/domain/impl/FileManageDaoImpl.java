package cn.jasframework.file.manage.demo.domain.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.jasframework.file.manage.demo.domain.IFileManageDao;
import cn.jasframework.file.manage.demo.domain.entity.FileBlock;
import cn.jasframework.file.manage.demo.domain.entity.TempFileInServer;

@Repository
public class FileManageDaoImpl implements IFileManageDao {
	@Resource
    private JdbcTemplate jdbcTemplate;
	
	/**
	 * <p>功能描述：查询分块是否已上传。</p>
	 * <p>Jial </p>	
	 * @param entity
	 * @return
	 * @since JDK1.8。
	 * <p>创建日期:2017年5月5日 下午7:40:09。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public int checkChunk(FileBlock entity) {
		Object[] args = { entity.getFileMd5(), entity.getChunk() };
		String sql = "SELECT COUNT(0) FROM file_block t WHERE t.file_md5=? AND t.chunk=?";
		List list = jdbcTemplate.queryForList(sql, args);
		return list.size();
	}
	
	/**
	 * <p>功能描述：将上传成功的分块儿文件信息保存到数据库。</p>
	 * <p>Jial </p>	
	 * @param entity
	 * @return
	 * @since JDK1.8。
	 * <p>创建日期:2017年5月5日 下午7:53:58。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public int recordChunk(FileBlock entity) {
		Object[] args = { entity.getFileMd5(), entity.getChunk() };
		String sql = "INSERT INTO file_block VALUES (?,?)";
		return jdbcTemplate.update(sql, args);
	}
	
	public List<TempFileInServer> queryTempServerPath(String md5) {
		Object[] args = { md5 };
		String sql = "SELECT t.temp_file_path FROM temp_file_in_server t WHERE t.md5=? ORDER BY t.index";
		return jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<TempFileInServer>(TempFileInServer.class));
	}
	
	
	

}
