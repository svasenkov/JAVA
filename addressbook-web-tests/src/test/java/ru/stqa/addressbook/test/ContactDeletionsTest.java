package ru.stqa.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.addressbook.model.ContactData;


public class ContactDeletionsTest extends TestBase {

  @Test
  public void testContactDeletions() {
    app.getNavigationHelper().gotoHomePage();

    int before = app.getContactHelper().getContactCount();

    if(! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Evgen", "Test",
              "+7123456", "mail@mail.ru", "TEST"));
    }

    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().deletSeletedContact();
    app.closeAlert();
    app.getNavigationHelper().gotoContactPage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);






  }

}
