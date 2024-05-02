package com.feng.demo01;

// 多个线程同时操作一个对象
// 例子：买火车票
public class TestThread4 implements Runnable {

  // 票数
  private int ticketNums = 10;

  @Override
  public void run() {
    while (true) {
      if (ticketNums <= 0) {
        break;
      }

      // 模拟延时
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println(Thread.currentThread().getName() + "--->拿到了第" + ticketNums-- + "张票");
    }
  }

  public static void main(String[] args) {
    TestThread4 ticket = new TestThread4();

    new Thread(ticket, "小明").start();
    new Thread(ticket, "老师").start();
    new Thread(ticket, "黄牛党").start();
  }

}