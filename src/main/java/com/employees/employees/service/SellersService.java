package com.employees.employees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.employees.employees.converter.SellersInfoConverter;
import com.employees.employees.dto.SellersInfoDTO;
import com.employees.employees.exception.ValidatorException;
import com.employees.employees.model.Sellers;
import com.employees.employees.repository.SellersRepository;

@Configuration
@Service
public class SellersService {

		@Autowired
		SellersRepository repository;
		
		@Autowired
		SellersInfoConverter converter;
	
	/**
	 * this method used to send the data in repository
	 * @param sellersDto
	 * @return 
	 * @throws ValidatorException 
	 */
	public SellersInfoDTO registration(SellersInfoDTO sellersDto) throws ValidatorException {
		Sellers sellers = converter.toModel(sellersDto);
		try {
			sellers = repository.save(sellers);
			sellersDto = converter.toDto(sellers);
			}catch(Exception e) {
				throw new ValidatorException(e.getMessage());
			}
		return sellersDto;
	}

	public List<Sellers> getDetails() throws ValidatorException {
		try {
			List<Sellers> sellers = repository.findAll();
			return sellers;
			}catch(Exception e) {
				throw new ValidatorException(e.getMessage());
			}
		
	}
}
