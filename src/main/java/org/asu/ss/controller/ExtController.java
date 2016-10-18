package org.asu.ss.controller;

import org.asu.ss.model.TempExternalUser;
import org.asu.ss.model.TempTransaction;
import org.asu.ss.service.ExtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExtController {
	@Autowired
	private ExtService extService;

	public void setExtService(ExtService extService) {
		this.extService = extService;
	}

	//To update the profile(otp verification)
	@RequestMapping(value = {
			"/externaluserControllers/verify" }, method = RequestMethod.POST, produces = MediaType.ALL_VALUE)
	public ResponseEntity<String> validateOTP(@RequestBody TempExternalUser tempexternaluser) {

		String response;
		response = extService.validateOTP(tempexternaluser, tempexternaluser.getOtp_value());
		if (response.equals("Validaton Successful")) {
			return new ResponseEntity<String>(response, HttpStatus.OK);
		} else if (response.equals("Wrong OTP entered")) {
			return new ResponseEntity<String>(response, HttpStatus.EXPECTATION_FAILED);
		} else {
			return new ResponseEntity<String>("OTP Value Expired - Request for new OTP", HttpStatus.NOT_MODIFIED);
		}
	}

	//To update the profile(OTP Generation)
	@RequestMapping(value = "/externaluserControllerr/update", method = RequestMethod.POST, produces = MediaType.ALL_VALUE)
	public ResponseEntity<String> updateInfo(@RequestBody TempExternalUser tempexternaluser) {
		String response = "Error - Profile Update cannot be completed.";
		try {

			response = extService.tempUpdateProfile(tempexternaluser, tempexternaluser.getItem());
			if (response != null) {
				return new ResponseEntity<String>(response, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(response, HttpStatus.NOT_MODIFIED);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return new ResponseEntity<String>(response, HttpStatus.NOT_MODIFIED);
		}

	}

	//To update the transactions(OTP Validation)
		@RequestMapping(value = {
				"/externaluserControllers/verifytrans" }, method = RequestMethod.POST, produces = MediaType.ALL_VALUE)
		public ResponseEntity<String> validateOTPforTransactions(@RequestBody TempTransaction temptrans) {

			String response;
			response = extService.validateOTPforTransactions(temptrans, temptrans.getOtp_value());
			if (response.equals("Validaton Successful")) {
				return new ResponseEntity<String>(response, HttpStatus.OK);
			} else if (response.equals("Wrong OTP entered")) {
				return new ResponseEntity<String>(response, HttpStatus.EXPECTATION_FAILED);
			} else {
				return new ResponseEntity<String>("OTP Value Expired - Request for new OTP", HttpStatus.NOT_MODIFIED);
			}
		}

		//To update the transactions(OTP Generation)
		@RequestMapping(value = "/externaluserControllerr/updatetrans", method = RequestMethod.POST, produces = MediaType.ALL_VALUE)
		public ResponseEntity<String> updateInfoTrans(@RequestBody TempTransaction temptrans) {
			String response = "Error - Profile Update cannot be completed.";
			try {

				response = extService.updateOTPTransactionsTable(temptrans, temptrans.getItem());
				if (response != null) {
					return new ResponseEntity<String>(response, HttpStatus.OK);
				} else {
					return new ResponseEntity<String>(response, HttpStatus.NOT_MODIFIED);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				 return new ResponseEntity<String>(response, HttpStatus.NOT_MODIFIED);
			}

		}
}
