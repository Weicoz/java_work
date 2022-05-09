package com.lagou.class1_3.work2;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<Worker> list = new ArrayList<>();
        list.add(new Worker("刘德华", 40, 30000));
        list.add(new Worker("欧阳峰", 60, 8000));
        list.add(new Worker("凤姐", 18, 20000));
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).getName().equals("欧阳峰")) {
                list.add(i, new Worker("张柏芝", 35, 3300));
                break;
            }
        }
        for (int i = 0; i < size; i++) {
            if (list.get(i).getName().equals("刘德华")) {
                list.remove(list.get(i));
                break;
            }
        }
        for (Worker v:list) {
            System.out.println(v);
            v.work();
        }
    }

}
