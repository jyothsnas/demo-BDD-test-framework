package utils;

import org.openqa.selenium.WebDriver;

public class BaseUtils {
    public static WebDriver driver;
    public WebDriver getDriver(){
        return driver;
    }
    public void setDriver(WebDriver driver){
        this.driver = driver;
    }
}