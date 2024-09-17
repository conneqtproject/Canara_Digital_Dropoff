package com.conneqt.canara.pojo;

public class Canara_Pojo {

	 private final static String key = System.getenv("ENCRYPTION_KEY");
	    private final static String ivkey = System.getenv("IV_KEY");
	public static String getKey() {
		return key;
	}
	public static String getIvkey() {
		return ivkey;
	}
}
