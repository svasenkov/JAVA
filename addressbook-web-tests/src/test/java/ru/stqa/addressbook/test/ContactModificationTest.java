package ru.stqa.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.stqa.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class ContactModificationTest extends TestBase {


  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();

    if(! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Evgen", "Test",
              "+7123456", "mail@mail.ru", "TEST"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().initModificationContact();
    ContactData contactData = new ContactData(before.get(before.size() - 1).getId(),"NewName",
            "NewLastName",
            "+7901234567",
            "mail@net.com","Mogaisk");
    app.getContactHelper().fillContactGroup(contactData);

    app.getContactHelper().submitModificationContact();
    app.getNavigationHelper().gotoContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.add(contactData);
    before.remove(before.size() - 1);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
