package com.gioov.java2sql;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        String[] args = {"migration:CreateUsersTable", "testDatabase"};
        App.main(args);
    }

//    public void testDirectory(){
//
//        try {
//            App.directory();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

//    public void testCreateNewFile(){
//        try {
//            App.createNewFile("migration","name");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    public void testCreateNewMigration(){

    }

}
