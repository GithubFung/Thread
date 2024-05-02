package com.feng.demo01;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

// 实现多线程同步下载图片
public class TestThread2 extends Thread {

  private String url;
  private String file;

  public TestThread2(String url, String file) {
    this.url = url;
    this.file = file;
  }

  @Override
  public void run() {
    WebDownloader webDownloader = new WebDownloader();
    webDownloader.downloader(url, file);
    System.out.println("从" + url + "下载了文件" + file);
  }

  public static void main(String[] args) {
    TestThread2 t1 = new TestThread2(
        "https://mdn.alipayobjects.com/huamei_0prmtq/afts/img/A*9uyGR6gGcI4AAAAAAAAAAAAADvuFAQ/original", "语雀1");
    TestThread2 t2 = new TestThread2(
        "https://mdn.alipayobjects.com/huamei_0prmtq/afts/img/A*9uyGR6gGcI4AAAAAAAAAAAAADvuFAQ/original", "语雀2");
    TestThread2 t3 = new TestThread2(
        "https://mdn.alipayobjects.com/huamei_0prmtq/afts/img/A*9uyGR6gGcI4AAAAAAAAAAAAADvuFAQ/original", "语雀3");

    t1.start();
    t2.start();
    t3.start();
  }

}

// 下载器
class WebDownloader {
  // 下载方法
  public void downloader(String url, String file) {
    try {
      FileUtils.copyURLToFile(new URL(url), new File(file));
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("IO异常，downloader方法出现问题！");
    }
  }

}
