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
		return addressesOfList.stream().map(address -> new AddressDto().toDto(address))
				.collect(Collectors.toList());
	}

	@Override
	public AddressDto findById(Long id) {
		Address address=addressRepository.findById(id).
				orElseThrow(()-> new RuntimeException("Address not found with id"+id));
		return new AddressDto().toDto(address);
	}

	@Override
	public AddressDto create(AddressDto addressDto) {
		
		Address newAddress = new Address();
        newAddress.setType(addressDto.getType());
        newAddress.setCity(addressDto.getCity());
        newAddress.setState(addressDto.getState());
        newAddress.setZipcode(addressDto.getZipcode());
        newAddress.setDeleted(addressDto.isDeleted());

     
        Address savedAddress = addressRepository.save(newAddress);

        return new AddressDto().toDto(savedAddress);
	}

	@Override
	public AddressDto update(Long id, AddressDto addressDto) {
		
		Address existingAddress = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id " + id));

        existingAddress.setType(addressDto.getType());
        existingAddress.setCity(addressDto.getCity());
        existingAddress.setState(addressDto.getState());
        existingAddress.setZipcode(addressDto.getZipcode());
        existingAddress.setDeleted(addressDto.isDeleted());

        Address updatedAddress = addressRepository.save(existingAddress);
        return new AddressDto().toDto(updatedAddress);
	}

	@Override
	public void delete(Long id) {
		
		Address deleteAddress=addressRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Address not found with id"+id));
		
		addressRepository.delete(deleteAddress);
		
	}
	
	
	
	

}
