package com.hdsx.dao.data.type;

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
	TYPE_UUID("UUID"), 
	
	/** ArcSDE data type for 2 byte integer data.(1-5) */
	TYPE_INT16("Short"),
	
	/** ArcSDE data type for 4 byte integer data.(6-10) */
	TYPE_INT32("Integer"),
	
	/** ArcSDE data type for 8 byte integer data.(6-10) */
	TYPE_INT64("Long"),
	
	/** ArcSDE data type for 4 byte floating point data.(1–6) */
	TYPE_FLOAT32("Float"),
	
	/** ArcSDE data type for 8 byte floating point data.(7+) */
	TYPE_FLOAT64("Double"),
	
	/** ArcSDE data type for dates. */
	TYPE_DATE("Date"),
	
	/** ArcSDE data type for Character Variable Length Data. */
	TYPE_CLOB("Clob"),
	
	/** ArcSDE data type for UNICODE Character Large Object. */
	TYPE_NCLOB("NClob"),

	/**  ArcSDE data type for variable length binary data. */
	TYPE_BLOB("Blob"),

	/** The blank. */
	TYPE_STRING("String"),
	
	/** ArcSDE data type for UNICODE Null termindated character array. */
	TYPE_NSTRING("NString"),

	/** ArcSDE data type for raster data. */
	TYPE_RASTER("Raster"),
	
	/** ArcSDE data type for geometric features. */
	TYPE_SHAPE ("Shape"),
	
	/** ArcSDE data type for XML data. */
	TYPE_XML("Xml");
	private String type;
	
	JavaType(String type){
		this.type=type;
	}
	public String getType(){
		
		return type;
	}
	
}
