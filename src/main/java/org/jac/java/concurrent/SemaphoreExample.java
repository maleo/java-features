package org.jac.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
	
	public static void main(String[] args) {
        // 线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        // 只能5个线程同时访问
        final Semaphore semp = new Semaphore(5);
        // 模拟20个客户端访问
        for (int index = 1; index <= 20; index++) {
            final int NO = index;
            exec.execute(() -> {
            	try {
            		// 获取许可
            		semp.acquire();
            		System.out.println("Accessing: " + NO);
            		Thread.sleep((long) (Math.random() * 6000));
            		// 访问完后，释放
            		semp.release();
            		//availablePermits()指的是当前信号灯库中有多少个可以被使用
            		System.out.println("------ Avalable: " + semp.availablePermits()); 
            	} catch (InterruptedException e) {
            		e.printStackTrace();
            	}
            });
        }
        // 退出线程池
        exec.shutdown();
    }
}
