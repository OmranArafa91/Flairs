package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver= driver;
    }

    @FindBy(name = "username")
    WebElement usernamePF;

    public WebElement usernamePOM(){

        By username = By.name("username");
        WebElement usernameEl = driver.findElement(By.name("username"));

        return usernameEl;
    }

    public WebElement passwordPOM(){
        return driver.findElement(By.name("password"));
    }

    public WebElement loginBtnPOM(){
        return driver.findElement(By.className("oxd-button oxd-button--medium oxd-button--main orangehrm-login-button"));
    }

    public void LoginSteps (String username, String password){

        usernamePF.clear();
        usernamePOM().sendKeys(username);
        passwordPOM().sendKeys(password);
    }



}
