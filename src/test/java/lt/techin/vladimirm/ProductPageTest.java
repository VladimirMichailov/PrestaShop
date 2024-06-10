package lt.techin.vladimirm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class ProductPageTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/products.csv", numLinesToSkip = 1)
    void searchAndAddItems(String product,double price,double discount,String size) throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        productPage.inputSearchData(product);
        Assertions.assertTrue(productPage.isProductDisplayed());
        Assertions.assertEquals(product.toLowerCase(), productPage.productName().toLowerCase(), "Pavadinimai nesutampa");
        productPage.clickToOpenProductPage();
        productPage.clickToAddToWishList();
        Assertions.assertTrue(productPage.setNeedToSignInMessage());
        Assertions.assertEquals("You need to be logged in to save products in your wishlist.", productPage.warningMessage(), "Praneimai nesutampą");
        productPage.setCancelToAddToWishList();
        productPage.selectSize(size);
        productPage.clickAddToCartButton();
        Thread.sleep(2000);
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assertions.assertTrue(productPage.isAddedToKartMessageDisplayed());
        Assertions.assertTrue(productPage.confirmMessage().contains("Product successfully added to your shopping cart"),"Pranešimai nesutampa");
        productPage.clickToCheckOut();
        Assertions.assertEquals(product.toLowerCase(), productPage.getProductNameFromCart().toLowerCase(), "Pavadinimai nesutampa");
        Assertions.assertEquals(size.toLowerCase(), productPage.getProductSizeFromCart().toLowerCase(), "Pavadinimai nesutampa");
        Assertions.assertEquals(String.format(Locale.US,"%.2f",productPage.discountPrice(price, discount)),productPage.getDiscountPageFromCart(),"Reikšmes nesutampa");

    }


}
