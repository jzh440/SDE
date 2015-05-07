package com.hdsx.dao.parameter;
/**
 * 
 * @author Administrator
 * @descripe  读取(Retrieve)
 */
public class QueryParameter extends Parameters {

	public QueryParameter(){}
	
	/**
	 * 查询参数构造器.
	 *
	 * @param sqlWhere the sql where
	 * @param spatial the spatial
	 * @param wkt the wkt
	 * @param layerName the layer name
	 */
	public QueryParameter(String sqlWhere,SpatialRelation spatial,String wkt,String layerName){
		super( sqlWhere, spatial, wkt, layerName,CRUD.TYPE_QUERY);
	}
	
	
}
