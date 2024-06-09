package com.feng.demo02;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.io.FileUtils;

// 线程创建方式三：实现Callable接口
/**
 * callable的好处：
 * 1、可以定义返回值
 * 2、可以抛出异常
 */
public class TestCallable implements Callable<Boolean> {

  private String url;
  private String file;

  public TestCallable(String url, String file) {
    this.url = url;
    this.file = file;
  }

  @Override
  public Boolean call() {
    WebDownloader webDownloader = new WebDownloader();
    webDownloader.downloader(url, file);
    System.out.println("从" + url + "下载了文件" + file);
    return true;
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    TestCallable t1 = new TestCallable(
        "https://mdn.alipayobjects.com/huamei_0prmtq/afts/img/A*9uyGR6gGcI4AAAAAAAAAAAAADvuFAQ/original", "语雀11");
    TestCallable t2 = new TestCallable(
        "https://mdn.alipayobjects.com/huamei_0prmtq/afts/img/A*9uyGR6gGcI4AAAAAAAAAAAAADvuFAQ/original", "语雀22");
    TestCallable t3 = new TestCallable(
        "https://mdn.alipayobjects.com/huamei_0prmtq/afts/img/A*9uyGR6gGcI4AAAAAAAAAAAAADvuFAQ/original", "语雀33");

    // 创建执行服务
    ExecutorService ser = Executors.newFixedThreadPool(3);
    // 提交执行
    Future<Boolean> r1 = ser.submit(t1);
    Future<Boolean> r2 = ser.submit(t2);
    Future<Boolean> r3 = ser.submit(t3);
    // 获取结果
    boolean rs1 = r1.get();
    boolean rs2 = r2.get();
    boolean rs3 = r3.get();
    // 关闭服务
    ser.shutdownNow();
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