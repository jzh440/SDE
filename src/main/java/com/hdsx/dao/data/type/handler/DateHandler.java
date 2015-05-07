package com.hdsx.dao.data.type.handler;

import java.util.Date;

import com.hdsx.dao.data.type.ITypeHandler;


public class DateHandler extends ITypeHandler<Date>{

	@Override
	public Date convert(Object source) {
		if(source instanceof Boolean)
		{
			return (Date) source;
		}
		return null;
	}
}
