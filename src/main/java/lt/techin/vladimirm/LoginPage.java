package lt.techin.vladimirm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#_desktop_user_info > div > a > i")
    WebElement signInArea;

    @FindBy(css = "[data-link-action='display-register-form']")
    WebElement createNewAccount;
    @FindBy(css = "label:nth-of-type(1)  input[name='id_gender']")
    WebElement gendeIdMale;
    @FindBy(css = "input#field-firstname")
    WebElement inputFirstName;
    @FindBy(css = "input#field-lastname")
    WebElement inputSecondName;
    @FindBy(css = "input#field-email")
    WebElement inputEmail;
    @FindBy(css = "input#field-password")
    WebElement inputPassword;
    @FindBy(css ="input[name='psgdpr']")
    WebElement agreeToTermsMarker;
    @FindBy(css = "input[name='customer_privacy']")
    WebElement dataPrivacyMarker;
    @FindBy(css = "[title] .hidden-sm-down")
    WebElement myUserName;
    @FindBy(css = "#_desktop_user_info > div > a.logout.hidden-sm-down > i")
    WebElement logOut;






    @FindBy(css="#customer-form > footer > button")
    WebElement loginSaveButton;
    @FindBy(css = "button#submit-login")
    WebElement loginSubmitButton;








    public void clickToSignIn(){
        signInArea.click();
    }

    public void clickToCreateNewAccount(){
        createNewAccount.click();
    }

    public void clickToChooseGender(){
        gendeIdMale.click();
    }
    public void setInputFirstName(String firstName){
        inputFirstName.clear();
        inputFirstName.sendKeys(firstName);
    }
    public void setInputSecondName(String secondName){
        inputSecondName.clear();
        inputSecondName.sendKeys(secondName);
    }
    public void setInputEmail(String email){
        inputEmail.clear();
        inputEmail.sendKeys(email);
    }
    public void setInputPassword(String password){
        inputPassword.clear();
        inputPassword.sendKeys(password);
    }
    public void clickAgreeToTermsMarker(){
        agreeToTermsMarker.click();
    }

    public void clickDataPrivacyMarker(){
        dataPrivacyMarker.click();
    }
    public void clickLoginSaveButton(){
        loginSaveButton.click();
    }
    public String getMyUserName(){
       return myUserName.getText();
    }
    public void setLogOut(){
        logOut.click();
    }
    public void setLoginSubmitButton(){
        loginSubmitButton.click();
    }



}
