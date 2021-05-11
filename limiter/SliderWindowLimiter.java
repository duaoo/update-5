import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author duxiaojie
 * @date 2021-05-10 17:16
 */
public class SliderWindowLimiter {

    public static void main(String[] args) throws InterruptedException {

        int blockNum = 2;
        int limitNum = 3;

        SliderWindow sliderWindow = new SliderWindow(blockNum, limitNum);

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(sliderWindow,1000, TimeUnit.MILLISECONDS);

        for (;;){
            new Thread(()-> System.out.println(sliderWindow.tryAcquire())).start();
            TimeUnit.MILLISECONDS.sleep(200);
        }

    }

    static class SliderWindow implements Runnable {

        /**
         * 滑块个数
         */
        private final int blockNum;
        /**
         * 滑块数组
         */
        private AtomicLong[] blocks;
        /**
         * 当前滑块位置
         */
        private volatile int index;
        /**
         * 每秒允许通过的数量
         */
        private final long limitNum;
        /**
         * 当前请求数量
         */
        private AtomicLong currentTotalNum;

        public SliderWindow(int blockNum, long limitNum) {
            this.blockNum = blockNum;
            this.limitNum = limitNum;
            blocks = new AtomicLong[blockNum];
            for (int i = 0; i < blockNum; i++) {
                blocks[i] = new AtomicLong();
            }
            currentTotalNum = new AtomicLong(0);
        }

        /**
         * 判断是否可通过
         */
        public boolean tryAcquire() {
            return currentTotalNum.get() < limitNum;
        }


        @Override
        public void run() {

            // 提前记录当前index的val
            final long val = blocks[index].get();

            // 计算下一个新index
            index = (index + 1) % blockNum;
            // 重置新index的val
            blocks[index].set(0);

            // 重置当前请求数量
            currentTotalNum.addAndGet(-val);
        }
    }
}

