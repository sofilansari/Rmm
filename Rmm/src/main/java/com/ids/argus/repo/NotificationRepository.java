package com.ids.argus.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ids.argus.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
