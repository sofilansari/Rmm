package com.ids.argus.services;

import org.springframework.stereotype.Service;

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
	
	

}
