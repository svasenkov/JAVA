package ru.stqa.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String mobile;
  private final String email;
  private String address;
  private String group;



  public ContactData(String firstname, String lastname,
                     String mobile, String email, String address, String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.mobile = mobile;
    this.email = email;
    this.address = address;
    this.group = group;

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
  public String getGroup() {
    return group;
  }
}
