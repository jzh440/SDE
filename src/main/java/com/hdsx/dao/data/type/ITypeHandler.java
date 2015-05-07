package com.hdsx.dao.data.type;


public abstract class ITypeHandler<S>{
  public abstract S convert(Object source);
  public  final String getReturnType() throws SecurityException, NoSuchMethodException {
	 return getClass().getMethod("convert", Object.class).getReturnType().getSimpleName();	
  }
}
