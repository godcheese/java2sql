package com.gioov.java2sql;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 */
public class App {


    private static final String MIGRATION="migration";
    private static final String MIGRATE="migrate";
    private static final String SEED="seed";
    private static final String SEEDER="seeder";
    private static final String FILE_SEPARATOR=System.getProperty("file.separator");
    private static final String ORIGIN_PATH=new File("").getAbsolutePath();

    public static void main(String[] args) {

        if (args.length > 0) {

            try {
                directory();
            } catch (IOException e) {
                e.printStackTrace();
            }


            List list = Arrays.asList(args);
            Object action = list.get(0);

            action = action.toString();

            System.out.println(action);

            if (action.equals("migrate")) {

//                migrationAction();
            } else if (action.equals("seed")) {

            } else {


                String fileName=null;
                // 生成数据迁移文件
                String regexMigration = "^migration:Create([a-zA-Z0-9]+)Table$";
                Pattern patternMigration = Pattern.compile(regexMigration, Pattern.CASE_INSENSITIVE);
                Matcher matcherMigration = patternMigration.matcher((String) action);
                if (matcherMigration.matches()) {
                    fileName=matcherMigration.group(1);
                }

                // 执行迁移数据操作
                String regexMigrate = "^migrate:([a-zA-Z0-9]+)$";
                Pattern patternMigrate = Pattern.compile(regexMigrate, Pattern.CASE_INSENSITIVE);
                Matcher matcherMigrate = patternMigrate.matcher((String) action);
                if (matcherMigrate.matches()) {
                    fileName=matcherMigrate.group(1);
                }

                // 生成数据填充文件
                String regexSeeder = "^seeder:([a-zA-Z0-9]+)$";
                Pattern patternSeeder = Pattern.compile(regexSeeder, Pattern.CASE_INSENSITIVE);
                Matcher matcherSeeder = patternSeeder.matcher((String) action);
                if (matcherSeeder.matches()) {
                    fileName=matcherSeeder.group(1);
                }


                // 执行数据填充操作
                String regexSeed = "^seed:([a-zA-Z0-9]+)$";
                Pattern patternSeed = Pattern.compile(regexSeed, Pattern.CASE_INSENSITIVE);
                Matcher matcherSeed = patternSeed.matcher((String) action);
                if (matcherSeed.matches()) {
                    fileName=matcherSeeder.group(1);
                }

                System.out.println(fileName);
            }

        }

    }



    public static void createNewMigration(String name){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String migrationSortDatetime=sdf.format(System.currentTimeMillis());
        String pathname="Create"+migrationSortDatetime+name+"";
    }


    public static void executeNewMigration(String name){

    }


    public static void createNewSeed(String name){

    }
    public static void executeNewSeed(String name){

    }


    public static void existsFile(String type , String name){

    }


    public static void createNewFile(String type , String pathname) throws IOException {

        URL url=App.class.getClassLoader().getResource("CreateTestsTable.javabak");
        String inputFilename;
        String outputFilename;

        if((inputFilename=url.getFile())!=null) {
            outputFilename=ORIGIN_PATH+FILE_SEPARATOR+MIGRATION+"s"+FILE_SEPARATOR+"CreateTestsTable.java";

            String findContentOfDatabaseName = "databaseName";
            String findContentOfTableName = "tests";

            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilename));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilename));

            String s = null;
            while ((s = bufferedReader.readLine()) != null) {

                s = s.replaceFirst(findContentOfDatabaseName, "dbname");
                s = s.replaceFirst(findContentOfTableName, "tablename");
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }

            bufferedWriter.flush();
            bufferedWriter.close();
            bufferedReader.close();
        }
    }



    public static void directory() throws IOException {
        String[] directories={"migrations","seeds"};
        for(String directory : directories){
            String pathname=ORIGIN_PATH+FILE_SEPARATOR+directory;
            File file=new File(pathname);
            if(!file.exists() || !file.isDirectory()){
                file.mkdir();
            }
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
