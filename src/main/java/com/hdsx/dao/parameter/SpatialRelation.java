package com.hdsx.dao.parameter;

import com.esri.sde.sdk.client.SeFilter;

/**
 * switch (filter.getFilterType()) {
case FilterType.GEOMETRY_BBOX:
    addSpatialFilter(filter, SeFilter.METHOD_ENVP, true);

    break;

case FilterType.GEOMETRY_CONTAINS:
    addSpatialFilter(filter, SeFilter.METHOD_PC, true);

    break;

case FilterType.GEOMETRY_CROSSES:
    addSpatialFilter(filter, SeFilter.METHOD_LCROSS_OR_CP, true);

    break;

case FilterType.GEOMETRY_DISJOINT:
    addSpatialFilter(filter, SeFilter.METHOD_II_OR_ET, false);

    break;

case FilterType.GEOMETRY_EQUALS:
    addSpatialFilter(filter, SeFilter.METHOD_IDENTICAL, true);

    break;

case FilterType.GEOMETRY_INTERSECTS:
    addSpatialFilter(filter, SeFilter.METHOD_II_OR_ET, true);

    break;

case FilterType.GEOMETRY_OVERLAPS:
    addSpatialFilter(filter, SeFilter.METHOD_II, true);
    addSpatialFilter(filter, SeFilter.METHOD_PC, false);
    addSpatialFilter(filter, SeFilter.METHOD_SC, false);

    break;

case FilterType.GEOMETRY_WITHIN:
    addSpatialFilter(filter, SeFilter.METHOD_SC, true);

    break;

default: {
    // This shouldn't happen since we will have pulled out
    // the unsupported parts before invoking this method
    String msg = "unsupported filter type";
    log.warning(msg);
}
}*/
public enum SpatialRelation {
	/** 关系未定义. */
	Undefined("Undefined",-1),
	
	/** A与B相交. */
	Intersects("Intersects",SeFilter.METHOD_II_OR_ET),
	
//	/** A的包络与B包络相交. */
//	EnvelopeIntersects(),
//	
//	/** A的索引与B索引相交. */
//	IndexIntersects(3),
	
	/** A与B相接即边界处相接. */
	Touches("Touches",SeFilter.METHOD_ET_OR_AI ),
	
	/** A与B相叠加，他们必须是同维对象，如都是多边形. */
	Overlaps("Overlaps",SeFilter.METHOD_II),
	
	/** A与B相交，如两条线交于一点，面和线交于一条线. */
	Crosses("Crosses",SeFilter.METHOD_LCROSS_OR_CP),
	
	/** A在B的内部. */
	Within("Within",SeFilter.METHOD_SC),
	
	/** A被B的包含. */
	Contains("Contains",SeFilter.METHOD_PC);
	
	
	
	private int sdeSpatial;
	
	private String jtsSpatial;
	
	private SpatialRelation(String jtsSpatial,int sdeSpatial){
		this.jtsSpatial=jtsSpatial;
		this.sdeSpatial=sdeSpatial;
	}

	public int getSdeSpatial() {
		return sdeSpatial;
	}

	public String getJtsSpatial() {
		return jtsSpatial;
	}
	
	
}
