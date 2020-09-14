package ru.stqa.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionsTest extends TestBase {

  @Test
  public void testGroupDeletions() {
    app.getNavigationHelper().gotoGroupPage();
    if ( ! app.getGroupHelper().isThereAgroup()) {
      app.getGroupHelper().creatGroup(new GroupData("TestTes", null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();

    app.getGroupHelper().selectGroup(before.size() -1);
    app.getGroupHelper().deletSelectedGroups();
    app.getGroupHelper().returnGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();

    Assert.assertEquals(after.size(), before.size() -1);

    before.remove(before.size() -1);
    Assert.assertEquals(before, after);


  }

}
