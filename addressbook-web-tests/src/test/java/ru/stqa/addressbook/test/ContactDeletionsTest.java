package ru.stqa.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

import java.util.List;
import java.util.Set;


public class ContactDeletionsTest extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {

    app.goTo().homePage();
    if(app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Евген").withLastname("Жека")
              .withMobile("+7123456").withEmail("mail@mail.ru").withAddress("Mogaisk"));
    }
  }

  @Test
  public void testContactDeletions() {
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();

    app.contact().delet(deletedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() -1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);


  }



}
