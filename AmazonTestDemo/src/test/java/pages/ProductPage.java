package pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

import static utils.BaseUtils.driver;

public class ProductPage {
    public void test1(DataTable dataTable){
        // Cucumber Data table
        List<Map<String, String>> data = dataTable.asMaps(String.class,String.class);
        //List<String> list = dataTable.asList(String.class);
        String a1=data.get(0).get("Details");
        String a2=data.get(1).get("Details");
        List<WebElement> ele = driver.findElements(By.xpath(""));
        for(WebElement ele1:ele){
            ele1.getText();
        }
        ele.size();
        Select sel = new Select(driver.findElement(By.xpath("")));
        sel.selectByValue("");
    }
    public void test2(){
        By x1 = By.xpath("");

    }
}