package com.gioov.java2sql;

import com.gioov.java2sql.adapter.MySqlAdapter;
import com.gioov.java2sql.migration.Field;
import org.junit.Test;

/**
 * Created by godcheese on 2017/7/14.
 */
public class MigrationTest {

    @Test
    public void executeTest() {

        DatabaseConfig databaseConfig = new DatabaseConfig();

        MySqlAdapter mySqlAdapter = new MySqlAdapter();

        databaseConfig.setAdapter(mySqlAdapter);

        Migration migration = new Migration(databaseConfig);
        Field field1 = new Field();
        field1.setName("id");
        field1.setType("int");

        field1.setLength(10);
        field1.setComment("主键描述");
        field1.setPrimaryKey(true);
        field1.setAutoIncrement(true);
        field1.setUnsigned(true);
        migration.setTask(field1);

        Field field2 = new Field();
        field2.setName("name");
        field2.setType("varchar");
        field2.setLength(10);
        field2.setComment("名字");
        field2.setUnsigned(true);
        migration.setTask(field2);

        String sql = migration.execute();
        System.out.println(sql);
    }
}
