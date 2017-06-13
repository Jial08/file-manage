package cn.jasframework.file.manage.common;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

}
