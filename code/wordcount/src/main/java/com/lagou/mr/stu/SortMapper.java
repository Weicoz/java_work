package com.lagou.mr.stu;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;
import java.math.BigInteger;

public class SortMapper extends Mapper<LongWritable, Text, IntWritable, IntWritable> {
    IntWritable data = new IntWritable();
    IntWritable one = new IntWritable(1);
    int num;
    @Override
    protected void map(LongWritable key,Text value,Context context) throws IOException, InterruptedException {
//        while(num>0) {
//            int num = Integer.parseInt(value.toString());
//            n.set(num);
//            try {
//                context.write(n, m);
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        String line = value.toString();
        data.set(Integer.parseInt(line.trim()));
        context.write(data, one);

    }


}
