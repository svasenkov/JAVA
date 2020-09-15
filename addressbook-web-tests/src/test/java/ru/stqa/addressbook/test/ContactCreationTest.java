package ru.stqa.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {

    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contactData = new ContactData("Evgen", "Test",
            "+7123456", "mail@mail.ru", "TEST");
    app.getContactHelper().createContact(contactData);
    app.getNavigationHelper().gotoContactPage();

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    int max = 0;
    for (ContactData c : after) {
      if(c.getId() > max) {
        max = c.getId();
      }
    }
    contactData.setId(max);
    before.add(contactData);

    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }

}
