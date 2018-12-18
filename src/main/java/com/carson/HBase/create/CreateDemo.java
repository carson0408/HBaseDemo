package com.carson.HBase.create;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;

import java.io.IOException;

/**
 * @author carson0408
 * 该类主要用于建表，涉及到配置的读取，以及建表
 */
public class CreateDemo {
    /**
     * 创建表
     * @param tableName
     * @param columnFamily
     * @throws IOException
     */
    public static void create(String tableName,String[] columnFamily) throws IOException {
        //利用HBaseConfiguration的静态方法create()，生成Configuration对象
        Configuration cfg =  HBaseConfiguration.create();
        //利用Configuration对象生成HBaseAdmin对象，主要用于管理HBase数据库的表信息，包括创建或删除表
        HBaseAdmin admin = new HBaseAdmin(cfg);

        //创建表，根据数据库的建表习惯，都是先判断表是否存在，如果存在先删除后建表,但是HBase中删除表之前需要使表先无效再删除
        if(admin.tableExists(tableName)){
            admin.disableTable(tableName);
            admin.deleteTable(tableName);
        }

        //创建表，HBaseAdmin对象的createTable(HTableDescriptor desc)方法创建表，输入参数是HTableDescriptor对象
        //HTableDescriptor对象则是包含了HBase中表格的详细信息，通过tableName作为参数建立对象，并将列族添加进去。
        //添加列族时通过HTableDescriptor对象的addFamily(HColumnDescriptor hcd)添加的
        //HColumnDescriptor对象则是以列族名作为参数创建的。
        HTableDescriptor htd = new HTableDescriptor(tableName);
        for(String column:columnFamily){
            htd.addFamily(new HColumnDescriptor(column));
        }
        admin.createTable(htd);
    }
}
