package com.example;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FirstSpringDemoApplication.class)
@WebAppConfiguration
public class FirstSpringDemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void test_01() {
        assertThat(1, is(1));
    }

    // TODO Springテスト化
    public void test_getUserList_a() {
//        User u1 = User.builder().id("1").name("Tanaka").build();
//        User u2 = User.builder().id("2").name("Satou").build();
//
//        List<User> expected = Arrays.asList(u1, u2);
//        List<User> actual = new HelloCounter().getUserList();
//
//        assertThat(actual, is(expected));
    }
}
