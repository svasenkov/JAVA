package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactGroup(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getEmail());

  }


  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }
  public void initContactCreation() {
    click(By.linkText("add new"));
  }
  public void deletSeletedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }
  public void selectContact() {
    click(By.name("selected[]"));
  }
  public void submitModificationContact() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }
  public void initModificationContact() {
    click(By.xpath("//img[@alt='Edit']"));
  }
  public void returnContactPage() {
    click(By.linkText("home"));
  }

  public void createContact(ContactData contact) {
  initContactCreation();
    fillContactGroup(contact);
    submitContactCreation();
    returnContactPage();

  }



  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }
}
