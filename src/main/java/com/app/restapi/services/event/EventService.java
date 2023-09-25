package com.app.restapi.services.event;

import java.util.List;
import com.app.restapi.entities.Event;

public interface EventService {
    void sendEvent(Event event);

    List<Event> getEventsByUserId(String userId);
}
