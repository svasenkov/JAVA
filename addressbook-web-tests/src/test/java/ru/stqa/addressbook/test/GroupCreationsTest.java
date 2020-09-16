package ru.stqa.addressbook.test;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.GroupData;

import java.util.Set;


public class GroupCreationsTest extends TestBase {

  @Test
  public void testGroupCreations() {

    app.goTo().groupPage();
    Set<GroupData> before = app.group().all();
    GroupData group = new GroupData().withName("Test");
    app.group().create(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(group);
    Assert.assertEquals(before, after);

  }

}
