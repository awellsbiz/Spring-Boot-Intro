package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Laptop {
  private int id;
  private String brand;

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getBrand() {
    return this.brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", brand='" + getBrand() + "'" +
        "}";
  }

  public void compile() {
    System.out.println("...I AM COMPILING...");
  }
}
