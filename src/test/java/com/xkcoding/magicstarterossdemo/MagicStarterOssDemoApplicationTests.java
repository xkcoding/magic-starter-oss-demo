package com.xkcoding.magicstarterossdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MagicStarterOssDemoApplicationTests {
    protected final static String BUCKET = "magic-test-xkcoding";
    protected final static String FILE = "/Users/yangkai.shen/Desktop/avatar.jpeg";
    protected final static String FILE_NAME = "avatar.jpeg";

    @Test
    public void contextLoads() {
    }

}
