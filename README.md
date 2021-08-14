# java 1.8 extension

## Delegate equivalent

Using "delegate" to create execution block inside method without the need of interface. 

```java
import com.sfbl.javaext.delegate.Action;
import com.sfbl.javaext.delegate.Func;

class Example {
  void ex() {
    // declare function w/o param, no return
    Action._0 helloWorld = () -> Log.d("", "Hello world");
    helloWorld.$();
    
    // declare function with 1 param, no return
    Action._1<String> log = content -> Log.d("", content);
    log.$("Timeout!");
    
    // declare function w/o param, return Long
    Func._1<Long> getTime = () -> new Date().getTime();
    long time = getTime.$();
    
    // declare function w 1 param, return Long
    Func._2<Long, Long> square = value -> value * value;
    long squareOfFive = square.$(5);
    
    // Predicate is similar to Func._2<T, Boolean>
  }
}
```

## Tuple

Using Tuple to create complex response data without the need of data class.

```java
import com.sfbl.javaext.tuple.Tuple;
import com.sfbl.javaext.delegate.Func;

class Example {
  void ex() {  
    Func._2<Integer, Tuple._3<Integer, Integer, String>> getLatestWithdrawInfo = balanceId -> {
      int amount = 30; // usd
      String withdrawMessage = "Payout";
      return Tuple.create(balanceId, amount, withdrawMessage);
    }; 

    Tuple._3<Integer, Integer, String> withdrawInfo = getLatestWithdrawInfo.$(123);

    int balanceId = withdrawInfo.item1;
    int amount = withdrawInfo.item2;
    String msg = withdrawInfo.item3;
  }
}
```


## Threads

```java
import com.sfbl.javaext.thread.Threads;
class Example {
  void ex() {  
    // sleep w/o ignored exception
    Threads.sleep(500);
    
    // run after 500ms
    long timeOutId = Threads.setTimeout(() -> { /* execution code */ }, 500);
    
    // stop created timeOut thread
    Threads.clearTimeout(timeOutId);
    
    // run each 1s
    long intervalId = Threads.setInterval(() -> { /* execution code */ }, 1000);
    
    // stop interval by id
    Threads.clearInterval(intervalId);
    
    // or stop interval inside execution code and do not need to care about interval id.
    Threads.setInterval(() -> {
      if (new Date().getTime() % 5 == 0)
        throw new StopIntervalException();
      else
        Log.d("Threads", "...");
    }, 1000);
  }
}
```

### Strings

```java
import com.sfbl.javaext.utils.Strings;

class Example {
  void ex() {
    Strings.isNullOrEmpty(""); // true
    Strings.isNullOrEmpty(null); // true
    Strings.isNullOrEmpty("hi"); // false

    Strings.eq("", ""); // true
    Strings.eq(null, ""); // false
    Strings.join(",", {"1", "2", "3", "4"});  // "1,2,3,4"
    Strings.join(":", "1", "2", "3", "4");    // "1:2:3:4" 

    Strings.padLeft("9", "0", 2);   // "09"
    Strings.padLeft("59", "0", 2);  // "59"

    Strings.padRight("Key: 123456", " ", 20);  // "Key: 123456         "
    Strings.newStr('*', 10);                   // "**********"
  }
}
```

### Async/await

Calling async/await easier

```java
import com.sfbl.javaext.asyncAwait.Async;
import com.sfbl.javaext.delegate.Action;
import com.sfbl.javaext.delegate.Func;

class Example {
  void ex() {
    Action._2<String, Action._1<String>> downloadHtml = (url, callback) -> { 
      String htmlResult = "Lorem ipsum";
      callback.$(htmlResult);
    };

    Func._2<String, String> extractHtml = html -> "extract html code";

    // without async/await
    downloadHtml.$("https://google.com", html -> {
      Log.d("AsyncExample", html);
      String extractedHtml = extractHtml.$(html);
      // do stuff with extractedHtml html
    });

    // with async/await    
    String html = Async.await(resolve -> downloadHtml.$("https://google.com", resolve));
    Log.d("AsyncExample", html);
    String extractedHtml = extractHtml.$(html);
    // do stuff with extractedHtml html
  }
}
```