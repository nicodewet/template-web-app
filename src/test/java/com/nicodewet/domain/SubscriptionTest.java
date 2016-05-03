package com.nicodewet.domain;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.Test;

public class SubscriptionTest {
	
	public void emailRegex(String email, boolean validates) {
	    Field field;
		try {
			field = Subscription.class.getDeclaredField("email");
		} catch (NoSuchFieldException | SecurityException e) {
			throw new RuntimeException(e);
		}
	    javax.validation.constraints.Pattern[] annotations = field.getAnnotationsByType(javax.validation.constraints.Pattern.class);
	    assertEquals(email.matches(annotations[0].regexp()),validates);
	}
	
	@Test
	public void testInvalidEmail() {
	    emailRegex("Jackyahoo.com", false);
	}

	@Test
	public void testValidEmail() {
	    emailRegex("jack@yahoo.com", true);
	}

	@Test
	public void testYesToUpperCase() {
	    emailRegex("Jack@yahoo.com", true);
	}

}

