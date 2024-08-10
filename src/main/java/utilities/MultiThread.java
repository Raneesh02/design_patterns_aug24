package utilities;

public class MultiThread extends Thread{
    @Override
    public void run() {
        DbUtilSingleton instance = DbUtilSingleton.getInstance();
        instance.runQuery(this.getName()+" query");
    }
}
