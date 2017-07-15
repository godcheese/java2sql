package com.gioov.java2sql;

import java.util.LinkedHashMap;

/**
 * Created by godcheese on 2017/7/14.
 */
public class Seeder {

    private StringBuilder insertSql;
    private StringBuilder updateSql;
    private StringBuilder deleteSql;

    private String database;
    private String table;
    private String[] insertFields;

    public Seeder(String database) {
        insertSql = new StringBuilder();
        updateSql = new StringBuilder();
        deleteSql = new StringBuilder();
        this.database = database;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }


    public String[] getInsertFields() {
        return insertFields;
    }

    public void setInsertFields(String[] insertFields) {
        this.insertFields = insertFields;
    }

    public void insert(Object[] insertValues) {

        Integer insertFieldsLength = insertFields.length;
        Integer insertValuesLength = insertValues.length;

        if (insertFieldsLength > 0 && insertValuesLength > 0 && insertFieldsLength.equals(insertValuesLength)) {

            insertSql.append(" INSERT INTO ");
            insertSql.append(" `");
            insertSql.append(database);
            insertSql.append("`.`");
            insertSql.append(table);
            insertSql.append("` ");

            StringBuilder fields = new StringBuilder();
            StringBuilder values = new StringBuilder();
            fields.append("(");
            values.append(" VALUES(");

            for (String field : insertFields) {
                fields.append("`");
                fields.append(field);
                fields.append("`,");
            }


            Integer fieldsEndComma = fields.lastIndexOf(",");
            if (fieldsEndComma > -1) {
                fields.deleteCharAt(fieldsEndComma);
            }
            fields.append(")");

            for (Object value : insertValues) {

                if (value instanceof Integer) {
                    values.append(value);
                } else if (value instanceof Double) {

                    values.append(value);
                } else {
                    values.append("'");
                    values.append(value);
                    values.append("'");
                }
                values.append(",");
            }

            Integer valuesEndComma = values.lastIndexOf(",");
            if (valuesEndComma > -1) {
                values.deleteCharAt(valuesEndComma);
            }
            values.append(")");

            insertSql.append(fields);
            insertSql.append(values);
            insertSql.append(";");
        }
    }

    public void update(LinkedHashMap<String, Object> updateSets, LinkedHashMap<String, Object> updateWhere) {

    }


    public void update(LinkedHashMap<String, Object> updateSets) {

    }

    public void delete(LinkedHashMap<String, Object> deleteSets) {

    }


    public void execute() {

        System.out.println(insertSql);
        System.out.println(updateSql);
        System.out.println(deleteSql);

        insertSql = null;
        updateSql = null;
        deleteSql = null;
    }

}
