package future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * submit(Runnable task)方法使用
 *
 * @author hupan
 * @date 2020/09/04
 */
public class TestSubmitNoResult {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable = () -> {
            //System.out.println("This is ThreadPoolExetor#submit(Runnable runnable) method.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future future = executor.submit(runnable);

        System.out.println("获取结果：");
        System.out.println(future.get());
    }
}