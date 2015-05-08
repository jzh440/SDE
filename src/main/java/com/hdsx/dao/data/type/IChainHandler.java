package com.hdsx.dao.data.type;

import com.hdsx.dao.exception.TypeException;

public interface IChainHandler {
  Object handle(JavaType type,Object source) throws SecurityException, NoSuchMethodException,TypeException;
}
