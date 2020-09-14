package ru.stqa.addressbook.test;


import org.testng.annotations.*;
import ru.stqa.addressbook.model.GroupData;


public class GroupModificationTest extends TestBase{


  @Test
  public void testGroupModifications() {

    app.getNavigationHelper().gotoGroupPage();
    if ( ! app.getGroupHelper().isThereAgroup()) {
      app.getGroupHelper().creatGroup(new GroupData("TestTes", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initModificationTest();
    app.getGroupHelper().fillGroupForm(new GroupData( "New Test", "Test New","New"));
    app.getGroupHelper().submitModificationTest();

  }
}
