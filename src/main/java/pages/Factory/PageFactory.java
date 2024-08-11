package pages.Factory;

import org.openqa.selenium.WebDriver;
import pages.interfaces.HomePage;
import pages.mobileweb.mWebHomePage;
import pages.web.WebHomepage;
import utilities.PropertyHandler;


public class PageFactory {

     public HomePage getHomePage(WebDriver driver){
         HomePage homePage;
         switch (PropertyHandler.platform){
             case "web":
                 homePage = new WebHomepage(driver);
                 break;
             case "mweb":
                 homePage = new mWebHomePage(driver);
                 break;
             default: throw new IllegalArgumentException("Platform "+ PropertyHandler.platform+" is invalid");
         }

         return homePage;
     }

}
