package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

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
  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
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

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name=\"entry\"]"));
    for (WebElement element : elements) {
      String lastname = element.findElement(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[2]")).getText();
      String firstname = element.findElement(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[3]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id,firstname, lastname, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
