package com.lagou.class1_3.work1;

public class Test {

    public static void main(String[] args) {
        System.out.println(toString(new int[]{1, 2, 3, 4, 5}));
        System.out.println(toString(null));
        System.out.println(toString(new int[]{}));
    }

    public static String toString(int[] arr) {
        if (null == arr) return "null";
        if (0 == arr.length) return "[]";
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (0 == i) {
                str.append("{").append(arr[i]);
            }else {
                str.append(",").append(arr[i]);
            }
            if ((i + 1) == arr.length) {
                str.append("}");
            }
        }
        return str.toString();
    }

}
