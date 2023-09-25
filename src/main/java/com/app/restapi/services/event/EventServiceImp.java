package com.app.restapi.services.event;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.restapi.entities.Event;
import com.app.restapi.services.rabbitmq.RabbitmqService;

@Repository
public class EventServiceImp implements EventService {
    private JpaRepository<Event, Integer> repository;

    public void sendEvent(Event event) {
        String stringfiedEvent = event.getName() + "-" + event.getUserId();

        RabbitmqService.sendMessage("event", stringfiedEvent);
        repository.save(event);
    }

    public List<Event> getEventsByUserId(String userId) {
        return repository.findAll();
    }
}