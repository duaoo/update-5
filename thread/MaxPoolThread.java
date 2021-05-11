import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author duxiaojie
 * @date 2020-12-26 14:18
 */
public class MaxPoolThread {

    private final static int CORE_POOL_SIZE = 1024;
    private final static int MAXIMUM_POOL_SIZE = Integer.MAX_VALUE;
    private final static long KEEP_ALIVE_TIME = 10;
    private final static int MAX_FUTURE = 20000;

    public static void main(String[] args) {

//        ExecutorService executorService = new ThreadPoolExecutor(
//                CORE_POOL_SIZE,
//                MAXIMUM_POOL_SIZE,
//                KEEP_ALIVE_TIME,
//                TimeUnit.MINUTES,
//                new SynchronousQueue<>(),
//                new ThreadPoolExecutor.AbortPolicy()
//        );
//
//        List<FutureTask> futureTaskList = new ArrayList<>();
//        for (int i = 0; i < MAX_FUTURE; i++) {
//            final int n = i;
//            futureTaskList.add(
//                    new FutureTask(() -> {
//                        System.out.println(n);
//                        Thread.sleep(60 * 60 * 1000);
//                        return 0;
//                    })
//            );
//        }
//
//        futureTaskList.forEach(executorService::submit);

        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println("done");

    }

}

