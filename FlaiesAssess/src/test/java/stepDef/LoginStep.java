package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class LoginStep {

    WebDriver driver =null;
    LoginPage login;
    @Given("user open browser")
    public void open_browser() throws InterruptedException {
        String chromepath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromepath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);

        login = new LoginPage(driver);
        throw new io.cucumber.java.PendingException();
    }

    @And("navigate to login page")
    public void navigate_to_login(){
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
        throw new io.cucumber.java.PendingException();
    }

    @When("^user enter \"(.*)\" and \"(.*)\"$")
    public void valid_login(String username, String password){
        login.LoginSteps(username, password);
        throw new io.cucumber.java.PendingException();
    }

    @And("click login button")
    public void login_btn(){
        login.loginBtnPOM().click();
        throw new io.cucumber.java.PendingException();
    }

    @Then("user redirected to dashboard page")
    public void success_login(){

        String expectedRusult = "dashboard";
        String actualRusult = driver.findElement(By.className("oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module")).getText();

        Assert.assertEquals(actualRusult, expectedRusult);
        throw new io.cucumber.java.PendingException();

    }
}
