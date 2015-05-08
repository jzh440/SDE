package com.hdsx.dao.data;

import java.util.LinkedHashMap;
import java.util.Map;

import com.vividsolutions.jts.geom.Geometry;


public class Feature {

	private Map<String,Object> attributes=new LinkedHashMap<String,Object>();
	

	private byte[] wkb;
	
	private Geometry shape;
	
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}


	public byte[] getWkb() {
		return wkb;
	}

	public void setWkb(byte[] wkb) {
		this.wkb = wkb;
	}

	public Geometry getShape() {
		return shape;
	}

	public void setShape(Geometry shape) {
		this.shape = shape;
	}


	
}
