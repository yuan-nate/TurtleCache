package org.qfd.engine;

import java.util.concurrent.ConcurrentHashMap;

public class MainStorage {

    private final ConcurrentHashMap<String, String> storage;

    public MainStorage() {
        storage = new ConcurrentHashMap<>();
    }

    public void set(String key, String value) {
        if(key == null || key.isEmpty() || value == null || value.isEmpty()) {
            throw new IllegalArgumentException();
        }
        storage.put(key, value);
    }

    public String get(String key) {
        if(key == null || key.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return storage.get(key);
    }

    public void delete(String key) {
        if(key == null || key.isEmpty()) {
            throw new IllegalArgumentException();
        }
        storage.remove(key);
    }

    public boolean containsKey(String key) {
        if(key == null || key.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return storage.containsKey(key);
    }
}
