package com.gioov.java2sql;

import com.gioov.java2sql.adapter.DatabaseAdapter;
import com.gioov.java2sql.adapter.FieldAdapter;
import com.gioov.java2sql.adapter.TableAdapter;
import com.gioov.java2sql.adapter.mysql.MysqlFieldAdapter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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
    private DatabaseAdapter database;
    private TableAdapter table;

    private FileWriter fileWriter;

    public Migration(DatabaseAdapter databaseAdapter,TableAdapter tableAdapter) {
        fields = new ArrayList<>();
        sql = new StringBuilder();

        this.database = databaseAdapter;
        this.table = tableAdapter;

        File file=new File("");
        String fileName=file.getAbsolutePath()+System.getProperty("file.separator")+"Migration.sql";
        try {
            fileWriter= new FileWriter(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public StringBuilder getSql() {
        return sql;
    }

    public List<Object> getFields() {
        return fields;
    }

    public Migration addField(FieldAdapter field) {
        fields.add(field);
        return this;
    }

    public void toSql(List<Object> tasks) {

        Set<String> primaryKeys = new LinkedHashSet<>();

        List<String> numberFields = new ArrayList<>();
        numberFields.add("int");
        numberFields.add("bigint");

        Set<String> stringFields = new LinkedHashSet<>();
        stringFields.add("varchar");
        stringFields.add("char");
        stringFields.add("text");

        if (tasks.size() > 0) {
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
    }

    public String execute() {
        toSql(fields);
        sql.insert(0, " ( ")
                .insert(0, "`").insert(0, table.getName())
                .insert(0, "`").insert(0, " CREATE TABLE ");

        if(table.getDropIfExists()){

            sql.insert(0,";").insert(0,"`")
                    .insert(0,table.getName()).insert(0," DROP TABLE IF EXISTS `");
        }

        sql.append(" ) ").append(" ENGINE= ").append(database.getEngine());

        if (table.getAutoIncrement() != null) {
            sql.append(" AUTO_INCREMENT = ").append(table.getAutoIncrement()).append(" ");
        }

        if (table.getRowFormat() != null) {
            sql.append(" ROW_FORMAT = ").append(table.getRowFormat()).append(" ");
        }

        sql.append(";");

        String str=sql.toString();
        writeSqlToFile(str);

        return str;
    }

    private void writeSqlToFile(String sql){
        try {
            String s=sql+System.getProperty("line.separator");
            fileWriter.write(s);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void finalize(){
        sql.delete(0,sql.length());
        this.table=null;
        this.database=null;
        try {
            if(fileWriter!=null) {
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
