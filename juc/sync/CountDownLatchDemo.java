package sync;

import java.util.concurrent.CountDownLatch;

/**
 * @author duxiaojie
 * @date 2020-12-28 16:06
 */
public class CountDownLatchDemo {

    static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {

        CountDownLatchDemo demo = new CountDownLatchDemo();
        Thread thread1 = demo.handleWork(countDownLatch, "1st thread");
        Thread thread2 = demo.handleWork(countDownLatch, "2st thread");
        Thread thread3 = demo.handleWork(countDownLatch, "3st thread");

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("countDownLatch await start");
//        countDownLatch.await(1, TimeUnit.SECONDS);
        countDownLatch.await();
        System.out.println("countDownLatch await end");

        System.out.println("全部完成啦！");
    }


    private Thread handleWork(CountDownLatch countDownLatch, String threadName) {

        return new Thread(threadName) {

            public void run() {

                System.out.println(threadName + "开始工作啦！");
                try {
                    Thread.sleep(1000 * 5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadName + "工作完成啦！");
                countDownLatch.countDown();
            }
        };
    }
}
