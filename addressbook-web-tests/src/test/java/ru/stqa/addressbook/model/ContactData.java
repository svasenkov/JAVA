package ru.stqa.addressbook.model;

import java.util.Objects;

public class ContactData {
  private  int id;
  private final String firstname;
  private final String lastname;
  private final String mobile;
  private final String email;
  private String address;


  public ContactData(int id,String firstname, String lastname,
                     String mobile, String email, String address) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.mobile = mobile;
    this.email = email;
    this.address = address;
  }
  public ContactData(String firstname, String lastname,
                     String mobile, String email, String address) {
    this.id = 0;
    this.firstname = firstname;
    this.lastname = lastname;
    this.mobile = mobile;
    this.email = email;
    this.address = address;
  }

  public int getId() {
    return id;
  }
  public String getAddress() {
    return address;
  }
  public String getFirstname() {
    return firstname;
  }
  public String getLastname() {
    return lastname;
  }
  public String getMobile() {
    return mobile;
  }
  public String getEmail() {
    return email;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }


}
