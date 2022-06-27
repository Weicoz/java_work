package com.lagou.class1_4.work3;

public class RunnableTest implements Runnable{

    private TrainStation trainStation;
    private int tickCount;

    public RunnableTest(TrainStation trainStation, int tickCount) {
        this.trainStation = trainStation;
        this.tickCount = tickCount;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 线程开启");
        trainStation.outTicket(tickCount);
    }

}
