package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // makes as spring bean in side the spring container
// @Scope(value = "prototype")

public class Alien {

  private int id;
  private String name;
  private String tech;
  @Autowired
  private Laptop laptop; // in order to make laptop work you need getter and setters

  public Alien() {
    super();
    System.out.println("Obj Created");
  }

  // Getter and setters for Alien
  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTech() {
    return this.tech;
  }

  public void setTech(String tech) {
    this.tech = tech;
  }

  // Getter and setters for Laptop

  public Laptop getLaptop() {
    return this.laptop;
  }

  public void setLaptop(Laptop laptop) {
    this.laptop = laptop;
  }

  public void alienIsHungry() {
    System.out.println("I am Hungry AF!");
    laptop.compile(); // Alien class is now dependent on laptop. In order to get it instanciated in
                      // Spring frame work dont forget to add the @Component annotation to the laptop
                      // class- and use @Autowired so that the alien component will try to search and
                      // connect to the class that it depends on.
                      // @Autowired searches for the type not the name.
                      // using @Qualifier("laptop") it will search for the name
                      // add parameters to componenet to change the name that you are searchinh for:
                      // @Component("lap1")

  }

}
