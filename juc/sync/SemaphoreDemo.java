package sync;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author duxiaojie
 * @date 2020-12-28 16:38
 */
public class SemaphoreDemo {

    static Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Worker(i, semaphore).start();
        }

    }

    public static class Worker extends Thread {

        private int seq;
        private Semaphore semaphore;

        public Worker(int seq, Semaphore semaphore) {
            this.seq = seq;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {

            try {
                semaphore.acquire();
                System.out.println(seq + " doing...");
                TimeUnit.SECONDS.sleep(new Random().nextInt(1)+1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println(seq + " done.");
            }

        }
    }
}
