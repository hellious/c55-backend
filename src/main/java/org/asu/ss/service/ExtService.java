package org.asu.ss.service;

import java.util.Date;

import org.asu.ss.C55_Backend.SendOTPforTransactions;
import org.asu.ss.C55_Backend.SendaMail;
import org.asu.ss.dao.ExtDAO;
import org.asu.ss.model.ExternalUser;
import org.asu.ss.model.OTP;
import org.asu.ss.model.TempExternalUser;
import org.asu.ss.model.TempTransaction;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

public class ExtService {

	@Autowired
	private ExtDAO extDAO;
	private String generatedOTPValue;
	private String generatedOTPValueforTransactions;

	public void setExtDAO(ExtDAO extDAO) {
		this.extDAO = extDAO;
	}

	TempExternalUser tempExternalUserOutput = null;
	OTP otpobjectforexternaluser = null;
	OTP otpobjectfortransactions = null;
	ExternalUser permanentupdateprofile = null;
	TempTransaction temptransactionoutput = null;

	// For Profile Update
	public String[] generateOTP(TempExternalUser tempexternaluser, String fieldtobeUpdated) {
		SendaMail otpSend = new SendaMail();
		String[] responsetoController = otpSend.mailtheOTP(tempexternaluser, fieldtobeUpdated);
		generatedOTPValue = responsetoController[1];
		return responsetoController;
	}

	// For Profile Update
	public String tempUpdateProfile(TempExternalUser tempexternaluser, String FieldtobeUpdated) // where

	{
		String[] responsetoUI = this.generateOTP(tempexternaluser, FieldtobeUpdated);
		tempexternaluser.setOtp_value(generatedOTPValue);

		System.out.println("data to temp table");
		tempExternalUserOutput = this.extDAO.tempExternalUser(tempexternaluser);
		System.out.println(tempExternalUserOutput.getCust_id() + tempExternalUserOutput.getId());
		System.out.println("data to temp table inserted");

		System.out.println("data to OTP table");
		writeOtptoDB(tempExternalUserOutput, generatedOTPValue, FieldtobeUpdated);
		System.out.println("data to OTP table completed");
		return responsetoUI[0];
	}

	// For Profile Update
	public void writeOtptoDB(TempExternalUser tempExternalOutput, String otpGenerated, String fieldtobeUpdated) {
		Date opt_ts2 = new Date(); // import joda
		String otp_purpose = fieldtobeUpdated;
		otpobjectforexternaluser = new OTP();

		otpobjectforexternaluser.setC_id(tempExternalOutput.getCust_id());
		otpobjectforexternaluser.setMobile(tempExternalOutput.getMobile());
		otpobjectforexternaluser.setMobile_carrier(tempExternalOutput.getMobile_carrier());
		otpobjectforexternaluser.setOpt_ts(opt_ts2);
		otpobjectforexternaluser.setOtp_id(tempExternalOutput.getId());
		otpobjectforexternaluser.setOtp_purpose(otp_purpose);
		otpobjectforexternaluser.setOtp_value(otpGenerated);
		otpobjectforexternaluser.setEmail(tempExternalOutput.getEmail());

		this.extDAO.tempWriteOTPtoDB(otpobjectforexternaluser);
	}

	// For Profile Update
	public String validateOTP(TempExternalUser tempexternaluser, String inputOTP) {
		Date opt_ts3 = new Date();
		long customerID = tempexternaluser.getCust_id();
		long otpID = tempexternaluser.getId();
		System.out.println(" Value is - " + tempexternaluser.getCust_id() + "f" + tempexternaluser.getId());
		TempExternalUser fetchedtempObject = this.extDAO.fetchtempdetailsforOTPValidation(customerID, otpID);
		OTP fetchedotpObject = this.extDAO.fetchdetailsforOTPValidation(customerID, otpID);
		// if (fetchedotpObject.getOpt_ts().plusMinutes(15) == opt_ts3) {
		System.out.println(fetchedotpObject.getOtp_value() + inputOTP);
		if (fetchedotpObject.getOtp_value().equals(inputOTP)) {
			System.out.println(fetchedtempObject.getItem());
			System.out.println("hey " + fetchedtempObject.getEmail());
			permanentUpdateCustomerProfile(fetchedtempObject, fetchedtempObject.getItem());
			return "Validaton Successful";
		} else
			return "Wrong OTP entered";
	}
	/*
	 * else { return "OTP Value Expired - Request for new OTP"; }}
	 */

	// For Profile Update
	private void permanentUpdateCustomerProfile(TempExternalUser tempexternaluser, String updatedItem) {
		System.out.println("Entered permanentUpdateCustomerProfile");

		permanentupdateprofile = new ExternalUser();
		permanentupdateprofile.setCust_id(tempexternaluser.getCust_id());
		if (updatedItem.equals("Mobile")) {
			permanentupdateprofile.setMobile(tempexternaluser.getMobile());
			permanentupdateprofile.setMobile_carrier(tempexternaluser.getMobile_carrier());
		} else if (updatedItem.equals("Email")) {
			System.out.println("The email is" + tempexternaluser.getEmail());
			permanentupdateprofile.setEmail(tempexternaluser.getEmail());
		}

		this.extDAO.permanentUpdatetoDb(permanentupdateprofile, updatedItem);

	}

	// For Transactions
	public String[] generateOTPforTransactions(TempTransaction temptransaction, String fieldtobeUpdated) {
		SendOTPforTransactions otpfortransactions = new SendOTPforTransactions();
		String[] responsetoController = otpfortransactions.mailtheOTPforTransactions(temptransaction, fieldtobeUpdated);
		generatedOTPValueforTransactions = responsetoController[1];
		return responsetoController;
	}

	// For Transactions
	public String updateOTPTransactionsTable(TempTransaction temptransaction, String FieldtobeUpdated) // where

	{
		String[] responseforotptransactions = this.generateOTPforTransactions(temptransaction, FieldtobeUpdated);
		temptransaction.setOtp_value(generatedOTPValueforTransactions);

		System.out.println("data to temp trans table");
		temptransactionoutput = this.extDAO.temptransupdate(temptransaction);
		System.out.println(temptransactionoutput.getCust_id() + temptransactionoutput.getId());
		System.out.println("data to temp trans table inserted");

		System.out.println("data to OTP table");
		writeOtptoTransDB(temptransactionoutput, generatedOTPValueforTransactions, FieldtobeUpdated);
		System.out.println("data to OTP table completed");
		return responseforotptransactions[0];
	}

	private void writeOtptoTransDB(TempTransaction temptrans2, String otp,String fieldtobeUpdated) 
	{
		Date opt_ts2 = new Date(); // import joda
		String otp_purpose = fieldtobeUpdated;
		otpobjectfortransactions = new OTP();

		otpobjectfortransactions.setC_id(temptrans2.getCust_id());
		otpobjectfortransactions.setMobile(temptrans2.getMobile());
		otpobjectfortransactions.setMobile_carrier(temptrans2.getMobile_carrier());
		otpobjectfortransactions.setOpt_ts(opt_ts2);
		otpobjectfortransactions.setOtp_id(temptrans2.getId());
		otpobjectfortransactions.setOtp_purpose(otp_purpose);
		otpobjectfortransactions.setOtp_value(otp);
		otpobjectfortransactions.setEmail(temptrans2.getEmail());

		this.extDAO.tempWriteOTPtoDB(otpobjectfortransactions);
		
	}

	// For Transactions
	public String validateOTPforTransactions(TempTransaction temptransaction, String inputOTP) {
		Date opt_ts3 = new Date();
		long customerID = temptransaction.getCust_id();
		long otpID = temptransaction.getId();
		System.out.println(" Value is - " + temptransaction.getCust_id() + "f" + temptransaction.getId());
		TempTransaction fetchedtempObjectfortransactions = this.extDAO.fetchtemptransdetailsforOTPValidation(customerID, otpID);
		OTP fetchedotpTransObject = this.extDAO.fetchdetailsforOTPValidation(customerID, otpID);
		// if (fetchedotpObject.getOpt_ts().plusMinutes(15) == opt_ts3) {
		System.out.println(fetchedotpTransObject.getOtp_value() + inputOTP);
		if (fetchedotpTransObject.getOtp_value().equals(inputOTP)) {
			System.out.println(fetchedtempObjectfortransactions.getItem());
			System.out.println("hey " + fetchedtempObjectfortransactions.getEmail());
			return "Validaton Successful";
		} else
			return "Wrong OTP entered";
	}
	/*
	 * else { return "OTP Value Expired - Request for new OTP"; }}
	 */

}
