package com.gioov.java2sql;

import com.gioov.java2sql.adapter.DatabaseAdapter;

/**
 * Created by godcheese on 2017/7/14.
 */
public class DatabaseConfig {

    private DatabaseAdapter adapter;

    public DatabaseAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(DatabaseAdapter adapter) {
        this.adapter = adapter;
    }

}
