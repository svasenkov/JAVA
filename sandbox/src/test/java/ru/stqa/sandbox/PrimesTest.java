package ru.stqa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


public class PrimesTest {

  @Test
  public void testPrimes() {

    Assert.assertTrue(Primes.isPrimes(Integer.MIN_VALUE));
  }

  public void testNonPrimes() {

    Assert.assertTrue(Primes.isPrimes(Integer.MIN_VALUE - 2));
  }

  @Test (enabled = false)
  public void testIsPrimesLong() {
    long n = Integer.MIN_VALUE;
    Assert.assertTrue(Primes.isPrimes(n));
  }
}