package ru.stqa.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTest extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {

    app.goTo().homePage();
    if( app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Евген").withLastname("Жека")
              .withMobile("+7123456").withEmail("mail@mail.ru").withAddress("Mogaisk"));
    }
  }

  @Test
  public void testContactModification() {

    Set<ContactData> before = app.contact().all();
    ContactData modifyContact = before.iterator().next();

    ContactData contactData = new ContactData().withId(modifyContact.getId())
            .withFirstname("ЕвGeN").withLastname("Жека").withMobile("+7901234567")
            .withEmail("mail@net.com").withAddress("Mogaisk");

    app.contact().modify(contactData);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

// делаем замену удаленного на измененный
    before.remove(modifyContact);
    before.add(contactData);
    Assert.assertEquals(before, after);
  }



}
