package TestCases_PracticeSession;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class Javascriptsample extends BaseClassforPS {
	 
	@Test(priority=0)
	public void javaScriptImple()
	{
		//Scrolling a page
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	@Test(priority=1)
	public void scrollUntilElefind()
	{
		element=driver.findElement(By.xpath("/html/body/footer/div/div[1]/div/ul/li[2]/a/img"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

}
