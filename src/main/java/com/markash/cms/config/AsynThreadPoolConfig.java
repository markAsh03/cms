
package com.markash.cms.config;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 
 * @author muanan
 *
 */
@EnableAsync
@Configuration
public class AsynThreadPoolConfig {

    // 参数初始化
    // private static final int CPU_COUNT =
    // Runtime.getRuntime().availableProcessors();
    // 核心线程数量大小
    private static final int corePoolSize = 10;
    // 线程池最大容纳线程数
    private static final int maximumPoolSize = 120;
    // 线程空闲后的存活时长
    private static final int keepAliveTime = 30;

    // 任务过多后，存储任务的一个阻塞队列
    BlockingQueue<Runnable> workQueue = new SynchronousQueue<>();

    // 线程的创建工厂
    ThreadFactory threadFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable r) {
            return new Thread(r, "AdvacnedAsyncTask #" + mCount.getAndIncrement());
        }
    };

    // 线程池任务满载后采取的任务拒绝策略
    RejectedExecutionHandler rejectHandler = new ThreadPoolExecutor.DiscardOldestPolicy();

    // 线程池对象，创建线程
    @Bean
    public ExecutorService g() {
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue,
                threadFactory, rejectHandler);
    }

}
