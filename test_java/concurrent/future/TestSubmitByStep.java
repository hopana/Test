package future;

import org.apache.commons.lang3.ArrayUtils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * submit(Runnable task)方法多个任务依次执行
 *
 * @author hupan
 * @date 2020/09/04
 */
public class TestSubmitByStep {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable1 = () -> {
            try {
                Thread.sleep(3000);
                System.out.println("----task1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(3000);
                System.out.println("----task2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };


        Runnable runnable3 = () -> {
            try {
                Thread.sleep(3000);
                System.out.println("----task3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        executeAllByStep(runnable1, runnable2, runnable3);
    }

    public static void executeAllByStep(Runnable... threads) throws ExecutionException, InterruptedException {
        if (ArrayUtils.isEmpty(threads)) {
            return;
        }

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (Runnable thread : threads) {
            executor.submit(thread).get();
        }

        executor.shutdown();
    }
}