package com.hdsx.dao.data.jts;

import com.hdsx.dao.exception.CRUDException;
import com.hdsx.dao.parameter.Parameters;


public interface JTSDao {

	Object CRUDMethod(Parameters parameters)throws CRUDException;
}
