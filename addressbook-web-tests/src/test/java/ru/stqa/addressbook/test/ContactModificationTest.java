package ru.stqa.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {

    app.goTo().homePage();
    if( app.contact().list().size() == 0) {
      app.contact().create(new ContactData("Евген", "Жека",
              "+7123456", "mail@mail.ru", "Mogaisk"));
    }
  }

  @Test
  public void testContactModification() {

    List<ContactData> before = app.contact().list();
    int index = before.size() -1;
    ContactData contactData = new ContactData( before.get(index).getId(),"ЕвGeN",
            "Жека",
            "+7901234567",
            "mail@net.com","Mogaisk");

    app.contact().modify(index, contactData);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

// делаем замену удаленного на измененный
    before.remove(index);
    before.add(contactData);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }



}
