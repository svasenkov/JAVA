package ru.stqa.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[] args) {
//    String [] langs = new String[4];
//    langs [0] = "Java";
//    langs [1] = "C#";
//    langs [2] = "PHP";
//    langs [3] = "Python";

    String [] langs = {"Java", "C#", "PHP", "Python"};


    for (String str : langs) {
      System.out.println(" I want to learn " + str);
    }

    for (int i = 0; i < langs.length; i ++) {
      System.out.println("My favorite langs is  " + langs[i]);
    }


//    List<String> languages = new ArrayList<>();
//    languages.add("&&&");
//    languages.add("C$$");
//    languages.add("HHHH");

    List<String> languages = Arrays.asList("Java", "C#", "PHP", "Python");
    for (String lng : languages) {
      System.out.println("ArraysList " + lng);
    }

  }

}
