package main.abhishek.cache.policies;

public interface EvictionPolicy<Key> {
    void keyAccessed(Key key);
    Key getEvictKey();
}
