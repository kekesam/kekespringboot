package com.mengke.util;

import java.util.Date;

public class StringUtils {
	
	public static final long ONE_KB = 1024;
	public static final long ONE_MB = ONE_KB * ONE_KB;
	public static final long ONE_GB = ONE_KB * ONE_MB;

	/**
	 * 判断内容是否为空
	 * 方法名：isEmpty<br/>
	 * 创建人：xuchengfei <br/>
	 * 时间：2017年7月29日-下午2:19:44 <br/>
	 * 手机:1564545646464<br/>
	 * @param content
	 * @return boolean<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public static boolean isEmpty(String content){
		return null == content || "".equals(content);
	}
	
	/**
	 * 
	 * 判断内容不为空
	 * 方法名：isNotEmpty<br/>
	 * 创建人：xuchengfei <br/>
	 * 时间：2017年7月29日-下午2:20:16 <br/>
	 * 手机:1564545646464<br/>
	 * @param content
	 * @return boolean<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public static boolean isNotEmpty(String content){
		return !isEmpty(content);
	}
	
	
	
	/**
	 * 
	 * 根据文件字节转换对应的MB GB KB
	 * 方法名：byteCountToDisplaySize<br/>
	 * 创建人：xuchengfei <br/>
	 * 时间：2017年7月29日-下午1:35:28 <br/>
	 * 手机:1564545646464<br/>
	 * @param size
	 * @return String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public static String sizeString(long size) {
		String displaySize;
		if (size / ONE_GB > 0) {
			displaySize = String.valueOf(size / ONE_GB) + " GB";
		} else if (size / ONE_MB > 0) {
			displaySize = String.valueOf(size / ONE_MB) + " MB";
		} else if (size / ONE_KB > 0) {
			displaySize = String.valueOf(size / ONE_KB) + " KB";
		} else {
			displaySize = String.valueOf(size) + " bytes";
		}
		return displaySize;
	}
	
	
	
	/**
	 * 根据实际获取几秒前，几分钟前的数据格式
	 * 方法名：getTimeFormat<br/>
	 * 创建人：xuchengfei <br/>
	 * 时间：2017年7月29日-下午1:35:02 <br/>
	 * 手机:1564545646464<br/>
	 * @param startTime
	 * @return String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public static String getTimeFormat(Date startTime){
		try{
			long startTimeMills = startTime.getTime();
			long endTimeMills = new Date().getTime();
			long diff = (endTimeMills - startTimeMills)/1000;//秒
			long day_diff  = (long) Math.floor(diff/86400);//天
			StringBuffer buffer = new StringBuffer();
			if(day_diff<0){
				return "[error],时间越界...";
			}else{
				if(day_diff==0 && diff<60){
					if(diff==0)diff=1;
					buffer.append(diff+"秒前");
				}else if(day_diff==0 && diff<120){
					buffer.append("1 分钟前");
				}else if(day_diff==0 && diff<3600){
					buffer.append(Math.round(Math.floor(diff/60))+"分钟前");
				}else if(day_diff==0 && diff<7200){
					buffer.append("1小时前");
				}else if(day_diff==0 && diff<86400){
					buffer.append(Math.round(Math.floor(diff/3600))+"小时前");
				}else if(day_diff==1){
					buffer.append("1天前");
				}else if(day_diff<7){
					buffer.append(day_diff+"天前");
				}else if(day_diff <30){
					buffer.append(Math.round(Math.ceil( day_diff / 7 )) + " 星期前");
				}else if(day_diff >=30 && day_diff<=179 ){
					buffer.append(Math.round(Math.ceil( day_diff / 30 )) + "月前");
				}else if(day_diff >=180 && day_diff<365){
					buffer.append("半年前");
				}else if(day_diff>=365){
					buffer.append(Math.round(Math.ceil( day_diff /30/12))+"年前");
				}
			}
			return buffer.toString();
		}catch(Exception ex){
			return "";
		}
	}
}
