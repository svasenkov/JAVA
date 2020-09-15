package ru.stqa.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {
    for (int i = 0; i < 20; i++) {
      app.getNavigationHelper().gotoHomePage();
      int before = app.getContactHelper().getContactCount();

      app.getContactHelper().createContact(new ContactData("Evgen", "Test",
              "+7123456", "mail@mail.ru", "TEST"));
      app.getNavigationHelper().gotoContactPage();
      int after = app.getContactHelper().getContactCount();
      Assert.assertEquals(after, before +1);
    }


  }

}
