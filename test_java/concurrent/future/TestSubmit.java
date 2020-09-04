package future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * submit(Runnable task, T result)方法使用
 *
 * @author hupan
 * @date 2020/09/04
 */
public class TestSubmit {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Data data = new Data();
        Future<Data> future = executor.submit(new Task(data), data);
        System.out.println(future.get().getName());
    }
}

class Data {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Task implements Runnable {
    Data data;

    public Task(Data data) {
        this.data = data;
    }
    public void run() {
        //System.out.println("This is ThreadPoolExetor#submit(Runnable task, T result) method.");
        data.setName("kevin");
    }
}