package com.ids.argus.services;

import java.util.List;

import com.ids.argus.dto.NotificationDto;

public interface NotificationServices {

	public List<NotificationDto> getAllNotification();

	public NotificationDto findById(Long id);

	public NotificationDto create(NotificationDto notificationDto);

	public NotificationDto update(Long id, NotificationDto notificationDto);

	public void delete(long id);

}
