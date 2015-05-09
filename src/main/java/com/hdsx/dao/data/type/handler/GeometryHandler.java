package com.hdsx.dao.data.type.handler;

import java.util.ArrayList;

import com.esri.sde.sdk.client.SeException;
import com.esri.sde.sdk.client.SeShape;
import com.hdsx.dao.common.JTSGeometryUtils;
import com.hdsx.dao.data.type.ITypeHandler;
import com.hdsx.dao.exception.TypeException;
import com.vividsolutions.jts.geom.Geometry;

public class GeometryHandler extends ITypeHandler<Geometry>{
	@Override
	public Geometry convert(Object source) throws TypeException{
		if(source instanceof SeShape)
		{
			SeShape shape=(SeShape)source;
			int wkbSize;
			try 
			{
				wkbSize = shape.getWKBSize();
				ArrayList<?> list=shape.asWKB(wkbSize);
				byte[] wkb=(byte[]) list.get(1);
				return JTSGeometryUtils.WKBToGeometry(wkb);
			} catch (SeException e) {
				throw new TypeException(e);
			}
		}
		return null;
	}
}
