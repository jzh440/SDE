package com.hdsx.dao.parameter;

import java.util.List;

import com.hdsx.dao.data.Feature;

// TODO: Auto-generated Javadoc
/**
 * The Class ModifyParameter.
 *
 * @author Administrator
 * @descripr 增加(Create)、更新(Update)和删除(Delete)
 */
public class ModifyParameter extends Parameters {

	private Feature feature;
	
	private List<Feature> features;
	/**
	 * The Constructor.
	 */
	public ModifyParameter(){} 
	
	/**
	 * 单条插入.
	 *
	 * @param feature the feature
	 * @param layerName the layer name
	 */
	public ModifyParameter(Feature feature,String layerName){
		super(layerName,CRUD.TYPE_INSERT);
		this.feature=feature;
	}
	
	/**
	 * 批量插入.
	 *
	 * @param features the features
	 * @param layerName the layer name
	 */
	public ModifyParameter(List<Feature> features,String layerName){
		super(layerName,CRUD.TYPE_INSERT_BATCH);
		this.features=features;
	}
	
	/**
	 * 删除.
	 *
	 * @param sqlWhere the sql where
	 * @param layerName the layer name
	 */
	public ModifyParameter(String sqlWhere,String layerName){
		super(sqlWhere,SpatialRelation.Undefined,null,layerName,CRUD.TYPE_DELETE);
	}
	/**
	 * 删除.
	 *
	 * @param sqlWhere the sql where
	 * @param spatial the spatial
	 * @param wkt the wkt
	 * @param layerName the layer name
	 */
	public ModifyParameter(String sqlWhere,SpatialRelation spatial,String wkt,String layerName){
		super(sqlWhere,spatial,wkt,layerName,CRUD.TYPE_DELETE);
	}
	
	/**
	 * 修改.
	 *
	 * @param sqlWhere the sql where
	 * @param spatial the spatial
	 * @param wkt the wkt
	 * @param feature the feature
	 * @param layerName the layer name
	 */
	public ModifyParameter(String sqlWhere,Feature feature,String layerName){
		super(sqlWhere,SpatialRelation.Undefined,null,layerName,CRUD.TYPE_UPDATE);
		this.feature=feature;
	}
	/**
	 * 修改.
	 *
	 * @param sqlWhere the sql where
	 * @param spatial the spatial
	 * @param wkt the wkt
	 * @param feature the feature
	 * @param layerName the layer name
	 */
	public ModifyParameter(String sqlWhere,SpatialRelation spatial,String wkt,Feature feature,String layerName){
		super(sqlWhere,spatial,wkt,layerName,CRUD.TYPE_UPDATE);
		this.feature=feature;
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
	
}
