package com.lagou.work3_1;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NumBean implements WritableComparable<NumBean> {

    private Integer sort = 0;
    private Integer num;

    public NumBean() {
    }

    public NumBean(Integer sort, Integer num) {
        this.sort = sort;
        this.num = num;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public int compareTo(NumBean o) {
        // 与自身num进行对比升序排序
        return this.num.compareTo(o.getNum());
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(sort);
        dataOutput.writeInt(num);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        setSort(dataInput.readInt());
        setNum(dataInput.readInt());
    }

    @Override
    public String toString() {
        return sort + "\t" + num;
    }
}
