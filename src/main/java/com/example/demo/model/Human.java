package com.example.demo.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // Here we are asking spring fromaework to handle the obj creation, managing,
           // and destroying /deleting.
@Scope("prototype") // with out this you will have multiple
public class Human {
  private int id;
  private String name;
  private String tech;

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

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", name='" + getName() + "'" +
        ", tech='" + getTech() + "'" +
        "}";
  }

}
