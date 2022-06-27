package com.lagou.class1_4.work3;

public class TrainStation {

    private int ticket;

    public TrainStation(int ticket) {
        this.ticket = ticket;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    /**
     * 出票方法
     * @param tickCount 出票数量
     */
    public synchronized void outTicket(int tickCount) {
        while (tickCount > 0) {
            if (getTicket() > 0) {
                tickCount--;
                setTicket(getTicket() - 1);
                System.out.println("正在出票，剩余需要出票：" + tickCount + "，剩余总票数：" + getTicket() + " " + Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("票已售完，剩余需要出票：" + tickCount + "，剩余总票数：" + getTicket() + " " + Thread.currentThread().getName());
                break;
            }
        }
    }

    public static void main(String[] args) {
        TrainStation trainStation = new TrainStation(100);
        Thread t1 = new Thread(new RunnableTest(trainStation, 70));
        Thread t2 = new Thread(new RunnableTest(trainStation, 50));
        Thread t3 = new Thread(new RunnableTest(trainStation, 60));
        Thread t4 = new ThreadTest(trainStation, 5);
        Thread t5 = new ThreadTest(trainStation, 40);
        Thread t6 = new ThreadTest(trainStation, 60);
//        t1.start();
//        t2.start();
//        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }

}
