package search;

import java.time.LocalDateTime;
import java.util.TimerTask;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-22 15:36
 **/
public class Inter {
    static class Task extends TimerTask {
        @Override
        public void run() {
            System.out.println("Short time task: " + LocalDateTime.now());
            throw new RuntimeException("异常啦！");
        }
    }

    static class LongRunningTask extends TimerTask {
        @Override
        public void run() {
            try {
                System.out.println("Long time task： " + LocalDateTime.now());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    static class MySync {
        private Object lock = new Object();

        public void syncWait() {
            synchronized (lock) {
                System.out.println("同步代码块");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("被唤醒！");
        }

        public void syncNotify() {
            synchronized (lock) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("唤醒...");
                lock.notifyAll();
            }
        }

    }


    public static void main(String[] args) {
//        Timer timer = new Timer();
//        timer.schedule(new LongRunningTask(), 10, 3000);
//        //timer.schedule(new Task(), 10, 5000);
//        timer.scheduleAtFixedRate(new Task(), 10, 1000);

//        ScheduledThreadPoolExecutor timerExecutor = new ScheduledThreadPoolExecutor(1);
//        timerExecutor.scheduleWithFixedDelay(new LongRunningTask(), 10, 3000, TimeUnit.MILLISECONDS);
//        timerExecutor.scheduleAtFixedRate(new Task(), 10, 1000, TimeUnit.MILLISECONDS);
        MySync mySync = new MySync();
        new Thread(() -> mySync.syncWait()).start();

        new Thread(() -> mySync.syncNotify()).start();


    }

}
