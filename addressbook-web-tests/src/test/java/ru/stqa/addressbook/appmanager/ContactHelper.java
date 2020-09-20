package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactGroup(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getEmail());
    type(By.name("address"), contactData.getAddress());

  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void modify(ContactData contactData) {
    initModificationContactById(contactData.getId());
    fillContactGroup(contactData);
    submitModificationContact();
    contactPage();
  }

  private void initModificationContactById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    ;
  }

  private void contactPage() {
    click(By.linkText("home"));
  }

  public void deletSeletedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void selectContact(int index) {
    wd.findElements(By.xpath("//*[@name=\"selected[]\"]")).get(index).click();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void submitModificationContact() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void initModificationContact(int index) {
    wd.findElements(By.xpath("//*[@title=\"Edit\"]/..")).get(index).click();
  }

  public void returnContactPage() {
    click(By.linkText("home"));
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactGroup(contact);
    submitContactCreation();
    returnContactPage();

  }

  public void delet(int index) {
    selectContact(index);
    deletSeletedContact();
    closeAlert();
    contactPage();
  }

  public void delet(ContactData contact) {

    selectContactById(contact.getId());
    deletSeletedContact();
    closeAlert();
    contactPage();

  }

  private void closeAlert() {
    wd.switchTo().alert().accept();

  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement row : elements) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
     ContactData cont = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname);
     contacts.add(cont);
    }
    return contacts;
  }


  public Set<ContactData> all() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement row : elements) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
      ContactData cont = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname);
      contacts.add(cont);
    }
    return contacts;
  }


}
