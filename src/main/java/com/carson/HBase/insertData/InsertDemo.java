package com.carson.HBase.insertData;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;

import java.io.IOException;

public class InsertDemo {

    /**
     *
     * @param tableName
     * @param row
     * @param columnFamily
     * @param column
     * @param data
     * @throws IOException
     */
    public static void insertData(String tableName,String row,String columnFamily,String column,String data) throws IOException {
        Configuration cfg = HBaseConfiguration.create();
        //HTable对象用于与HBase进行通信。
        HTable table = new HTable(cfg,tableName);
        //通过Put对象为已存在的表添加数据
        Put put = new Put(row.getBytes());
        if(column==null)//判断列限定符是否为空，如果为空，则直接添加列数据
            put.add(columnFamily.getBytes(),null,data.getBytes());
        else
            put.add(columnFamily.getBytes(),column.getBytes(),data.getBytes());
        //table对象的put输入参数是put对象，而put对象则表示每一单元格数据。
        table.put(put);


    }
}
