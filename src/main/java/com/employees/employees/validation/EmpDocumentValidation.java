package com.employees.employees.validation;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import com.employees.employees.exception.ValidatorException;
import com.employees.employees.model.EmployeeInformation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@Validated
public class EmpDocumentValidation {

	/**
	 * this method using to validate inputs
	 * 
	 * @param id
	 * @param status
	 * @throws ValidatorException
	 */
	public void validate(Integer id, String status) throws ValidatorException {
		this.valiodateId(id);
		this.validateStatus(status);

	}

	/**
	 * this method used ton validate verification status
	 * 
	 * @param status
	 * @throws ValidatorException
	 */
	private void validateStatus(String status) throws ValidatorException {
		if ("".equals(status.trim()) || status.isEmpty()) {
			log.error("input status is empty ");
			throw new ValidatorException("input status is empty ");
		}

	}

	/**
	 * this method used to validate id field
	 * 
	 * @param id
	 * @throws ValidatorException
	 */
	private void valiodateId(Integer id) throws ValidatorException {
		if (id <= 0) {
			log.error("incomminig id is less the zero");
			throw new ValidatorException("id then can be less then zero");
		}
	}

	public void validateDocuments(List<EmployeeInformation> list) throws ValidatorException {

		for (EmployeeInformation details : list) {
			this.valiodateId(details.getEmpId());
			this.validateStatus(details.getEmpEmail());
			this.valiodateAadhar(details.getAadhar());
			this.valiodateAccountNo(details.getAccountNo());
			this.valiodateEmpName(details.getEmpName());
			this.valiodateIfscCode(details.getIfscCode());
			this.valiodateMobileNumber(details.getMobileNumber());
			this.valiodatePannum(details.getPannum());
			this.valiodateRole(details.getRole());

		}

	}

	private void valiodateRole(String role) throws ValidatorException {
		if ("".equals(role.trim()) || role.isEmpty()) {
			log.error("input status is empty");
			throw new ValidatorException("input status is empty");
		}

	}
	
	/**
	 * this method used to validate pan card number
	 * @param pannum
	 * @throws ValidatorException
	 */
	private void valiodatePannum(String pannum) throws ValidatorException {

		String regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
		if (pannum == null) {
			log.error("pannum is null");
			throw new ValidatorException("pannum is null");
		}
		if(pannum.matches(regex)) {
			log.error("wrong pan number");
			throw new ValidatorException("wrong pan number");
		}
		
	}
	
	
	private void valiodateMobileNumber(String mobileNumber) throws ValidatorException {
		Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");  
		Matcher match = ptrn.matcher(mobileNumber);
		if(!(match.find() && match.group().equals(mobileNumber))){
			log.error("wrong mobile number");
			throw new ValidatorException("wrong mobile number"); 

		}
	}

	private void valiodateIfscCode(String ifscCode) throws ValidatorException {
		String regex = "^[A-Z]{4}0[A-Z0-9]{6}$";
		Pattern ptrn = Pattern.compile(regex);
		Matcher match = ptrn.matcher(ifscCode);
		if(!(match.find() && match.group().equals(ifscCode))){
			log.error("wrong IFSC code");
			throw new ValidatorException("wrong IFSC code"); 

		}

	}

	private void valiodateEmpName(String empName) throws ValidatorException {
		if("".equals(empName.trim()) && empName.isEmpty()) {
			log.error("wrong IFSC code");
			throw new ValidatorException("invalide employee nqame");
		}
	}

	private void valiodateAccountNo(long accountNo) {
		

	}

	private void valiodateAadhar(long aadhar) throws ValidatorException {
		String number =String.valueOf(aadhar);
		String regex = "^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$";
		Pattern ptrn = Pattern.compile(regex);  
		Matcher match = ptrn.matcher(number);
		if(!(match.find() && match.group().equals(aadhar))){
			log.error("wrong Aadar number");
			throw new ValidatorException("wrong Aadar number");
		}

	}

}
