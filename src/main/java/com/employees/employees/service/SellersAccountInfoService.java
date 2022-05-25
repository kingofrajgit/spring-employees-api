package com.employees.employees.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.employees.employees.converter.SellersAccountInfoConverter;
import com.employees.employees.dto.SellersAccountInfoDTO;
import com.employees.employees.exception.ValidatorException;
import com.employees.employees.model.SellersAccountInfo;
import com.employees.employees.repository.SellersAccountInfoRepository;

@Configuration
@Service
public class SellersAccountInfoService {
	
	@Autowired
	SellersAccountInfoRepository repository;
	
	@Autowired
	SellersAccountInfoConverter converter;
	
	public SellersAccountInfoDTO insert(SellersAccountInfoDTO dto) throws ValidatorException {
		SellersAccountInfo model = converter.toModel(dto);
		try {
			model = repository.save(model);
			dto = converter.toDto(model);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(e.getMessage());
		}
		return dto;
	}
	
}
