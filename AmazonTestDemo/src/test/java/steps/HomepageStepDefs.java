package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import utils.BaseUtils;

public class HomepageStepDefs extends BaseUtils {
    BaseUtils baseUtils;
    HomePage homePage;
    public HomepageStepDefs(BaseUtils baseUtils) {
        super();
        this.baseUtils = baseUtils;
        this.homePage =new HomePage();
    }
    @Given("User landed on the HomePage")
    public void user_landed_on_the_home_page() {
        homePage.visitHomePage();
        Assert.assertTrue(homePage.verifyHomepage());
    }
    @When("User selects {string} from the Main menu")
    public void user_selects_from_the_main_menu(String cate) {
          homePage.selectElectronicsAndComp(cate);
    }
    @And("selects {string}")
    public void selects(String string) {
        homePage.selectSubCategory();
    }
    @And("Selects the Mobile phones {string}")
    public void selects_the_mobile_phones(String string) {
       homePage.selectFilters();
       homePage.selectBrand();
    }
}