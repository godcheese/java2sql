package com.gioov.java2sql;

import com.gioov.java2sql.adapter.DatabaseAdapter;
import com.gioov.java2sql.adapter.FieldAdapter;
import com.gioov.java2sql.adapter.mysql.MySqlAdapter;
import com.gioov.java2sql.adapter.mysql.MysqlFieldAdapter;
import com.gioov.java2sql.adapter.mysql.MysqlTableAdapter;

/**
 * Created by godcheese on 2017/7/16.
 */
public class TemplateMigration {

    public static void main(String[] arg){

        /**
         *
         *  Init database adapter
         *  Init table adapter
         *  Init migration
         *
          */

        DatabaseAdapter database=new MySqlAdapter();
        database.setName("test").setCharacterSet("utf8mb4").setCollate("utf8mb4_unicode_ci");
        MysqlTableAdapter table =new MysqlTableAdapter();
        table.setName("NewTable");
        Migration migration =new Migration(database,table);

        /**
         * Init field adapter and set properties
         * Field Name:id
         * Field Type:bigint
         * Field Length:20
         * Filed Primary Key:true
         * Filed Auto Increment:true
         * Field Null:false
         * Field Unsigned:false
         *
         */
        FieldAdapter idField=new MysqlFieldAdapter().setName("id").setType("bigint").setLength(20).setPrimaryKey(true).setAutoIncrement(true).setIsNull(false).setIsUnsigned(false);

        /**
         * Init field adapter and set properties
         * Field Name:name
         * Field Type:varchar
         * Field Length:50
         * Filed Null:false
         *
         */

        FieldAdapter nameField=new MysqlFieldAdapter().setName("name").setType("varchar").setLength(50).setIsNull(false);


        // Add database table fields
      String sql=  migration.addField(idField).addField(nameField).execute();

      System.out.println(sql);

        /**
         *
         *
         * Result Sql: DROP TABLE IF EXISTS `NewTable`;
         * CREATE TABLE `NewTable` (  `id`  bigint(20) NOT NULL ,
         * `name`  varchar(50) CHARACTER SET utf8mb4  COLLATE utf8mb4  NOT NULL ,
         * PRIMARY KEY (`id`) )
         * ENGINE= InnoDB;
         *
         */

    }
}
