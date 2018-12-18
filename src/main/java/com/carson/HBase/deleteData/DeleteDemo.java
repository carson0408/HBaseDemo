package com.carson.HBase.deleteData;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.HTable;

import java.io.IOException;

/**
 * 用于删除单元格数据
 */
public class DeleteDemo {

    public static void deleteData(String tableName,String row,String columnFamily,String column) throws IOException {
        Configuration cfg = HBaseConfiguration.create();
        HTable table = new HTable(cfg,tableName);
        Delete delete = new Delete(row.getBytes());
        //delete.deleteFamily(columnFamily.getBytes());
        delete.deleteColumn(columnFamily.getBytes(),column.getBytes());
        table.delete(delete);
    }
}
