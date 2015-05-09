package com.hdsx.dao.data.type.handler;

import com.hdsx.dao.data.type.ITypeHandler;

public class ShortHandler extends ITypeHandler<Short>{
	@Override
	public Short convert(Object source) {
		if(source instanceof Number)
		{
			Number number=(Number)source;
			return number.shortValue();
		}
		else if(source instanceof String)
	    {
			return Short.parseShort((String) source);
		}
		else if(source instanceof Boolean)
		{
			return (short) ((Boolean) source?1:0);
		}
		return 0;
	}
}
