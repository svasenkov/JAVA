package ru.stqa.addressbook.test;


import org.testng.annotations.Test;
import ru.stqa.addressbook.model.GroupData;
import ru.stqa.addressbook.model.Groups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationsTest extends TestBase {

  @Test
  public void testGroupCreations() {

    for (int i = 0; i < 40; i++) {
      app.goTo().groupPage();
      Groups before = app.group().all();
      GroupData group = new GroupData().withName("Test");
      app.group().create(group);
      Groups after = app.group().all();
      assertThat(after.size(), equalTo(before.size() + 1));


      assertThat(after, equalTo(
              before.withAdded(group.withId(after.stream().
                      mapToInt((g) -> g.getId()).max().getAsInt()))));

    }

  }

}
