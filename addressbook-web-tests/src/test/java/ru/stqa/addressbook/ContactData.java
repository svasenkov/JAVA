package ru.stqa.addressbook;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String addres;
  private final String homePhone;
  private final String mobile;
  private final String email;

  public ContactData(String firstname, String lastname, String addres, String homePhone, String mobile, String email) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.addres = addres;
    this.homePhone = homePhone;
    this.mobile = mobile;
    this.email = email;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddres() {
    return addres;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobile() {
    return mobile;
  }

  public String getEmail() {
    return email;
  }
}