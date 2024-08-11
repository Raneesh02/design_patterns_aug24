package pages.Factory;

import org.openqa.selenium.WebDriver;
import pages.RegistrationPage;
import pages.interfaces.HomePage;
import pages.mobileweb.mWebHomePage;
import pages.web.WebHomepage;
import utilities.PropertyHandler;


public abstract class PageFactory {

     public abstract HomePage getHomePage(WebDriver driver);

     public static PageFactory getPageFactory(){
         switch (PropertyHandler.platform){
             case "web":
                 return new WebPageFactory();
             case "mweb":
                 return new MWebPageFactory();
             default: throw new IllegalArgumentException("Platform "+ PropertyHandler.platform+" is invalid");
         }
     }



}
