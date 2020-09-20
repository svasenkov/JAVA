package ru.stqa.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

import java.util.List;


public class ContactDeletionsTest extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {

    app.goTo().homePage();
    if(! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Евген", "Жека",
              "+7123456", "mail@mail.ru", "Mogaisk"));
    }
  }

  @Test
  public void testContactDeletions() {
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() -1;
    app.getContactHelper().selectContact(index);
    app.getContactHelper().deletSeletedContact();
    app.closeAlert();
    app.goTo().contactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), index);
    before.remove(index);
    Assert.assertEquals(before, after);


  }

}
