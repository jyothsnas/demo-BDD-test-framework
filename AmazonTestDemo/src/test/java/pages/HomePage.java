package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HomePage extends BasePage {
    static final Logger log = LogManager.getLogger(HomePage.class);
    String url = "https://www.amazon.co.uk";
    By verifyHomePageText = By.xpath("//div[@id='nav-logo']/a");
    By menuButton = By.xpath("//div[@id ='nav-main']/div/a");

    public void visitHomePage(){
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        log.info("HomePage errors");
        visit(url);
        driver.manage().window().maximize();
        acceptCookies();
    }
    public boolean verifyHomepage() {
        boolean result;
        try {
            result = driver.findElement(verifyHomePageText).isDisplayed();
            } catch (Exception e) {
            log.error("Exception occurred", new Exception("Captcha message"));
            ///takeScreenshot();
            result = false;
        }
        return result;
    }
    public void acceptCookies(){
        By amazonCook = By.xpath("//span/input[@id='sp-cc-accept']");
        click(amazonCook);
    }
    public void selectElectronicsAndComp(String selCategory) {
        click(menuButton);
        By eleAndComp = By.xpath("//li/a/div[contains(text(), '" + selCategory + "')]");
        waitUntilElementVisibile(eleAndComp);
        clickByjs(eleAndComp);

        By headerEle = By.xpath("//li/div[@class='hmenu-item hmenu-title '][contains(text(), 'electronics')]");
        waitUntilElementVisibile(headerEle);
        String s = find(headerEle).getText();
        Assert.assertTrue("Electronics Header is not as expected", s.contains("Electronics"));
    }

    public void selectSubCategory(){
        By phonesAndAcc = By.xpath("//li/a[contains(text(),'Phones & Accessories')]");
        waitUntilElementVisibile(phonesAndAcc);
        clickByjs(phonesAndAcc);

        By mobilesHeaderNew= By.xpath("//h3[contains(text(),'Mobile Phones')]");
        waitUntilElementVisibile(mobilesHeaderNew);
        Assert.assertTrue("Mobile header is not present", find(mobilesHeaderNew).getText().contains("Mobile Phones"));

        By simFreePhones = By.xpath("//div[@class='left_nav browseBox']/h3[text()='Mobile Phones']//following::ul/descendant::a[contains(text(),'SIM-Free')]");
        waitUntilElementVisibile(simFreePhones);
        clickByjs(simFreePhones);
    }
    public void selectFilters(){
        selectCamResolution();
        selectPrice();
    }
    public void selectPrice(){
        By selectPrice = By.xpath("//span[contains(text(),'£50 to £100')]");
        scrollIntoView(find(selectPrice));
        clickByjs(selectPrice);
        System.out.println("url after price selection" +driver.getCurrentUrl());
        driver.navigate().refresh();
    }
    public void selectCamResolution(){
       // By cameraRes = By.xpath("//span[@class='a-list-item']/a/span[contains(text(), '20 MP & above')]");
        By cameraRes =By.xpath("//span/li[@aria-label='13 to 19.9 MP']/span/a/div/label/i");
        scrollBottomOfPage(find(cameraRes));
        clickByjs(cameraRes);
        driver.navigate().refresh();
    }
    public void selectBrand(){
        By selectBrand = By.xpath("//span[(text()='Samsung')]");
        scrollIntoView(find(selectBrand));
        clickByjs(selectBrand);
        log.info("select Product");
    }
    public void validateSPec() {
        //verifyPrice();
        By getv=By.xpath("//span/span[@class='a-price-whole']");
        waitUntilElementVisibile(getv);
        String pr3= find(getv).getText();
        int price =0;
        price=Integer.parseInt(pr3);
        Assert.assertTrue("Mobile Price is not in the range", (price>99 && price<150));

        By getMp = By.xpath("//span[contains(text(),'Optical sensor resolution')]/../span[@class='a-text-bold']");
        String s2 = find(getMp).getText();
        Assert.assertTrue("Camera resolution not as expected", s2.contains("5"));
    }
    public void verifyPrice(){
        //By getPrice1=By.xpath("//span/span[@class='a-price-whole']");
        By getPrice = By.xpath("//span[@class='a-price-whole']");
        waitUntilElementVisibile(getPrice);
        List<WebElement> ele = findAll(getPrice);
        System.out.println("size:" +ele.size());
        for(WebElement ele1:ele){
            String pr= ele1.getText();
            int price=0;
            price=Integer.parseInt(pr);
            Assert.assertTrue("Mobile Price is not in the range:",(price>99 && price<150));
        }
    }
}