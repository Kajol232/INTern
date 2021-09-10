package com.muhammad.personal.intern.repository;

import com.muhammad.personal.intern.model.Notification;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NotificationRepository extends CrudRepository<Notification, Long> {
    Notification findById(long id);
    List<Notification> findAllByPerformer(long id);
}
