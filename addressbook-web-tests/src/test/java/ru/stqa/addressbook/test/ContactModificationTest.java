package ru.stqa.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {


  @Test
  public void testContactModification() {

    app.goTo().homePage();
    if(! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Евген", "Жека",
              "+7123456", "mail@mail.ru", "Mogaisk"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initModificationContact(before.size() -1);
    ContactData contactData = new ContactData( before.get(before.size() -1).getId(),"ЕвGeN",
            "Жека",
            "+7901234567",
            "mail@net.com","Mogaisk");
    app.getContactHelper().fillContactGroup(contactData);
    app.getContactHelper().submitModificationContact();
    app.goTo().contactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

// делаем замену удаленного на измененный
    before.remove(before.size() - 1);
    before.add(contactData);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
