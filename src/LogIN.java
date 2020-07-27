import Utils.BaseDriver;
import Utils.Page_Factory;
import Utils.ReusableMethods;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public class LogIN extends BaseDriver{
    protected Page_Factory pageFactory;
    protected ReusableMethods reusableMethods;

    @BeforeMethod(alwaysRun = true)
    void goToWebsite() {
        String[] myInfo = new String[]{"Delik@gmail.com","Delik12345"};
        pageFactory = new Page_Factory( driver );
        reusableMethods = new ReusableMethods( wait,driver,js );
        driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS );
        driver.get( "http://automationpractice.com/index.php" );
        pageFactory.SighnIn_Button.click();
        waiters.urlContains( "authentication" );
        pageFactory.EmailSpot.sendKeys( myInfo[0] );
        pageFactory.PSWRD_Spot.sendKeys( myInfo[1] );
        pageFactory.SighIn.click();
        waiters.visibilityOf( pageFactory.My_Wishlists );
    }
}
