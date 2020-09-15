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
    ContactData contactData = new ContactData("Test2", "Test3",
            "+7123456", "mail@mail.ru", "TEST");
    app.getContactHelper().createContact(contactData);
    app.getNavigationHelper().gotoContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contactData);

    contactData.setId(after.stream().max(((o1, o2) -> Integer.compare(o1.getId(), o2.getId()))).get().getId());
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }

}
