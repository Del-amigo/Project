package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class Page_Factory {
    protected WebDriver driver;

    public Page_Factory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(className = "login")
    public WebElement SighnIn_Button;

    @FindBy(id = "email")
    public WebElement EmailSpot;

    @FindBy(id = "passwd")
    public WebElement PSWRD_Spot;

    @FindBy(id = "SubmitLogin")
    public WebElement SighIn;

    @FindBy(id = "firstname")
    public WebElement firstName_Spot;

    @FindBy(id = "lastname")
    public WebElement lastName_Spot;

    @FindBy(id = "address1")
    public WebElement Address_Spot;

    @FindBy(id = "city")
    public WebElement City_spot;

    @FindBy(id = "postcode")
    public WebElement Zip_spot;

    @FindBy(id = "phone")
    public WebElement Phone_spot;

    @FindBy(id = "alias")
    public WebElement MYADRESS_TITLE_spot;

    @FindBy(id = "submitAddress")
    public WebElement SaveButton;

    @FindBy(id = "wishlist_button")
    public WebElement wishlist_Button;

    @FindBy(className = "icon-heart")
    public WebElement My_Wishlists;

    @FindBy(className = "icon-building")
    public WebElement My_Addresses;

    @FindBy(className = "fancybox-error")
    public WebElement AddPopup;

    @FindBy(className = "fancybox-close")
    public WebElement closeButton;

    @FindBy(className = "header_user_info")
    public WebElement username_onTop;

    @FindBy(className = "align_center")
    public WebElement Quantity_Wishlist;

    @FindBy(className = "icon-remove")
    public WebElement delete_Button;

    @FindBy(className = "icon-remove-sign")
    public WebElement Small_delete_Button;

    @FindBy(xpath = "//a[@class='product-name']")
    public List<WebElement> NameOfItems_Button;

    @FindBy(xpath = "(//a[@class='sf-with-ul'])[4]")
    public WebElement Dresses;
}
