// com.ihfms.healthfinancehub.accountsmodule.services.EventManagerService
package com.ihfms.healthfinancehub.accountsmodule.services;

import java.util.HashMap;
import java.util.Map;

public class EventManagerService {
    private Map<String, EventListener> listeners = new HashMap<>();

    public void subscribe(String eventType, EventListener listener) {
        listeners.put(eventType, listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        listeners.remove(eventType, listener);
    }

    public void notify(String eventType, String data) {
        listeners.getOrDefault(eventType, (data) -> {}).update(data);
    }
}
