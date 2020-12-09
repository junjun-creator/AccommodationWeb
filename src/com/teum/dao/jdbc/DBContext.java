package com.teum.dao.jdbc;

public class DBContext {

	public final static String URL;
	public final static String UID;
	public final static String PWD;
	
	// 여기서 초기화를 하는 이유는 이 정보를 텍스트 파일에 둘 것이기 때문에 거기서 읽어오게 된다.
	// 텍스트 내용만 변경하면 되기 때문에 유지보수 측면에서 장점이 있다.
	static {
		URL = "jdbc:oracle:thin:@HI.namoolab.com:1521/xepdb1";
		UID = "TEUM";
		PWD = "4444";
	}
}
