package com.gioov.java2sql.adapter;

/**
 * Created by godcheese on 2017/7/15.
 */
public interface TableAdapter {

    /**
     String name="NewTable";
     String characterSet=null;
     String collate=null;
     Boolean dropIfExists=true;
     String rowFormat=null;
     Integer autoIncrement=null;
     */

    String getName();
    String getCharacterSet();
    String getCollate();
    Boolean getDropIfExists();
    String getRowFormat();
    Integer getAutoIncrement();

    TableAdapter setName(String name);
    TableAdapter setCharacterSet(String name);
    TableAdapter setCollate(String name);
    TableAdapter setDropIfExists(Boolean dropIfExists);
    TableAdapter setRowFormat(String rowFormat);
    TableAdapter setAutoIncrement(Integer autoIncrement);
}
