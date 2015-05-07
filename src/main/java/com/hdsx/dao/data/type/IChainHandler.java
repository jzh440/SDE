package com.hdsx.dao.data.type;

public interface IChainHandler {
  Object handle(String type,Object source) throws SecurityException, NoSuchMethodException;
}
