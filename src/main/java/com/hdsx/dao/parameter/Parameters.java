package com.hdsx.dao.parameter;


/**
 * 
 * @author Administrator
 * @CRUD 参数
 */
public class Parameters {

	private CRUD crud=CRUD.TYPE_QUERY;
	
	private SpatialRelation spatial;
	
	private String wkt;
	
	private String sqlWhere;
	
	private String layerName;

	public Parameters(){}
	
	public Parameters(String layerName,CRUD crud){
		this.layerName=layerName;
		this.crud=crud;
	}
	public Parameters(String sqlWhere,String layerName,CRUD crud){
		this.sqlWhere=sqlWhere;
		this.layerName=layerName;
		this.crud=crud;
	}
	public Parameters(String sqlWhere,SpatialRelation spatial,String wkt,String layerName,CRUD crud){
		this.sqlWhere=sqlWhere;
		this.spatial=spatial;
		this.wkt=wkt;
		this.layerName=layerName;
		this.crud=crud;
	}
	public SpatialRelation getSpatial() {
		return spatial;
	}

	public void setSpatial(SpatialRelation spatial) {
		this.spatial = spatial;
	}

	public String getWkt() {
		return wkt;
	}

	public void setWkt(String wkt) {
		this.wkt = wkt;
	}

	public String getSqlWhere() {
		return sqlWhere;
	}

	public void setSqlWhere(String sqlWhere) {
		this.sqlWhere = sqlWhere;
	}

	public String getLayerName() {
		return layerName;
	}

	public void setLayerName(String layerName) {
		this.layerName = layerName;
	}


	public CRUD getCrud() {
		return crud;
	}

	public void setCrud(CRUD crud) {
		this.crud = crud;
	}
	
}
