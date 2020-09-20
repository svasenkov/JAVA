package ru.stqa.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {


      app.goTo().homePage();
      Set<ContactData> before = app.contact().all();
      ContactData contactData = new ContactData().withFirstname("ЕвGeN").withLastname("Жека")
              .withMobile("+7 901 234 456").withEmail("mail@net.com").withAddress("Geleznodorogniy");
      app.contact().create(contactData);
      app.goTo().contactPage();
      Set<ContactData> after = app.contact().all();
      Assert.assertEquals(after.size(), before.size() + 1);

      contactData.withId(after.stream().mapToInt((c) ->c.getId()).max().getAsInt());
      before.add(contactData);
      Assert.assertEquals(before, after);





  }

}
