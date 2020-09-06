package ru.stqa.sandbox;

public class Equation {
  private double a;
  private double c;
  private double b;

  private int n;

  public Equation(double a, double c, double b) {
    this.a = a;
    this.c = c;
    this.b = b;

    double d = b*b + 4*a*c;

    if (a != 0) {
      if (b > 0) {
        n = 2;
      } else if (d == 0) {
        n = 1;
      } else {
        n = 0;
      }
    } else if (b != 0) {
      n = 1;
    } else if (c != 0) {
      n = 0;
    } else {
      n = -1;
    }
  }

  public int rootNumber() {
    return n;
  }
}
