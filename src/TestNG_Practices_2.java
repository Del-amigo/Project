import Utils.ReusableMethods;
import org.testng.annotations.Test;

public class TestNG_Practices_2 extends LogIN {

    @Test
    public void TestCase_02(){
        builder.moveToElement( pageFactory.Dresses ).click().perform();
        reusableMethods.ScrollAndClick(pageFactory.NameOfItems_Button);
        waiters.urlContains( "product" );
        pageFactory.wishlist_Button.click();
        waiters.textToBePresentInElement(pageFactory.AddPopup,"Added to your wishlist");
        pageFactory.closeButton.click();
        pageFactory.username_onTop.click();
        waiters.visibilityOf( pageFactory.My_Wishlists );
        pageFactory.My_Wishlists.click();
        waiters.urlContains("mywishlist");
        double quantityOfElements = ReusableMethods.converter( pageFactory.Quantity_Wishlist.getText() );
        softAssert.assertTrue( quantityOfElements==1 );
        reusableMethods.byText( "View","4" ).click();
        pageFactory.Small_delete_Button.click();
        reusableMethods.tryCatch("View","4");
        pageFactory.delete_Button.click();
        waiters.alert();
        driver.switchTo().alert().accept();
        reusableMethods.tryCatch( "1","9" ); //Deleting an element in a try/catch block**/
        softAssert.assertAll();
    }
}
