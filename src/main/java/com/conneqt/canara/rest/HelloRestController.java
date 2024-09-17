package com.conneqt.canara.rest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conneqt.canara.models.AuthenticationRequest;
import com.conneqt.canara.models.AuthenticationResponse;
import com.conneqt.canara.models.CheckDataResponse;
import com.conneqt.canara.models.canara_loans_cpl_cel_cgl;
import com.conneqt.canara.pojo.Canara_Pojo;
import com.conneqt.canara.repo.CampianRepository;
import com.conneqt.canara.security.MyUserDetailsService;
import com.conneqt.canara.service.Canara_Encryption_Decryption;
import com.conneqt.canara.service.Canara_Loans_Cpl_Cel_Cgl_Service;
import com.conneqt.canara.util.JwtUtil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@RestController
public class HelloRestController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;
	String jsonResponse = null;
	String username = "";
	String IVR = "";

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private CampianRepository campianRepo;
	
	@Autowired
	private Canara_Loans_Cpl_Cel_Cgl_Service canara_service;

	@RequestMapping(value = "/CanaraLoans_CPL_CEL_CGL", method = RequestMethod.POST)
	public ResponseEntity<?> firstPage(@RequestBody String data) {
		
		

		jsonResponse = Canara_Encryption_Decryption.decrypt(data, Canara_Pojo.getKey(), Canara_Pojo.getIvkey());
		
		JsonParser parser = new JsonParser();
		JsonElement jsonTree = parser.parse(jsonResponse);
		

		com.google.gson.JsonObject payload = jsonTree.getAsJsonObject();
		
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = dateFormat.format(currentDate);
		String mobileNumber = payload.get("mobilenumber").getAsString();
		mobileNumber = mobileNumber.substring(mobileNumber.length() - 10);
		mobileNumber = "86" + mobileNumber;
		System.out.println("Mobilenumber: " + mobileNumber);

		String loantype = payload.get("loantype").getAsString();
		System.out.println("loantype: " + loantype);
		String customername = payload.get("customername").getAsString();
		System.out.println("Customer Name: " + customername);

		canara_loans_cpl_cel_cgl campian = new canara_loans_cpl_cel_cgl();
		campian.setMobileno(mobileNumber);
		campian.setLOAN_ProductType(loantype);
		campian.setCustomer_name(customername);
		campian.setPhone(mobileNumber);
		campian.setPhone_type(1);
		campian.setRecord_type(2);
		campian.setRecord_status(1);
		campian.setCall_result(28);
		campian.setAttempt(0);
		campian.setDaily_from(0);
		campian.setDaily_till(86399);
		campian.setTz_dbid(109);
		campian.setCampaign_id(135);
		campian.setChain_n(0);
		campian.setSys_datetime(formattedDate);
		
		
		
		

		boolean saveData = canara_service.saveBOIEFRMDetailsUAT(campian);
		

		if (saveData) {
			CheckDataResponse response = new CheckDataResponse("Data Inserted Successfully" + campian.getRecordId());
			
			
			Gson gson = new Gson();
			String jsonResponse1 = gson.toJson(response);

			String encrypt = Canara_Encryption_Decryption.encrypt(jsonResponse1, Canara_Pojo.getKey(),
					Canara_Pojo.getIvkey());
			
			
			return ResponseEntity.ok(encrypt);
		} else {
			String encrypt = Canara_Encryption_Decryption.encrypt("Error Occured", Canara_Pojo.getKey(),
					Canara_Pojo.getIvkey());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(encrypt);
		}

	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody String authenticationRequest)
			throws Exception {

		try {
			jsonResponse = Canara_Encryption_Decryption.decrypt(authenticationRequest, Canara_Pojo.getKey(),
					Canara_Pojo.getIvkey());
			
			
			JsonParser parser = new JsonParser();
			JsonElement jsonTree = parser.parse(jsonResponse);

			if (jsonTree.isJsonObject()) {

				com.google.gson.JsonObject jsonObject2 = jsonTree.getAsJsonObject();

				username = jsonObject2.get("username").toString().replaceFirst("\"", "").replaceAll("\"$", "");

				

				IVR = jsonObject2.get("password").toString().replaceFirst("\"", "").replaceAll("\"$", "");

				
			}
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, IVR));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(username);

		System.out.println("USER: " + userDetails);

		final String jwtToken = jwtTokenUtil.generateToken(userDetails);

		System.out.println("JWT: " + jwtToken);

		String tokenType = "Bearer";
		
		
		AuthenticationResponse response = new AuthenticationResponse();
		
		response.setJwtToken(jwtToken);
		response.setToken_type(tokenType);
		
		Gson gson = new Gson();
		String jsonResponse = gson.toJson(response);
		String encrypt = Canara_Encryption_Decryption.encrypt(jsonResponse.toString(), Canara_Pojo.getKey(),
				Canara_Pojo.getIvkey());

		return ResponseEntity.ok(encrypt);
	}

}
