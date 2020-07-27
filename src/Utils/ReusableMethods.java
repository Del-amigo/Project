package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;
import java.util.Random;

public class ReusableMethods {
    private WebDriverWait wait;
    private WebDriver driver;
    private JavascriptExecutor js;


    public ReusableMethods(WebDriverWait wait, WebDriver driver, JavascriptExecutor js) {
        this.wait = wait;
        this.driver = driver;
        this.js = js;
    }

    public void verifyAtLeastOneContainsText(List<WebElement> elements, String searchTerm) {
        Assert.assertFalse(elements.isEmpty(), "The list of elements is empty, cannot find searchTerm!");
        boolean found = elementIsFoundIn(elements, searchTerm);
        Assert.assertTrue(found, "The list doesn't contain any search term: " + searchTerm);
    }

    public void verifyOneContainsText(WebElement element, String searchTerm) {
        System.out.println( "Element Text: " + element.getText() );
        System.out.println( "Search Term: " + searchTerm );
        try {
            Assert.assertTrue( element.getText().contains( searchTerm.toLowerCase() ), "'" + element.getText() + "' does not contain '" + searchTerm + "'" );
        }catch (AssertionError assertionError){
            System.out.println(assertionError.getMessage());
        }
    }

    public void clearAndSendKeys(WebElement locator, String text) {
        locator.clear();
        locator.sendKeys(text);
    }

    public List<WebElement> waitAndGetList(By locator) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
        return driver.findElements(locator);
    }

    public void ScrollAndClick(List<WebElement> listOfItems) {
        js.executeScript( "window.scrollBy(0, 1000)" );
        int randomnum = new Random().nextInt( listOfItems.size()  );
        listOfItems.get( randomnum ).click();
    }

    public String randomNumber(int length) {
        String passwordSet = "123456789";
        return getRandomString(length, passwordSet);
    }

    public String randomWord(int length) {
        String passwordSet = "abcdefgijklmopqrstuvwxyz";
        return getRandomString(length, passwordSet);
    }

    private String getRandomString(int length, String possibleLetters) {
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * possibleLetters.length());
            password[i] = possibleLetters.charAt(rand);
        }
        return new String(password);
    }

    private boolean elementIsFoundIn(List<WebElement> elements, String searchTerm) {
        boolean found = false;
        for (WebElement element : elements) {
            String elementText = element.getText().toLowerCase();
            if (elementText.contains(searchTerm.toLowerCase())) {
                found = true;
                break;
            }
        }
        return found;
    }
    public void RandomSelectByIndex(By locator) {
        WebElement stateDropdown = driver.findElement(locator );
        Select select_One = new Select( stateDropdown );
        List<WebElement> stateList = select_One.getOptions();
        int i = new Random().nextInt( stateList.size() );
        select_One.selectByIndex( i );
    }

    public WebElement byText(String partOfText, String nthElement) {
        return driver.findElement( By.xpath( "(//*[contains(text(),'" + partOfText + "')])[" + nthElement + "]" ) );
    }
    public void tryCatch(String partOfText,String numOfElement) {
        try {
           if(byText( partOfText, numOfElement ).isDisplayed()) {
               System.out.println( "An Element is deleted, Successfully" );
           }
        }catch (Exception no){
            System.out.println(no.getMessage());
            System.out.println("An Element is NOT deleted!");
        }
    }
    public static double converter(String text) {
        return Double.parseDouble( text.replaceAll( "[^0-9]", "" ) );
    }
}
