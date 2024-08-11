package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.PropertyHandler;

import java.util.HashMap;

public class DriverManager {

    private static ThreadLocal<WebDriver> threadLocalDriver= new ThreadLocal<>();;

    public static WebDriver initDriver(){
        ChromeOptions chromeOptions = new ChromeOptions();

        switch (PropertyHandler.platform){
            case "web":
                break;
            case "mweb":
                HashMap<String, String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", "Nexus 5");
                chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                break;
            default: throw new IllegalArgumentException("Platform "+ PropertyHandler.platform+" is invalid");
        }

        threadLocalDriver.set(new ChromeDriver(chromeOptions));

        return threadLocalDriver.get();
    }

    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }

    public static void quitDriver(){
        threadLocalDriver.get().quit();
        threadLocalDriver.remove();
    }

}
