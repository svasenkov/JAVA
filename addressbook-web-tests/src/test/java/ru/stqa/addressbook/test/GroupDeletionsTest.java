package ru.stqa.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionsTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData().withName("TestNew"));
    }
  }

  @Test
  public void testGroupDeletions() {

    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    app.group().delet(index);
    List<GroupData> after = app.group().list();

    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);


  }


}
