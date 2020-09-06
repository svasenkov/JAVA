package ru.stqa.addressbook.test;

import org.testng.annotations.*;


public class ContactDeletionsTest extends TestBase {

  @Test
  public void testContactDeletions() {
    app.getNavigationHelper().gotoContactPage();
    app.selectContact();
    app.deletSeletedContact();
    app.closeAlert();
    app.getNavigationHelper().gotoContactPage();
  }

}
