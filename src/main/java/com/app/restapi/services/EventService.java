package com.app.restapi.services;

import com.app.restapi.entity.Event;
import java.util.List;

public class EventService {
    public static void sendEvent(Event event) {
        RabbitmqService.sendMessage(null, null);
    }

    public static List<Event> getEventsByUserId(String userId) {
        return null;
    }
}
