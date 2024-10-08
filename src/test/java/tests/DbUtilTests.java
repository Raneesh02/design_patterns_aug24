package tests;

import Base.BaseTest;
import org.testng.annotations.Test;
import utilities.DbUtil;
import utilities.DbUtilSingleton;
import utilities.MultiThread;

public class DbUtilTests extends BaseTest {

//    @Test
//    public void dbUtilTest1(){
//        DbUtil dbUtil = new DbUtil();
//        dbUtil.runQuery("dbUtilTest1 select * from table");
//    }
//
//    @Test
//    public void dbUtilTest2(){
//        DbUtil dbUtil = new DbUtil();
//        dbUtil.runQuery("dbUtilTest2 select * from table");
//    }

//    @Test
//    public void dbUtilTest3(){
//        DbUtil dbUtil = new DbUtil();
//        dbUtil.runQuery("dbUtilTest3 select * from table");
//    }

    @Test
    public void dbUtilTest1Singleton(){
        DbUtilSingleton dbUtilSingleton = DbUtilSingleton.getInstance();
        dbUtilSingleton.runQuery("dbUtilTest1Singleton select * from table");
    }

    @Test
    public void dbUtilTest2Singleton(){
        DbUtilSingleton dbUtilSingleton = DbUtilSingleton.getInstance();
        dbUtilSingleton.runQuery("dbUtilTest2Singleton select * from table");
    }

    @Test
    public void dbUtilTest2SingletonEarlyInitProblem(){
        DbUtilSingleton.printConfig();
    }

    @Test
    public void dbUtilSingletonLazyMultiThreading(){
        for(int i=0;i<100;i++){
            MultiThread multiThread = new MultiThread();
            multiThread.start();
        }

    }

}
