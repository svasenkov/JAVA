package ru.stqa.addressbook.test;


import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.stqa.addressbook.model.GroupData;


public class GroupModificationTest extends TestBase{


  @Test
  public void testUntitledTestCase() {

    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initModificationTest();
    app.getGroupHelper().fillGroupForm(new GroupData( "New Test", "Test New","New"));
    app.getGroupHelper().submitModificationTest();

  }
}
