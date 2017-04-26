package zzjp.springboot.async;

import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * Created by lukasz on 4/19/17.
 */
@Component
public class MyAsyncComponent {

//    @Bean("taskExecutor-2")
//    public TaskExecutor taskExecutor() {
//        return new SimpleAsyncTaskExecutor();
//    }


    @Async
    public void storeInDb(String value) {

        // do something

    }

    @Async
    public Future<String> accessWebService(String address) {
        // access web service
        try {
            Thread.sleep(1000);
            return new AsyncResult<>("result " + Thread.currentThread());
        } catch (InterruptedException e) {
            throw new RuntimeException("errorr");
        }
    }



}
