package ru.stqa.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {

    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().createContact(new ContactData("Evgen", "Test",
            "+7123456", "mail@mail.ru", "TEST", "TestTest"), true);

  }

}
