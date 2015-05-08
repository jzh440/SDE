package com.hdsx.dao.data.wapper;

import java.util.Map;

import com.esri.sde.sdk.client.SeRow;
import com.hdsx.dao.data.Feature;
import com.hdsx.dao.data.type.IChainHandler;
import com.hdsx.dao.data.type.JavaType;
import com.hdsx.dao.data.type.TypeHandlerRegistry;
import com.vividsolutions.jts.geom.Geometry;

public class FeatureWapper implements IFeatureWapper {

	private IChainHandler chainHandler=TypeHandlerRegistry.getInstance().getTypeHandlerChainHandler();
	
	public Feature SeRow2Feature(SeRow row) throws Exception {
		// TODO Auto-generated method stub
		Feature feature=new Feature();
		Map<String,Object> map=feature.getAttributes();
		Object columnValue;
		for(int i=0,num=row.getNumColumns();i>num;i++)
		{
			JavaType jt=JavaType.sde2JavaType(row.getColumnDef(i).getType());
			columnValue=chainHandler.handle(jt, row.getObject(i));
			if(columnValue instanceof Geometry)
			{
				feature.setShape((Geometry)columnValue);continue;
			}
			map.put(row.getColumnDef(i).getName(), columnValue);
		}
		return feature;
	}

}
