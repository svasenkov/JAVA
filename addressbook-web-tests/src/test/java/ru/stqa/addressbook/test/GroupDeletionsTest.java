package ru.stqa.addressbook.test;

import org.testng.annotations.*;
import ru.stqa.addressbook.model.GroupData;

public class GroupDeletionsTest extends TestBase {

  @Test
  public void testGroupDeletions() {
    app.getNavigationHelper().gotoGroupPage();
    if( ! app.getGroupHelper().isThereAGruop()) {
      app.getGroupHelper().creatGroup(new GroupData("TestReTest", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deletSelectedGroups();
    app.getGroupHelper().returnGroupPage();
  }

}
