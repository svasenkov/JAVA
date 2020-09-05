package ru.stqa.addressbook;

import org.testng.annotations.*;
import org.openqa.selenium.*;

public class GroupDeletionsTest extends TestBase {

  @Test
  public void testGroupDeletions() {
    gotoGroupPage();
    selectGroup();
    deletSelectedGroups();
    returnGroupPage();
  }

}
