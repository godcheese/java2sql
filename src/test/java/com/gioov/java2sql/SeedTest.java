package com.gioov.java2sql;

import com.gioov.java2sql.adapter.DatabaseAdapter;
import com.gioov.java2sql.adapter.mysql.MysqlAdapter;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by godcheese on 2017/7/15.
 */
public class SeedTest {


    @Test
    public void testSeed(String[] args) {

        // Init DatabaseAdapter
        DatabaseAdapter database = new MysqlAdapter();
        database.setName("test");

        // Set insert fields
        String[] insertFields = {"id", "name", "email"};
        Seed seed = new Seed(database, "test", insertFields); // Init seed processor,it cloud not  insertFields that when you need not INSERT.

        Object[] insert1 = {1, "jack", "godcheese@qq.com"}; // Insert a record
        Object[] insert2 = {2, "tom", "1176394803@qq.com"}; // Insert a record

        // Execute insert
        ArrayList<String> sqlBatches = seed.insert(insert1).insert(insert2).execute();

        // Foreach every batch sql
        for (String batch : sqlBatches) {
            System.out.println(batch);
        }

        /**
         *
         * -- Result sql
         * INSERT INTO  `test`.`test` (`id`,`name`,`email`) VALUES(1,'jack','godcheese@qq.com');
         * INSERT INTO  `test`.`test` (`id`,`name`,`email`) VALUES(2,'tom','1176394803@qq.com');
         *
         */
    }
}
