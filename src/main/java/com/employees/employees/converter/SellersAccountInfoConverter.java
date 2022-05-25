package com.employees.employees.converter;

import org.springframework.context.annotation.Configuration;

import com.employees.employees.dto.SellersAccountInfoDTO;
import com.employees.employees.model.SellersAccountInfo;

@Configuration
public class SellersAccountInfoConverter {

	/**
	 * this method used for converting purpose
	 * @param sellersInfo
	 * @return dto
	 */
	public SellersAccountInfoDTO toDto(SellersAccountInfo model ) {
		SellersAccountInfoDTO dto = new SellersAccountInfoDTO();
		dto.setAccountId(model.getAccountId());
		dto.setAadharNumber(model.getAadharNumber());
		dto.setPanNumber(model.getPanNumber());
		dto.setAccountNumber(model.getAccountNumber());
		dto.setBankName(model.getBankName());
		dto.setIfscCode(model.getIfscCode());
		return dto;
		
	}
	/**
	 * this method used for converting purpose
	 * @param sellersInfo
	 * @return model
	 */
	public SellersAccountInfo toModel(SellersAccountInfoDTO dto ) {
		SellersAccountInfo model = new SellersAccountInfo();
		model.setAccountId(dto.getAccountId());
		model.setAadharNumber(dto.getAadharNumber());
		model.setPanNumber(dto.getPanNumber());
		model.setAccountNumber(dto.getAccountNumber());
		model.setBankName(dto.getBankName());
		model.setIfscCode(dto.getIfscCode());
		return model;
		
	}
}
