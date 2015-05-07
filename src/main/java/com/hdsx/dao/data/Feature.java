package com.hdsx.dao.data;

import java.util.LinkedHashMap;
import java.util.Map;


public class Feature {

	private Map<String,Object> attributes=new LinkedHashMap<String,Object>();
	
	private String wkt;

	private byte[] wkb;
	
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public String getWkt() {
		return wkt;
	}

	public void setWkt(String wkt) {
		this.wkt = wkt;
	}

	public byte[] getWkb() {
		return wkb;
	}

	public void setWkb(byte[] wkb) {
		this.wkb = wkb;
	}


	
}
