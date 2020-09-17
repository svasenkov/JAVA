package ru.stqa.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {


  @Test
  public void testContactModification() {
    app.goTo().homePage();

    if(! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Evgen", "Test",
              "+7123456", "mail@mail.ru", "TEST"));
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().initModificationContact(before - 1);
    ContactData contactData = new ContactData("!!!!!",
            "!!!!!",
            "+7901234567",
            "mail@net.com","Mogaisk");
    app.getContactHelper().fillContactGroup(contactData);
    app.getContactHelper().submitModificationContact();
    app.goTo().contactPage();
    int after = app.getContactHelper().getContactCount();


    Assert.assertEquals(after, before);
  }

}
