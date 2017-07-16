package com.gioov.java2sql.adapter.mysql;

import com.gioov.java2sql.adapter.FieldAdapter;

/**
 * Created by godcheese on 2017/7/14.
 */
public final class MysqlFieldAdapter implements FieldAdapter {


    private String name = null;
    private String type = null;
    private Integer length = null;
    private Integer decimal = null;
    private Boolean isNull = true;
    private Boolean primaryKey = false;
    private String comment = null;
    private String defaultValue = null;
    private Boolean autoIncrement = false;
    private Boolean isUnsigned = null;
    private Boolean zerofill = false;
    private String characterSet = null;
    private String collate = null;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Integer getLength() {
        return length;
    }

    @Override
    public Integer getDecimal() {
        return decimal;
    }

    @Override
    public Boolean getIsNull() {
        return isNull;
    }

    @Override
    public Boolean getPrimaryKey() {
        return primaryKey;
    }

    @Override
    public String getComment() {
        return comment;
    }

    @Override
    public String getDefaultValue() {
        return defaultValue;
    }

    @Override
    public Boolean getAutoIncrement() {
        return autoIncrement;
    }

    @Override
    public Boolean getIsUnsigned() {
        return isUnsigned;
    }

    @Override
    public Boolean getZerofill() {
        return zerofill;
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
    public MysqlFieldAdapter setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public MysqlFieldAdapter setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public MysqlFieldAdapter setLength(Integer length) {
        this.length = length;
        return this;
    }

    @Override
    public MysqlFieldAdapter setDecimal(Integer decimal) {
        this.decimal = decimal;
        return this;
    }

    @Override
    public MysqlFieldAdapter setIsNull(Boolean isNull) {
        this.isNull = isNull;
        return this;
    }

    @Override
    public MysqlFieldAdapter setPrimaryKey(Boolean primaryKey) {
        this.primaryKey = primaryKey;
        return this;
    }

    @Override
    public MysqlFieldAdapter setComment(String comment) {
        this.comment = comment;
        return this;
    }

    @Override
    public MysqlFieldAdapter setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    @Override
    public MysqlFieldAdapter setAutoIncrement(Boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
        return this;
    }

    @Override

    public MysqlFieldAdapter setIsUnsigned(Boolean isUnsigned) {
        this.isUnsigned = isUnsigned;
        return this;
    }

    @Override
    public MysqlFieldAdapter setZerofill(Boolean zerofill) {
        this.zerofill = zerofill;
        return this;
    }

    @Override
    public MysqlFieldAdapter setCharacterSet(String characterSet) {
        this.characterSet = characterSet;
        return this;
    }

    @Override
    public MysqlFieldAdapter setCollate(String collate) {
        this.collate = collate;
        return this;
    }
}
