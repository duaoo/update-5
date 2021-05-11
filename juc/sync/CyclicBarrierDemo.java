package sync;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author duxiaojie
 * @date 2020-12-28 17:00
 */
public class CyclicBarrierDemo {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public static void main(String[] args) {

        for (int i = 1; i < 10; i++) {
            new Worker(i, cyclicBarrier).start();
        }

    }

    public static class Worker extends Thread {

        private int seq;
        private CyclicBarrier cyclicBarrier;

        public Worker(int seq, CyclicBarrier cyclicBarrier) {
            this.seq = seq;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {

            try {
                System.out.println(seq + " doing...");
                TimeUnit.SECONDS.sleep(new Random().nextInt(10) + 3);
                cyclicBarrier.await();

            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            } finally {
                System.out.println(seq + " done.");
            }

        }
    }
}
