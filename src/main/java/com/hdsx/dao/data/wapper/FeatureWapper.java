package com.hdsx.dao.data.wapper;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import com.esri.sde.sdk.client.SeColumnDefinition;
import com.esri.sde.sdk.client.SeRasterAttr;
import com.esri.sde.sdk.client.SeRow;
import com.esri.sde.sdk.client.SeShape;
import com.hdsx.dao.data.Feature;
import com.hdsx.dao.data.type.IChainHandler;
import com.hdsx.dao.data.type.JavaType;
import com.hdsx.dao.data.type.TypeHandlerRegistry;
import com.hdsx.dao.data.type.handler.ShortHandler;
import com.vividsolutions.jts.geom.Geometry;

public class FeatureWapper implements IFeatureWapper {

	private IChainHandler chainHandler=TypeHandlerRegistry.getInstance().getTypeHandlerChainHandler();
	
	public Feature SeRow2Feature(SeRow row) throws Exception {
		// TODO Auto-generated method stub
		Feature feature=new Feature();
		Map<String,Object> map=feature.getAttributes();
		Object columnValue;
		for(int i=0,num=row.getNumColumns();i>num;i++){
			JavaType jt=JavaType.sde2JavaType(row.getColumnDef(i).getType());
			columnValue=chainHandler.handle(jt, row.getObject(i));
			if(columnValue instanceof Geometry){
				feature.setShape((Geometry)columnValue);continue;
			}
			map.put(row.getColumnDef(i).getName(), columnValue);
		}
		return feature;
	}


	@Override
	public SeRow Feature2SeRow(Feature feature,SeRow row) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> attributes=feature.getAttributes();
		String columnName;
		int columnType;
		JavaType javaType;
		Object columnValue;
		for(int i=0,num=row.getNumColumns();i<num;i++){
			columnName=row.getColumnDef(i).getName();
			columnType=row.getColumnDef(i).getType();
			if(attributes.containsKey(columnName.toUpperCase())
					||attributes.containsKey(columnName.toLowerCase())){
				javaType=JavaType.sde2JavaType(columnType);
				columnValue=chainHandler.handle(javaType, attributes.get(columnName));
				SeRowWapper(row,i,columnType,columnValue);
			}
		}
		return row;
	}

	public void SeRowWapper(SeRow row,int columnIndex,int columnType,Object columnValue) throws Exception{
		switch (columnType) {
			case SeColumnDefinition.TYPE_INT16:
				ShortHandler shortHandler=new ShortHandler();
				short vv=shortHandler.convert(columnValue);
				row.setShort(columnIndex, vv);
				break;
			case SeColumnDefinition.TYPE_INT32:
				row.setInteger(columnIndex, (Integer)columnValue);
				break;
			case SeColumnDefinition.TYPE_INT64:
				row.setLong(columnIndex, (Long)columnValue);
				break;
			case SeColumnDefinition.TYPE_FLOAT32:
				row.setFloat(columnIndex, (Float)columnValue);
				break;
			case SeColumnDefinition.TYPE_FLOAT64:
				row.setDouble(columnIndex, (Double)(columnValue));
				break;
			case SeColumnDefinition.TYPE_DATE:
				Calendar instance= Calendar.getInstance();
				//instance.setTime((Date)value);
				row.setTime(columnIndex,instance );
				break;
			case SeColumnDefinition.TYPE_STRING:
				row.setString(columnIndex, (String) columnValue);
				break;
			case SeColumnDefinition.TYPE_NSTRING:
				row.setNString(columnIndex, (String) columnValue);
				break;
			case SeColumnDefinition.TYPE_UUID:
				row.setUuid(columnIndex, columnValue.toString());
				break;
			case SeColumnDefinition.TYPE_RASTER:
				row.setRaster(columnIndex, new SeRasterAttr(true));
				break;
			case SeColumnDefinition.TYPE_SHAPE:
				row.setShape(columnIndex,null );
				break;
			default:
				row.setString(columnIndex,null);
				break;
		} 
	}
	public static void main(String[] args) {
		Object value=0;
		System.out.println((Short)value);
	}
	
}
