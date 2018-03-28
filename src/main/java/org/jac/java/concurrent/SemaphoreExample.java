package org.jac.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
	
	public static void main(String[] args) {
        // �̳߳�
        ExecutorService exec = Executors.newCachedThreadPool();
        // ֻ��5���߳�ͬʱ����
        final Semaphore semp = new Semaphore(5);
        // ģ��20���ͻ��˷���
        for (int index = 1; index <= 20; index++) {
            final int NO = index;
            exec.execute(() -> {
            	try {
            		// ��ȡ���
            		semp.acquire();
            		System.out.println("Accessing: " + NO);
            		Thread.sleep((long) (Math.random() * 6000));
            		// ��������ͷ�
            		semp.release();
            		//availablePermits()ָ���ǵ�ǰ�źŵƿ����ж��ٸ����Ա�ʹ��
            		System.out.println("------ Avalable: " + semp.availablePermits()); 
            	} catch (InterruptedException e) {
            		e.printStackTrace();
            	}
            });
        }
        // �˳��̳߳�
        exec.shutdown();
    }
}
