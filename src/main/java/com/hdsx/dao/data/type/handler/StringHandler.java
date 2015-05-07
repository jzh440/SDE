package com.hdsx.dao.data.type.handler;

import com.hdsx.dao.data.type.ITypeHandler;

public class StringHandler extends ITypeHandler<String>{
    
	@Override
	public String convert(Object source) {
		if(source instanceof String)
	    {
			return (String) source;
		}
		else if(source instanceof Double)
		{
			return String.valueOf(source);
		}
		else if(source instanceof Integer)
		{
			return String.valueOf(source);
		}
		else if(source instanceof Long)
		{
			return String.valueOf(source);
		}
		else if(source instanceof Boolean)
		{
			return String.valueOf(source);
		}
		else if(source instanceof byte[])
		{
			return new String((byte[])source);
		}
		else if(source instanceof Object)
		{
			return source.toString();
		}
		return null;
	}
	
}
