package main.abhishek.cache.storage;
import main.abhishek.cache.exceptions.NotFoundException;
import main.abhishek.cache.exceptions.StorageFullException;

import java.util.HashMap;

public class MapBasedStorage<Key, Value> implements Storage<Key, Value>{
    private final HashMap<Key, Value> map;
    private final Integer capacity;
    private Integer len;

    public MapBasedStorage(Integer capacity) {
        this.len = 0;
        this.capacity = capacity;
        map = new HashMap<Key, Value>();
    }

    public boolean isFull() {
        return len.equals(capacity);
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public void add(Key key, Value value) throws StorageFullException {
        if (this.isFull()) {
            throw new StorageFullException("Cache storage Full\n");
        }

        map.put(key, value);
        len++;
    }

    public void remove(Key key) throws NotFoundException {
        if (this.isEmpty()) {
            throw new NotFoundException("Cache is Empty");
        }

        if (!map.containsKey(key)) {
            throw new NotFoundException("Key Not found");
        }

        map.remove(key);
        len--;
    }

    public Value get(Key key) throws NotFoundException{
        if (this.isEmpty()) {
            throw new NotFoundException("Cache is Empty");
        }

        if (!map.containsKey(key)) {
            throw new NotFoundException("Key Not found");
        }

        return map.get(key);
    }
}
