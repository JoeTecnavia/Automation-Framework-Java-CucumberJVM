package datamodels;

import com.github.javafaker.Faker;

public abstract class BaseModel {
	private Faker faker = new Faker();
	
	public Faker getFaker() {
		return this.faker;
	}
}
