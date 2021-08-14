package com.sfbl.javaext.asyncAwait;

import com.sfbl.javaext.delegate.Action;
import java.util.concurrent.ExecutionException;
import java9.util.concurrent.CompletableFuture;

public class Async {
  /**
   * Run task asynchronous
   * @param executor task
   * @param <T> result
   * @return result
   * @throws ExecutionException
   * @throws InterruptedException
   */
  public static <T> T await(Action._1<Action._1<T>> executor)
      throws ExecutionException, InterruptedException {

    CompletableFuture<T> future = new CompletableFuture<>();

    new Thread(() -> executor.$(future::complete)).start();

    return future.get();
  }
}