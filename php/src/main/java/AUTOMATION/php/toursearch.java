package AUTOMATION.php;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class toursearch extends launch {
	static By Tours=By.xpath("//a[@title='Tours']");
	//static By cookies=By.xpath("//*[@id=\"cookyGotItBtn\"]");
	static By search=By.xpath("//span[contains(text(),'Search by Listing or City Name')]");
	static By search1=By.xpath("//div[@id='s2id_autogen3']//a[@class='select2-choice select2-default']");
	static By search2=By.xpath("//*[@id=\"select2-drop\"]/ul/li[1]/ul/li[1]/div");
	static By departure=By.xpath("//div[@id='tchkin']//input[@placeholder='Check in']");
	static By guest=By.xpath("//select[@id='adults']");
	static By typetour=By.xpath("//select[@id='tourtype']");
	static By typetours=By.xpath("//option[contains(text(),'Couples')]");
	static By sea=By.xpath("//div[@class='col-md-2 form-group go-right col-xs-12 search-button']//button[@class='btn-primary btn btn-lg btn-block pfb0 loader'][contains(text(),'Search')]");

	public static void tourpage() throws InterruptedException {
		driver.findElement(Tours).click();
		//driver.findElement(cookies).click();
		Thread.sleep(1000);
		driver.findElement(search).click();
		driver.findElement(search1).sendKeys(prop.getProperty("Source"));
		driver.findElement(search1).sendKeys(Keys.DOWN);
		driver.findElement(search2).click();
		
		//date
		driver.findElement(departure).click();
		while(true)
		{
			String str1 = driver.findElement(By.xpath("//div[11]//div[1]//tr[1]//th[2]")).getText();
			if(str1.equals(prop.getProperty("tourMonth")))
			{
				break;
			}
			else {
				driver.findElement(By.xpath("//div[11]//div[1]//tr[1]//th[3]")).click();
			}
		}
		driver.findElement(By.xpath("//div[11]//tr//td[contains(text(),"+prop.getProperty("tday")+")]")).click();
		
		//guest
		 
		driver.findElement(guest).click();
		driver.findElement(By.xpath("//select[@id='adults']//option[4]")).click();
		
		//select
		driver.findElement(typetour).click();
		driver.findElement(typetours).click();
		
		//search button
		driver.findElement(sea).click();
	
	}
	

	public static void main(String[] args){
		
		
		try {
			Launchbrowser();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			tourpage();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("C:\\arpi\\tours"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
