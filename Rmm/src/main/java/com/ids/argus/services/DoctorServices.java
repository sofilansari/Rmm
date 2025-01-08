package com.ids.argus.services;

import java.util.List;

import com.ids.argus.dto.DoctorDto;

public interface DoctorServices {

	public List<DoctorDto> getAllDoctor();

	public DoctorDto findById(Long id);

	public DoctorDto create(DoctorDto doctorDto);

	public DoctorDto update(DoctorDto doctorDto, Long id);

	public void delete(Long id);

	public List<DoctorDto> getDoctorsByStatus(boolean status);

}
