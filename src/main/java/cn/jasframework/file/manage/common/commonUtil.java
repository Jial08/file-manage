package cn.jasframework.file.manage.common;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

public class commonUtil {
	
	/**
	 * <p>类描述：获取当前时间的年月日时分秒字符串。</p>
	 * @author贾亮
	 * @version v1.0.0.1。
	 * @since JDK1.8。
	 *<p>创建日期：2017年4月17日 下午4:22:42。</p>
	 */
	public static String getCurrentTime() {
		long time = System.currentTimeMillis();
		Date date = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * <p>功能描述：将字符串的时间类型转为Date类型。</p>
	 * <p>贾亮 </p>	
	 * @param dateStr
	 * @param dateFormat
	 * @return
	 * @since JDK1.8。
	 * <p>创建日期:2017年4月17日 下午4:45:19。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public static Date getDateFromDateString(String dateStr,
			String dateFormat) {
		if (dateStr != null && !"".equals(dateStr)) {
			SimpleDateFormat sdf = null;
			try {
				sdf = new SimpleDateFormat(dateFormat);
				Date date = sdf.parse(dateStr);
				return date;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	
	/**
	 * <p>功能描述：将文件大小(long型)转为String型(kb)。</p>
	 * <p>贾亮 </p>	
	 * @param sizeL
	 * @return
	 * @since JDK1.8。
	 * <p>创建日期:2017年4月18日 下午2:58:32。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public static String handleFileSize(long sizeL) {
		Double size = Double.valueOf(sizeL);
		size = size / 1024;
		// 设置小数保留两位，如果整数位是0，则会出现如（.01）这样的解决，所有括号里格式可以设置为（0.00）
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(size) + "k";
	}
	
	/**
	 * <p>功能描述：通用的响应头处理，设置常用格式文件的浏览器打开方式。</p>
	 * <p>贾亮 </p>	
	 * @param response
	 * @param fileName	文件名
	 * @param fileType	文件格式(后缀名，如：doc/txt/zip等)
	 * @throws IOException 
	 * @since JDK1.8。
	 * <p>创建日期:2017年5月17日 上午11:06:56。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public static void disposeResponse(HttpServletResponse response, String fileName, String fileType) throws IOException {
		String displayname = new String(fileName.getBytes("GBK"), "ISO-8859-1");
//		String name = new String(fileName.getBytes("ISO8859-1"), "UTF-8");
		response.setCharacterEncoding("UTF-8");
		if (fileType != null && !"".equals(fileType)) {
			if (fileType.equalsIgnoreCase("doc") || fileType.equalsIgnoreCase("docx")) {
				response.setContentType("application/msword");
			} else if (fileType.equalsIgnoreCase("xls") || fileType.equalsIgnoreCase("xlsx")) {
				response.setContentType("application/msexcel");
			} else if (fileType.equalsIgnoreCase("pdf")) {
				response.setContentType("application/pdf");
			} else if (fileType.equalsIgnoreCase("ppt") || fileType.equalsIgnoreCase("pptxx")) {
				response.setContentType("application/ms-powerpoint");
			} else if (fileType.equalsIgnoreCase("txt")) {
				response.setContentType("text/plain");
			} else if (fileType.equalsIgnoreCase("zip")) {
				response.setContentType("application/zip");
			}
		}
		response.addHeader("Content-Disposition", "attachment;filename=" + displayname);
	}

}
