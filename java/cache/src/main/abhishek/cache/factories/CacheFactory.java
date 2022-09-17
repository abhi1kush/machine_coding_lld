package main.abhishek.cache.factories;

import main.abhishek.cache.Cache;
import main.abhishek.cache.policies.LRUEvictionPolicy;
import main.abhishek.cache.storage.MapBasedStorage;

public class CacheFactory<Key, Value> {
    public Cache<Key, Value> defaultCache(final Integer capacity) {
        return new Cache<Key, Value>(new LRUEvictionPolicy<Key>(),
                new MapBasedStorage<Key, Value>(capacity));
    }
}
