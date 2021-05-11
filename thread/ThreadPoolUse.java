import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author duxiaojie
 * @date 2021-01-07 19:23
 */
public class ThreadPoolUse {

    static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        executorService.submit(new Speaker1("hello sony"));
        executorService.submit(new Speaker2("hello apple"));
    }

    public static class Speaker2 implements Runnable {

        private String msg;

        Speaker2(String msg){
            this.msg = msg;
        }

        @Override
        public void run() {
            System.out.println(msg);
        }
    }

    public static class Speaker1 extends Thread {

        private String msg;

        Speaker1(String msg){
            this.msg = msg;
        }

        @Override
        public void run() {
            System.out.println(msg);
        }
    }
}
