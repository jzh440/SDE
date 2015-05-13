package com.hdsx.dao.pool;

import java.util.NoSuchElementException;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;

import com.esri.sde.sdk.client.SeConnection;


public class ConnectionManager  {

	private static GenericObjectPool<SeConnection> pool; 
	private SDEObjectPoolConfig config=SDEObjectPoolConfig.getInstance();
	private PooledObjectFactory<SeConnection> factory=new DaoPooledObjectFactory();
	static
	{
		new ConnectionManager();
	}
	private ConnectionManager(){
		pool=new GenericObjectPool<SeConnection>(factory, config);
	}
	public static SeConnection getConn(){
		try 
		{
			return pool.borrowObject();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void free(SeConnection conn){
		try 
		{
			System.out.println("当前借出:"+pool.getNumActive());
			System.out.println("当前可用:"+pool.getNumIdle());
			System.out.println("当前等待:"+pool.getNumWaiters());
			pool.returnObject(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
