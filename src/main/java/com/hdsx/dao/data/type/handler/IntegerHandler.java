package com.hdsx.dao.data.type.handler;

import com.hdsx.dao.data.type.ITypeHandler;

public class IntegerHandler extends ITypeHandler<Integer>{

	@Override
	public Integer convert(Object source) {
		if(source instanceof String)
	    {
			return Integer.parseInt((String) source);
		}
		else if(source instanceof Number)
		{
			Number number=(Number)source;
			return number.intValue();
		}
		else if(source instanceof Boolean)
		{
			return (int) ((Boolean) source?1:0);
		}
		return null;
	}
}
