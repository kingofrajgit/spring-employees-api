package com.employees.employees.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import com.employees.employees.dto.ValidateResultDTO;
import com.employees.employees.exception.ValidatorException;
import com.employees.employees.model.EmployeeInformation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@Validated
public class EmpDocumentValidation {

	public String result = "sucess";

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

	private void validateStatus(String status) throws ValidatorException {
		if ("".equals(status.trim()) || status.isEmpty()) {
			log.error("input status is empty ");
			throw new ValidatorException("input status is empty ");
		}

	}

	private void valiodateId(Integer id) throws ValidatorException {
		if (id <= 0) {
			log.error("incomminig id is less the zero");
			throw new ValidatorException("id then can be less then zero");
		}
	}
	
	/**
	 * this method is used to validate all fields and get error or success message
	 * @param list
	 * @return
	 * @throws ValidatorException
	 */
	public List<ValidateResultDTO> validateDocuments(List<EmployeeInformation> list) throws ValidatorException {
		List<ValidateResultDTO> listDto = new ArrayList<>();
		ValidateResultDTO resultDto = null;
		for (EmployeeInformation details : list) {
			 resultDto = new ValidateResultDTO();
			this.validateId(details.getEmpId(), resultDto);
			this.validateEmpEmail(details.getEmpEmail(), resultDto);
			this.validateAadhar(details.getAadhar(), resultDto);
			this.validateAccountNo(details.getAccountNo(), resultDto);
			this.validateEmpName(details.getEmpName(), resultDto);
			this.validateIfscCode(details.getIfscCode(), resultDto);
			this.validateMobileNumber(details.getMobileNumber(), resultDto);
			this.validatePannum(details.getPannum(), resultDto);
			this.validateRole(details.getRole(), resultDto);
			listDto.add(resultDto);
		}
		return listDto;

	}

	/**
	 * this method used ton validate verification status
	 * 
	 * @param status
	 * @param resultDto
	 * @throws ValidatorException
	 */
	private void validateEmpEmail(String empEmail, ValidateResultDTO resultDto) throws ValidatorException {
		if ("".equals(empEmail.trim()) || empEmail.isEmpty()) {
			log.error("input status is empty ");
			resultDto.setEmpEmailResult("input status is empty ");
		}

	}

	/**
	 * this method used to validate id field
	 * 
	 * @param id
	 * @param resultDto
	 * @throws ValidatorException
	 */
	private void validateId(Integer id, ValidateResultDTO resultDto) throws ValidatorException {
		if (id <= 0) {
			log.error("incomminig id is less the zero");
			throw new ValidatorException("id then can be less then zero");
		}
		
	}

	private void validateRole(String role, ValidateResultDTO resultDto) throws ValidatorException {
		if ("".equals(role.trim()) || role.isEmpty()) {
			log.error("input status is empty");
			resultDto.setRoleResult("input status is empty");
		} else {
			resultDto.setRoleResult(this.result);
		}

	}

	/**
	 * this method used to validate pan card number
	 * 
	 * @param pannum
	 * @param resultDto
	 * @throws ValidatorException
	 */
	private void validatePannum(String pannum, ValidateResultDTO resultDto) throws ValidatorException {
		System.out.println("enter");
		String regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
		if (pannum.matches(regex)) {
			log.error("wrong pan number");
			resultDto.setPannumResult("wrong pan number");
		} else {
			resultDto.setPannumResult(this.result);
		}

	}

	private void validateMobileNumber(String mobileNumber, ValidateResultDTO resultDto) throws ValidatorException {
		Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");
		Matcher match = ptrn.matcher(mobileNumber);
		if (!(match.find() && match.group().equals(mobileNumber))) {
			log.error("wrong mobile number");
			resultDto.setMobileNumberResult("wrong mobile number");
		} else {
			resultDto.setMobileNumberResult(this.result);
		}
	}

	private void validateIfscCode(String ifscCode, ValidateResultDTO resultDto) throws ValidatorException {
		String regex = "^[A-Z]{4}0[A-Z0-9]{6}$";
		Pattern ptrn = Pattern.compile(regex);
		Matcher match = ptrn.matcher(ifscCode);
		if (!(match.find() && match.group().equals(ifscCode))) {
			log.error("wrong IFSC code");
			resultDto.setIfscCodeResult("wrong IFSC code");
		} else {
			resultDto.setIfscCodeResult(this.result);
		}

	}

	private void validateEmpName(String empName, ValidateResultDTO resultDto) throws ValidatorException {
		if ("".equals(empName.trim()) && empName.isEmpty()) {
			log.error("employee name is empty ");
			resultDto.setEmpNameResult("employee name is empty");
		} else {
			resultDto.setEmpNameResult(this.result);
		}
	}

	private void validateAccountNo(long accountNo, ValidateResultDTO resultDto) {
		if(accountNo >0 && accountNo <=16 ) {
			resultDto.setAccountNoResult(this.result);
		}else {
			resultDto.setAccountNoResult("wrong account number");
		}
		

	}

	private void validateAadhar(long aadhar, ValidateResultDTO resultDto) throws ValidatorException {
		String number = String.valueOf(aadhar);
		String regex = "^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$";
		Pattern ptrn = Pattern.compile(regex);
		Matcher match = ptrn.matcher(number);
		if (!(match.find() && match.group().equals(number))) {
			log.error("wrong Aadar number");
			resultDto.setAadharResult("wrong Aadar number");
		} else {
			resultDto.setAadharResult(this.result);
		}

	}

}
