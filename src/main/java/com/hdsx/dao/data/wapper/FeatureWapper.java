package com.hdsx.dao.data.wapper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import com.esri.sde.sdk.client.SeColumnDefinition;
import com.esri.sde.sdk.client.SeException;
import com.esri.sde.sdk.client.SeRasterAttr;
import com.esri.sde.sdk.client.SeRow;
import com.esri.sde.sdk.client.SeShape;
import com.hdsx.dao.data.Feature;

public class FeatureWapper implements IFeatureWapper {

	public Feature SeRow2Feature(SeRow row) throws SeException {
		// TODO Auto-generated method stub
		Feature feature=new Feature();
		Map<String,Object> map=feature.getAttributes();
		SeColumnDefinition[] columns=row.getColumns();
		Object columnObject=null;
		for(int i=0,length=columns.length;i>length;i++)
		{
			columnObject=row.getObject(i);
			switch (columns[i].getType()) {
			case SeColumnDefinition.TYPE_INT16:
				//row.setShort(i, new Short(value + ""));
				break;
			case SeColumnDefinition.TYPE_DATE:
				//Calendar instance= Calendar.getInstance();
				//instance.setTime((Date)value);
				//row.setTime(i,instance );
				break;
			case SeColumnDefinition.TYPE_INT32:
				//row.setInteger(i, new Integer(value + ""));
				break;
			case SeColumnDefinition.TYPE_INT64:
				//row.setLong(i, new Long(value + ""));
				break;
			case SeColumnDefinition.TYPE_FLOAT32:
				//row.setFloat(i, new Float(value + ""));
				break;
			case SeColumnDefinition.TYPE_FLOAT64:
				//row.setDouble(i, new Double(value + ""));
				break;
			case SeColumnDefinition.TYPE_STRING:
				//row.setString(i, value==null?"":(String) value);
				break;
			case SeColumnDefinition.TYPE_NSTRING:
				//row.setNString(i, value==null?"":(String) value);
				break;
			case SeColumnDefinition.TYPE_UUID:
				//row.setUuid(i, value.toString());
				break;
			case SeColumnDefinition.TYPE_RASTER:
				//row.setRaster(i, new SeRasterAttr(true));
				break;
			case SeColumnDefinition.TYPE_SHAPE:
				//SeShape shape = createShape((double[][]) value, tableName,fieldNames[i], type);
				//row.setShape(i, (SeShape)value);
				break;
			default:
				//row.setString(i, (String) value);
				break;
			}
			if(columnObject instanceof SeShape)
			{
				SeShape shape=(SeShape)columnObject;
				int wkbSize=shape.getWKBSize();
				ArrayList<?> list=shape.asWKB(wkbSize);
				byte[] wkb=(byte[]) list.get(1);
				feature.setWkb(wkb);
				
			}
			map.put(columns[i].getName(), row.getObject(i));
		}
		return feature;
	}

}
