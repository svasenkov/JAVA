package ru.stqa.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.stqa.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {


  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();

    if(! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Evgen", "Test",
              "+7123456", "mail@mail.ru", "TEST"));
    }

    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().initModificationContact();
    app.getContactHelper().fillContactGroup(new ContactData("NewUpDate",
            "NewUpDate",
            "00000000",
            "010101010","Mogaisk"));

    app.getContactHelper().submitModificationContact();
    app.getNavigationHelper().gotoContactPage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
  }


}
