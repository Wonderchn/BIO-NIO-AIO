package com.hongna.four;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HanlerSocketServerPool {
    // 1.创建一个线程池的成员变量用于存储一个线程池对象
    private ExecutorService executorService;
    /**
     * 2.创建这个类的对象的时候就需要初始化线程池对象
     */
    public HanlerSocketServerPool(int maxThreadNum,int queueSize){
        executorService = new ThreadPoolExecutor(3, maxThreadNum, 120, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(queueSize));


    }
    /**
     * 3.提供一个方法来提交任务给线程池的任务队列来暂存，等着线程池来处理
     *
     */
   public void execute(Runnable target){
        executorService.execute(target);
}
}

