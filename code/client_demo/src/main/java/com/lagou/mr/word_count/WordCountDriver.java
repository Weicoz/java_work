package com.lagou.mr.word_count;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class WordCountDriver {

    Configuration conf = null;
    FileSystem fs = null;

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        WordCountDriver wordCountDriver = new WordCountDriver();
        wordCountDriver.init();



        wordCountDriver.close();
    }


    public void init() throws URISyntaxException, IOException, InterruptedException {
        Configuration conf = new Configuration();
        fs = FileSystem.get(new URI("hdfs://weinas.cf:49001"), conf, "root");
    }


    public void close() throws IOException {
        fs.close();
    }




}
