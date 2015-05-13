package com.hdsx.dao.data.type;


public interface IChainHandler {
  Object handle(JavaType type,Object source) throws SecurityException, NoSuchMethodException,Exception;
}
