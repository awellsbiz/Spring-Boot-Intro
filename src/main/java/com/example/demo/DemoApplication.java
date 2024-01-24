package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// making a variable of type ConfigurableApplicationContex inorder to use the
		// get bean method and access the spring container
		ConfigurableApplicationContext contex = SpringApplication.run(DemoApplication.class, args);

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