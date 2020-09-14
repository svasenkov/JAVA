package ru.stqa.addressbook.test;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.GroupData;


public class GroupCreationsTest extends TestBase {

  @Test
  public void testGroupCreations() {

    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().creatGroup(new GroupData("TestTest", null, null));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before + 1);

  }

}
