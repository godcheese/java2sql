package com.gioov.java2sql;

import org.junit.Test;

/**
 * Created by godcheese on 2017/7/15.
 */
public class SeederTest {


    @Test
    public void testInsert() {
        Seeder seeder = new Seeder("morse");
        seeder.setTable("test");
        String[] fields = {"id", "name", "price", "show"};
        seeder.setInsertFields(fields);
        Object[] value = {1, "测试", 10.20, true};
        seeder.insert(value);
        seeder.execute();
    }

}
