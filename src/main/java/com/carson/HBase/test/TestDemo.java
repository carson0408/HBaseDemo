package com.carson.HBase.test;

import com.carson.HBase.create.CreateDemo;
import com.carson.HBase.deleteData.DeleteDemo;
import com.carson.HBase.getData.GetDemo;
import com.carson.HBase.insertData.InsertDemo;

import java.io.IOException;

public class TestDemo {

    public static void main(String[] args) throws IOException {
/**
        //先创建一个scores的表，列族有info，score
        String[] columnFamily = {"info","score"};
        String tableName = "scores";
        CreateDemo.create(tableName,columnFamily);


        //插入数据
        //插入Carson的信息和成绩
        InsertDemo.insertData("scores","Carson","info","Id","10101");
        InsertDemo.insertData("scores","Carson","info","grade","4");
        InsertDemo.insertData("scores","Carson","score","Math","97");
        InsertDemo.insertData("scores","Carson","score","Chinese","90");
        InsertDemo.insertData("scores","Carson","score","English","80");
        //插入Amy的信息和成绩
        InsertDemo.insertData("scores","Amy","info","Id","10102");
        InsertDemo.insertData("scores","Amy","info","grade","3");
        InsertDemo.insertData("scores","Amy","score","Math","90");
        InsertDemo.insertData("scores","Amy","score","Chinese","70");
        InsertDemo.insertData("scores","Amy","score","English","89");
        //Bob
        InsertDemo.insertData("scores","Bob","info","Id","10103");
        InsertDemo.insertData("scores","Bob","info","grade","5");
        InsertDemo.insertData("scores","Bob","score","Math","95");
        InsertDemo.insertData("scores","Bob","score","Chinese","99");
        InsertDemo.insertData("scores","Bob","score","English","86");
        //Jason
        InsertDemo.insertData("scores","Jason","info","Id","10104");
        InsertDemo.insertData("scores","Jason","info","grade","3");
        InsertDemo.insertData("scores","Jason","score","Math","88");
        InsertDemo.insertData("scores","Jason","score","Chinese","93");
        InsertDemo.insertData("scores","Jason","score","English","95");

**/

        //查询数据,查询Carson的语文成绩
        String tableName = "scores";
        String row = "Carson";
        String columnFamily = "score";
        String column = "Chinese";

        //GetDemo.getData(tableName,row,columnFamily,column);

        //删除数据Carson的info列族中的grade
        DeleteDemo.deleteData(tableName,row,"info","grade");


    }
}
