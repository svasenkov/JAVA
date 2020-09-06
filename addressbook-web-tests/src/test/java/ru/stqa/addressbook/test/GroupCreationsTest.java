package ru.stqa.addressbook.test;


import org.testng.annotations.Test;
import ru.stqa.addressbook.model.GroupData;
import ru.stqa.addressbook.test.TestBase;


public class GroupCreationsTest extends TestBase {

  @Test
  public void testGroupCreations() {

    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("TestReTest", "Test1", "Test2"));
    app.submitGroupCreation();
    app.returnGroupPage();

  }

}
