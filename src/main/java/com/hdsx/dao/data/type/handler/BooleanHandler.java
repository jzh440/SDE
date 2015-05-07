package com.hdsx.dao.data.type.handler;

import com.hdsx.dao.data.type.ITypeHandler;


public class BooleanHandler extends ITypeHandler<Boolean>{

	@Override
	public Boolean convert(Object source) {
		if(source instanceof Boolean)
		{
			return (Boolean) source;
		}
		else if(source instanceof String)
		{
			return Boolean.parseBoolean((String) source);
		}
		else if(source instanceof Double)
		{
			return (Double)source>0;
		}
		else if(source instanceof Integer)
		{
			return (Integer)source>0;
		}
		else if(source instanceof Long)
		{
			return (Long)source>0;
		}
		return null;
	}
}
