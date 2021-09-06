package TestCases_PracticeSession;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class Omayoblogspot extends BaseClassforPS{

	@Test
	public void omayoElements() throws InterruptedException
	{
		/**
		 *  Multi Selection box
		 * 
		 **/
		//getting all the options in dropdown

		WebElement 	dropdown=driver.findElement(By.id("multiselect1"));

		Select list = new Select(dropdown);

		List<WebElement> dropdown_list = list.getOptions();

		for (int i = 0; i < dropdown_list.size(); i++) {

			String dropdown_value = dropdown_list.get(i).getText();

			System.out.println("dropdown values are " + dropdown_value);

		}
		System.out.println("*************************************************************************");
		Thread.sleep(3000);
		//selecting values by index

		list.selectByIndex(2);


		//getfirstselected option

		WebElement first=list.getFirstSelectedOption();
		String firsel=first.getText();
		System.out.println("THE SELECTED OPTION IS:=" +firsel);
		System.out.println("*************************************************************************");

		/**
		 * DropDown
		 * 
		 * **/
		WebElement dd=driver.findElement(By.id("drop1"));
		Select dropdown1=new Select(dd);
		List<WebElement> listoptions=dropdown1.getOptions();
		int size=listoptions.size();
		for(int j=0;j<size;j++)
		{
			String textoflist=listoptions.get(j).getText();
			System.out.println(textoflist);


		}
		System.out.println("*************************************************************************");
		Thread.sleep(3000);
		dropdown1.selectByVisibleText("doc 2");


		/**
		 * Click on link1
		 * 
		 * **/
		driver.findElement(By.id("link1")).click();
		Thread.sleep(3000);
		driver.navigate().back();

		/**
		 * Click on link2
		 * 
		 * **/
		driver.findElement(By.id("link2")).click();
		Thread.sleep(3000);
		driver.navigate().back();


		/**
		 * Text Box with Preloaded Text
		 * Get text and also clear text and reenter the text of TB
		 */

		String text=driver.findElement(By.id("textbox1")).getAttribute("value");
		System.out.println("The Text in the TEXTBOX is:="  +text);

		System.out.println("*************************************************************************"); 

		WebElement TB= driver.findElement(By.id("textbox1"));
		TB.clear();
		TB.sendKeys("Bhargavi");



		/**
		 * 
		 * Opening a window using link
		 * 
		 * **/

		driver.findElement(By.linkText("SeleniumTutorial")).click();
		String MainWindow=driver.getWindowHandle();
		Set<String> allwin=driver.getWindowHandles();
		Iterator<String> itr=allwin.iterator();
		while(itr.hasNext())
		{
			String ChildWindow=itr.next();
			if(!MainWindow.equals(ChildWindow))
			{
				driver.switchTo().window(ChildWindow);
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				TakesScreenshot ts=(TakesScreenshot)driver;
				File scr=ts.getScreenshotAs(OutputType.FILE);
				String tname="PageScreenshot";
				String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
				String repName= tname+ "-"+timeStamp+".png";
				File trg=new File(System.getProperty("user.dir")+ "/Screenshots/" +repName);
				try {
					FileUtils.copyFile(scr, trg);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				System.out.println("screenshot taken");
				System.out.println("*************************************************************************");
				driver.close();
			}

		}	
		driver.switchTo().window(MainWindow);

		/**
		 * Enabled Button
		 * 
		 * **/

		WebElement e=driver.findElement(By.xpath("//button[@id='but2']"));


		boolean actualValue = e.isEnabled();
		if (actualValue) {
			System.out.println("Button is enabled:=" +actualValue);
		}else {
			System.out.println("Button is disabled:=" +actualValue);
		}

		/**
		 * Disabled Button
		 * 
		 * **/

		System.out.println("*************************************************************************");
		WebElement e1=driver.findElement(By.xpath("//button[@id='but1']"));
		boolean actualValue1 = e1.isEnabled();



		if (actualValue1) {
			System.out.println("Button is enabled:=" +actualValue1);
		}else {
			System.out.println("Button is disabled:=" +actualValue1);

		}
		System.out.println("*************************************************************************");
		/**
		 * Disabled Text Box
		 * 
		 * **/
		Boolean Tbresult=driver.findElement(By.id("tb2")).isEnabled();
		if(Tbresult)
		{
			System.err.println("The TB is enabled:=" +Tbresult);
		}
		else {
			System.out.println("The TB is disabled:=" +Tbresult);
		}
		System.out.println("*************************************************************************");
		((JavascriptExecutor)driver).executeScript("document.getElementById('tb2').value='Hanmandlu'");



		List<WebElement> allele=driver.findElements(By.xpath("//*[@id=\"HTML26\"]/div[1]/ul/li"));


		/**
		 * 
		 * Buttons with same name attribute values
		 * generate a pop Up alert
		 * 
		 * **/

		List<WebElement> Buttons=driver.findElements(By.xpath("//*[@id='HTML10']/div[1]/button"));
		int sizeofbutton=Buttons.size();
		System.out.println("The Buttons are:=");

		for(int k=0;k<sizeofbutton;k++)
		{

			String btntext=Buttons.get(k).getText();
			System.out.println("       " +btntext);

		}

		System.out.println("*************************************************************************");	



		/**
		 * 
		 * Unordered List of items
		 * Sorting....
		 * **/

		List<WebElement> unorderlist=driver.findElements(By.xpath("//*[@id='HTML26']/div[1]/ul/li"));

		int listsum=unorderlist.size();
		System.out.println("After sorting the items in Arraylist:=");

		for(int l=0;l<listsum;l++) 
		{
			String textoflist=unorderlist.get(l).getText();


			/**   SORTING ELEMENTS**/

			List<String> allop=Arrays.asList(textoflist);
			allop.sort(String.CASE_INSENSITIVE_ORDER);
			allop.sort(Comparator.naturalOrder());
			System.out.println(allop);
		}
		System.out.println("*************************************************************************");

		driver.findElement(By.id("alert2")).click();
		Thread.sleep(2000);
		a=driver.switchTo().alert();
		a.accept();
		//logger.info("alert accepted........");

		/**
		 * 
		 * delayedText
		 * 
		 * **/

		WebElement textdis=driver.findElement(By.id("delayedText"));
		String texttobedis=textdis.getText();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElement(textdis, texttobedis));
		System.out.println(texttobedis);


		/**
		 * 
		 * Upload File
		 * 
		 * **/
		WebElement upload=	driver.findElement(By.id("uploadfile"));
		upload.sendKeys("C:/Users/HOME/Desktop/selenium-java-3.141.59/Selenium/interviewQA.txt");
		System.out.println("The file is successfully uploaded....");

		System.out.println("*************************************************************************");

		/**
		 * 
		 * //button[contains(text(),'Double click Here')]
		 * **/

		Actions ac=new Actions(driver);
		WebElement doubleclickbtn=driver.findElement(By.xpath("//button[contains(text(),'Double click Here')]"));
		ac.moveToElement(doubleclickbtn).doubleClick().perform();
		Thread.sleep(3000);
		a=driver.switchTo().alert();
		a.accept();

		System.out.println("alert accepted after double click..........");

		driver.findElement(By.xpath("//button[contains(text(),'Check this')]")).click();
		Thread.sleep(10000);

		WebElement option1=driver.findElement(By.id("dte"));


		boolean res=option1.isEnabled();

		System.out.println(res);


		option1.click();			

		System.out.println("Checkbox is selected" +option1.isSelected());		


		System.out.println("**********************************************************************************");
		/**
		 * 
		 * Text Area
		 * 
		 * **/
		WebElement textbox=driver.findElement(By.id("ta1"));
		textbox.sendKeys("Selenium is a portable framework for testing web applications. Selenium provides a playback tool for authoring functional tests without the need to learn a test scripting language.");

		/**
		 * WebTable content
		 * 
		 * **/

		List<WebElement> tabledata=driver.findElements(By.xpath("//tbody/tr/td"));

		//data from 1st row and 1st collumn

		String td=driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
		System.out.println(td);




		/**
		 * HTML form
		 * 
		 * **/

		driver.findElement(By.xpath("//*[@id=\"HTML31\"]/div[1]/form/input[1]")).sendKeys("msg2klavanya@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"HTML31\"]/div[1]/form/input[2]")).sendKeys("classeight2018");
		element=driver.findElement(By.xpath("//button[contains(text(),'LogIn')]"));
		element.click();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid green'", element);


		/**
		 * Simple Login 
		 * 
		 * **/	
		driver.findElement(By.name("userid")).sendKeys("msg2klavanya@gmail.com");
		driver.findElement(By.name("pswrd")).sendKeys("classeight2018");
		element=driver.findElement(By.xpath("//*[@id=\"HTML42\"]/div[1]/form/input[3]"));
		element.click();
		a=driver.switchTo().alert();
		a.accept();


		/**
		 * 
		 * Radio Buttons
		 * 
		 * **/
		WebElement Radiobuttons=driver.findElement(By.xpath("//*[@id=\"HTML15\"]/div[1]/input"));
		WebElement male=driver.findElement(By.id("radio1"));
		WebElement female=driver.findElement(By.id("radio2"));
		if(Radiobuttons.equals(female))
		{
			male.click();

		}
		else {
			female.click();
		}

		/**
		 * 
		 * ReadOnly TB
		 * 
		 * **/

		String TBText=driver.findElement(By.id("rotb")).getAttribute("value");
		System.out.println("The Readable Text on the TB:= " +TBText);
		System.out.println("***********************************************************************");






		/**
		 * 
		 * AJAX CALLS HANDLING
		 * 
		 * **/

		driver.findElement(By.xpath("//button[contains(text(),'Dropdown')]")).click();
		
		WebDriverWait wait2=new WebDriverWait(driver, 30);
		WebElement facebooklink=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Facebook')]")));
		facebooklink.click();
		driver.navigate().back();
		


		/**
		 * Double click
		 * 
		 * 
		 * **/

		WebElement doubleclick=driver.findElement(By.id("testdoubleclick"));
		Actions doubleac=new Actions(driver);
		doubleac.doubleClick(doubleclick).perform();
		WebElement doublicklink=driver.findElement(By.linkText("Gmail"));
		String clicklink = Keys.chord(Keys.CONTROL,Keys.ENTER);
		doublicklink.sendKeys(clicklink);
		String linktitle=doublicklink.getAttribute("Title");
		System.out.println("The title:= "+linktitle);
		driver.close();

	}

}
