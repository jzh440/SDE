package com.hdsx.dao.parameter;

public enum SpatialRelation {
	/** 关系未定义. */
	Undefined(0),
	
	/** A与B相交. */
	Intersects(2),
	
	/** A的包络与B包络相交. */
	EnvelopeIntersects(2),
	
	/** A的索引与B索引相交. */
	IndexIntersects(3),
	
	/** A与B相接即边界处相接. */
	Touches(3),
	
	/** A与B相叠加，他们必须是同维对象，如都是多边形. */
	Overlaps(7),
	
	/** A与B相交，如两条线交于一点，面和线交于一条线. */
	Crosses(4),
	
	/** A在B的内部. */
	Within(5),
	
	/** A被B的包含. */
	Contains(6);
	
	
	private final int spatial;
	
	private SpatialRelation(int spatial){
		this.spatial=spatial;
	}

	public int getSpatial() {
		return spatial;
	}
	
	
}
