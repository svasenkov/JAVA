package ru.stqa.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {

    app.goTo().homePage();
    int before = app.getContactHelper().getContactCount();
    ContactData contactData = new ContactData("Name!!!", "LastName!!!!",
            "+7123456", "mail@mail.ru", "TEST");
    app.getContactHelper().createContact(contactData);
    app.goTo().contactPage();
    int after = app.getContactHelper().getContactCount();

    Assert.assertEquals(after, before + 1);




  }

}
