package kuke.cache;

import org.springframework.boot.SpringApplication;

public class TestKukeCacheApplication {

    public static void main(String[] args) {
        SpringApplication.from(KukeCacheApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
