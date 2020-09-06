package ru.stqa.addressbook.test;

import org.testng.annotations.*;
import ru.stqa.addressbook.test.TestBase;


public class ContactDeletionsTest extends TestBase {

  @Test
  public void testContactDeletions() {
    app.gotoContactPage();
    app.selectContact();
    app.deletSeletedContact();
    app.closeAlert();
    app.gotoContactPage();
  }

}
