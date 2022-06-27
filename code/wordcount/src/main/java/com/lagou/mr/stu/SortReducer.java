package com.lagou.mr.stu;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class SortReducer extends Reducer<IntWritable, IntWritable,IntWritable, IntWritable> {
    int i = 0;
    Text k = new Text();
    private static IntWritable linenumber = new IntWritable(1);
    @Override
    protected void reduce(IntWritable key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
//        for (IntWritable value : values) {
//            i++;
//            String s = i + "\t" + key.toString();
//            k.set(s);
//            context.write(k, new IntWritable());
//        }

        for (IntWritable value : values) {
            context.write(linenumber, key);
            linenumber.set(linenumber.get() + 1);
            // linenumber=new IntWritable(linenumber.get()+1);
        }
    }
}
