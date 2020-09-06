package ru.stqa.addressbook.test;


import org.testng.annotations.Test;
import ru.stqa.addressbook.model.GroupData;


public class GroupCreationsTest extends TestBase {

  @Test
  public void testGroupCreations() {

    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("TestReTest", null, null));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnGroupPage();

  }

}