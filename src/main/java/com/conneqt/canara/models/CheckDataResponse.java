package com.conneqt.canara.models;

import java.io.Serializable;

import org.json.JSONObject;

public class CheckDataResponse implements Serializable {

    private final String data;
   

    public CheckDataResponse(String data) {
        this.data = data;
		
	
    }

    public String getData() {
        return data;
    }
    
   
    
    
}
