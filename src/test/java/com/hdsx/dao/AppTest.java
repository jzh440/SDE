package com.hdsx.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.esri.sde.sdk.client.SeConnection;
import com.esri.sde.sdk.client.SeException;
import com.hdsx.dao.data.Feature;
import com.hdsx.dao.data.jts.JTSDao;
import com.hdsx.dao.data.jts.JTSDaoImpl;
import com.hdsx.dao.exception.CRUDException;
import com.hdsx.dao.parameter.CRUD;
import com.hdsx.dao.parameter.Parameters;
import com.hdsx.dao.parameter.QueryParameter;
import com.hdsx.dao.pool.ConnectionManager;



/**
 * Unit test for simple App.
 */
public class AppTest {
  
	public static void main(String[] args) {
		
//		new PrimeThread(1).start();
//		new PrimeThread(2).start();
//		new PrimeThread(3).start();
//		new PrimeThread(4).start();
//		new PrimeThread(5).start();
//		new PrimeThread(6).start();
//		new PrimeThread(7).start();
//		new PrimeThread(8).start();
//		new PrimeThread(9).start();
//		new PrimeThread(10).start();
//		new PrimeThread(11).start();
//		new PrimeThread(12).start();
//		new PrimeThread(13).start();
		testQuery("");
	}
	public static void testConnPool(){
		
		SeConnection conn=ConnectionManager.getConn();
		try {
			System.out.println(conn.getAdminDatabaseName());
		} catch (SeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void testQuery(String name){
		QueryParameter para=new QueryParameter();
		para.setReturnGeometry(true);
		para.setCrud(CRUD.TYPE_QUERY);
		para.setLayerName("GIS_LX");
		para.setSqlWhere("");
		para.setWkt("");
		JTSDao dao=new JTSDaoImpl();
		try {
			List<Feature> features=(List<Feature>) dao.CRUDMethod(para);
			System.out.println(name+":"+features.size());
		} catch (CRUDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class PrimeThread  extends Thread{
	private int threadNum;
	public PrimeThread(int threadNum){
		this.threadNum=threadNum;
	}
	public void run(){
		ExecutorService executor=Executors.newFixedThreadPool(5);
		Collection<PooledCallback> list1=new ArrayList<PooledCallback>();
		for(int i=0;i<10;i++)
		{
			list1.add(new PooledCallback("thread-"+threadNum+":"+i));
		}
		try 
		{
			executor.invokeAll(list1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class PooledCallback implements Callable<Integer>{

	private String threadName;
	public PooledCallback(String threadName){
		this.threadName=threadName;
	}
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		AppTest.testQuery("thread-"+threadName);
		return 1;
	}
	
}