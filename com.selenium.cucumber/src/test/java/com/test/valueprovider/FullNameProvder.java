package com.test.valueprovider;

import com.github.javafaker.Faker;

public class FullNameProvder {

	public String CreateName() {

		Faker faker = new Faker();

		String name = faker.name().fullName();

		return name;

	}

}
