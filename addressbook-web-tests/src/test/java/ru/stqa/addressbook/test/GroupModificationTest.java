package ru.stqa.addressbook.test;


import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.stqa.addressbook.model.GroupData;


public class GroupModificationTest extends TestBase{


  @Test
  public void testUntitledTestCase() {

    app.getNavigationHelper().gotoGroupPage();

    if( ! app.getGroupHelper().isThereAGruop()) {
      app.getGroupHelper().creatGroup(new GroupData("TestReTest", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initModificationTest();
    app.getGroupHelper().fillGroupForm(new GroupData( "New Test", "Test New","New"));
    app.getGroupHelper().submitModificationTest();

  }
}
