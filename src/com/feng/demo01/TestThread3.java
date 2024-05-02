package com.feng.demo01;

// 实现Runnable接口，重写run方法，执行线程需要丢入Runnable接口实现类，调用start方法
public class TestThread3 implements Runnable {

  // 重写run()方法
  @Override
  public void run() {
    for (int i = 0; i < 200; i++) {
      System.out.println("我在看代码---" + i);
    }
  }

  public static void main(String[] args) {
    // 创建Runnable接口的实现类对象
    TestThread3 testThread3 = new TestThread3();

    // 创建线程对象，通过线程对象来开启线程，代理
    // Thread thread = new Thread(testThread3);
    // thread.start();

    new Thread(testThread3).start();

    for (int i = 0; i < 200; i++) {
      System.out.println("我在学习多线程---" + i);
    }
  }
}