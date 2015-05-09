package com.hdsx.dao.data.type;

import com.hdsx.dao.exception.TypeException;


public abstract class ITypeHandler<S>{
  public abstract S convert(Object source) throws TypeException;
  public  final String getReturnType() throws SecurityException, NoSuchMethodException {
	 return getClass().getMethod("convert", Object.class).getReturnType().getSimpleName();	
  }
}
