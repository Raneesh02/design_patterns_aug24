package utilities;

public class DbUtil {

    public DbUtil(){
        System.out.println("DbUtil Constructor called, Database connection opened");
        //initialize connection
    }

    public void runQuery(String query){
        System.out.println("Query : "+ query + " ran");
    }

    public void printConfit(){
        System.out.println("DbUtil Configuration");
    }

}
