package com.hdsx.dao.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import com.esri.sde.sdk.client.SeConnection;

public class DaoPooledObjectFactory extends BasePooledObjectFactory<SeConnection> {

	private SDEObjectPoolConfig instance=SDEObjectPoolConfig.getInstance();
	private SeConnection conn;
	@Override
	public SeConnection create() throws Exception {
		// TODO Auto-generated method stub
		conn = new SeConnection(instance.sdeHost, instance.sdePort,
				null, instance.sdeUserName, instance.sdePassword);
		//conn.testServer(1000);
		return conn;
	}

	@Override
	public PooledObject<SeConnection> wrap(SeConnection obj) {
		// TODO Auto-generated method stub
		return new DefaultPooledObject<SeConnection>(obj);
	}

}
