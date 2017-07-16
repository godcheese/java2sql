package com.gioov.java2sql.adapter.mysql;

import com.gioov.java2sql.adapter.DatabaseAdapter;

/**
 * Created by godcheese on 2017/7/15.
 */
public final class MySqlAdapter implements DatabaseAdapter {


    private String user = "root";
    private String password = "";
    private String name = "test";
    private String host = "localhost";
    private Integer port = 3306;

    private String engine = "InnoDB";
    private String characterSet = "utf8mb4";
    private String collate = "utf8mb4_unicode_ci";
    private String[] escapeRules = {"//", "/'", "/\"", ""};
    private String[] unescapeRules = {"/", "'", "\"", "'"};

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public Integer getPort() {
        return port;
    }

    @Override
    public String getEngine() {
        return engine;
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
    public String[] getEscapeRules() {
        return escapeRules;
    }

    @Override
    public String[] getUnescapeRules(){
        return unescapeRules;
    }

    @Override
    public MySqlAdapter setUser(String user) {
        this.user=user;
        return this;
    }

    @Override
    public MySqlAdapter setPassword(String password) {
        this.password=password;
        return this;
    }

    @Override
    public MySqlAdapter setName(String name) {
        this.name=name;
        return this;
    }

    @Override
    public MySqlAdapter setHost(String host) {
        this.host=host;
        return this;
    }

    @Override
    public MySqlAdapter setPort(Integer port) {
        this.port=port;
        return this;
    }

    @Override
    public MySqlAdapter setEngine(String engine) {
        this.engine=engine;
        return this;
    }

    @Override
    public MySqlAdapter setCharacterSet(String characterSet) {
        this.characterSet=characterSet;
        return this;
    }

    @Override
    public MySqlAdapter setCollate(String collate) {
        this.collate=collate;
        return this;
    }

    @Override
    public MySqlAdapter setEscapeRules(String[] escapeRules) {
        this.escapeRules=escapeRules;
        return this;
    }

    @Override
    public MySqlAdapter setUnescapeRules(String[] unescapeRules) {
        this.unescapeRules=unescapeRules;
        return this;
    }
}
