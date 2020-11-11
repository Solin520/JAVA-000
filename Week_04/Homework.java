package com.solin.week04;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Homework {
    public static void main(String[] args) throws Exception {
        /*******************************方法1Start*******************************/
        Callable<Integer> myCallable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return sum(36);
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<Integer>(myCallable);
        new Thread(futureTask).start();
        int result1 = futureTask.get();
        System.out.println("方法1计算结果为："+result1);
        /*******************************方法1End*******************************/
        
        /*******************************方法2Start*******************************/
        Map<String, Integer> result2 = new HashMap<>();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                result2.put("result", sum(36));
            }
        });
        thread2.start();
        thread2.join();
        System.out.println("方法2计算结果为："+result2.get("result"));
        /*******************************方法2End*******************************/
        
        /*******************************方法3Start*******************************/
        Map<String, Integer> result3 = new HashMap<>();
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                result3.put("result", sum(36));
            }
        });
        thread3.start();
        while (result3.get("result") == null){
            Thread.sleep(500);
        }
        System.out.println("方法3计算结果为："+result3.get("result"));
        /*******************************方法3End*******************************/
        
        /*******************************方法4Start*******************************/
        Callable<Integer> myCallable4 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return sum(36);
            }
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(myCallable4);
        int result4 = future.get();
        System.out.println("方法4计算结果为："+result4);
        /*******************************方法4End*******************************/
        
    }
    
    private static int sum(int a) {
        return fibo(a);
    }
    
    private static int fibo(int a) {
        if ( a < 2) 
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
