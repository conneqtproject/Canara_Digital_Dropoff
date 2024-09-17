package com.conneqt.canara.models;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CANARA_LOANS_CPL_CEL_CGL_PROD")
public class canara_loans_cpl_cel_cgl {
	


	@Id
	@Column(name = "record_id")
	private int recordId;
	@Column(name = "phone")
	private String phone;
	@Column(name = "phone_type")
	private int phone_type;
	@Column(name = "record_type")
	private int record_type;
	@Column(name = "record_status")
	private int record_status;
	@Column(name = "call_result")
	private int call_result;
	@Column(name = "attempt")
	private int attempt;
	@Column(name = "dial_sched_time")
	private int dial_sched_time;
	@Column(name = "call_time")
	private int call_time;
	@Column(name = "daily_from")
	private int daily_from;
	@Column(name = "daily_till")
	private int daily_till;
	@Column(name = "tz_dbid")
	private int tz_dbid;
	@Column(name = "campaign_id")
	private int campaign_id;
	@Column(name = "agent_id")
	private int agent_id;
	@Column(name = "chain_id", nullable = false)
    private int chainId;
	@Column(name = "chain_n")
	private int chain_n;
	@Column(name = "group_id")
	private int group_id;
	@Column(name = "app_id")
	private int app_id;
	@Column(name = "treatments")
	private String treatments;
	@Column(name = "media_ref")
	private int media_ref;
	@Column(name = "email_subject")
	private String email_subject;
	@Column(name = "email_template_id")
	private int email_template_id;
	@Column(name = "switch_id")
	private int switch_id;
	@Column(name = "mobileno")
	private String mobileno;
	@Column(name = "loan_producttype")
	private String LOAN_ProductType;
	@Column(name = "alert_id")
	private String Alert_ID;
	@Column(name = "Sys_datetime")
	private String Sys_datetime;
	@Column(name = "customer_name")
	private String customer_name;

	


	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPhone_type() {
		return phone_type;
	}

	public void setPhone_type(int phone_type) {
		this.phone_type = phone_type;
	}

	public int getRecord_type() {
		return record_type;
	}

	public void setRecord_type(int record_type) {
		this.record_type = record_type;
	}

	public int getRecord_status() {
		return record_status;
	}

	public void setRecord_status(int record_status) {
		this.record_status = record_status;
	}

	public int getCall_result() {
		return call_result;
	}

	public void setCall_result(int call_result) {
		this.call_result = call_result;
	}

	public int getAttempt() {
		return attempt;
	}

	public void setAttempt(int attempt) {
		this.attempt = attempt;
	}

	public int getDial_sched_time() {
		return dial_sched_time;
	}

	public void setDial_sched_time(int dial_sched_time) {
		this.dial_sched_time = dial_sched_time;
	}

	public int getCall_time() {
		return call_time;
	}

	public void setCall_time(int call_time) {
		this.call_time = call_time;
	}

	public int getDaily_from() {
		return daily_from;
	}

	public void setDaily_from(int daily_from) {
		this.daily_from = daily_from;
	}

	public int getDaily_till() {
		return daily_till;
	}

	public void setDaily_till(int daily_till) {
		this.daily_till = daily_till;
	}

	public int getTz_dbid() {
		return tz_dbid;
	}

	public void setTz_dbid(int tz_dbid) {
		this.tz_dbid = tz_dbid;
	}

	public int getCampaign_id() {
		return campaign_id;
	}

	public void setCampaign_id(int campaign_id) {
		this.campaign_id = campaign_id;
	}

	public int getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}

	



	public int getChainId() {
		return chainId;
	}



	public void setChainId(int chainId) {
		this.chainId = chainId;
	}



	public int getChain_n() {
		return chain_n;
	}

	public void setChain_n(int chain_n) {
		this.chain_n = chain_n;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public int getApp_id() {
		return app_id;
	}

	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}

	public String getTreatments() {
		return treatments;
	}

	public void setTreatments(String treatments) {
		this.treatments = treatments;
	}

	public int getMedia_ref() {
		return media_ref;
	}

	public void setMedia_ref(int media_ref) {
		this.media_ref = media_ref;
	}

	public String getEmail_subject() {
		return email_subject;
	}

	public void setEmail_subject(String email_subject) {
		this.email_subject = email_subject;
	}

	public int getEmail_template_id() {
		return email_template_id;
	}

	public void setEmail_template_id(int email_template_id) {
		this.email_template_id = email_template_id;
	}

	public int getSwitch_id() {
		return switch_id;
	}

	public void setSwitch_id(int switch_id) {
		this.switch_id = switch_id;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getLOAN_ProductType() {
		return LOAN_ProductType;
	}

	public void setLOAN_ProductType(String lOAN_ProductType) {
		LOAN_ProductType = lOAN_ProductType;
	}

	public String getAlert_ID() {
		return Alert_ID;
	}

	public void setAlert_ID(String alert_ID) {
		Alert_ID = alert_ID;
	}

	public String getSys_datetime() {
		return Sys_datetime;
	}

	public void setSys_datetime(String sys_datetime) {
		Sys_datetime = sys_datetime;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	
	
	 public static int generateRandomInt(int min, int max) {
	        Random random = new Random();
	        return random.nextInt((max - min) + 1) + min;
	    }

}
