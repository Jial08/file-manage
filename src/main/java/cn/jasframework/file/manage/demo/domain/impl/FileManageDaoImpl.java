package cn.jasframework.file.manage.demo.domain.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.jasframework.file.manage.demo.domain.IFileManageDao;
import cn.jasframework.file.manage.demo.domain.entity.FileBlock;
import cn.jasframework.file.manage.demo.domain.entity.FileInServer;

@Repository
public class FileManageDaoImpl implements IFileManageDao {
	@Resource
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public FileInServer checkFile(FileInServer entity) {
		Object[] args = { entity.getMd5(), entity.getLastModifiedDate() };
		String sql = "SELECT DISTINCT\n" +
				"	f.md5,\n" +
				"	f.file_size,\n" +
				"	f.file_type,\n" +
				"	f.last_modified_date,\n" +
				"	f.file_path\n" +
				"FROM\n" +
				"	file_in_server f\n" +
				"WHERE\n" +
				"	f.md5 =?\n" +
				"AND f.last_modified_date =?";
		// 下面的查询方法不能用，包括queryForMap，如果没有结果则会报异常
//		FileInServer fileInServer = jdbcTemplate.queryForObject(sql, args, FileInServer.class);
		List<FileInServer> list = jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<FileInServer>(FileInServer.class));
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * <p>功能描述：查询分块是否已上传。</p>
	 * <p>Jial </p>	
	 * @param entity
	 * @return
	 * @since JDK1.8。
	 * <p>创建日期:2017年5月5日 下午7:40:09。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public String checkChunk(FileBlock entity) {
		Object[] args = { entity.getFileMd5(), entity.getChunk() };
		String sql = "SELECT DISTINCT t.file_id FROM file_block t WHERE t.file_md5=? AND t.chunk=?";
		List list = jdbcTemplate.queryForList(sql, args);
		if (list.size() > 0) {
			Map map = (Map) list.get(0);
			return map.get("file_id").toString();
		}
		return null;
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
		Object[] args = { entity.getFile_id(), entity.getFileMd5(), entity.getChunk() };
		String sql = "INSERT INTO file_block (file_id,file_md5,chunk) VALUES (?,?,?)";
		return jdbcTemplate.update(sql, args);
	}
	
	@Override
	public int saveFileInfo(FileInServer entity) {
		String sql = "INSERT INTO file_in_server (object_id,md5,file_name,file_size,file_type,last_modified_date,file_path,create_user,create_time,modify_user,modify_time,active)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] args = { entity.getObjectId(), entity.getMd5(), entity.getFileName(), entity.getFileSize(),
				entity.getFileType(), entity.getLastModifiedDate(), entity.getFilePath(), entity.getCreateUser(), new Date(), 
				entity.getModifyUser(), entity.getModifyTime(), entity.getActive()};
		return jdbcTemplate.update(sql, args);
	}

	@Override
	public int deleteChunkInfo(String fileId) {
		Object[] args = { fileId };
		String sql = "DELETE FROM file_block WHERE file_id = ?";
		return jdbcTemplate.update(sql, args);
	}

}
