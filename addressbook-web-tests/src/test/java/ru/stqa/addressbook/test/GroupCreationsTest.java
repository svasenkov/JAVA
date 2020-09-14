package ru.stqa.addressbook.test;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;


public class GroupCreationsTest extends TestBase {

  @Test
  public void testGroupCreations() {

    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("TestTest",  null, null);
    app.getGroupHelper().creatGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);

    int max = 0;
    for (GroupData g : after) {
      if(g.getId() > max) {
        max = g.getId();
      }
    }
    group.setId(max);
    before.add(group);

    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }

}
