package e2e.login;

import e2e.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends TestBase {
    LoginPage loginPage;
    String password = "secret_sauce";

    public void positiveTestMethod(String username) {
        loginPage = new LoginPage();
        loginPage.login(username, password);
        loginPage.confirmLogin();

       /* OverviewPage overviewPage = new OverviewPage();
        LinkedHashMap<String, String[]> infoObject = overviewPage.getAllIInfoPage();
        String[] productsName = infoObject.get("productsName");
        String[] productList = new String[]{productsName[0], productsName[1], productsName[2]};
        String[] productsPrice = infoObject.get("productsPrice");*/
    }

    @Epic("Login")
    @Feature("Positive Login")
    @Description("Login as standard_user with valid password")
    @Test(description = "Login as standard_user with valid password")
    public void loginAsStandardUser() {
        positiveTestMethod("standard_user");
    }

    @Epic("Login")
    @Feature("Positive Login")
    @Description("Login as problem_user with valid password")
    @Test(description = "Login as problem_user with valid password")
    public void loginAsProblem_user() {
        positiveTestMethod("problem_user");
    }

    @Epic("Login")
    @Feature("Positive Login")
    @Description("Login as performance_glitch_user with valid password")
    @Test(description = "Login as performance_glitch_user with valid password")
    public void loginAsPerformance_glitch_user() {
        positiveTestMethod("performance_glitch_user");
    }

    @Epic("Login")
    @Feature("Positive Login")
    @Description("Login as error_user with valid password")
    @Test(description = "Login as error_user with valid password")
    public void loginAsError_user() {
        positiveTestMethod("error_user");
    }

    @Epic("Login")
    @Feature("Positive Login")
    @Description("Login as visual_user with valid password")
    @Test(description = "Login as visual_user with valid password")
    public void loginAsVisual_user() {
        positiveTestMethod("visual_user");
    }

}
