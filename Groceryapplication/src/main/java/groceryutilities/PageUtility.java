package groceryutilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void selectDragDropWithValue(WebElement element, String value) 
	{
		Select object = new Select(element);
		object.selectByValue(value);
	}
	
	public void selectByIndexValue(WebElement element, String value) 
	{
		Select object = new Select(element);
		object.selectByIndex(0);
	}
	
	public void selectByVisibleText(WebElement element, String value) 
	{
		Select object = new Select(element);
		object.selectByVisibleText(value);;
	}
	
	public void windowscrollByJavaScriptExector(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 350)", "");
	}
	
	public void clickByJavaScriptExector(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

}
