package pages;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.github.javafaker.File;

public class BasePage {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions act;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		js = (JavascriptExecutor) driver;
		act = new Actions(driver);
	}

	public void fillText(WebElement el, String text) {
		highlightElement(el, "green");
		el.clear();
		el.sendKeys(text);
	}

	// key
	public void fillTextClearAllText(WebElement el, String text) {
		highlightElement(el, "green");
		el.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		el.sendKeys(text);
	}

	public void moveToNewTabs() {
		Keys.chord(Keys.CONTROL, "2");
	}

	public void click(WebElement el) {
		waiting(600);
		highlightElement(el, "orange");
		el.click();
	}

	public String getText(WebElement el) {
		highlightElement(el, "red");
		return el.getText();
	}

	public void selectByValue(WebElement el, String value) {
		Select s = new Select(el);
		s.selectByValue(value);
	}

	public void selectByVisibleText(WebElement el, String value) {
		Select s = new Select(el);
		s.selectByVisibleText(value);
	}
	
	// wait
	public void waitUntilElementToBeClickable(WebElement el) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}

	public void waitUntilElementToBeVisible(WebElement el) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}

	public void waitUntilElementToBeInVisible(WebElement el) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}

	public void waiting(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void highlightElement(WebElement element, String color) {
		// keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "background-color:yellow;border: 1px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change the style
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ newStyle + "');},0);", element);

		// Change the style back after few miliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);
	}

	// mouse
	public void mouseMoveToElement(WebElement el) {
		// Move mouse to element
		act.moveToElement(el).build().perform();
	}

	public void alertOk(String text) {
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
	}
	
}
