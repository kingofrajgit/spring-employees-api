package com.employees.employees.validation;

import com.employees.employees.model.ApplyLeave;

public class ApplyLeaveValidation {
public static void validateApplyLeave(ApplyLeave applyLeave) throws Exception {
		
		if (applyLeave.getEmpId() != null) {
		} else {
			throw new Exception("The Employee Id cannot be empty");
		}
		if (applyLeave.getEmpName() != null && !applyLeave.getEmpName().trim().equals("")) {
		} else {
			throw new Exception("The Name cannot be empty");
		}
		
		if (applyLeave.getLeaveFromDate() != null && !applyLeave.getLeaveFromDate().trim().equals("")) {
		} else {
			throw new Exception("The Leave From Date cannot be empty");
		}
		if (applyLeave.getLeaveToDate() != null && !applyLeave.getLeaveToDate().trim().equals("")) {
		} else {
			throw new Exception("The Leave To Date cannot be empty");
		}
		if (applyLeave.getReason() != null) {
		} else {
			throw new Exception("The reason cannot be empty");
		}
		
		
		System.out.println("You have applied leave successfully");
	}
}



