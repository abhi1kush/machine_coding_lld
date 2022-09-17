package main.abhishek.cache;
import main.abhishek.cache.exceptions.NotFoundException;
import main.abhishek.cache.policies.EvictionPolicy;
import main.abhishek.cache.storage.Storage;

public class Cache<Key, Value> {
    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key, Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value) {
        try {
            if (storage.isFull()) {
                Key keyToBeRemoved = evictionPolicy.getEvictKey();
                storage.remove(keyToBeRemoved);
            }
            storage.add(key, value);
        } catch(NotFoundException notFoundException) {
            System.out.println("Invalid evictKey: not found in the storage");
        }
    }

    public Value get(Key key) {
        try {
            if (storage.isEmpty()) {
                System.out.println("Cache is empty\n");
                return null;
            }
            return storage.get(key);
        } catch (NotFoundException notFoundException) {
            System.out.println("Key not found int the cache\n");
            return null;
        }
    }
}
