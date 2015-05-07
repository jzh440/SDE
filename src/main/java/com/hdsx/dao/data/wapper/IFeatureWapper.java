package com.hdsx.dao.data.wapper;

import com.esri.sde.sdk.client.SeException;
import com.esri.sde.sdk.client.SeRow;
import com.hdsx.dao.data.Feature;

public interface IFeatureWapper {

	 Feature SeRow2Feature(SeRow row)throws SeException;
}
