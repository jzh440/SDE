package com.hdsx.dao.data.type.handler;

import com.esri.sde.sdk.geom.Geometry;
import com.hdsx.dao.data.type.ITypeHandler;

public class GeometryHandler extends ITypeHandler<Geometry>{
	@Override
	public Geometry convert(Object source) throws Exception{
		if(source instanceof Geometry)
		{
			return (Geometry)source;
		}
		return null;
	}
}
