package com.ids.argus.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ids.argus.dto.AddressDto;
import com.ids.argus.dto.CategoryDto;
import com.ids.argus.dto.ContactDto;
import com.ids.argus.dto.DoctorDto;
import com.ids.argus.model.Address;
import com.ids.argus.model.Category;
import com.ids.argus.model.Contact;
import com.ids.argus.model.Doctor;
import com.ids.argus.repo.AddressRepository;
import com.ids.argus.repo.CategoryRepository;
import com.ids.argus.repo.ContactRepository;
import com.ids.argus.repo.DoctorRepository;

@Service
@Transactional
public class DoctorServicesImpl implements DoctorServices{
	
		@Autowired
	    private  DoctorRepository doctorRepository;
		
		@Autowired
		private AddressRepository addressRepository;
		
		@Autowired
		private ContactRepository contactRepository;
		
		@Autowired
		private CategoryRepository categoryRepository;
	    

	    @Override
	    public List<DoctorDto> getAllDoctor() {
	        List<Doctor> doctors = doctorRepository.findAll();
	        return doctors.stream().map(doctor -> new DoctorDto().toDto(doctor)).collect(Collectors.toList());
	    }

	    @Override
	    public DoctorDto findById(Long id) {
	        Doctor doctor = doctorRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Doctor not found with ID:" + id));
	        return new DoctorDto().toDto(doctor);
	    }

	    @Override
	    public DoctorDto create(DoctorDto doctorDto) {
	    	
	    	 Doctor doctor = new Doctor();
	    	    doctor.setType(doctorDto.getType());
	    	    doctor.setFirstName(doctorDto.getFirstName());
	    	    doctor.setLastName(doctorDto.getLastName());
	    	    doctor.setGroupName(doctorDto.getGroupName());
	    	    doctor.setState(doctorDto.isState());
	    	    doctor.setDeleted(doctorDto.isDeleted());
	    	    doctor.setSpeciality(doctorDto.getSpeciality());
	    	    doctor.setEmailId(doctorDto.getEmailId());
	    	    doctor.setAlternativeEmailId(doctorDto.getAlternativeEmailId());

	    	    Doctor savedDoctor = doctorRepository.save(doctor);
	    	 
	    	   if (doctorDto.getAddresses() != null && !doctorDto.getAddresses().isEmpty()) {
	    	        for (AddressDto addressDto : doctorDto.getAddresses()) {
	    	            Address address = new Address();
	    	            address.setType(addressDto.getType());
	    	            address.setCity(addressDto.getCity());
	    	            address.setState(addressDto.getState());
	    	            address.setZipcode(addressDto.getZipcode());
	    	            address.setDeleted(addressDto.isDeleted());
	    	            address.setDoctor(savedDoctor);  
	    	            addressRepository.save(address);
	    	            
	    	        }
	    	          	        
	    	    }
	    	   
	    	   if(doctorDto.getContacts() !=null && !doctorDto.getContacts().isEmpty()) {
	    		   for(ContactDto contactDto : doctorDto.getContacts()) {
	    			   Contact contact=new Contact();
	    			   contact.setType(contactDto.getType());
	    			   contact.setPhoneNo(contactDto.getPhoneNo());
	    			   contact.setDeleted(contactDto.isDeleted());
	    			   contact.setDoctor(savedDoctor);
	    			   contactRepository.save(contact);
	    		   }
	    	   }
	    	   
	    	   if(doctorDto.getCategories() !=null &&!doctorDto.getCategories().isEmpty()) {
	    		   for(CategoryDto categoryDto : doctorDto.getCategories()) {
	    			   
	    			   Category category=new Category();
	    			   category.setType(categoryDto.getType());
	    			   category.setName(categoryDto.getName());
	    			   category.setStats(categoryDto.getStats());
	    			   category.setDeleted(categoryDto.isDeleted());
	    			   
	    			   category.setDoctor(savedDoctor);
	    			   categoryRepository.save(category);
	    			   
	    		   }
	    		   
	    	   }

	    	    return new DoctorDto().toDto(savedDoctor);	     }
	    
	    @Override
	    public void delete(Long id) {
	        Doctor deleteDoctor = doctorRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Doctor not found with ID:" + id));
	        doctorRepository.delete(deleteDoctor);
	    }

	    @Override
	    public DoctorDto update(DoctorDto doctorDto, Long id) {
	        Doctor existingDoctor = doctorRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Doctor not found with ID:" + id));

	        existingDoctor.setType(doctorDto.getType());
	        existingDoctor.setFirstName(doctorDto.getFirstName());
	        existingDoctor.setLastName(doctorDto.getLastName());
	        existingDoctor.setGroupName(doctorDto.getGroupName());
	        existingDoctor.setState(doctorDto.isState());
	        existingDoctor.setSpeciality(doctorDto.getSpeciality());
	        existingDoctor.setEmailId(doctorDto.getEmailId());
	        existingDoctor.setAlternativeEmailId(doctorDto.getAlternativeEmailId());
	        existingDoctor.setDeleted(doctorDto.isDeleted());
	       
	        existingDoctor = doctorRepository.save(existingDoctor);

	        
	        return new DoctorDto().toDto(existingDoctor);
	    }

}
