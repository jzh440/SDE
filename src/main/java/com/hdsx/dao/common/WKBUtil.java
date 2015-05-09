package com.hdsx.dao.common;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKBReader;
import com.vividsolutions.jts.io.WKBWriter;

// TODO: Auto-generated Javadoc
/**
 * WKB 辅助对象，对JTS中WKBWriter和WKBReader类的包装
 * @author kemi
 */
public class WKBUtil {
  
  /** The wkb writer. */
  private static WKBWriter wkbWriter=new WKBWriter();
  
  /** The wkb reader. */
  private static WKBReader wkbReader=new WKBReader();
  
  /**
   * 写入
   *
   * @param geometry JTS空间对象
   * @return the byte[] WKB格式数据
   */
  public static byte[] writer(Geometry geometry)
  {
	 return  wkbWriter.write(geometry);
  }
  
  /**
   * 读取
   *
   * @param wkb WKB格式数据
   * @return the geometry JTS空间对象
   */
  public static Geometry reader(byte[] wkb)
  {
	 try {
		return wkbReader.read(wkb);
	} catch (ParseException e) {
		e.printStackTrace();
	}
	return null;
  }
}
