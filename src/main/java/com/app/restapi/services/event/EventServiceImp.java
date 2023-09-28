package com.app.restapi.services.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.app.restapi.entities.Event;
import com.app.restapi.services.rabbitmq.RabbitmqService;

@Repository
public class EventServiceImp implements EventService {
    @Autowired
    private EventRepository repository;

    public void sendEvent(Event event) {
        String stringEvent = event.getName() + "-" + event.getUserId();
        String queueName = "events";

        RabbitmqService.sendMessage(queueName, stringEvent);
        repository.save(event);
    }

    public List<Event> getEventsByUserId(String userId) {
        return repository.findAllByUserId(userId);
    }
}