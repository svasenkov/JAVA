package ru.stqa.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.GroupData;
import ru.stqa.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("TestNew"));
    }
  }

  @Test (enabled = false)
  public void testGroupModifications() {

    Groups before = app.group().all();
    GroupData modifedGroup = before.iterator().next();
    GroupData group = new GroupData().withId(modifedGroup.getId()).
            withName("Test").withHeader("TestToHeader").withFooter("TestToFooter");
    app.group().modify(group);
    Groups after = app.group().all();
    Assert.assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifedGroup).withAdded(group)));
  }


}
