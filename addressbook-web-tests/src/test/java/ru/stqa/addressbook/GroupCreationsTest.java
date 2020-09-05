package ru.stqa.addressbook;


import org.testng.annotations.Test;


public class GroupCreationsTest extends TestBase {

  @Test
  public void testGroupCreations() {

    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("TestReTest", "Test1", "Test2"));
    submitGroupCreation();
    returnGroupPage();

  }

}
