package com.lagou.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HdfsClient {
    FileSystem fs = null;
    Configuration configuration = null;

    @Before
    public void init () throws URISyntaxException, IOException, InterruptedException {
        // 配置在集群上运行
        configuration = new Configuration();
        fs = FileSystem.get(new URI("hdfs://weinas.cf:49001"), configuration, "root");
    }

    @After
    public void destroy() throws IOException {
        // 3 关闭资源
        fs.close();
    }

    @Test
    public void testMkdirs() throws IOException {
        fs.mkdirs(new Path("/test"));
    }

}
