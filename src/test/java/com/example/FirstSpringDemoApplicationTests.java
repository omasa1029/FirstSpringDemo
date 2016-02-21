package com.example;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.controller.HelloCounter;
import com.example.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FirstSpringDemoApplication.class)
@WebAppConfiguration
public class FirstSpringDemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	public void test_getUserList_a() {
		User u1 = User.builder().id("1").name("Tanaka").build();
		User u2 = User.builder().id("2").name("Satou").build();
		
		List<User> expected = Arrays.asList(u1, u2);
		List<User> actual = new HelloCounter().getUserList();

		assertThat(actual, is(expected));
	}
}
