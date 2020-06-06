
package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class User implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long Id;

  private String name;
  private String email;
  private String password;
  private String type;

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", email='" + getEmail() + "'"
        + ", password='" + getPassword() + "'" + ",type='" + getType() + "'}";
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Long getId() {
    return this.Id;
  }

  // public void setId(Long id) {
  //   this.Id = Id;
  // }

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
}