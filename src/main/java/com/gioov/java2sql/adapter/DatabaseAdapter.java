package com.gioov.java2sql.adapter;


import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by godcheese on 2017/7/15.
 */
public interface DatabaseAdapter {

    /**
    String user = "root";
    String password = "";
    String name = "test";
    String host = "localhost";
    Integer port = 3306;

    String engine = "InnoDB";
    String characterSet = "utf8mb4";
    String collate = "utf8mb4_unicode_ci";
    String[] escapeRules = {"//", "/'", "/\"", ""};
    String[] unescapeRules = {"/", "'", "\"", "'"};
     */

    String getUser();
    String getPassword();
    String getName();
    String getHost();
    Integer getPort();
    String getEngine();
    String getCharacterSet();
    String getCollate();
    String[] getEscapeRules();
    String[] getUnescapeRules();

    DatabaseAdapter setUser(String user);
    DatabaseAdapter setPassword(String password);
    DatabaseAdapter setName(String name);
    DatabaseAdapter setHost(String host);
    DatabaseAdapter setPort(Integer port);
    DatabaseAdapter setEngine(String engine);
    DatabaseAdapter setCharacterSet(String characterSet);
    DatabaseAdapter setCollate(String collate);
    DatabaseAdapter setEscapeRules(String[] escapeRules);
    DatabaseAdapter setUnescapeRules(String[] unescapeRules);

    ArrayList<String> executeSqlBatches(ArrayList<String> batches);
}
