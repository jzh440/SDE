package com.hdsx.dao.parameter;

import java.util.List;

import com.hdsx.dao.data.Feature;

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

	private Feature feature;
	
	private List<Feature> features;
	
	public Parameters(){}
	
	public Parameters(Feature feature,String layerName,CRUD crud){
		this.feature=feature;
		this.layerName=layerName;
		this.crud=crud;
	}
	public Parameters(List<Feature> features,String layerName,CRUD crud){
		this.features=features;
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
	public Parameters(String sqlWhere,SpatialRelation spatial,String wkt,Feature feature,String layerName,CRUD crud){
		this.feature=feature;
		this.spatial=spatial;
		this.wkt=wkt;
		this.feature=feature;
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

	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	public CRUD getCrud() {
		return crud;
	}

	public void setCrud(CRUD crud) {
		this.crud = crud;
	}
	
}
