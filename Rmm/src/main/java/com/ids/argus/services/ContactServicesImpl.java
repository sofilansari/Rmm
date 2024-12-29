package com.ids.argus.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ids.argus.dto.ContactDto;
import com.ids.argus.model.Contact;
import com.ids.argus.repo.ContactRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ContactServicesImpl implements ContactServices{
	
	private final ContactRepository contactRepository;

	public ContactServicesImpl(ContactRepository contactRepository) {
		super();
		this.contactRepository = contactRepository;
	}

	@Override
	public List<ContactDto> getAllContct() {
		List<Contact>contactsOfList=contactRepository.findAll();
		return contactsOfList.stream().map(contect -> new ContactDto().toDo(contect)).
				collect(Collectors.toList());
	}

	@Override
	public ContactDto findById(Long id) {
		
		Contact contact=contactRepository.findById(id).
				orElseThrow(()-> new RuntimeException("Contact not found with id"+ id));
		return new ContactDto().toDo(contact);
	}

	@Override
	public ContactDto create(ContactDto contactDto) {
		
		Contact savedContact=new Contact();
		savedContact.setId(contactDto.getId());
		savedContact.setType(contactDto.getType());
		savedContact.setPhoneNo(contactDto.getPhoneNo());
		savedContact.setDeleted(contactDto.isDeleted());
		//savedContact.setVersion(contactDto.getVersion());
		
		Contact saved=contactRepository.save(savedContact);
		
		return new ContactDto().toDo(saved);
	}

	@Override
	public ContactDto update(Long id, ContactDto contactDto) {
		
		Contact exisitingContact=contactRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Contact not fount with id"+ id));
		
		exisitingContact.setId(contactDto.getId());
		exisitingContact.setType(contactDto.getType());
		exisitingContact.setPhoneNo(contactDto.getPhoneNo());
		exisitingContact.setDeleted(contactDto.isDeleted());
		
		Contact savedexisiting=contactRepository.save(exisitingContact);
		
		return new ContactDto().toDo(savedexisiting);
	}

	@Override
	public void delete(Long id) {
		
		Contact deleteContact=contactRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Contct not found with id"+id));
		
		contactRepository.delete(deleteContact);
		
	}
	
	

}
