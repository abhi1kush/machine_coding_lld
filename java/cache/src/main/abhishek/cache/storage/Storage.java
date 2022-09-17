package main.abhishek.cache.storage;
import main.abhishek.cache.exceptions.StorageFullException;
import main.abhishek.cache.exceptions.NotFoundException;

public interface Storage<Key, Value> {
    void add(Key key, Value value) throws StorageFullException;
    void remove(Key key) throws NotFoundException;
    Value get(Key key) throws NotFoundException;
    boolean isFull();
    boolean isEmpty();
}
