package ru.stqa.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {

    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactGroup(new ContactData("Evgeniy",
            "Telepnev", "+7 926 123 45 67","mail@net.ru",
            "Mogaisk", "TestTest"), true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage();


  }

}
