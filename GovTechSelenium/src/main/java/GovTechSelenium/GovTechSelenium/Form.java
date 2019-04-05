package GovTechSelenium.GovTechSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Form extends MainApp {
	@Test
	public static void form() throws InterruptedException, FindFailed {
		// TODO Auto-generated method stub
			Proposal prop = new Proposal();
			MainApp app= new MainApp();
			
			boolean clicked = true;
			System.out.println("the boolean value now is" + clicked);
			WebDriverWait wait = new WebDriverWait(driver,10);
			
			WebElement name = driver.findElement(By.id("react-contact_info-name"));
			wait.until(ExpectedConditions.visibilityOf(name));
			name.clear();
			name.sendKeys("Jermayne Chong");
			
			WebElement jobTitle=driver.findElement(By.id("react-contact_info-designation"));
			jobTitle.clear();
			jobTitle.sendKeys("Developer");
			
			
			WebElement contactNo=driver.findElement(By.id("react-contact_info-phone"));
			contactNo.clear();
			contactNo.sendKeys("123456789");
			
			
			WebElement email=driver.findElement(By.id("react-contact_info-primary_email"));
			email.clear();
			email.sendKeys("jerchong@hotmail.com");
			
			WebElement altEmail=driver.findElement(By.id("react-contact_info-secondary_email"));
			altEmail.clear();
			altEmail.sendKeys("jer2@gmail.com");
			
			WebElement postalCode = driver.findElement(By.id("react-contact_info-correspondence_address-postal"));
			postalCode.sendKeys("734683");
			Thread.sleep(1000);
			
			WebElement level=driver.findElement(By.id("react-contact_info-correspondence_address-level"));
			level.sendKeys("1");
			
			WebElement unit = driver.findElement(By.id("react-contact_info-correspondence_address-unit"));
			unit.sendKeys("01-12");
			
			WebElement buildingName = driver.findElement(By.id("react-contact_info-correspondence_address-building_name"));
			buildingName.sendKeys("Woodlands");
						
			WebElement checkbox = driver.findElement(By.id("react-contact_info-copied"));
			checkbox.click();
			
	
			WebElement nextButton = driver.findElement(By.id("next-btn"));
			nextButton.click();
			
			WebElement spinner = driver.findElement(By.xpath("//*[@id=\"js-app\"]"));

			
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[2]/div[3]")));
			
			app.loadingWait(spinner);
				prop.proposal();
			}
		
			
			//Assert.assertEquals("true",checkbox.getAttribute("checked"));
			
			
			
			
		}



   
			

		
		
		
		
		
	
	
	


