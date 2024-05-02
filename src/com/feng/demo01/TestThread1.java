package com.feng.demo01;

// 继承Thread方法，重写run方法，调用start开启线程
public class TestThread1 extends Thread {

  // 重写run()方法
  @Override
  public void run() {
    for (int i = 0; i < 200; i++) {
      System.out.println("我在看代码---" + i);
    }
  }

  public static void main(String[] args) {
    // 创建线程对象
    TestThread1 testThread1 = new TestThread1();
    // 1、启动线程run()方法
    testThread1.run();
    // 2、启动线程start()方法
    testThread1.start();
    for (int i = 0; i < 200; i++) {
      System.out.println("我在学习多线程---" + i);
    }
  }
}