package com.hdsx.dao.data.sde;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.esri.sde.sdk.client.SeConnection;
import com.esri.sde.sdk.client.SeException;
import com.esri.sde.sdk.client.SeInsert;
import com.esri.sde.sdk.client.SeQuery;
import com.esri.sde.sdk.client.SeQueryInfo;
import com.esri.sde.sdk.client.SeRow;
import com.esri.sde.sdk.client.SeSqlConstruct;
import com.hdsx.dao.data.Feature;
import com.hdsx.dao.data.wapper.FeatureWapper;
import com.hdsx.dao.data.wapper.IFeatureWapper;
import com.hdsx.dao.exception.CRUDException;
import com.hdsx.dao.parameter.ModifyParameter;
import com.hdsx.dao.parameter.Parameters;
import com.hdsx.dao.parameter.QueryParameter;

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
		try 
		{
			QueryParameter queryParameter=(QueryParameter)parameters;
			SeQuery query=new SeQuery(conn);
			SeSqlConstruct sqlC = new SeSqlConstruct(parameters.getLayerName());
			sqlC.setWhere(parameters.getSqlWhere());
			SeQueryInfo seQueryInfo = new SeQueryInfo();
			seQueryInfo.setConstruct(sqlC);
			seQueryInfo.setColumns(queryParameter.getOutFields());
			if(queryParameter.getOrderByFields()!=null){
				seQueryInfo.setByClause(queryParameter.getOrderByFields());
			}
			query.prepareQueryInfo(seQueryInfo);
			query.execute();  
			SeRow row=query.fetch();
			Feature feature;
			while(row!=null){
				feature=wapper.SeRow2Feature(row);
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
		} 
		return features;
	}

	public int insert(Parameters parameters) {
		try 
		{	ModifyParameter modifyParameter=(ModifyParameter)parameters;
			SeInsert insert=new SeInsert(conn);
			Set<String> colsSet=modifyParameter.getFeature().getAttributes().keySet();
			String[] arrCols=modifyParameter.getFeature().getAttributes().keySet().toArray(new String[colsSet.size()]);
			insert.intoTable(parameters.getLayerName(),arrCols );
			insert.setWriteMode(true);
			SeRow row = insert.getRowToSet();
			insert.execute();
			insert.close();
		} 
		catch (Exception e) {
			log.error("插入失败:"+e.getMessage());
			e.printStackTrace();
		} 
		return 1;
	}

	public int update(Parameters parameters) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Parameters parameters) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int count(Parameters parameters) {
		// TODO Auto-generated method stub
		return 0;
	}

}
