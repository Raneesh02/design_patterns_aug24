package Base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.PropertyHandler;

public class BaseTest {

    protected String url;

    @BeforeMethod
    public void init(){
        DriverManager.initDriver();
        url = PropertyHandler.getProperty("url");
        DriverManager.getDriver().get(url);
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.quitDriver();
    }

}
