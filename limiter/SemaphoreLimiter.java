import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author duxiaojie
 * @date 2021-05-08 17:47
 */
public class SemaphoreLimiter {

    static int limitNum = 2;
    static Semaphore semaphore = new Semaphore(limitNum);

    public static void main(String[] args) throws InterruptedException {

        for (; ; ) {
            new Thread(() -> {
                String msg = tryAcquire() ? " 进入":" 拒绝";
                System.out.println(Thread.currentThread().getName() + msg);
            }).start();

            TimeUnit.MILLISECONDS.sleep(300);
        }


    }


    private static boolean tryAcquire() {

        if (!semaphore.tryAcquire()) {
            return false;
        }

        try {
            // do something
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }

        return true;
    }

}
