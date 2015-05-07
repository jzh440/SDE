package com.hdsx.dao.data.type;

public class ChainHandler implements IChainHandler{
	private ITypeHandler<?> typeHandler;
	private IChainHandler handler;
	@Override
	public Object handle(String type,Object source) throws SecurityException, NoSuchMethodException
	{
		Object value = null;
		if(typeHandler.getReturnType().equals(type)&&(value=typeHandler.convert(source))!=null)
		{
			   return value;
		}
		else
		{
			if(handler!=null)
			{
			  return handler.handle(type, source);
			}
		}
		return value;		
	  
	}
	public ChainHandler(ITypeHandler<?> typeHandler) {
		super();
		this.typeHandler = typeHandler;
	}
	public ChainHandler(ITypeHandler<?> typeHandler, IChainHandler ich) {
		super();
		this.typeHandler = typeHandler;
		this.handler = ich;
	}
}
