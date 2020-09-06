package ru.stqa.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.*;


public class ContactDeletionsTest extends TestBase {

  @Test
  public void testContactDeletions() {
    gotoContactPage();
    selectContact();
    deletSeletedContact();
    closeAlert();
  }

}
