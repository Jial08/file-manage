package cn.jasframework.file.manage.common;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

public class commonUtil {
	
	/**
	 * <p>功能描述：通用的响应头处理，设置常用格式文件的浏览器打开方式。</p>
	 * <p>Jial </p>	
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
	
	/**
	 * <p>功能描述：判断字符串存在且非空。</p>
	 * <p>Jial </p>	
	 * @param str
	 * @return
	 * @since JDK1.8。
	 * <p>创建日期:2017年6月30日 下午4:55:12。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public static boolean hasText(String str) {
		if (str != null && !"".equals(str) && !"null".equals(str) && !"undefined".equals(str)) {
			return true;
		}
		return false;
	}

}
