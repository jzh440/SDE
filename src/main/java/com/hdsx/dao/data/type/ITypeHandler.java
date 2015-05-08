package com.hdsx.dao.data.type;

import com.hdsx.dao.exception.TypeException;


public abstract class ITypeHandler<S>{
  public abstract S convert(Object source) throws TypeException;
  public  final String getReturnType() throws SecurityException, NoSuchMethodException {
	 return getClass().getMethod("convert", Object.class).getReturnType().getSimpleName();	
  }
  
  public Object convert(JavaType javaType,Object source)throws TypeException{
	  if(source==null
			  &&(javaType==JavaType.TYPE_INT16
			  ||javaType==JavaType.TYPE_INT32
			  ||javaType==JavaType.TYPE_INT64)){
		  return 0;
	  }
	  else if(source==null
			  &&(javaType==JavaType.TYPE_FLOAT32
			  ||javaType==JavaType.TYPE_FLOAT64)){
		  return 0.0;
	  }
	  else {
		 return  convert(source);
	  }
  } 
 
}
