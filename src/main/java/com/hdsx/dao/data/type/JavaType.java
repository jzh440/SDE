package com.hdsx.dao.data.type;

import com.esri.sde.sdk.client.SeColumnDefinition;

/**
	Data type  Precision (field length)  Scale (decimal places)
	
	Short integer* 1–5 (Oracle, SQL Server, PostgreSQL, Netezza); 5 (DB2, Informix) 0
		
	Long integer 6–10 (Oracle and PostgreSQL); 6–9 (DB2, Informix, Netezza, and SQL Server) 0
	
	Float  1–6    1–6
		
	Double 7+     0+
*/
	

// TODO: Auto-generated Javadoc
/**
 * The Enum JavaType.
 * @author jingzh
 */
public enum JavaType {
	
	/** ArcSDE data type for Universal Unique ID. */
	TYPE_UUID("String",SeColumnDefinition.TYPE_UUID), 
	
	/** ArcSDE data type for 2 byte integer data.(1-5) */
	TYPE_INT16("Short",SeColumnDefinition.TYPE_INT16),
	
	/** ArcSDE data type for 4 byte integer data.(6-10) */
	TYPE_INT32("Integer",SeColumnDefinition.TYPE_INT32),
	
	/** ArcSDE data type for 8 byte integer data.(6-10) */
	TYPE_INT64("Long",SeColumnDefinition.TYPE_INT64),
	
	/** ArcSDE data type for 4 byte floating point data.(1–6) */
	TYPE_FLOAT32("Float",SeColumnDefinition.TYPE_FLOAT32),
	
	/** ArcSDE data type for 8 byte floating point data.(7+) */
	TYPE_FLOAT64("Double",SeColumnDefinition.TYPE_FLOAT64),
	
	/** ArcSDE data type for dates. */
	TYPE_DATE("Date",SeColumnDefinition.TYPE_DATE),
	
	/** ArcSDE data type for Character Variable Length Data. */
	TYPE_CLOB("String",SeColumnDefinition.TYPE_CLOB),
	
	/** ArcSDE data type for UNICODE Character Large Object. */
	TYPE_NCLOB("String",SeColumnDefinition.TYPE_NCLOB),

	/**  ArcSDE data type for variable length binary data. */
	TYPE_BLOB("Blob",SeColumnDefinition.TYPE_BLOB),

	/** The blank. */
	TYPE_STRING("String",SeColumnDefinition.TYPE_STRING),
	
	/** ArcSDE data type for UNICODE Null termindated character array. */
	TYPE_NSTRING("String",SeColumnDefinition.TYPE_NSTRING),

	/** ArcSDE data type for raster data. */
	TYPE_RASTER("Raster",SeColumnDefinition.TYPE_RASTER),
	
	/** ArcSDE data type for geometric features. */
	TYPE_SHAPE ("Geometry",SeColumnDefinition.TYPE_SHAPE),
	
	/** ArcSDE data type for XML data. */
	TYPE_XML("Xml",SeColumnDefinition.TYPE_XML);
	private String javaType;
	
	private int sdeType;
	
	JavaType(String javaType,int sdeType){
		this.javaType=javaType;
		this.sdeType=sdeType;
	}

	public static JavaType sde2JavaType(int sdeType){
		JavaType[] types=JavaType.values();
		for(JavaType javaType:types){
			if(javaType.getSdeType()==sdeType){
				return javaType;
			}
		}
		return null;
	}
	
	public String getJavaType() {
		return javaType;
	}

	public int getSdeType() {
		return sdeType;
	}
}
