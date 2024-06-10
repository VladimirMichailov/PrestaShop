package lt.techin.vladimirm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginPageTest extends BaseTest{

@Test
void registerInToPage(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.clickToSignIn();
    loginPage.clickToCreateNewAccount();
    loginPage.clickToChooseGender();
    loginPage.setInputFirstName("Dartas");
    loginPage.setInputSecondName("Vaideris");
    loginPage.setInputEmail("darto.vaiderio@kosminis.lt");
    loginPage.setInputPassword("*DartasBlogas+");
    loginPage.clickAgreeToTermsMarker();
    loginPage.clickDataPrivacyMarker();
    loginPage.clickLoginSaveButton();
    Assertions.assertEquals("Dartas Vaideris",loginPage.getMyUserName(),"Vardai nesutampa");
    loginPage.setLogOut();
}

@Test
    void loginToAccount(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.clickToSignIn();
    loginPage.setInputEmail("darto.vaiderio@kosminis.lt");
    loginPage.setInputPassword("*DartasBlogas+");
    loginPage.setLoginSubmitButton();
    Assertions.assertEquals("Dartas Vaideris",loginPage.getMyUserName(),"Vardai nesutampa");


}


}
