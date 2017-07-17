package com.gioov.java2sql;

/**
 * Created by godcheese on 2017/7/14.
 */
public class MigrationTest {


//    @Test
//    public void testMigration() {
//
//        /**
//         *
//         *  Init database adapter
//         *  Init table adapter
//         *  Init migration
//         *
//         */
//
//        DatabaseAdapter database = new MysqlAdapter();
//        database.setName("test");
//        MysqlTableAdapter table = new MysqlTableAdapter();
//        table.setName("test");
//        Migration migration = new Migration(database, table);
//
//        /**
//         * Init field adapter and set properties
//         * Field Name:id
//         * Field Type:bigint
//         * Field Length:20
//         * Filed Primary Key:true
//         * Filed Auto Increment:true
//         * Field Null:false
//         * Field Unsigned:false
//         *
//         */
//        FieldAdapter idField = new MysqlFieldAdapter().setName("id").setType("bigint").setLength(20).setPrimaryKey(true).setAutoIncrement(true).setIsNull(false).setIsUnsigned(false);
//
//        /**
//         * Init field adapter and set properties
//         * Field Name:name
//         * Field Type:varchar
//         * Field Length:50
//         * Filed Null:false
//         *
//         */
//
//        FieldAdapter nameField = new MysqlFieldAdapter().setName("name").setType("varchar").setLength(50).setIsNull(false);
//
//        /**
//         * Init field adapter and set properties
//         * Field Name:email
//         * Field Type:varchar
//         * Field Length:50
//         * Filed Null:false
//         *
//         */
//        FieldAdapter emailField = new MysqlFieldAdapter().setName("email").setType("varchar").setLength(50).setIsNull(false);
//
//        // Add database table fields
//        ArrayList<String> sqlBatches = migration.addField(idField).addField(nameField).addField(emailField).execute();
//
//        for (String batch : sqlBatches) {
//            System.out.println(batch);
//        }
//
//        /**
//         *
//         * -- Result sql
//         * DROP TABLE IF EXISTS `test`;
//         * CREATE TABLE `test` (  `id`  bigint(20) NOT NULL ,
//         * `name`  varchar(50) CHARACTER SET utf8mb4  COLLATE utf8mb4_unicode_ci  NOT NULL ,
//         * `email`  varchar(50) CHARACTER SET utf8mb4  COLLATE utf8mb4_unicode_ci  NOT NULL ,
//         * PRIMARY KEY (`id`) )
//         * ENGINE= InnoDB;
//         *
//         */
//
//    }
}
