package com.conneqt.canara.models;

import java.io.Serializable;

public class AuthenticationResponse  {

    private  String jwtToken;
    private  String token_type;
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

  
    
    
}
