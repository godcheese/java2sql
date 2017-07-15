package com.gioov.java2sql;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by godcheese on 2017/7/15.
 */
public class SeederTest {


    @Test
    public void insertTest(){


        Seeder seeder=new Seeder("morse");



        seeder.setTable("test");


        List<LinkedHashMap<String,Object>> insertSets = new ArrayList<>();
        LinkedHashMap<String,Object> insertSet1 = new LinkedHashMap<>();
        insertSet1.put("id",1);
        insertSet1.put("name","测试");
        insertSets.add(insertSet1);

        LinkedHashMap<String,Object> insertSet2= new LinkedHashMap<>();
        insertSet2.put("id",2);
        insertSet2.put("name","测试2");
        insertSets.add(insertSet2);

        seeder.insert(insertSets);

        seeder.execute();


    }

}
