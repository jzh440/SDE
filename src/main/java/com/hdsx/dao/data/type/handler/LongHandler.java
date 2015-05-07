package com.hdsx.dao.data.type.handler;

import com.hdsx.dao.data.type.ITypeHandler;

public class LongHandler extends ITypeHandler<Long>{
	@Override
	public Long convert(Object source) {
		if(source instanceof String)
	    {
			return Long.parseLong((String) source);
		}
		else if(source instanceof Number)
		{
			Number number=(Number)source;
			return number.longValue();
		}
		else if(source instanceof Boolean)
		{
			return (long) ((Boolean) source?1:0);
		}
		return null;
	}
}
