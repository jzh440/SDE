package com.hdsx.dao.data.sde;

import java.util.List;

import com.esri.sde.sdk.client.SeConnection;
import com.esri.sde.sdk.client.SeException;
import com.esri.sde.sdk.client.SeQuery;
import com.esri.sde.sdk.client.SeQueryInfo;
import com.esri.sde.sdk.client.SeRow;
import com.esri.sde.sdk.client.SeSqlConstruct;
import com.hdsx.dao.data.Feature;
import com.hdsx.dao.parameter.Parameters;

public class SDEDaoImpl implements SDEDao {

	private SeConnection conn;
	
	public SDEDaoImpl(){}
	
	public SDEDaoImpl(SeConnection conn)
	{
		this.conn=conn;
	}
	
	public List<Feature> query(Parameters parameters) {
		// TODO Auto-generated method stub
		try 
		{
			SeQuery query=new SeQuery(conn);
			SeSqlConstruct sqlC = new SeSqlConstruct(parameters.getLayerName());
			sqlC.setWhere(parameters.getSqlWhere());
			SeQueryInfo seQueryInfo = new SeQueryInfo();
			seQueryInfo.setConstruct(sqlC);
			seQueryInfo.setColumns(new String[] {"*"});
			query.prepareQueryInfo(seQueryInfo);
			query.execute();  
			SeRow row=query.fetch();
			while(row!=null)
			{
				row.getColumns();
				row=query.fetch();
			}
			//return SDEUtils.setRows(query, o).get(0);
		} 
		catch (SeException e) {
			//log.error("单条查询失败:"+e.getMessage());
			e.printStackTrace();
		} 
		return null;
	}

	public int insert(Parameters parameters) {
		// TODO Auto-generated method stub
		return 0;
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
