package com.lagou.work3_1;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SortNumMapper extends Mapper<LongWritable, Text, NumBean, NullWritable> {
    NumBean numBean = new NumBean();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 定义自定义Bean类，设置数值，对元素进行比较排序
        numBean.setNum(Integer.valueOf(value.toString()));
        context.write(numBean, NullWritable.get());
    }
}
