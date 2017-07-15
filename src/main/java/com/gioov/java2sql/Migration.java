package com.gioov.java2sql;

import com.gioov.java2sql.migration.Field;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by godcheese on 2017/7/14.
 */
public class Migration {

    private List<Object> tasks;
    private Object task;

    private DatabaseConfig databaseConfig;
    private StringBuilder sql;

    public StringBuilder getSql() {
        return sql;
    }

    public void setSql(StringBuilder sql) {
        this.sql = sql;
    }

    public Migration(DatabaseConfig databaseConfig) {
        tasks = new ArrayList<>();
        sql = new StringBuilder();
        this.databaseConfig = databaseConfig;
    }

    public List<Object> getTasks() {
        return tasks;
    }

    public void setTask(Object task) {
        tasks.add(task);
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

                if (task instanceof Field) {

                    String name = null;
                    String type = null;
                    Integer length = null;
                    Integer decimal = null;
                    boolean isNull = false;
                    boolean primaryKey = false;
                    String comment = null;
                    String defaultValue = null;
                    boolean autoIncrement = false;
                    boolean isUnsigned = false;
                    boolean isZerofill = false;
                    String characterSet = null;
                    String collate = null;

                    Field field = (Field) task;
                    name = field.getName();
                    type = field.getType() != null ? field.getType().toLowerCase() : null;
                    length = field.getLength();
                    autoIncrement = field.isAutoIncrement();
                    isNull = field.isNull();
                    primaryKey = field.isPrimaryKey();
                    defaultValue = field.getDefaultValue();
                    isUnsigned = field.isUnsigned();
                    isZerofill = field.isZerofill();
                    characterSet = field.getCharacterSet() != null ? field.getCharacterSet().toLowerCase() : null;
                    collate = field.getCollate() != null ? field.getCollate().toLowerCase() : null;
                    comment = field.getComment();
                    decimal = field.getDecimal();

                    sql.append(" `");
                    sql.append(name);
                    sql.append("`");
                    sql.append(" ");
                    sql.append(" ");
                    sql.append(type);
                    sql.append("(");
                    sql.append(length);
                    sql.append(")");


                    // zerofill 填充零
                    if (isZerofill) {
                        sql.append(" ZEROFILL ");
                    }


                    // default
                    if (defaultValue != null) {
                        sql.append(" DEFAULT ");
                        if (defaultValue.equals("null") || defaultValue.equals("NULL")) {
                            sql.append(defaultValue);
                        } else {
                            sql.append("'");
                            sql.append(defaultValue);
                            sql.append("'");
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
                                sql.append(autoIncrement ? " AUTO_INCREMENT " : "");
                            }

                        }

                    }

                    // 设置 encoding
                    for (String f : stringFields) {
                        if (f.toLowerCase().equals(type)) {

                            // character set
                            sql.append(" CHARACTER SET ");
                            if (characterSet == null) {
                                sql.append(databaseConfig.getAdapter().getCharacterSet());
                            } else {
                                sql.append(characterSet);
                            }
                            sql.append(" ");

                            // collate
                            sql.append(" COLLATE ");
                            if (collate != null) {
                                sql.append(collate);
                            } else {
                                sql.append(databaseConfig.getAdapter().getCollate());
                            }
                            sql.append(" ");
                        }
                    }

                    // not null
                    sql.append(!isNull ? " NOT NULL " : " NULL ");


                    // comment
                    if (comment != null) {
                        sql.append(" COMMENT ");
                        sql.append("'");
                        sql.append(comment);
                        sql.append("'");
                        sql.append(" ");
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
                    sql.append(" PRIMARY KEY ");
                    sql.append("(`");
                    sql.append(p);
                    sql.append("`)");
                    sql.append(",");
                }
            }
            Integer end = sql.lastIndexOf(",");
            sql.delete(end, end + 1);
        }
    }

    public String execute() {
        toSql(tasks);
        sql.toString();
        sql.insert(0, " ( ");
        sql.insert(0, "`");
        sql.insert(0, databaseConfig.getAdapter().getTable());
        sql.insert(0, "`");
        sql.insert(0, " CREATE TABLE ");


        sql.append(" ) ");
        sql.append(" ENGINE= ");
        sql.append(databaseConfig.getAdapter().getEngine());

        if (databaseConfig.getAdapter().getAutoIncrement() != null) {
            sql.append(" AUTO_INCREMENT = ");
            sql.append(databaseConfig.getAdapter().getAutoIncrement());
            sql.append(" ");
        }

        if (databaseConfig.getAdapter().getRowFormat() != null) {
            sql.append(" ROW_FORMAT = ");
            sql.append(databaseConfig.getAdapter().getRowFormat());
            sql.append(" ");
        }

        sql.append(";");
        return sql.toString();
    }
}
