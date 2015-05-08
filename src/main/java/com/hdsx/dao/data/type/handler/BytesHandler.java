package com.hdsx.dao.data.type.handler;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import com.hdsx.dao.data.type.ITypeHandler;


public class BytesHandler extends ITypeHandler<byte[]>{
	@Override
	public byte[] convert(Object source) {
		if(source instanceof ByteArrayInputStream)
		{
			ByteArrayInputStream bis=(ByteArrayInputStream)source;
			byte[] byt=new byte[bis.available()];
			try 
			{
				bis.read(byt);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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
