package com.test.valueprovider;

import com.github.javafaker.Faker;

public class UsernameProvider {

	public String CreateUsername() {

		Faker faker = new Faker();

		String name = faker.name().username();

		return name;

	}
}
