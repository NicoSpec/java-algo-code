package cn.migu.music.easy;

import com.google.common.collect.Lists;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @version 1.0 created by huangfei on 2025/3/21 14:51
 */
public class 线程池实现{

    private ArrayBlockingQueue<Runnable> queue;

    private List<WorkThread> workThreads;

    private boolean shutDown;

    public 线程池实现(int n) {
        workThreads = Lists.newArrayList();
        queue = new ArrayBlockingQueue<>(100);
        shutDown = false;
        for (int i = 0;i < n;i++) {
            WorkThread workThread = new WorkThread();
            workThreads.add(workThread);
            workThread.start();
        }

    }

    public void execute(Runnable runnable) {
        queue.add(runnable);
    }

    public void shutDown() {
        this.shutDown = true;
    }

    public static void main(String[] args) {
        线程池实现 a = new 线程池实现(3);
        for (int i = 0;i < 100;i++) {
            a.execute(() -> System.out.println("当前执行线程：" + Thread.currentThread().getName()));
        }

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {

        }
    }

    private class WorkThread extends Thread {

        @Override
        public void run() {
            System.out.println("线程启动：" + Thread.currentThread().getName());
            while (!shutDown || !queue.isEmpty()) {
                Runnable poll = null;
                try {
                    poll = queue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                poll.run();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
            }
        }
    }
}
