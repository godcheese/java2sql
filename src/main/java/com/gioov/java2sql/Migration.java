package com.gioov.java2sql;

import com.gioov.java2sql.adapter.DatabaseAdapter;
import com.gioov.java2sql.adapter.FieldAdapter;
import com.gioov.java2sql.adapter.TableAdapter;
import com.gioov.java2sql.adapter.mysql.MysqlAdapter;
import com.gioov.java2sql.adapter.mysql.MysqlFieldAdapter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by godcheese on 2017/7/14.
 */
public final class Migration {

    private List<Object> fields;

    private StringBuilder sql;
    private StringBuilder dropIfExistsSql;
    private ArrayList<String> batches;
    private DatabaseAdapter database;
    private TableAdapter table;

    private FileWriter fileWriter;

    /**
     *
     * @param databaseAdapter DatabaseAdapter
     * @param tableAdapter TableAdapter
     */
    public Migration(DatabaseAdapter databaseAdapter,TableAdapter tableAdapter) {
        fields = new ArrayList<>();
        sql = new StringBuilder();
        dropIfExistsSql = new StringBuilder();
        this.database = databaseAdapter;
        this.table = tableAdapter;
        this.batches=new ArrayList<>();
    }

    public StringBuilder getSql() {
        return sql;
    }

    public List<Object> getFields() {
        return fields;
    }

    /**
     *
     * @param field FieldAdapter
     * @return Migration
     */
    public Migration addField(FieldAdapter field) {
        fields.add(field);
        return this;
    }

    public void processFields(List<Object> tasks) {

        Set<String> primaryKeys = new LinkedHashSet<>();

        List<String> numberFields = new ArrayList<>();
        numberFields.add("int");
        numberFields.add("bigint");

        Set<String> stringFields = new LinkedHashSet<>();
        stringFields.add("varchar");
        stringFields.add("char");
        stringFields.add("text");

        if (tasks.size() > 0) {

            if(table.getDropIfExists()){
                dropIfExistsSql.append(" DROP TABLE IF EXISTS `").append(table.getName()).append("`;");
                this.batches.add(dropIfExistsSql.toString());
                dropIfExistsSql=null;
            }


            sql.append(" CREATE TABLE ")
                    .append("`").append( table.getName()).append( "`")
                    .append( " ( ");

            for (Object task : tasks) {

                if (task instanceof MysqlFieldAdapter) {

                    String name = null;
                    String type = null;
                    Integer length = null;
                    Integer decimal = null;
                    String isNull;
                    Boolean primaryKey = false;
                    String comment = null;
                    String defaultValue = null;
                    String autoIncrement;
                    Boolean isUnsigned = false;
                    String isZerofill;
                    String characterSet = null;
                    String collate = null;

                    FieldAdapter field = (MysqlFieldAdapter) task;

                    name = field.getName();
                    type = field.getType() != null ? field.getType().toLowerCase() : null;
                    length = field.getLength();
                    autoIncrement = field.getAutoIncrement() ? "" : " AUTO_INCREMENT ";
                    isNull = field.getIsNull() && !field.getAutoIncrement() ? " NULL " : " NOT NULL ";
                    primaryKey = field.getPrimaryKey();
                    defaultValue = field.getDefaultValue();
                    isUnsigned = field.getIsUnsigned();
                    isZerofill = field.getZerofill() ? " ZEROFILL " : "";
                    characterSet = field.getCharacterSet() != null ? field.getCharacterSet().toLowerCase() : database.getCharacterSet().toLowerCase();
                    collate = field.getCollate() != null ? field.getCollate().toLowerCase() : database.getCollate().toLowerCase();
                    comment = field.getComment();
                    decimal = field.getDecimal();


                    sql.append(" `")
                            .append(name)
                            .append("`")
                            .append(" ")
                            .append(type)
                            .append("(")
                            .append(length)
                            .append(")");

                    // zerofill 填充零
                    sql.append(isZerofill);

                    // default
                    if (defaultValue != null) {
                        sql.append(" DEFAULT ");
                        if (defaultValue.toLowerCase().equals("null")) {
                            sql.append(defaultValue);
                        } else {
                            sql.append("'").append(defaultValue).append("'");
                        }
                        sql.append(" ");
                    }

                    // auto increment
                    for (String f : numberFields) {

                        if (f.toLowerCase().equals(type)) {
                            if (isUnsigned) {
                                sql.append(" UNSIGNED ");
                            }

                            if (primaryKey) {
                                sql.append(autoIncrement);
                            }

                        }

                    }

                    // 设置 encoding
                    for (String f : stringFields) {
                        if (f.toLowerCase().equals(type)) {

                            // character set
                            sql.append(" CHARACTER SET ").append(characterSet).append(" ");

                            // collate
                            sql.append(" COLLATE ").append(collate).append(" ");

                        }
                    }

                    // not null
                    sql.append(isNull);

                    // comment
                    if (comment != null) {
                        sql.append(" COMMENT ").append("'").append(comment).append("' ");
                    }

                    if (primaryKey) {
                        primaryKeys.add(name);
                    }
                }

                sql.append(",");
            }


            // 设置 primary key
            if (primaryKeys.size() > 0) {
                for (String p : primaryKeys) {
                    sql.append(" PRIMARY KEY ").append("(`").append(p).append("`)").append(",");
                }
            }


            // 删除sql语句最后一个逗号，防止sql语句报错
            Integer end = sql.lastIndexOf(",");
            sql.delete(end, end + 1);

        }

        sql.append(" ) ").append(" ENGINE= ").append(database.getEngine());

        if (table.getAutoIncrement() != null) {
            sql.append(" AUTO_INCREMENT = ").append(table.getAutoIncrement()).append(" ");
        }

        if (table.getRowFormat() != null) {
            sql.append(" ROW_FORMAT = ").append(table.getRowFormat()).append(" ");
        }
        sql.append(";");
        batches.add(sql.toString());
        sql=new StringBuilder();
    }

    /**
     *
     * @return String
     */
    public ArrayList<String> execute() {
        processFields(fields);
        ArrayList<String> arrayList=new ArrayList<>();

        if(database instanceof MysqlAdapter){
            arrayList=database.executeSqlBatches(batches);
        }

        return arrayList;
    }

}
