package com.hdsx.dao.parameter;


public enum CRUD {
	TYPE_INSERT(1),
	TYPE_DELETE(2),
	TYPE_UPDATE(3),
	TYPE_QUERY(4),
	TYPE_INSERT_BATCH(5),
	TYPE_QUERY_LIST(5);;
	
	private final int type;
	
	private CRUD(int type){
		this.type=type;
	}
	public  int getCrud() {
		return type;
	}
}
