package com.hdsx.dao.pool;

import java.util.*;
import java.io.*;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;




public class SDEObjectPoolConfig  extends GenericObjectPoolConfig {
	
	static final SDEObjectPoolConfig instance = new SDEObjectPoolConfig();

	String sdeHost;//SDE 主机
	String sdePort;	//SDE 端口
	String sdeUserName;//Oracle 用户户
	String sdePassword;//Oracle 密码
	private SDEObjectPoolConfig() {
		try {
			InputStream is = getClass().getResourceAsStream("/application.properties");
			Properties dbProps = new Properties();
			dbProps.load(is);
			sdeHost = dbProps.getProperty("SDEHost");
			sdePort = dbProps.getProperty("SDEPort");
			sdeUserName = dbProps.getProperty("SDEUserName");
			sdePassword = dbProps.getProperty("SDEPassword");
			instance.setMinIdle(new Integer(dbProps.getProperty("maxTotal",DEFAULT_MAX_TOTAL+"")).intValue());
			instance.setMaxIdle(new Integer(dbProps.getProperty("maxIdle",DEFAULT_MAX_IDLE+"")).intValue());
			instance.setMaxTotal(new Integer(dbProps.getProperty("minIdle",DEFAULT_MIN_IDLE+"")).intValue());
			instance.setMaxWaitMillis(new Integer(dbProps.getProperty("maxWaitMillis",DEFAULT_MAX_WAIT_MILLIS+"")).intValue());
		} catch (Exception e) {
			//log.error("读取数据库连接配置文件出错");
		}
	}
	


	public String getSdeHost() {
		return sdeHost;
	}

	public String getSdePassword() {
		return sdePassword;
	}

	public String getSdePort() {
		return sdePort;
	}

	public String getSdeUserName() {
		return sdeUserName;
	}



	public static SDEObjectPoolConfig getInstance() {
		return instance;
	}



	public void setSdeHost(String sdeHost) {
		this.sdeHost = sdeHost;
	}



	public void setSdePort(String sdePort) {
		this.sdePort = sdePort;
	}



	public void setSdeUserName(String sdeUserName) {
		this.sdeUserName = sdeUserName;
	}



	public void setSdePassword(String sdePassword) {
		this.sdePassword = sdePassword;
	}
	




}