package com.lagou.work3_1;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class SortNumReduce extends Reducer<NumBean, NullWritable, NumBean, NullWritable> {

    private Integer sort = 1;

    @Override
    protected void reduce(NumBean key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        // 防止相同值覆盖，对values进行遍历
        for (NullWritable value : values) {
            key.setSort(sort++);    // 根据升序排序，对值进行排名
            context.write(key, value);
        }
    }
}
