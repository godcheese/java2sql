package com.gioov.java2sql.migration;

/**
 * Created by godcheese on 2017/7/14.
 */
public class ForeignKey {

    /**
     * CONSTRAINT `role_permissions` FOREIGN KEY (`api_id`) REFERENCES `apis`(`id`) ON UPDATE CASCADE ON DELETE ON CASCADE
     */

    private String table;
    private String foreignKey;
    private String peferencesTable;
    private String peferencesKey;
    private String onUpdate;
    private String onDelete;




}
