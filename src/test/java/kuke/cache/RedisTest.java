package kuke.cache;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RedisTest extends RedisTestContainerSupport {
    @Test
    void test1() {
        redisTemplate.opsForValue().set("mykey", "myKeyHello");
        String myValue = redisTemplate.opsForValue().get("mykey");

        assertThat(myValue).isEqualTo("myKeyHello");
    }

    @Test
    void test2() {
        // return null.
        String result = redisTemplate.opsForValue().get("mykey");
        System.out.println("result = " + result);
    }
}
