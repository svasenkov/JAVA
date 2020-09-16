package ru.stqa.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.GroupData;

import java.util.Set;


public class GroupModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("TestNew"));
    }
  }

  @Test
  public void testGroupModifications() {

    Set<GroupData> before = app.group().all();
    GroupData modifedGroup = before.iterator().next();
    GroupData group = new GroupData().withId(modifedGroup.getId()).
            withName("Test").withHeader("TestToHeader").withFooter("TestToFooter");
    app.group().modify(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size());
    before.remove(modifedGroup);
    before.add(group);
    Assert.assertEquals(before, after);
  }


}
