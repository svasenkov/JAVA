package ru.stqa.addressbook.test;

import org.testng.annotations.*;
import ru.stqa.addressbook.model.ContactData;


public class ContactDeletionsTest extends TestBase {

  @Test
  public void testContactDeletions() {
    app.getNavigationHelper().gotoHomePage();
    if(! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Evgen", "Test",
              "+7123456", "mail@mail.ru", "TEST", "TestTest"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deletSeletedContact();
    app.closeAlert();
    app.getNavigationHelper().gotoHomePage();
  }

}
