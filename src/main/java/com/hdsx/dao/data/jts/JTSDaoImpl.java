package com.hdsx.dao.data.jts;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.esri.sde.sdk.client.SeConnection;
import com.hdsx.dao.data.sde.SDEDao;
import com.hdsx.dao.data.sde.SDEDaoImpl;
import com.hdsx.dao.parameter.Parameters;
import com.hdsx.dao.pool.ConnectionManager;


public class JTSDaoImpl implements JTSDao {

	private SDEDao daoProxy;
	public JTSDaoImpl(){
		this.daoProxy = (SDEDao) Proxy.newProxyInstance(
				SDEDao.class.getClassLoader(),
		        new Class[]{SDEDao.class},
		        new DaoInvokeHandler());
	}
	public Object CRUDMethod(Parameters parameters) {
		// TODO Auto-generated method stub
		Object obj=null;
		switch(parameters.getCrud())
		{
			case  TYPE_INSERT:
				obj=insert(parameters);break;
			case  TYPE_DELETE:
				obj=delete(parameters);break;
			case  TYPE_UPDATE:
				obj=update(parameters);break;
			case  TYPE_QUERY:
				obj=query(parameters);break;
			default:;
		}
		return obj;
	}

	protected Object insert(Parameters parameters){
		
		return daoProxy.insert(parameters);
	}
	
	protected Object delete(Parameters parameters){
		
		return daoProxy.delete(parameters);
	}
	
	protected Object update(Parameters parameters){
		
		return daoProxy.update(parameters);
	}
	
	protected Object query(Parameters parameters){
		
		return daoProxy.query(parameters);
	}
	/**
	 * The Class DaoInvokeHandler.
	 */
	private static class DaoInvokeHandler implements InvocationHandler{
		
		/* (non-Javadoc)
		 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
		 */
		public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
			SeConnection conn=ConnectionManager.getConn();
			SDEDao sdeDao = new SDEDaoImpl(conn);
			try {
				conn.startTransaction();
				Object result = method.invoke(sdeDao, args);
				conn.commitTransaction();
				return result;
			} catch (Throwable t) {
				conn.rollbackTransaction();
				//log.error("提交出错："+t.getMessage(), t);
			} 
			finally 
			{
				ConnectionManager.free(conn);
			}
			return null;
		}
	}
}
