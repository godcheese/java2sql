package com.gioov.java2sql;

import com.gioov.java2sql.adapter.DatabaseAdapter;
import com.gioov.java2sql.adapter.mysql.MysqlAdapter;
import com.gioov.java2sql.adapter.mysql.MysqlTableAdapter;

/**
 * Created by godcheese on 2017/7/16.
 */
public class TestMigration {

    public static void main(String[] arg) {

        /**
         * //////////////////////////////////////////////////////////////
         *
         * Demo
         *
         * A field
         * FieldAdapter idField=new MysqlFieldAdapter()
         * .setName("id").setType("bigint").setLength(20)
         * .setPrimaryKey(true).setAutoIncrement(true)
         * .setIsNull(false).setIsUnsigned(false);
         *
         * Add database table fields
         * ArrayList<String> sqlBatches = migration.addField(idField)
         * .addField(nameField).addField(emailField).execute();
         *
         * for(String batch : sqlBatches){
         *   System.out.println(batch);
         * }
         *
         * -- Result sql
         * DROP TABLE IF EXISTS `test`;
         * CREATE TABLE `test` (  `id`  bigint(20) NOT NULL ,
         * PRIMARY KEY (`id`) )
         * ENGINE= InnoDB;
         *
         * //////////////////////////////////////////////////////////////
         *
         */


        DatabaseAdapter database = new MysqlAdapter();
        database.setName("testDatabase");
        MysqlTableAdapter table = new MysqlTableAdapter();
        table.setName("test");
        Migration migration = new Migration(database, table);

        // migration.addField(Filed field);


    }
}
