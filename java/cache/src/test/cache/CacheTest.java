package test.cache;

import main.abhishek.cache.Cache;
import main.abhishek.cache.factories.CacheFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CacheTest {
    Cache<Integer, String> cache;
    Integer cap = 3;

    @BeforeEach
    public void setup() {
        cache = new CacheFactory<Integer, String>().defaultCache(cap);
    }

    @Test
    public void simpleAddTest0() {
        cache.put(1, "one");
        cache.put(2,"two");

        assertEquals("one", cache.get(1));
        cache.put(3, "three");
        assertEquals("three", cache.get(3));
    }

    @Test
    public void simpleAddTest1() {
        cache.put(1, "one");
        cache.put(2,"two");

        assertEquals("one", cache.get(1));
        cache.put(3, "three");
        assertEquals("three", cache.get(3));
        cache.put(4, "four");
    }
}
