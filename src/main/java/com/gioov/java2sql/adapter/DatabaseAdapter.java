package com.gioov.java2sql.adapter;

/**
 * Created by godcheese on 2017/7/15.
 */
public class DatabaseAdapter {

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


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
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

    public String[] getEscapeRules() {
        return escapeRules;
    }

    public void setEscapeRules(String[] escapeRules) {
        this.escapeRules = escapeRules;
    }

    public String[] getUnescapeRules() {
        return unescapeRules;
    }

    public void setUnescapeRules(String[] unescapeRules) {
        this.unescapeRules = unescapeRules;
    }
}
