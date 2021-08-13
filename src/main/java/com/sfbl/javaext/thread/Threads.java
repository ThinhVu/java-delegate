package com.sfbl.javaext.thread;

import com.sfbl.javaext.delegate.Action;
import com.sfbl.javaext.thread.exception.StopIntervalException;

import java.util.Date;
import java.util.HashSet;

public class Threads {
  public static void sleep(long ms) {
    try { Thread.sleep(ms); } catch (Exception ignored){}
  }

  private static final HashSet<Long> timeoutIds = new HashSet<>();
  private static long generateTimeoutId(HashSet<Long> ids) {
    long id = new Date().getTime();
    while (ids.contains(id)) {
      id = new Date().getTime();
    }
    return id;
  }
  public static long setTimeout(Action._0 action, long timeout) {
    long id = generateTimeoutId(timeoutIds);
    timeoutIds.add(id);
    new Thread(() -> {
      Threads.sleep(timeout);
      if (timeoutIds.contains(id)) {
        action.$();
        clearTimeout(id);
      }
    }).start();
    return id;
  }
  public static void clearTimeout(long timeoutId) {
    timeoutIds.remove(timeoutId);
  }

  private static final HashSet<Long> intervalIds = new HashSet<>();
  interface IIntervalAction {
    void $() throws StopIntervalException;
  }
  public static long setInterval(IIntervalAction action, long interval) {
    long id = generateTimeoutId(intervalIds);
    intervalIds.add(id);
    new Thread(() -> {
      while(intervalIds.contains(id)) {
        try {
          action.$();
          Threads.sleep(interval);
        } catch (StopIntervalException sie) {
          clearInterval(id);
        }
      }
    }).start();
    return id;
  }
  public static void clearInterval(long intervalId) {
    intervalIds.remove(intervalId);
  }
}

