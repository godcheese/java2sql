package com.gioov.java2sql.adapter;

/**
 * Created by godcheese on 2017/7/15.
 */
public class MySqlAdapter extends DatabaseAdapter {

    private String user = "root";
    private String password = "";
    private String database = "test";
    private String host = "localhost";
    private Integer port = 3306;

    private String table = "NewTable";
    private String engine = "InnoDB";
    private String characterSet = "utf8mb4";
    private String collate = "utf8mb4_unicode_ci";
    private String rowFormat = "DYNAMIC";
    private Integer autoIncrement = null;
    private String[] escapeRules = {"//", "/'", "/\"", ""};
    private String[] unescapeRules = {"/", "'", "\"", "'"};

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getDatabase() {
        return database;
    }

    @Override
    public void setDatabase(String database) {
        this.database = database;
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public Integer getPort() {
        return port;
    }

    @Override
    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public String getTable() {
        return table;
    }

    @Override
    public void setTable(String table) {
        this.table = table;
    }

    @Override
    public String getEngine() {
        return engine;
    }

    @Override
    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public String getCharacterSet() {
        return characterSet;
    }

    @Override
    public void setCharacterSet(String characterSet) {
        this.characterSet = characterSet;
    }

    @Override
    public String getCollate() {
        return collate;
    }

    @Override
    public void setCollate(String collate) {
        this.collate = collate;
    }

    @Override
    public String getRowFormat() {
        return rowFormat;
    }

    @Override
    public void setRowFormat(String rowFormat) {
        this.rowFormat = rowFormat;
    }

    @Override
    public Integer getAutoIncrement() {
        return autoIncrement;
    }

    @Override
    public void setAutoIncrement(Integer autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    @Override
    public String[] getEscapeRules() {
        return escapeRules;
    }

    @Override
    public void setEscapeRules(String[] escapeRules) {
        this.escapeRules = escapeRules;
    }

    @Override
    public String[] getUnescapeRules() {
        return unescapeRules;
    }

    @Override
    public void setUnescapeRules(String[] unescapeRules) {
        this.unescapeRules = unescapeRules;
    }
}
