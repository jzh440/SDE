package com.hdsx.dao.parameter;
/**
 * 
 * @author Administrator
 * @descripe  读取(Retrieve)
 */
public class QueryParameter extends Parameters {

	private String[] outFields=new String[]{"*"};
	
	private boolean returnGeometry=true;
	
	private String orderByFields;
	
	public QueryParameter(){}
	
	public QueryParameter(String sqlWhere,String layerName){
		super(sqlWhere,layerName,CRUD.TYPE_QUERY);
	}
	/**
	 * 查询参数构造器.
	 *
	 * @param sqlWhere the sql where
	 * @param spatial the spatial
	 * @param wkt the wkt
	 * @param layerName the layer name
	 */
	public QueryParameter(String sqlWhere,SpatialRelation spatial,String wkt,String layerName){
		super(sqlWhere, spatial, wkt, layerName,CRUD.TYPE_QUERY);
	}
	
	public QueryParameter(String[] outFields,String layerName,String sqlWhere,String orderByFields,String wkt,SpatialRelation spatial,boolean returnGeometry){
		super( sqlWhere, spatial, wkt, layerName,CRUD.TYPE_QUERY);
		this.outFields=outFields;
		this.orderByFields=orderByFields;
		this.returnGeometry=returnGeometry;
	}

	public String[] getOutFields() {
		return outFields;
	}

	public void setOutFields(String[] outFields) {
		this.outFields = outFields;
	}

	public boolean isReturnGeometry() {
		return returnGeometry;
	}

	public void setReturnGeometry(boolean returnGeometry) {
		this.returnGeometry = returnGeometry;
	}

	public String getOrderByFields() {
		return orderByFields;
	}

	public void setOrderByFields(String orderByFields) {
		this.orderByFields = orderByFields;
	}
	
	
}
