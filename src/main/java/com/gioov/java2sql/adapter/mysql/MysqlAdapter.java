package com.gioov.java2sql.adapter.mysql;

import com.gioov.java2sql.adapter.DatabaseAdapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by godcheese on 2017/7/15.
 */
public final class MysqlAdapter implements DatabaseAdapter {


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
    public String[] getUnescapeRules() {
        return unescapeRules;
    }

    @Override
    public MysqlAdapter setUser(String user) {
        this.user = user;
        return this;
    }

    @Override
    public MysqlAdapter setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public MysqlAdapter setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public MysqlAdapter setHost(String host) {
        this.host = host;
        return this;
    }

    @Override
    public MysqlAdapter setPort(Integer port) {
        this.port = port;
        return this;
    }

    @Override
    public MysqlAdapter setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    @Override
    public MysqlAdapter setCharacterSet(String characterSet) {
        this.characterSet = characterSet;
        return this;
    }

    @Override
    public MysqlAdapter setCollate(String collate) {
        this.collate = collate;
        return this;
    }

    @Override
    public MysqlAdapter setEscapeRules(String[] escapeRules) {
        this.escapeRules = escapeRules;
        return this;
    }

    @Override
    public MysqlAdapter setUnescapeRules(String[] unescapeRules) {
        this.unescapeRules = unescapeRules;
        return this;
    }

    @Override
    public ArrayList<String> executeSqlBatches(ArrayList<String> batches) {

        if (batches.size() > 0) {
            String uri = "jdbc:mysql://" + host + ":" + port + "/" + name;
            String driverClass = "com.mysql.jdbc.Driver";
            Connection connection = null;
            Statement statement = null;

            try {
                Class.forName(driverClass);
                connection = DriverManager.getConnection(uri, user, password);
                statement = connection.createStatement();

                for (String batch : batches) {
                    statement.executeUpdate(batch);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                try {
                    if (connection != null) {
                        connection.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        }

        return batches;
    }


}
