package com.hdsx.dao.data.type.handler;

import com.hdsx.dao.data.type.ITypeHandler;


public class BytesHandler extends ITypeHandler<byte[]>{
	@Override
	public byte[] convert(Object source) {
        if(source instanceof byte[])
        {
        	return (byte[]) source;
        }
        else if(source instanceof String)
        {
        	return ((String) source).getBytes();
        }
		return null;
	}
}
