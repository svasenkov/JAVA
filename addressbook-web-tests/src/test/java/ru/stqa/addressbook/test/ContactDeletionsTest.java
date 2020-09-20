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
    if(app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Евген").withLastname("Жека")
              .withMobile("+7123456").withEmail("mail@mail.ru").withAddress("Mogaisk"));
    }
  }

  @Test
  public void testContactDeletions() {
    List<ContactData> before = app.contact().list();
    int index = before.size() -1;
    app.contact().delet(index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), index);
    before.remove(index);
    Assert.assertEquals(before, after);


  }



}
