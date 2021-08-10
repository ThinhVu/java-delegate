package com.sfbl.javaext.utils;

public class Strings {
  /**
   * Helper method which check if string is null or empty.
   * @param s string you want to check
   * @return true if string is null or empty
   */
  public static boolean isNullOrEmpty(String s) {
    return s == null || "".equals(s);
  }

  /**
   * Helper method which check if s1 string is equal to s2 string. Reduce bored null checking in your code.
   * @return true if s1.equals(s2)
   */
  public static boolean eq(String s, String t) {
    if (s == null) {
      return t == null;
    } else {
      return s.equals(t);
    }
  }
}
