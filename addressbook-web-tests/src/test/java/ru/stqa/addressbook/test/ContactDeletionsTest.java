package ru.stqa.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

import java.util.List;


public class ContactDeletionsTest extends TestBase {

  @Test
  public void testContactDeletions() {
    app.goTo().homePage();

    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Evgen", "Test",
              "+7123456", "mail@mail.ru", "TEST"));
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact(2);
    app.getContactHelper().deletSeletedContact();
    app.closeAlert();
    app.goTo().contactPage();
    int after = app.getContactHelper().getContactCount();

    Assert.assertEquals(after, before - 1);


  }

}
