package com.ids.argus.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
		public List<DoctorDto> getDoctorsByStatus(boolean status) {
			
			List<Doctor>doctors=doctorRepository.findByStatus(status);
			
			return doctors.stream().map(doctor -> new DoctorDto().toDto(doctor))
					.collect(Collectors.toList());
		}


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
	    	    doctor.setStatus(doctorDto.isStatus());
	    	    doctor.setDeleted(doctorDto.isDeleted());
	    	    doctor.setSpeciality(doctorDto.getSpeciality());
	    	    doctor.setEmailId(doctorDto.getEmailId());
	    	    doctor.setAlternativeEmailId(doctorDto.getAlternativeEmailId());

	    	    Doctor savedDoctor = doctorRepository.save(doctor);
	    	 
	    	  if(doctorDto.getAddresses() !=null) {
	    		  List<Address> addresses=doctorDto.getAddresses().stream().map(addressDto -> {
	    			  Address address=new Address();
	    			  address.setCity(addressDto.getCity());
	    			  address.setType(addressDto.getType());
	    			  address.setState(addressDto.getState());
	    			  address.setZipcode(addressDto.getZipcode());
	    			  address.setDeleted(addressDto.isDeleted());
	    			  address.setDoctor(savedDoctor);
	    			  return addressRepository.save(address);
	    		  }).collect(Collectors.toList());
	    		  savedDoctor.setAddresses(addresses);
	    	  }
	    	   
	    	   if(doctorDto.getContacts() !=null) {
	    		   List<Contact>contacts=doctorDto.getContacts().stream().map(contactDto -> {
	    			   Contact contact=new Contact();
	    			   contact.setType(contactDto.getType());
	    			   contact.setPhoneNo(contactDto.getPhoneNo());
	    			   contact.setDeleted(contactDto.isDeleted());
	    			   contact.setDoctor(savedDoctor);
	    			   return contactRepository.save(contact);
	    		   }).collect(Collectors.toList());
	    		   savedDoctor.setContacts(contacts);
	    	   }
	    	   
	    	   if(doctorDto.getCategories() !=null) {
	    		   List<Category>categories=doctorDto.getCategories().stream().map(categoryDto -> {
	    			   Category category=new Category();
	    			   category.setName(categoryDto.getName());
	    			   category.setStats(categoryDto.getStats());
	    			   category.setType(categoryDto.getType());
	    			   category.setDeleted(categoryDto.isDeleted());
	    			   return categoryRepository.save(category);
	    		   }).collect(Collectors.toList());
	    		   savedDoctor.setCategories(categories);
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
	        existingDoctor.setStatus(doctorDto.isStatus());
	        existingDoctor.setSpeciality(doctorDto.getSpeciality());
	        existingDoctor.setEmailId(doctorDto.getEmailId());
	        existingDoctor.setAlternativeEmailId(doctorDto.getAlternativeEmailId());
	        existingDoctor.setDeleted(doctorDto.isDeleted());
	       
	        existingDoctor = doctorRepository.save(existingDoctor);

	        
	        return new DoctorDto().toDto(existingDoctor);
	    }


}
