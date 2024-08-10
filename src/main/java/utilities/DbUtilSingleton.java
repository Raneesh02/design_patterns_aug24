package utilities;

public class DbUtilSingleton {

    private DbUtilSingleton(){
        System.out.println("DbUtilSingleton Constructor called, Database connection opened");
        //initialize connection
    }

    // Early Initialization
    final static DbUtilSingleton dbUtilSingleton = new DbUtilSingleton();

    static public DbUtilSingleton getInstance(){
        return  dbUtilSingleton;
    }


    // Early Initialization


    public void runQuery(String query){
        System.out.println("Query : "+ query + " ran");
    }

    public void printConfit(){
        System.out.println("DbUtil Configuration");
    }

}
