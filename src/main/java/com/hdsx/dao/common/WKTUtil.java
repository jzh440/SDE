package com.hdsx.dao.common;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import com.vividsolutions.jts.io.WKTWriter;

// TODO: Auto-generated Javadoc
/**
 * WKT 辅助对象，对JTS中WKTWriter和WKTReader类的包装
 * @author kemi
 */
public class WKTUtil {
	  
  	/** The wkt writer. */
  	private static WKTWriter wktWriter=new WKTWriter();
	  
  	/** The wkt reader. */
  	private static WKTReader wktReader=new WKTReader();
	  
	  /**
  	 * 写入
  	 *
  	 * @param geometry JTS空间对象
  	 * @return the string WKT格式数据
  	 */
  	public static String writer(Geometry geometry)
	  {
		 return  wktWriter.write(geometry);
	  }
	  
	  /**
  	 * 读取
  	 *
  	 * @param wkt WKT格式数据
  	 * @return the geometry JTS空间对象
  	 */
  	public static Geometry reader(String wkt)
	  {
		 try {
			return wktReader.read(wkt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	  }
}
