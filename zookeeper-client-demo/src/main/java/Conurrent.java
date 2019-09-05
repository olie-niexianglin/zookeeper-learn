import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by IntelliJ IDEA.
 * User: Nie Xianglin
 * Date: 2019/9/3
 * Time: 11:35
 * Desc: 多线程
 */
public class Conurrent {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();



    }

}
