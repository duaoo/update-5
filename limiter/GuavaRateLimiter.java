import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * @author duxiaojie
 * @date 2021-05-10 15:05
 */
public class GuavaRateLimiter {

    static int limitNum = 1;
    static final RateLimiter rateLimiter = RateLimiter.create(limitNum);

    public static void main(String[] args) throws InterruptedException {

        for (; ; ) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + (tryAcquire() ? "进入" : "拒绝"));
            }).start();

            TimeUnit.MILLISECONDS.sleep(100);
        }

    }

    private static boolean tryAcquire() {
        return rateLimiter.tryAcquire();
    }
}
