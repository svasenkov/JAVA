package ru.stqa.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {


    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData contactData = new ContactData().withFirstname("ЕвGeN").withLastname("Жека")
            .withMobile("+7 901 234 456").withEmail("mail@net.com").withAddress("Geleznodorogniy");
    app.contact().create(contactData);
    app.goTo().contactPage();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(before.withAdded(contactData.withId(after.stream()
            .mapToInt((c) -> c.getId()).max().getAsInt()))));


  }

}
