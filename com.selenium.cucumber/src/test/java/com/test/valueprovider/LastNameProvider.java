package com.test.valueprovider;

import com.github.javafaker.Faker;

public class LastNameProvider {

	public String CreateLastName() {

		Faker faker = new Faker();

		String name = faker.name().lastName();

		return name;

	}
}
