package lt.techin.vladimirm;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }
@FindBy(css = "input[name='s']")
    WebElement searchInputWindow;
    @FindBy(css = "h2 > a")
    WebElement chooseProduct;

    @FindBy(css = ".wishlist-button-product")
    WebElement addToWishList;

    @FindBy(css = ".modal-text")
    WebElement needToSignInMessage;

    @FindBy(css = ".show .btn-secondary")
    WebElement cancelToAddToWishList;

    @FindBy(css = "select[name='group[1]']")
    WebElement sizeSelectorDropdown;
    @FindBy(css = ".add-to-cart.btn.btn-primary")
    WebElement addToCartButton;
    @FindBy(css = "h4#myModalLabel")
    WebElement addedToCartConfirmMessage;
    @FindBy(css = ".modal-body .btn.btn-primary")
    WebElement checkOutButton;

    @FindBy(css = "[data-id_customization]")
    WebElement productLinkInCart;
    @FindBy(css=".cart-items .value")
    WebElement productSizeInCart;
    @FindBy (css = "strong")
    WebElement priceAfterDiscount;







    public void inputSearchData(String product){
        searchInputWindow.sendKeys(product);
        searchInputWindow.sendKeys(Keys.ENTER);

    }
    public boolean isProductDisplayed(){
        return chooseProduct.isDisplayed();
    }
    public String productName(){
        return chooseProduct.getText();
    }
    public void clickToOpenProductPage(){
        chooseProduct.click();
    }
    public void clickToAddToWishList(){
        addToWishList.click();
    }
    public boolean setNeedToSignInMessage(){
       return needToSignInMessage.isDisplayed();
    }
    public String warningMessage(){
        return needToSignInMessage.getText();
    }
    public void setCancelToAddToWishList(){
        cancelToAddToWishList.click();
    }
    public void selectSize(String size){
        Select dropdown = new Select(sizeSelectorDropdown);
        dropdown.selectByVisibleText(size);
    }
    public void clickAddToCartButton(){
        addToCartButton.click();
    }
    public boolean isAddedToKartMessageDisplayed(){
        return addedToCartConfirmMessage.isDisplayed();
    }
    public String confirmMessage(){
        return addedToCartConfirmMessage.getText();
    }
    public void clickToCheckOut(){
        checkOutButton.click();
    }
    public String getProductNameFromCart(){
        return productLinkInCart.getText();
    }
    public String getProductSizeFromCart(){
        return productSizeInCart.getText();
    }
    public double discountPrice(double price,double discount){
        double newPrice = price-((price * discount)/100);
        return newPrice;
    }
    public String getDiscountPageFromCart(){
        String getText = priceAfterDiscount.getText();
        return getText.replace("$","");
    }



}
