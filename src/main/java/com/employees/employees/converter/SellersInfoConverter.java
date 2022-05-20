package com.employees.employees.converter;

import com.employees.employees.dto.SellersInfoDTO;
import com.employees.employees.model.Sellers;

public class SellersInfoConverter {
	
	/**
	 * this method used to create converting purpose
	 * @param sellersInfo
	 * @return obj
	 */
	public SellersInfoDTO toDto(Sellers sellersInfo) {
		SellersInfoDTO obj = new SellersInfoDTO();
		obj.setSellersId(sellersInfo.getSellersId());
		obj.setSellersName(sellersInfo.getSellersName());
		obj.setAccountId(sellersInfo.getAccountId());
		obj.setMobileNumber(sellersInfo.getMobileNumber());
		obj.setGender(sellersInfo.getGender());
		obj.setCategorie(sellersInfo.getCategorie());
		obj.setBranchName(sellersInfo.getBranchName());
		obj.setAddress(sellersInfo.getAddress());
		obj.setCity(sellersInfo.getCity());
		obj.setPincode(sellersInfo.getPincode());
		return obj;
	}
	
	/**
	 * this method used to create converting purpose
	 * @param obj
	 * @return sellersInfo
	 */
	public Sellers toModel(SellersInfoDTO obj) {
		Sellers sellersInfo = new Sellers();
		sellersInfo.setSellersId(obj.getSellersId());
		sellersInfo.setSellersName(obj.getSellersName());
		sellersInfo.setAccountId(obj.getAccountId());
		sellersInfo.setMobileNumber(obj.getMobileNumber());
		sellersInfo.setGender(obj.getGender());
		sellersInfo.setCategorie(obj.getCategorie());
		sellersInfo.setBranchName(obj.getBranchName());
		sellersInfo.setAddress(obj.getAddress());
		sellersInfo.setCity(obj.getCity());
		sellersInfo.setPincode(obj.getPincode());
		return sellersInfo;
	}
}
