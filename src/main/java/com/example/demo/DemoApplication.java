package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.Human;
import com.example.demo.repo.HumanRepo;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// making a variable of type ConfigurableApplicationContex inorder to use the
		// get bean method and access the spring container
		ConfigurableApplicationContext contex = SpringApplication.run(DemoApplication.class, args);
		// Above we are getting a hold on the spring container.

		Human ajay = contex.getBean(Human.class);
		ajay.setName("jay");
		ajay.setId(1);
		ajay.setTech("java");

		// have to write extra classes / extra files to save to DB:
		// you will be having multiple layers:
		// 1. Controller Layer
		// 2. Service Layer
		// 3. Repository Layer - responsible for connecting to the DB

		HumanRepo repo = contex.getBean(HumanRepo.class);
		repo.save(ajay);

		System.out.println(repo.findAll());

		Alien a = contex.getBean(Alien.class);
		a.alienIsHungry();

	}

}

// Spring frame work has a single turn design. meaning if you annotate a class
// as a component spring will give you the object even if you do not ask for it
// w/ get bean.
// In single turn you only get one instance of the class.
// If we dont want it to create an instance of the class right away we have to
// add another annotation @Scopr(value = "prototype") to the class. Then it will
// create the instance when getbean is called. you will not get the object
// inside of the spring container.