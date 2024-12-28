package com.ids.argus.services;

import java.util.List;
import java.util.stream.Collectors;
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
	
	 private final DoctorRepository doctorRepository;
	    private final AddressRepository addressRepository;
	    private final ContactRepository contactRepository;
	    private final CategoryRepository categoryRepository;

	    public DoctorServicesImpl(DoctorRepository doctorRepository, AddressRepository addressRepository,
	            ContactRepository contactRepository, CategoryRepository categoryRepository) {
	        this.doctorRepository = doctorRepository;
	        this.addressRepository = addressRepository;
	        this.categoryRepository = categoryRepository;
	        this.contactRepository = contactRepository;
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
	         doctor.setId(doctorDto.getId());
	         doctor.setType(doctorDto.getType());
	         doctor.setFirstName(doctorDto.getFirstName());
	         doctor.setLastName(doctorDto.getLastName());
	         doctor.setGroupName(doctorDto.getGroupName());
	         doctor.setState(doctorDto.isState());
	         doctor.setDeleted(doctorDto.isDelete());
	         doctor.setSpeciality(doctorDto.getSpeciality());
	         doctor.setEmailId(doctorDto.getEmailId());
	         doctor.setAlternativeEmailId(doctorDto.getAlternativeEmailId());

	         // Save categories
	         if (doctorDto.getCategories() != null) {
	             for (CategoryDto categoryDto : doctorDto.getCategories()) {
	                 Category category = new Category();
	                 category.setName(categoryDto.getName());
	                 category.setType(categoryDto.getType());
	                 category.setStats(categoryDto.getStats());
	                 category.setDoctor(doctor);  // Set doctor reference
	                 categoryRepository.save(category);  // Save category to DB
	             }
	         }

	         // Save addresses
	         if (doctorDto.getAddresses() != null) {
	             for (AddressDto addressDto : doctorDto.getAddresses()) {
	                 Address address = new Address();
	                 address.setType(addressDto.getType());  // Assuming AddressDto has 'type' property
	                 address.setZipcode(addressDto.getZipcode());
	                 address.setCity(addressDto.getCity());
	                 address.setState(addressDto.getState());
	                 address.setDeleted(addressDto.isDeleted());
	                 address.setDoctor(doctor);  // Set doctor reference
	                 addressRepository.save(address);  // Save address to DB
	             }
	         }

	         // Save contacts
	         if (doctorDto.getContacts() != null) {
	             for (ContactDto contactDto : doctorDto.getContacts()) {
	                 Contact contact = new Contact();
	                 contact.setPhoneNo(contactDto.getPhoneNo());  // Assuming ContactDto has 'phoneNumber'
	                 contact.setType(contactDto.getType());
	                 contact.setDeleted(contactDto.isDeleted());
	                 contact.setDoctor(doctor);  // Set doctor reference
	                 contactRepository.save(contact);  // Save contact to DB
	             }
	         }

	         // Save doctor entity
	         Doctor savedDoctor = doctorRepository.save(doctor);

	         // Convert the saved Doctor entity back to DoctorDto and return
	         return new DoctorDto().toDto(savedDoctor); // Using the toDto method to return the saved doctor as DTO
	         
	     	    }

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
	        existingDoctor.setDeleted(doctorDto.isDelete());

	        // Update related entities (Categories, Addresses, Contacts)
	        if (doctorDto.getCategories() != null) {
	            List<Category> categories = doctorDto.getCategories().stream()
	                    .map(categoryDto -> {
	                        Category category = categoryRepository.findById(categoryDto.getId())
	                                .orElse(new Category()); // Use existing or create new
	                        category.setName(categoryDto.getName());
	                        category.setStats(categoryDto.getStats());
	                        category.setDeleted(categoryDto.isDeteled());
	                        return category;
	                    })
	                    .collect(Collectors.toList());
	            categoryRepository.saveAll(categories); // Save or update categories
	            existingDoctor.setCategories(categories); // Associate with doctor
	        }

	        if (doctorDto.getAddresses() != null) {
	            List<Address> addresses = doctorDto.getAddresses().stream()
	                    .map(addressDto -> {
	                        Address address = addressRepository.findById(addressDto.getId())
	                                .orElse(new Address()); // Use existing or create new
	                        address.setType(addressDto.getType());
	                        address.setCity(addressDto.getCity());
	                        address.setState(addressDto.getState());
	                        address.setZipcode(addressDto.getZipcode());
	                        address.setDeleted(addressDto.isDeleted());
	                        return address;
	                    })
	                    .collect(Collectors.toList());
	            addressRepository.saveAll(addresses); // Save or update addresses
	            existingDoctor.setAddresses(addresses); // Associate with doctor
	        }

	        if (doctorDto.getContacts() != null) {
	            List<Contact> contacts = doctorDto.getContacts().stream()
	                    .map(contactDto -> {
	                        Contact contact = contactRepository.findById(contactDto.getId())
	                                .orElse(new Contact()); // Use existing or create new
	                        contact.setType(contactDto.getType());
	                        contact.setPhoneNo(contactDto.getPhoneNo());
	                        contact.setDeleted(contactDto.isDeleted());
	                        return contact;
	                    })
	                    .collect(Collectors.toList());
	            contactRepository.saveAll(contacts); // Save or update contacts
	            existingDoctor.setContacts(contacts); // Associate with doctor
	        }

	        // Save the updated Doctor entity
	        existingDoctor = doctorRepository.save(existingDoctor);

	        // Convert saved Doctor entity back to DTO
	        return new DoctorDto().toDto(existingDoctor);
	    }
}
