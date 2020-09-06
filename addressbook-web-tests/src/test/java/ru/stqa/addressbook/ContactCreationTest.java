package ru.stqa.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {

    gotoContactPage();
    initContactCreation();
    fillContactGroup(new ContactData("Evgeniy", "Telepnev", "Mogaisk", "+7 926 123 45 67", "8 901 233 44 55", "mail@net.ru"));
    submitContactCreation();

  }

}
