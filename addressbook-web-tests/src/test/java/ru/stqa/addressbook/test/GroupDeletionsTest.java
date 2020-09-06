package ru.stqa.addressbook.test;

import org.testng.annotations.*;
import ru.stqa.addressbook.test.TestBase;

public class GroupDeletionsTest extends TestBase {

  @Test
  public void testGroupDeletions() {
    app.gotoGroupPage();
    app.selectGroup();
    app.deletSelectedGroups();
    app.returnGroupPage();
  }

}
