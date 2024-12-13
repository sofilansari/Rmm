package com.ids.argus.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ids.argus.dto.DoctorDto;
import com.ids.argus.model.Doctor;
import com.ids.argus.repo.DoctorRepository;

@Service
@Transactional
public class DoctorServicesImpl implements DoctorServices{
	
	private final DoctorRepository doctorRepository;

	public DoctorServicesImpl(DoctorRepository doctorRepository) {
		
		this.doctorRepository = doctorRepository;
	}

	@Override
	public List<DoctorDto> getAllDoctor() {
		
		List<Doctor>doctors=doctorRepository.findAll();
		
		return doctors.stream().map(doctor ->new DoctorDto().toDo(doctor))
				.collect(Collectors.toList());
	}

	@Override
	public DoctorDto findById(Long id) {
		
		Doctor docter=doctorRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Doctor not found with ID:" + id));
		
		return new DoctorDto().toDo(docter);
	}

	@Override
	public DoctorDto create(DoctorDto doctorDto) {
		
		Doctor doctor=new Doctor();
		doctor.setType(doctorDto.getType());
		doctor.setFirstName(doctorDto.getFirstName());
		doctor.setLastName(doctorDto.getLastName());
		doctor.setGroupName(doctorDto.getGroupName());
		doctor.setState(doctorDto.isState());
		doctor.setDelete(doctorDto.isDelete());
		doctor.setSpeciality(doctorDto.getSpeciality());
		doctor.setEmailId(doctorDto.getEmailId());
		doctor.setAlternativeEmailId(doctorDto.getAlternativeEmailId());
		
		Doctor savedDoctor =doctorRepository.save(doctor);
		
		return new DoctorDto().toDo(savedDoctor);
	}

	@Override
	public DoctorDto update(DoctorDto doctorDto, Long id) {
		
		Doctor existingDoctor=doctorRepository.findById(id)
				.orElseThrow(() ->new RuntimeException("Doctor not found with ID:"+ id));
		
		existingDoctor.setType(doctorDto.getType());
		existingDoctor.setFirstName(doctorDto.getFirstName());
		existingDoctor.setLastName(doctorDto.getLastName());
		existingDoctor.setGroupName(doctorDto.getGroupName());
		existingDoctor.setState(doctorDto.isState());
		existingDoctor.setDelete(doctorDto.isDelete());
		existingDoctor.setSpeciality(doctorDto.getSpeciality());
		existingDoctor.setEmailId(doctorDto.getEmailId());
		existingDoctor.setAlternativeEmailId(doctorDto.getAlternativeEmailId());
		
		Doctor saveDoctor=doctorRepository.save(existingDoctor);
				
		return new DoctorDto().toDo(saveDoctor);
	}

	@Override
	public void delete(Long id) {
		Doctor deleteDoctor=doctorRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Doctor not found with ID:"+ id));
		doctorRepository.delete(deleteDoctor);
	}
	
	

}
