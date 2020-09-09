package ru.stqa.addressbook.test;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.stqa.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {


  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initModificationContact();
    app.getContactHelper().fillContactGroup(new ContactData("NewUpDate",
            "NewUpDate",
            "00000000",
            "010101010","Mogaisk", null), false);
    app.getContactHelper().submitModificationContact();
    app.getNavigationHelper().gotoContactPage();

  }


}
