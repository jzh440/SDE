package com.hdsx.dao.data.wapper;

import com.esri.sde.sdk.client.SeRow;
import com.hdsx.dao.data.Feature;

public interface IFeatureWapper {

	 abstract Feature SeRow2Feature(SeRow row,boolean returnGeometry) throws Exception;
	 
	 abstract SeRow   Feature2SeRow(Feature feature,SeRow row) throws Exception;
}
