
package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class User implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long Id;

  private String name;
  private String email;
  private String password;
  private String type;
  private String gender;
  private String age;
  private String occupation;
  private String zipcode;

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", email='" + getEmail() + "'"
        + ", password='" + getPassword() + "'" + ",type='" + getType() + ",gender='" + getGender() + ",age='" + getAge()
        + ",occupation='" + getOccupation() + ",zipcode='" + getZipcode() + "'}";
  }

  public Long getId() {
    return this.Id;
  }

  public String getPassword() {
    return this.password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public String getType() {
    return this.type;
  }
  public void setType(String type) {
    this.type = type;
  }

  public String getGender() {
    return this.gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getAge() {
    return this.age;
  }
  public void setAge(String age) {
    this.age = age;
  }

  public String getOccupation() {
    return this.occupation;
  }
  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public String getZipcode() {
    return this.zipcode;
  }
  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }
}