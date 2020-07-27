package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    private WebDriverWait wait;
    private WebDriver driver;

    public Waiter(WebDriverWait wait, WebDriver driver) {
        this.wait = wait;
        this.driver = driver;
    }

    public void visibilityOf(WebElement webElement ){
      wait.until( ExpectedConditions.visibilityOf( webElement ) );
    }
    public void elementsMoreThan(By webElement, int number){
        wait.until( ExpectedConditions.numberOfElementsToBeMoreThan( webElement,number));
    }
    public void urlContains(String text){
        wait.until(ExpectedConditions.urlContains(text));
    }
    public void alert(){
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public void textToBePresentInElement(WebElement webElement,String text){
        wait.until( ExpectedConditions.textToBePresentInElement(webElement,text ));

    }
    }

