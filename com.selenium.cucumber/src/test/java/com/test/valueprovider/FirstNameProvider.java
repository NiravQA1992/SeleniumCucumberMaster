package com.test.valueprovider;

import com.github.javafaker.Faker;

public class FirstNameProvider {

	public String CreateFirstName() {

		Faker faker = new Faker();

		String name = faker.name().firstName();

		return name;

	}
}
