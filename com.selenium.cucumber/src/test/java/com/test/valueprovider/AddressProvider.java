package com.test.valueprovider;

import com.github.javafaker.Faker;

public class AddressProvider {

	public String CreateAddress() {

		Faker faker = new Faker();
		String streetAddress = faker.address().streetAddress();
		return streetAddress;

	}

}
