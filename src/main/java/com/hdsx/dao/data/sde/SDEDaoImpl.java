package com.hdsx.dao.data.sde;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.esri.sde.sdk.client.SeConnection;
import com.esri.sde.sdk.client.SeDelete;
import com.esri.sde.sdk.client.SeException;
import com.esri.sde.sdk.client.SeFilter;
import com.esri.sde.sdk.client.SeInsert;
import com.esri.sde.sdk.client.SeLayer;
import com.esri.sde.sdk.client.SeQuery;
import com.esri.sde.sdk.client.SeQueryInfo;
import com.esri.sde.sdk.client.SeRow;
import com.esri.sde.sdk.client.SeShape;
import com.esri.sde.sdk.client.SeShapeFilter;
import com.esri.sde.sdk.client.SeSqlConstruct;
import com.esri.sde.sdk.client.SeStreamOp;
import com.esri.sde.sdk.client.SeUpdate;
import com.hdsx.dao.data.Feature;
import com.hdsx.dao.data.wapper.FeatureWapper;
import com.hdsx.dao.data.wapper.IFeatureWapper;
import com.hdsx.dao.exception.CRUDException;
import com.hdsx.dao.parameter.ModifyParameter;
import com.hdsx.dao.parameter.Parameters;
import com.hdsx.dao.parameter.QueryParameter;
import com.hdsx.dao.parameter.SpatialRelation;

public class SDEDaoImpl implements SDEDao {
	
	private Logger log=LoggerFactory.getLogger(SDEDaoImpl.class);
	
	private IFeatureWapper wapper;
	private SeConnection conn;
	
	public SDEDaoImpl(){}
	
	public SDEDaoImpl(SeConnection conn)
	{
		this.conn=conn;
		wapper=new FeatureWapper();
	}
	
	public List<Feature> query(Parameters parameters) throws CRUDException{
		List<Feature> features=new ArrayList<Feature>();
		SeQuery query=null;
		SeLayer layer=null;
		SeFilter[] filters=null;
		SeShape shape=null;
		try 
		{
			QueryParameter queryParameter=(QueryParameter)parameters;
			query=new SeQuery(conn);
			SeSqlConstruct sqlC = new SeSqlConstruct(parameters.getLayerName());
			sqlC.setWhere(parameters.getSqlWhere());
			SeQueryInfo seQueryInfo = new SeQueryInfo();
			seQueryInfo.setConstruct(sqlC);
			seQueryInfo.setColumns(queryParameter.getOutFields());
			if(queryParameter.getOrderByFields()!=null){
				seQueryInfo.setByClause(queryParameter.getOrderByFields());
			}
			query.prepareQueryInfo(seQueryInfo);
			if(!parameters.getSpatial().equals(SpatialRelation.Undefined))
			{
				layer=new SeLayer(conn);
				filters = new SeFilter[1]; 
		        shape = new SeShape(layer.getCoordRef()); 
		        shape.generateFromText(queryParameter.getWkt());
		        filters[0] = new SeShapeFilter(parameters.getLayerName(), layer.getSpatialColumn(), shape, parameters.getSpatial().getSdeSpatial());
				query.setSpatialConstraints(SeQuery.SE_SPATIAL_FIRST, false, filters);
			}
			query.execute(); 
			SeRow row=query.fetch();
			Feature feature;
			while(row!=null){
				feature=wapper.SeRow2Feature(row,queryParameter.isReturnGeometry());
				features.add(feature);
				row=query.fetch();
			}
		} 
		catch (SeException e) {
			log.error("SDE数据查询失败{}",e.getSeError());
			throw new CRUDException(e);
		} catch (Exception e) {
			log.error("类型转换失败{}",e.getMessage());
			throw new CRUDException(e);
		} finally {
			closeStream(query);
		}
		return features;
	}

	public int insert(Parameters parameters) throws CRUDException{
		ModifyParameter modifyParameter=(ModifyParameter)parameters;
		SeInsert insert=null;
		try 
		{	
			insert=new SeInsert(conn);
			Set<String> colsSet=modifyParameter.getFeature().getAttributes().keySet();
			String[] colsArr=colsSet.toArray(new String[colsSet.size()]);
			insert.intoTable(parameters.getLayerName(),colsArr );
			insert.setWriteMode(true);
			SeRow row = insert.getRowToSet();
			wapper.Feature2SeRow(modifyParameter.getFeature(), row);
			insert.execute();
		} catch (SeException e) {
			log.error("SDE数据查询失败{}",e.getSeError());
			throw new CRUDException(e.getCause());
		} catch (Exception e) {
			log.error("数据{}插入失败{}",modifyParameter.getFeature().toString(),e.getMessage());
			throw new CRUDException(e.getCause());
		} finally {
			closeStream(insert);
		}
		return 1;
	}

	public int update(Parameters parameters) throws CRUDException{
		ModifyParameter modifyParameter=(ModifyParameter)parameters;
		SeUpdate update=null;
		try 
		{
			update  =new SeUpdate(conn);
			Set<String> keys=modifyParameter.getFeature().getAttributes().keySet();
			String[] colsName=keys.toArray(new String[keys.size()]);
			update.toTable(parameters.getLayerName(), colsName, parameters.getSqlWhere());
			SeRow row = update.getRowToSet ();
			wapper.Feature2SeRow(modifyParameter.getFeature(), row);
			update.execute();
		} catch (SeException e) {
			log.error("SDE数据更新失败{}",e.getSeError());
			throw new CRUDException(e.getCause());
		} catch (Exception e) {
			log.error("更新失败:"+e.getMessage());
			throw new CRUDException(e.getCause());
		} finally {
			closeStream(update);
		}
		return 1;
	}

	public int delete(Parameters parameters) throws CRUDException{
		SeDelete delete=null;
		try
		{
			delete=new SeDelete(conn);
			delete.fromTable(parameters.getLayerName(), parameters.getSqlWhere());
			delete.execute();
		} catch (SeException e) {
			log.error("删除失败{}",e.getSeError());
			throw new CRUDException(e.getCause());
		} finally {
			closeStream(delete);
		} 
		return 1;
	}

	public int count(Parameters parameters) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void closeStream(SeStreamOp streamOp)throws CRUDException{
		if(streamOp!=null){
			try {
				streamOp.close();
			} catch (SeException e) {
				log.error("流关闭异常", e.getSeError());
				throw new CRUDException(e.getCause());
			}
		}
	}

}
