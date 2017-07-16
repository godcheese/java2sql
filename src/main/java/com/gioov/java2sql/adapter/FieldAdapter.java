package com.gioov.java2sql.adapter;


/**
 * Created by godcheese on 2017/7/14.
 */
public interface FieldAdapter {

    /**
    String name=null;
    String type=null;
    Integer length=null;
    Integer decimal=null;
    Boolean isNull=true;
    Boolean primaryKey=false;
    String comment=null;
    String defaultValue=null;
    Boolean autoIncrement=false;
    Boolean isUnsigned=null;
    Boolean zerofill=false;
    String characterSet=null;
    String collate=null;
     */

    String getName();
    String getType();
    Integer getLength();
    Integer getDecimal();
    Boolean getIsNull();
    Boolean getPrimaryKey();
    String getComment();
    String getDefaultValue();
    Boolean getAutoIncrement();
    Boolean getIsUnsigned();
    Boolean getZerofill();
    String getCharacterSet();
    String getCollate();

    FieldAdapter setName(String name);
    FieldAdapter setType(String type);
    FieldAdapter setLength(Integer length);
    FieldAdapter setDecimal(Integer decimal);
    FieldAdapter setIsNull(Boolean isNull);
    FieldAdapter setPrimaryKey(Boolean primaryKey);
    FieldAdapter setComment(String comment);
    FieldAdapter setDefaultValue(String defaultValue);
    FieldAdapter setAutoIncrement(Boolean autoIncrement);
    FieldAdapter setIsUnsigned(Boolean isUnsigned);
    FieldAdapter setZerofill(Boolean zerofill);
    FieldAdapter setCharacterSet(String characterSet);
    FieldAdapter setCollate(String collate);

}
