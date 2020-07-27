import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.List;

public class TestNG_Practices_1 extends LogIN {

    @Test()
    @Parameters({"FirstName", "LastName"})
    public void TestCase_01(String FirstName, String LastName){
        var webInfo = new String[]{"Del","Amigos",reusableMethods.randomNumber( 2 )};
        pageFactory.My_Addresses.click();
        reusableMethods.byText( "Add a new address", "1" ).click();
        waiters.urlContains( "address" );
        reusableMethods.clearAndSendKeys( pageFactory.firstName_Spot, webInfo[0] );
        reusableMethods.clearAndSendKeys( pageFactory.lastName_Spot, webInfo[1] );
        pageFactory.Address_Spot.sendKeys( reusableMethods.randomNumber( 4 ) + " Northeast Avenue" );
        pageFactory.City_spot.sendKeys( reusableMethods.randomWord( 6 ) );
        reusableMethods.RandomSelectByIndex( By.id( "id_state" ) );
        pageFactory.Zip_spot.sendKeys( reusableMethods.randomNumber( 5 ) );
        pageFactory.Phone_spot.sendKeys( reusableMethods.randomNumber( 10 ) );
        reusableMethods.clearAndSendKeys( pageFactory.MYADRESS_TITLE_spot,webInfo[2] );
        pageFactory.SaveButton.click();
        waiters.urlContains("addresses");
        reusableMethods.tryCatch(webInfo[2],"1");

        reusableMethods.byText( "Update","2" ).click();
        reusableMethods.clearAndSendKeys( pageFactory.firstName_Spot, FirstName );
        reusableMethods.clearAndSendKeys( pageFactory.lastName_Spot, LastName );
        pageFactory.SaveButton.click();

        waiters.urlContains("addresses");
        List<WebElement> elements = driver.findElements( By.cssSelector( ".row>.address" ) );
        for (int i = 0; i < elements.size(); i++) {
               softAssert.assertNotEquals(reusableMethods.byText(webInfo[0],"1"),FirstName);
               softAssert.assertNotEquals(reusableMethods.byText(webInfo[1],"1"),LastName);
        }

        reusableMethods.byText( "Delete","3" ).click();
        waiters.alert();
        driver.switchTo().alert().accept();
        reusableMethods.tryCatch( webInfo[2],"1" );
        softAssert.assertAll();
    }
}
