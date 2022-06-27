package com.lagou.work3_1;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class SortNumDrive {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();
        // 实例化job任务
        Job job = Job.getInstance(conf, "SortNumDrive");
        // 设置执行job类
        job.setJarByClass(SortNumDrive.class);
        // 配置MapperReducer执行类
        job.setMapperClass(SortNumMapper.class);
        job.setReducerClass(SortNumReduce.class);
        // 配置Mapper输出kv
        job.setMapOutputKeyClass(NumBean.class);
        job.setMapOutputValueClass(NullWritable.class);
        // 配置文件输出kv
        job.setOutputKeyClass(NumBean.class);
        job.setOutputValueClass(NumBean.class);
        // 配置Reduce任务数
        job.setNumReduceTasks(1);
        // 配置输入输出路径
        FileInputFormat.setInputPaths(job, new Path("src/input"));
        FileOutputFormat.setOutputPath(job, new Path("src/output"));
        // 执行任务
        boolean res = job.waitForCompletion(true);
        System.exit(res ? 0 : 1);
    }
}
