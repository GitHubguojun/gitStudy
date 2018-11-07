package com.hb.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @Description: 异步方法配置
 */
@Configuration
@EnableAsync
public class AsyncConfigurer extends AsyncConfigurerSupport{

    /**
     * 使用ThreadPoolTaskExecutor实现TaskExecutor,用来开发异步任务
     * @return
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(100);
        executor.setMaxPoolSize(100);
        executor.setQueueCapacity(100);
        executor.initialize();
        return executor;
    }

}
