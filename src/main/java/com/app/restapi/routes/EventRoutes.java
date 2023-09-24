package com.app.restapi.routes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.restapi.entity.Event;
import com.app.restapi.services.EventService;

@RestController
@RequestMapping("/event")
public class EventRoutes {

    @GetMapping("/{userId}")
    public List<Event> listUserEvents(String userId) {
        return EventService.getEventsByUserId(userId);
    }

    @PostMapping
    public void create(@RequestBody Event event) {
        EventService.sendEvent(event);
    }
}
