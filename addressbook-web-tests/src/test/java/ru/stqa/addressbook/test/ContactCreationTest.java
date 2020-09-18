package ru.stqa.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {


  @Test (enabled = false)
  public void testContactCreation() {

    app.goTo().homePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contactData = new ContactData("Name", "LastName",
            "+7123456", "mail@mail.ru", "TEST");
    app.getContactHelper().createContact(contactData);
    app.goTo().contactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);


    before.add(contactData);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}
