package com.sfbl.javaext.utils;

import java.util.Objects;

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
  public static boolean eq(String s, String t) { return Objects.equals(s, t); }

  /**
   * Join string by separator
   * @param separator
   * @param strs
   * @return
   */
  public static String join(String separator, String... strs) {
    StringBuilder sb = new StringBuilder();
    for (String str : strs) {
      sb.append(str).append(separator);
    }
    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }

  public static String newStr(Character fillWith, int length) {
    // better way???
    StringBuilder sb = new StringBuilder(length);
    for(int i=0; i<length; ++i)
      sb.append(fillWith);
    return sb.toString();
  }

  public static String padLeft(String s, Character fillWith, int length) {
    if (isNullOrEmpty(s))
      return newStr(fillWith, length);
    if (s.length() > length)
      return s;
    return newStr(fillWith, length - s.length()) + s;
  }

  public static String padRight(String s, Character fillWith, int length) {
    if (isNullOrEmpty(s))
      return newStr(fillWith, length);
    if (s.length() > length)
      return s;
    return s + newStr(fillWith, length - s.length());
  }
}
