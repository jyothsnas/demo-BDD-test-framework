package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage{
    static final Logger log = LogManager.getLogger(LandingPage.class);
    @FindBy(xpath = "")
    private WebElement mobileText;
    String url = "";
    By verifyHomePageText = By.xpath("//div[@id='nav-logo']/a");
    By menuButton = By.xpath("//div[@id ='nav-main']/div/a");
    By clickOnEle = By.xpath("//div[@id='hmenu-content']/ul/li/a[@class='hmenu-item']/div[text()='Mobiles, Computers']");
    By headerMobiles = By.xpath("//li/div[@class='hmenu-item hmenu-title '][contains(text(), 'Mobiles,')]");
    By clickOnMobiles = By.xpath("//li/div[@class='hmenu-item hmenu-title '][contains(text(), 'Mobiles,')]/../following-sibling::li/a[text()='All Mobile Phones']");
    By loc2 =By.xpath("//li/span/a/span[text()='Smartphones & Basic Mobiles']");
    By subHeaderMobiles = By.xpath("//li[@class='a-spacing-micro']/span/span[contains(text(),'Mobiles & Accessories')]");
    //By clickOnProduct=By.xpath("/li/span[@class='a-list-item']/a/span[contains(text(),'Smartphones & Basic Mobiles')]");
    By clickOnProduct=By.xpath("//li/span[@class='a-list-item']/a/span[contains(text(),'Smartphones')]");
    // By selectProduct = By.xpath("//div/span[text()= 'Brand']/../following-sibling::ul/li/span/a/span[text()='Samsung']");
    By selectProduct=By.xpath("//label/input[@aria-labelledby='Samsung']/following-sibling::i");
    By productSpec = By.xpath("//div[@data-cy='title-recipe']/h2/a/span");
    By productPrice=By.xpath("//a/span[@class='a-price']/span");
    By selectPrice = By.xpath("//span/a/span[contains(text(),'10,000 - ₹20,000')]");
    By camRes = By.xpath("//div/label/input[@aria-labelledby='32 MP & Above']/following-sibling::i");
    By selectProd1 =By.xpath("//span/li[@aria-label='Samsung']/span/a/div/label/i");
    By verifyPrice = By.xpath("//span/span[@class='a-price-whole']");
    public void visitHomePage1(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("HomePage errors");
        visit(url);
        driver.manage().window().maximize();
    }
    public boolean verifyHomepage1() {
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
    public void selectEleAndComp1(){
        //verifyHomepage();
        By amazonCook = By.xpath("//span/input[@id='sp-cc-accept']");
        click(amazonCook);
        click(menuButton);
        waitUntilElementVisibile(clickOnEle);
        clickByjs(clickOnEle);
    }
    public void selectSubCategory1(){
        waitUntilElementVisibile(headerMobiles);
        String str = find(headerMobiles).getText();
        Assert.assertTrue("Mobiles header mismatch", str.contains("Mobiles"));
        waitUntilElementVisibile(clickOnMobiles);
        clickByjs(clickOnMobiles);
        waitUntilElementVisibile(subHeaderMobiles);
        Assert.assertTrue("", find(subHeaderMobiles).getText().contains("Mobiles"));
        waitUntilElementVisibile(clickOnProduct);
        click(clickOnProduct);
    }
    public void selectProduct1(){
        driver.navigate().refresh();
        scrollIntoView(find(camRes));
        clickByjs(camRes);
        waitUntilElementVisibile(selectProd1);
        clickByjs(selectProd1);
        log.info("select Product");
    }
    public void validateSPec1() {
        waitUntilElementVisibile(productSpec);
        String actual = find(productSpec).getText();
        Assert.assertTrue("Mobile Specs are not as expected", actual.contains("50MP Triple Cam"));
        scrollIntoView(find(selectPrice));
        clickByjs(selectPrice);
        waitUntilElementVisibile(verifyPrice);
        String actualPrice = find(verifyPrice).getText();
        String p1= actualPrice.replace(",","");
        int p=0;
        p = Integer.valueOf(p1);
        Assert.assertTrue("Price is not in the given range", actualPrice.contains("13,990"));
        Assert.assertTrue("Price is not in the given range", (p>10000));
    }
}