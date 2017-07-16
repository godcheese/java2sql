package com.gioov.java2sql;

import com.gioov.java2sql.adapter.DatabaseAdapter;
import com.gioov.java2sql.adapter.TableAdapter;
import com.gioov.java2sql.adapter.mysql.MySqlAdapter;
import com.gioov.java2sql.adapter.mysql.MysqlFieldAdapter;
import com.gioov.java2sql.adapter.mysql.MysqlTableAdapter;
import org.junit.Test;

/**
 * Created by godcheese on 2017/7/14.
 */
public class MigrationTest {

    @Test
    public void testExecute() {

        DatabaseAdapter databaseAdapter = new MySqlAdapter();
        databaseAdapter.setName("morse");

        TableAdapter tableAdapter=new MysqlTableAdapter();

        Migration migration = new Migration(databaseAdapter,tableAdapter);
        MysqlFieldAdapter field11 = new MysqlFieldAdapter();
        field11.setName("id").setType("int").setLength(10).setComment("主键描述").setPrimaryKey(true).setAutoIncrement(true).setIsUnsigned(true);

        MysqlFieldAdapter field12 = new MysqlFieldAdapter();
        field12.setName("name").setType("varchar").setLength(10).setComment("名字").setIsUnsigned(true);

        String sql= migration.addField(field11).addField(field12).execute();
        System.out.println(sql);

        TableAdapter tableAdapter2=new MysqlTableAdapter();
        tableAdapter2.setName("table2");
        Migration migration2 = new Migration(databaseAdapter,tableAdapter2);
        MysqlFieldAdapter field21 = new MysqlFieldAdapter();
        field21.setName("id").setType("int").setLength(10).setComment("主键描述").setPrimaryKey(true).setAutoIncrement(true).setIsUnsigned(true);

        MysqlFieldAdapter field22 = new MysqlFieldAdapter();
        field22.setName("name").setType("varchar").setLength(10).setComment("名字").setIsUnsigned(true);
        String sql2= migration2.addField(field21).addField(field22).execute();
        System.out.println(sql2);

//        String user=databaseAdapter.getUser();
//        String password=databaseAdapter.getPassword();
//        String name=databaseAdapter.getName();
//        String host=databaseAdapter.getHost();
//        Integer port=databaseAdapter.getPort();
//
//        String uri="jdbc:mysql://"+host+":"+port+"/"+name;
//        String driverClass="com.mysql.jdbc.Driver";
//        Connection connection=null;
//        Statement statement=null;
//        try {
//            Class.forName(driverClass);
//            connection= DriverManager.getConnection(uri,user,password);
//            statement=connection.createStatement();
//            statement.executeUpdate(sql);
//            System.out.println(connection);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                if (connection != null) {
//                    connection.close();
//                }
//                if(statement!=null) {
//                    statement.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//
//            }
//        }



    }
}
