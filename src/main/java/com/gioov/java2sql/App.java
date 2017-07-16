package com.gioov.java2sql;

import com.sun.javaws.jnl.MatcherReturnCode;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {

    private final static Integer MIGRATION=1;
    private final static Integer SEEDER=2;

    public static void main(String[] args) {

        if(args.length>0) {

            List list=Arrays.asList(args);
            Object action=list.get(0);


            action=action.toString();

            System.out.println(action);

            if(action.equals("migrate")){

//                migrationAction();
            }else if(action.equals("seed")){

            }else{
                String patternMigration="^migration:([a-zA-Z0-9]+)$";
                String patternMigrate="^migrate:([a-zA-Z0-9]+)$";

                String patternSeed="^seed:([a-zA-Z0-9]+)$";
                String patternSeeder="^seeder:([a-zA-Z0-9]+)$";

                Pattern pattern=Pattern.compile(patternMigration,Pattern.CASE_INSENSITIVE);

                Matcher matcher=pattern.matcher((String)action);

                System.out.println(matcher.matches());
                if(matcher.matches()){

                }
            }


//            String type="";
//            String command="";
//
//            type = args[0].toLowerCase();
//            if(args[1]!=null){
//               command = args[1].toLowerCase();
//            }
//
//            switch (type) {
//
//                case "migrate":
//                    System.out.println("Migrate success.");
//                    break;
//
//                case "migrate-single":
//                    System.out.println("Migrate success :"+command);
//                    break;
//
//                    default:
//                        System.out.println("Please input a command.");
//            }
        }

    }


//    private static void migrateAction(Matcher matcher){
//
//        matcher.group(1);
//    }

//    private static void migrationAction(Matcher matcher){
//        String migration=matcher.group(1);
//
//    }

//
//    private static void createClassFile(String className,Integer type){
//
//
//        File file = new File("");
//        String fileName;
//        try {
//
//            Class aClass=Class.forName("com.gioov.java2sql.App");
//            InputStream inputStream=aClass.getResourceAsStream("TemplateMigration.java");
//
//            fileName = file.getCanonicalPath()+System.getProperty("file.separator");
//
//            String template=this.getClass().;
//            FileOutputStream fileOutputStream=new FileOutputStream(template);
//
//            fileWriter.write();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        switch (type){
//
//            case 1:
//                break;
//            case 2:
//                break;
//            default:
//                break;
//
//        }
//    }
}
