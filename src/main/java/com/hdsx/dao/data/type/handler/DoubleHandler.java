package com.hdsx.dao.data.type.handler;

import com.hdsx.dao.data.type.ITypeHandler;

public class DoubleHandler extends ITypeHandler<Double>{
	@Override
	public Double convert(Object source) {
		if(source instanceof String)
	    {
			return Double.parseDouble((String) source);
		}
		else if(source instanceof Number)
		{
			Number number=(Number)source;
			return number.doubleValue();
		}
		else if(source instanceof Boolean)
		{
			return (double) ((Boolean) source?1:0);
		}
		return 0.0;
	}
}
