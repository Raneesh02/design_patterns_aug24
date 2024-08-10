package utilities;

public class DbUtilSingleton {

    private DbUtilSingleton(){
        System.out.println("DbUtilSingleton Constructor called, Database connection opened");
        //initialize connection
    }

    // Early Initialization
//    final static DbUtilSingleton dbUtilSingleton = new DbUtilSingleton();
//
//    static public DbUtilSingleton getInstance(){
//        return  dbUtilSingleton;
//    }

    // Early Initialization

    //Lazy Initialization
//    static DbUtilSingleton dbUtilSingleton;
//
//    static public DbUtilSingleton getInstance() {
//        if(dbUtilSingleton == null) {  // Threads are accessing the same line , Thread T1 , T2, T3
//            dbUtilSingleton = new DbUtilSingleton();  //T3 Initalized the variable
//        }
//        ret

//    }


    //Lazy Initialization


    //     // Thread Safe
//    private static DbUtilSingleton dbUtilSingleton;
//
//    public static synchronized DbUtilSingleton getInstance() {
//        if(dbUtilSingleton == null){
//            dbUtilSingleton = new DbUtilSingleton();
//            System.out.println("DBUtilSingleton Instance Created" + dbUtilSingleton.hashCode());
//        }
//        System.out.println("DBUtilSingleton Instance Returned" + dbUtilSingleton.hashCode());
//        return dbUtilSingleton;
//    }
// //    Thread Safe

    //Double Locking Thread Safe
    private static DbUtilSingleton dbUtil;

    public static DbUtilSingleton getInstance() {
        if(dbUtil == null){
            System.out.println("Thread inside if waiting to create resource");
            synchronized (DbUtilSingleton.class) {
                if(dbUtil == null){
                    dbUtil = new DbUtilSingleton();
                    System.out.println("DBUtilSingleton Instance Created" + dbUtil.hashCode());
                }
                else {
                    System.out.println("Double locking worked");
                }
            }
        }
        System.out.println("DBUtilSingleton Instance Returned" + dbUtil.hashCode());
        return dbUtil;
    }
    //Double Locking Thread Safe
    public void runQuery(String query){
        System.out.println("Query : "+ query + " ran");
    }

    public static void printConfig(){
        System.out.println("DbUtil Configuration");
    }

}
