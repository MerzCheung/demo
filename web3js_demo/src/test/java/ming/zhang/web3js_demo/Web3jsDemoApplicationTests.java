package ming.zhang.web3js_demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@SpringBootTest
class Web3jsDemoApplicationTests {


    @Test
    void contextLoads() throws Exception {
//        int[] arr = {0};
//        Semaphore semaphore = new Semaphore(5);
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 2; i++) {
//            semaphore.acquire();
//            executorService.execute(() -> {
//                try {
//                    Thread.sleep(2000);
//                    System.out.println("1111111111");
//                    arr[0] = arr[0] + 1;
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    semaphore.release();
//                }
//            });
//        }
//        executorService.shutdown();
//        while (!executorService.isTerminated()) {
//            Thread.sleep(1000);
//        }
//        System.out.println(arr[0]);

        List<String> strings = Arrays.asList("1", "2");
        System.out.println(ObjectUtils.isEmpty(strings));
    }

}
