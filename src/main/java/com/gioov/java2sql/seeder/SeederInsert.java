package com.gioov.java2sql.seeder;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by godcheese on 2017/7/15.
 */
public class SeederInsert {


    private Map<String,Object> sets;


    public SeederInsert(){
        sets=new LinkedHashMap<>();

    }

    public Map<String, Object> getSets() {
        return sets;
    }

    public void setSet(String field, Object value) {
        sets.put(field,value);
    }

}
