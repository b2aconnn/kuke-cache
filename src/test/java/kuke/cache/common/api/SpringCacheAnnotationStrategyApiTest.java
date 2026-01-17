package kuke.cache.common.api;

import kuke.cache.common.cache.CacheStrategy;
import org.junit.jupiter.api.Test;

import static kuke.cache.common.cache.CacheStrategy.SPRING_CACHE_ANNOTATION;

public class SpringCacheAnnotationStrategyApiTest {
    static final CacheStrategy CACHE_STRATEGY = SPRING_CACHE_ANNOTATION;

    @Test
    void readNullData() {
        for(int i = 0; i < 3; i++) {
            try {
                ItemApiTestUtils.read(CACHE_STRATEGY, 99999L);
            } catch (Exception ignored) {
            }
        }
    }
}
