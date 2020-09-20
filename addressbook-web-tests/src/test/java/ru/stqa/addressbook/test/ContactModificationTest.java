package ru.stqa.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase {

//    Изменен
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

    Contacts before = app.contact().all();
    ContactData modifyContact = before.iterator().next();

    ContactData contactData = new ContactData().withId(modifyContact.getId())
            .withFirstname("ЕвGeN").withLastname("Жека").withMobile("+7901234567")
            .withEmail("mail@net.com").withAddress("Mogaisk");

    app.contact().modify(contactData);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size());

    assertThat(after, equalTo(before.withOut(modifyContact).withAdded(contactData)));
  }



}
