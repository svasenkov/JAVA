package ru.stqa.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.addressbook.model.GroupData;

public class GroupDeletionsTest extends TestBase {

  @Test
  public void testGroupDeletions() {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();

    if ( ! app.getGroupHelper().isThereAgroup()) {
      app.getGroupHelper().creatGroup(new GroupData("TestTes", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deletSelectedGroups();
    app.getGroupHelper().returnGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before -1);

  }

}
