package vitily.com.util;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class FontUtil {
	
	private static volatile Font simSun;//宋体
	private static volatile String simSunKey="SimSun.ttc";//宋体
	private static volatile Font simFang;//仿宋
	private static volatile String simFangKey="SimFang.ttf";//宋体
	private static volatile Font msyh;//雅黑
	private static volatile String msyhKey="MSYH.TTF";//宋体
	
	/**
	 * 获取宋体字体对象
	 * @param style
	 * @param size
	 * @return
	 */
	public static Font getSimSun(int style, float size){
		if(simSun==null){
			synchronized (simSunKey) {
				if (simSun == null) {
					simSun=getFont(simSunKey);
				}
			}
		}
		return simSun.deriveFont(style, size);
	}
	/**
	 * 获取宋体字体对象
	 * @return
	 */
	public static Font getSimSun(){
		return getSimSun(Font.PLAIN,12);
	}
	
	/**
	 * 获取仿宋字体
	 * @param style
	 * @param size
	 * @return
	 */
	public static Font getSimFang(int style, float size){
		if(simFang==null){
			synchronized (simFangKey) {
				if (simFang == null) {
					simFang=getFont(simFangKey);
				}
			}
		}
		return simFang.deriveFont(style, size);
	}
	
	/**
	 * 获取仿宋字体
	 * @return
	 */
	public static Font getSimFang(){
		return getSimFang(Font.PLAIN,12);
	}
	
	/**
	 * 获取微软雅黑字体
	 * @param style
	 * @param size
	 * @return
	 */
	public static Font getMsyh(int style, float size){
		if(msyh==null){
			synchronized (msyhKey) {
				if (msyh == null) {
					msyh=getFont(msyhKey);
				}
			}
		}
		return msyh.deriveFont(style, size);
	}
	
	/**
	 * 获取微软雅黑字体
	 * @return
	 */
	public static Font getMsyh(){
		return getMsyh(Font.PLAIN, 12);
	}
	
	
	
	public static Font getFont(String fileName) {
		Font fnt = null;
		InputStream fi = null;
		try {
			fi = FontUtil.class.getClassLoader().getResourceAsStream(
					fileName);
			fnt = Font.createFont(Font.TRUETYPE_FONT, fi);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fi != null) {
				try {
					fi.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return fnt;
	}
}
