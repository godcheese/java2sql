package com.gioov.java2sql;

import com.gioov.java2sql.adapter.DatabaseAdapter;
import com.gioov.java2sql.adapter.mysql.MysqlAdapter;

import java.util.ArrayList;

/**
 * Created by godcheese on 2017/7/14.
 */
public class Seed {

    private StringBuilder insertSql;

    private String table;
    private String[] insertFields;
    private DatabaseAdapter database;

    private ArrayList<String> batches;

    /**
     * @param databaseAdapter DatabaseAdapter
     * @param table           String
     * @param insertFields    String[]
     */
    public Seed(DatabaseAdapter databaseAdapter, String table, String[] insertFields) {
        insertSql = new StringBuilder();
        this.database = databaseAdapter;
        this.table = table;
        this.insertFields = insertFields;
        this.batches = new ArrayList<>();
    }

    /**
     * @param databaseAdapter DatabaseAdapter
     * @param table           String
     */
    public Seed(DatabaseAdapter databaseAdapter, String table) {
        insertSql = new StringBuilder();
        this.database = databaseAdapter;
        this.table = table;
        this.batches = new ArrayList<>();
    }

    /**
     * @return String[]
     */
    public String[] getInsertFields() {
        return insertFields;
    }

    /**
     * @param insertFields String[]
     */
    public void setInsertFields(String[] insertFields) {
        this.insertFields = insertFields;
    }

    public Seed insert(Object[] insertValues) {

        Integer insertFieldsLength = insertFields.length;
        Integer insertValuesLength = insertValues.length;

        if (insertFieldsLength > 0 && insertValuesLength > 0 && insertFieldsLength.equals(insertValuesLength)) {

            insertSql.append(" INSERT INTO ").append(" `")
                    .append(database.getName()).append("`.`").append(table).append("` ");

            StringBuilder fields = new StringBuilder();
            StringBuilder values = new StringBuilder();
            fields.append("(");
            values.append(" VALUES(");

            for (String field : insertFields) {
                fields.append("`").append(field).append("`,");
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
                    values.append("'").append(value).append("'");
                }
                values.append(",");
            }

            Integer valuesEndComma = values.lastIndexOf(",");
            if (valuesEndComma > -1) {
                values.deleteCharAt(valuesEndComma);
            }
            values.append(")");

            insertSql.append(fields).append(values).append(";");

            batches.add(insertSql.toString());
            insertSql = new StringBuilder();
        }
        return this;
    }

//    private Seed update(LinkedHashMap<String, Object> updateSets, LinkedHashMap<String, Object> updateWhere) {
//
//        return this;
//    }
//
//    private Seed update(LinkedHashMap<String, Object> updateSets) {
//
//        return this;
//    }
//
//    private Seed delete(LinkedHashMap<String, Object> deleteSets) {
//
//        return this;
//    }

    /**
     * @return String
     */
    public ArrayList<String> execute() {
        ArrayList<String> arrayList = new ArrayList<>();

        if (database instanceof MysqlAdapter) {
            arrayList = database.executeSqlBatches(batches);
        }

        return arrayList;
    }

}
