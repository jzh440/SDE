package com.hdsx.dao.data.type.handler;

import com.hdsx.dao.data.type.ITypeHandler;

public class FloatHandler extends ITypeHandler<Float>{
	@Override
	public Float convert(Object source) {
		if(source instanceof Number)
		{
			Number number=(Number)source;
			return number.floatValue();
		}
		else if(source instanceof String)
	    {
			return Float.parseFloat((String) source);
		}
		return 0.0f;
	}
}
