package ru.stqa.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;


public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {


      app.goTo().homePage();
      List<ContactData> before = app.contact().list();
      ContactData contactData = new ContactData().withFirstname("ЕвGeN").withLastname("Жека")
              .withMobile("+7 901 234 456").withEmail("mail@net.com").withAddress("Geleznodorogniy");
      app.contact().create(contactData);
      app.goTo().contactPage();
      List<ContactData> after = app.contact().list();
      Assert.assertEquals(after.size(), before.size() + 1);

      before.add(contactData);
      Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);





  }

}
