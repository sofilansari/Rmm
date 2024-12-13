package com.ids.argus.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ids.argus.dto.AddressDto;
import com.ids.argus.model.Address;
import com.ids.argus.repo.AddressRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AddressServicesImpl implements AddressServices{
	
	private final AddressRepository addressRepository;

	public AddressServicesImpl(AddressRepository addressRepository) {
		super();
		this.addressRepository = addressRepository;
	}

	@Override
	public List<AddressDto> getAllAddress() {
		List<Address>addressesOfList=addressRepository.findAll();
		return addressesOfList.stream().map(address -> new AddressDto().toDo(address))
				.collect(Collectors.toList());
	}

	@Override
	public AddressDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddressDto create(AddressDto addressDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddressDto update(Long id, AddressDto addressDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
