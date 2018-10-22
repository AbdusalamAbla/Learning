package bingxing;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Abdusalam on 18/10/20.
 */
public class ShellSortBingxin {
    private int[] a;
    private static ExecutorService pool = Executors.newCachedThreadPool();
    ShellSortBingxin(){
        Random random=new Random();
        Scanner scanner = new Scanner(System.in);
        a=new int[scanner.nextInt()];
        for (int i=0;i<a.length;i++) {
            a[i]=random.nextInt(1000000);
        }
    }
    public  class ShellSortTask implements Runnable {

        int x = 0;
        int h = 0;
        CountDownLatch l;

        public ShellSortTask(int x, int h, CountDownLatch latch) {
            this.x = x;
            this.h = h;
            this.l = latch;

        }

        public void run() {
            int i, j, key;
            for (i = x + h; i < a.length; i = i + h) {
                if (a[i] < a[i - h]) {
                    j = i - h;
                    key = a[i];
                    while (j >= 0 && a[j] > key) {
                        a[j + h] = a[j];
                        j -= h;
                    }
                    a[j + h] = key;
                }

            }

            l.countDown();

        }
    }

    public  void pShellSort(int[] arr) throws InterruptedException {
        // 计算出最大的n值
        int h = 1;
        CountDownLatch lathc = null;
        while (h <= arr.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            System.out.println("h=" + h);

            lathc = new CountDownLatch(h);
            for (int x = 0; x < h; x++) {
                pool.submit(new ShellSortTask(x, h, lathc));
            }
            lathc.await();
            // 计算下一个h值
            h = (h - 1) / 3;
        }
        pool.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {

        ShellSortBingxin shellSortBingxin=new ShellSortBingxin();
        long startTime = System.currentTimeMillis();
        shellSortBingxin.pShellSort(shellSortBingxin.a);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
        System.out.println("end");

    }

}

