package com.hdsx.dao.common;

import java.util.ArrayList;

import com.esri.sde.sdk.client.SeException;
import com.esri.sde.sdk.client.SeShape;
import com.esri.sde.sdk.geom.SeGeometryException;
import com.vividsolutions.jts.geom.Geometry;

// TODO: Auto-generated Javadoc
/**
 *  支持JTS空间数据转化对象，
 *  包括：WKT和WKB两种格式
 * @author kemi
 */
public class JTSGeometryUtils{
	
	/**
	 * 将JTS空间对象转化为WKT格式数据
	 *
	 * @param geometry JTS空间对象
	 * @return the string WKT格式数据
	 */
	public static String GeometryToWKT(Geometry geometry) {
		return WKTUtil.writer(geometry);
	}

	/**
	 * 将WKT格式数据解析为JTS空间对象
	 *
	 * @param wkt WKT格式数据
	 * @return the geometry JTS空间对象
	 */
	public static Geometry WKTToGeometry(String wkt) {
	    return WKTUtil.reader(wkt);
	}

	/**
	 * 将JTS空间对象转化为WKB格式数据
	 *
	 * @param geometry JTS空间对象
	 * @return the byte[] WKB格式数据
	 */
	public static byte[] GeometryToWKB(Geometry geometry) {
		return WKBUtil.writer(geometry);
	}

	/**
	 * 将WKB格式数据转化为JTS空间对象
	 *
	 * @param wkb WKB格式数据
	 * @return the geometry JTS空间对象
	 */
	public static Geometry WKBToGeometry(byte[] wkb) {
	   return WKBUtil.reader(wkb);
	}
	
}
