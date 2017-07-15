package com.gioov.java2sql;

import com.gioov.java2sql.migration.Field;

import java.util.*;

/**
 * Created by godcheese on 2017/7/14.
 */
public class Migration {

    private List <Object> tasks;
    private Object task;

    private String table="NewTable";
    private String engine="InnoDB";
    private String characterSet="utf8mb4";
    private String collate="utf8mb4_unicode_ci";
    private String rowFormat="DYNAMIC";
    private Integer autoIncrement=null;
    private StringBuilder sql;

    public String getRowFormat() {
        return rowFormat;
    }

    public void setRowFormat(String rowFormat) {
        this.rowFormat = rowFormat;
    }

    public Integer getAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(Integer autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    public StringBuilder getSql() {
        return sql;
    }

    public void setSql(StringBuilder sql) {
        this.sql = sql;
    }


    public Migration(){
        tasks= new ArrayList<>();
        sql=new StringBuilder();
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getCharacterSet() {
        return characterSet;
    }

    public void setCharacterSet(String characterSet) {
        this.characterSet = characterSet;
    }

    public String getCollate() {
        return collate;
    }

    public void setCollate(String collate) {
        this.collate = collate;
    }

    public List<Object> getTasks() {
        return tasks;
    }

    public void setTask(Object task){
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


                            if(isUnsigned){
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
                                sql.append(getCharacterSet());
                            } else {
                                sql.append(characterSet);
                            }
                            sql.append(" ");

                            // collate
                            sql.append(" COLLATE ");
                            if (collate == null) {
                                sql.append(getCollate());
                            } else {
                                sql.append(getCollate());
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

    public String execute(){
        toSql(tasks);
        sql.toString();
        sql.insert(0," ( ");
        sql.insert(0,"`");
        sql.insert(0,getTable());
        sql.insert(0,"`");
        sql.insert(0," CREATE TABLE ");


        sql.append(" ) ");
        sql.append(" ENGINE= ");
        sql.append(getEngine());

        if(getAutoIncrement()!=null){
            sql.append(" AUTO_INCREMENT = ");
            sql.append(getAutoIncrement());
            sql.append(" ");
        }

        if(getRowFormat()!=null){
            sql.append(" ROW_FORMAT = ");
            sql.append(getRowFormat());
            sql.append(" ");
        }

        sql.append(";");
        return sql.toString();
    }
}
