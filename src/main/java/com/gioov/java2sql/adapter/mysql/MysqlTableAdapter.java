package com.gioov.java2sql.adapter.mysql;

import com.gioov.java2sql.adapter.TableAdapter;

/**
 * Created by godcheese on 2017/7/15.
 */
public final class MysqlTableAdapter implements TableAdapter {

    private String name = "NewTable";
    private String characterSet = null;
    private String collate = null;
    private Boolean dropIfExists = true;
    private String rowFormat = null;
    private Integer autoIncrement = null;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCharacterSet() {
        return characterSet;
    }

    @Override
    public String getCollate() {
        return collate;
    }

    @Override
    public Boolean getDropIfExists() {
        return dropIfExists;
    }

    @Override
    public String getRowFormat() {
        return rowFormat;
    }

    @Override
    public Integer getAutoIncrement() {
        return autoIncrement;
    }

    @Override
    public MysqlTableAdapter setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public MysqlTableAdapter setCharacterSet(String characterSet) {
        this.characterSet = characterSet;
        return this;
    }

    @Override
    public MysqlTableAdapter setCollate(String collate) {
        this.collate = collate;
        return this;
    }

    @Override
    public MysqlTableAdapter setDropIfExists(Boolean dropIfExists) {
        this.dropIfExists = dropIfExists;
        return this;
    }

    @Override
    public MysqlTableAdapter setRowFormat(String rowFormat) {
        this.rowFormat = rowFormat;
        return this;
    }

    @Override
    public MysqlTableAdapter setAutoIncrement(Integer autoIncrement) {
        this.autoIncrement = autoIncrement;
        return this;
    }

}
