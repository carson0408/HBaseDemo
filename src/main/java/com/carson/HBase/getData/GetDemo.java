package com.carson.HBase.getData;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;

import java.io.IOException;

/**
 * 该类用于获取数据
 */
public class GetDemo {

    public static void getData(String tableName,String row,String columnFamily,String column) throws IOException {
        Configuration cfg = HBaseConfiguration.create();
        HTable table = new HTable(cfg,tableName);
        //根据行键建立Get对象
        Get get = new Get(row.getBytes());
        //通过get对象获取Result对象，Result对象表示一行的记录
        Result result = table.get(get);
        //再通过列族和列来确定单元格的数据。
        System.out.println(new String(result.getValue(columnFamily.getBytes(),column==null?null:column.getBytes())));
    }
}
