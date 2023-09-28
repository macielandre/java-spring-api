package com.app.restapi.services.event;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.restapi.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findAllByUserId(String userId);
}
