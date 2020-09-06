package ru.stqa.addressbook.test;

import org.testng.annotations.*;

public class GroupDeletionsTest extends TestBase {

  @Test
  public void testGroupDeletions() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deletSelectedGroups();
    app.getGroupHelper().returnGroupPage();
  }

}
