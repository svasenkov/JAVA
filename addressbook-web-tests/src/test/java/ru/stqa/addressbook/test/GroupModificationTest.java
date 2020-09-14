package ru.stqa.addressbook.test;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class GroupModificationTest extends TestBase{


  @Test
  public void testGroupModifications() {

    app.getNavigationHelper().gotoGroupPage();
    if ( ! app.getGroupHelper().isThereAgroup()) {
      app.getGroupHelper().creatGroup(new GroupData("Test1", null, null));
    }

    List<GroupData> before = app.getGroupHelper().getGroupList();

    app.getGroupHelper().selectGroup(before.size() -1);
    app.getGroupHelper().initModificationTest();
    GroupData group = new GroupData(before.get(before.size() -1).getId(),
            "New Test", null,null);
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitModificationTest();
    app.getGroupHelper().returnGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();

    Assert.assertEquals(after.size(), before.size());
    before.remove(before.size() -1);
    before.add(group);

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
