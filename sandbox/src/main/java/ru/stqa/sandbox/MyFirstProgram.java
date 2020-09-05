package ru.stqa.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    Square s = new Square(4);
    Rectangle r = new Rectangle(3,3);

    String name = "VASA";
    hello(name);

    System.out.println("Ploshad ravna = " +  r.area());
    System.out.println("Ploshad " + s.l + " ravna = " + s.area());

  }
  public static void hello (String name) {
    System.out.println("My name is " + name + " Hello ! ");
  }

}

