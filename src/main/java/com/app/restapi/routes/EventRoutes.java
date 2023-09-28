package com.app.restapi.routes;

import java.util.List;
import com.app.restapi.entities.Event;
import com.app.restapi.services.event.EventService;
import com.app.restapi.validations.EventRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventRoutes {
    @Autowired
    private EventService eventService;

    @GetMapping("/{userId}")
    public List<Event> listUserEvents(@PathVariable String userId) {
        return eventService.getEventsByUserId(userId);
    }

    @PostMapping
    public void create(@RequestBody EventRequest request) {
        Event event = new Event(request.getName(), request.getDescription(), request.getUserId());

        eventService.sendEvent(event);
    }
}
