package com.ids.argus.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ids.argus.dto.NotificationDto;
import com.ids.argus.model.Notification;
import com.ids.argus.repo.NotificationRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NotificationServicesImpl implements NotificationServices{
	
	private final NotificationRepository notificationRepository;

	public NotificationServicesImpl(NotificationRepository notificationRepository) {
		super();
		this.notificationRepository = notificationRepository;
	}

	@Override
	public List<NotificationDto> getAllNotification() {
		List<Notification>notifications=notificationRepository.findAll();
		return notifications.stream().map(notification -> new NotificationDto().toDto(notification)).
				collect(Collectors.toList());
	}

	@Override
	public NotificationDto findById(Long id) {
		Notification notifications=notificationRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Notification not found with id"+ id));
		return new NotificationDto().toDto(notifications);
	}

	@Override
	public NotificationDto create(NotificationDto notificationDto) {
		Notification saveNotification=new Notification();
		saveNotification.setId(notificationDto.getId());
		saveNotification.setSubject(notificationDto.getSubject());
		saveNotification.setNotification(notificationDto.getNotification());
		saveNotification.setStates(notificationDto.getStates());
		saveNotification.setDelete(notificationDto.isDelete());
		
		Notification saveNotifi=notificationRepository.save(saveNotification);
		return new NotificationDto().toDto(saveNotifi);
	}

	@Override
	public NotificationDto update(Long id, NotificationDto notificationDto) {
		Notification exisitingNotification=notificationRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Notification not found with id"+ id));
		
		exisitingNotification.setId(notificationDto.getId());
		exisitingNotification.setSubject(notificationDto.getSubject());
		exisitingNotification.setNotification(notificationDto.getNotification());
		exisitingNotification.setStates(notificationDto.getStates());
		exisitingNotification.setDelete(notificationDto.isDelete());
		
		Notification saveExisiting=notificationRepository.save(exisitingNotification);
		return new NotificationDto().toDto(saveExisiting);
	}

	@Override
	public void delete(long id) {
		Notification delete=notificationRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Notification not found with id"+ id));
		notificationRepository.delete(delete);
	}
	
	

}
