package com.lagou.class1_4.work2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class InputTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bufferedWriter = null;
        ArrayList<String> list = new ArrayList<>();
        // 循环写入到数组中
        while (true) {
            System.out.println("请输入需要写入文件中的字符串，输入end为退出");
            String input = scanner.next();
            if (input.equals("end")) {
                break;
            }
            list.add(input);
        }
        if (list.size() > 0) {
            // 按字典对数组排序
            list.sort(Comparator.naturalOrder());
            // 倒序数组中排列
            Collections.reverse(list);
        }
        System.out.println(list);
        try {
            // 打开写入文件
            bufferedWriter = new BufferedWriter(new FileWriter("./abc.txt"));
            for (String item : list) {
                // 循环写入数组内容并换行
                bufferedWriter.write(item);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bufferedWriter) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
