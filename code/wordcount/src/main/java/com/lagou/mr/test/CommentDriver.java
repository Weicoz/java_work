package com.lagou.mr.test;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.CombineTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class CommentDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        conf.set("mapreduce.task.io.sort.mb", "1");
        Job job = Job.getInstance(conf);
        job.setJarByClass(CommentDriver.class);

        job.setMapperClass(CommentMapper.class);
        job.setReducerClass(CommentReducer.class);

        job.setJobSetupCleanupNeeded(false);
        job.setMapOutputKeyClass(CommentBean.class);
        job.setMapOutputValueClass(NullWritable.class);
        job.setPartitionerClass(CommentPartioner.class);
//        job.setNumReduceTasks(3);
        job.setOutputKeyClass(CommentBean.class);
        job.setOutputValueClass(NullWritable.class);

        job.setInputFormatClass(CombineTextInputFormat.class);
//        job.setOutputFormatClass(CommentOutputFormat.class);
        //record压缩
//        SequenceFileOutputFormat.setOutputCompressorClass(job, CompressionCodec.class);
//        SequenceFileOutputFormat.setOutputCompressionType(job, SequenceFile.CompressionType.RECORD );
//        SequenceFileOutputFormat.setOutputCompressorClass(job, DefaultCodec.class);
        //block压缩
//        SequenceFileOutputFormat.setOutputCompressionType(job, SequenceFile.CompressionType.BLOCK );
//        SequenceFileOutputFormat.setOutputCompressorClass(job, DefaultCodec.class);
        FileSystem fs = FileSystem.get(conf);
        Path path = new Path("E:\\课程研发\\lagou大数据开发训练营\\课程优化\\讲义\\优化具体讲义\\data\\自定义outputformat\\out");
        boolean exists = fs.exists(path);
        if (exists) {
            fs.delete(path, true);
        }
        FileInputFormat.setInputPaths(job, new Path("E:\\课程研发\\lagou大数据开发训练营\\课程优化\\讲义\\优化具体讲义\\data\\自定义outputformat\\input"));
        FileOutputFormat.setOutputPath(job, new Path("E:\\课程研发\\lagou大数据开发训练营\\课程优化\\讲义\\优化具体讲义\\data\\自定义outputformat\\out"));

        final boolean flag = job.waitForCompletion(true);
        System.exit(flag ? 0 : 1);
    }
}

