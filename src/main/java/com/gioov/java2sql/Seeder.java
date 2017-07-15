package com.gioov.java2sql;

import com.gioov.java2sql.seeder.SeederInsert;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by godcheese on 2017/7/14.
 */
public class Seeder {

    private StringBuilder insertSql;
    private StringBuilder updateSql;
    private StringBuilder deleteSql;

    private String database;
    private String table;


    public Seeder(String database){

        insertSql=new StringBuilder();
        updateSql=new StringBuilder();
        deleteSql=new StringBuilder();

        this.database=database;


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

    public void insert(List<LinkedHashMap<String,Object>> insertSets){

        insertSql.append(" INSERT INTO ");
        insertSql.append(" `");
        insertSql.append(database);
        insertSql.append("`.`");
        insertSql.append(table);
        insertSql.append("` ");
        StringBuilder fields=new StringBuilder();
        StringBuilder values=new StringBuilder();
        fields.append("(");
        values.append(" VALUES(");

        for (LinkedHashMap<String,Object> insertSet :insertSets) {
            for (Map.Entry<String, Object> set : insertSet.entrySet()) {
                fields.append("`");
                fields.append(set.getKey());
                fields.append("`,");
                Object object = set.getValue();
                if (object instanceof String) {
                    values.append("'");
                    values.append(object);
                    values.append("',");
                }

                if (object instanceof Integer) {
                    values.append(object);
                    values.append(",");
                }
            }

            Integer fieldsEndComma=fields.lastIndexOf(",");
            if(fieldsEndComma>-1) {
                fields.deleteCharAt(fieldsEndComma);
            }
            fields.append(")");

            Integer valuesEndComma=values.lastIndexOf(",");
            if(valuesEndComma>-1) {
                System.out.println(valuesEndComma);
                values.deleteCharAt(valuesEndComma);
            }
            values.append(")");
        }

        insertSql.append(fields);
        insertSql.append(values);
        insertSql.append(";");
    }


    public void update(LinkedHashMap<String,Object> updateSets,LinkedHashMap<String,Object> updateWhere){



    }
    public void update(LinkedHashMap<String,Object> updateSets){

    }

    public void delete(LinkedHashMap <String,Object> deleteSets){

    }


    public void execute(){

        System.out.println(insertSql);
        System.out.println(updateSql);
        System.out.println(deleteSql);

        insertSql=null;
        updateSql=null;
        deleteSql=null;
    }

}
