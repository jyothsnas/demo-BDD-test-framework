package steps;

import io.cucumber.java.en.Then;
import pages.HomePage;
import utils.BaseUtils;

public class ProductStepDefs extends BaseUtils {
    BaseUtils baseUtils;
    HomePage homePage;
    public ProductStepDefs(BaseUtils baseUtils) {
        super();
        this.baseUtils = baseUtils;
        this.homePage = new HomePage();
    }
    @Then("User should see the specifications for {string} mobiles")
    public void userShouldSeeTheSpecificationsForMobiles(String arg0) {
        homePage.validateSPec();
    }
}