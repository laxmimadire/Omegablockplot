package TestCases_PracticeSession;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class windowHandles extends BaseClassforPS{


	@Test
	public void windowHandleMethod()
	{

		
		
		driver.findElement(By.xpath("//*[@id=\"post-481\"]/div/ul[1]/li[2]/a")).click();
		String ParentWindow=driver.getWindowHandle();
		
		Set<String> allwind=driver.getWindowHandles();
		Iterator<String> itr=allwind.iterator();
		while(itr.hasNext())
		{
			String childWindow=itr.next();
			if(!ParentWindow.equalsIgnoreCase(childWindow))
			{
				driver.switchTo().window(childWindow);
				String Title=driver.getTitle();
				System.out.println("The Title of the Page is := " +Title);
				
				driver.close();
	            System.out.println("Child window closed");
			}
			
			/*else {
		
				driver.switchTo().window(ParentWindow);
				String parentTitle=driver.getTitle();
				System.out.println("The Title of the Page is := " +parentTitle);
				 System.out.println("Parent  window also closed");
			}	*/
			     
		}        
	
		
	}
}