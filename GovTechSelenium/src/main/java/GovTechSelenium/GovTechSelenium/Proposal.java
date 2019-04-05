package GovTechSelenium.GovTechSelenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class Proposal extends MainApp {
	@Test
	public void proposal() throws InterruptedException, FindFailed {
		Thread.sleep(2000);
		// TODO Auto-generated method stub
		MainApp app= new MainApp();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-project-psg_category_id-ekZJg2e7dT1YBT8LtbjL42RS")));
		WebElement equipmentRadio = driver.findElement(By.id("react-project-psg_category_id-ekZJg2e7dT1YBT8LtbjL42RS"));
	
		WebElement itRadio = driver.findElement(By.id("react-project-psg_category_id-HJfTcAoAFJW2B9A6oqe297Ls"));
		
		
		equipmentRadio.click();
		
		
		if (equipmentRadio.isSelected()){
			
			WebElement searchBox = driver.findElement(By.xpath("//*[@id='react-select-project-psg_solution_id--value']/div[1]"));
			
			Actions action = new Actions(driver);
			searchBox.click();
		
			
			//action.click(searchBox);
			driver.switchTo().activeElement().sendKeys("Wire Saw" + Keys.RETURN);

			
			WebElement noUnits= driver.findElement(By.id("react-project-no_of_units"));
			noUnits.sendKeys("3");
			
			commonFields();
			
			WebElement projRefNo= driver.findElement(By.id("react-project-locations-0-project_ref_num"));
			projRefNo.sendKeys("A1234-000001-2011");
			
			WebElement projAddr= driver.findElement(By.id("react-project-locations-0-text_address"));
			projAddr.sendKeys("12345ref address");
			
			WebElement cost= driver.findElement(By.id("react-project-locations-0-estimated_cost"));
			cost.sendKeys("100");
			WebElement contractorYes= driver.findElement(By.id("react-project-locations-0-main_contractor_check-true"));
			contractorYes.click();
			
			
			WebElement nextButton = driver.findElement(By.id("next-btn"));
			nextButton.click();
			
			WebElement spinner = driver.findElement(By.xpath("//*[@id=\"js-app\"]"));
			app.loadingWait(spinner);
			
			cost();
			
		}
	}//end proposal
	@Test
	private static void commonFields() throws FindFailed, InterruptedException {
		// TODO Auto-generated method stub
		WebElement datePicker= driver.findElement(By.id("react-project-start_date"));
		
		String pattern = "dd MMM yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		datePicker.sendKeys(date);
		

		WebElement eqYes= driver.findElement(By.id("react-project-engaged_status-true"));
		eqYes.click();
		

		WebElement eqNo= driver.findElement(By.id("react-project-engaged_status-false"));
		eqNo.click();
		
		String reason ="e.g. To reduce the number of workers that are needed to do the job";
		WebElement reasonTextArea= driver.findElement(By.id("react-project-reason_for_engagement"));
		reasonTextArea.sendKeys(reason);
		
		WebElement singRadio = driver.findElement(By.id("react-project-vendors-0-local_vendor-true"));
		singRadio.click();
		WebElement vendorName= driver.findElement(By.id("react-project-vendors-0-name"));
		vendorName.sendKeys("vendor");
		
		WebElement vendorTextArea= driver.findElement(By.id("react-project-vendors-0-vendor_reason"));
		vendorTextArea.sendKeys("whatever reason");
		
		WebElement vendorEquip= driver.findElement(By.id("react-project-vendors-0-vendor_products"));
		vendorEquip.sendKeys("whatever eq desc");
		 
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	//wait for 3 secs
		//handle upload 
		WebElement uploadButton= driver.findElement(By.id("react-project-vendors-0-attachments-btn"));
		uploadButton.click();
		
		
		Thread.sleep(2000);
		Screen s = new Screen();
		 s.type(null,"C:\\Users\\642124\\Documents\\testExcel.xlsx", 0);


		 s.type(Key.ENTER);
		Thread.sleep(2000);
		 WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='react-select-project-vendors-0-attachments-0-document_type-types--value']/div[1]")));
		 WebElement tagDoc = driver.findElement(By.xpath("//*[@id='react-select-project-vendors-0-attachments-0-document_type-types--value']/div[1]"));
		
				 tagDoc.click();
				 
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div[contains(text(),'Other supporting documents')]")));
			
			WebElement tagDocText = driver.findElement(By.xpath("//*/div[contains(text(),'Other supporting documents')]"));
		
			tagDocText.click();
			
			Actions action = new Actions(driver);
			WebElement tagLabel = driver.findElement(By.xpath("//*[@id='react-project-vendors-0-attachments-0-document_type-types-label']"));
			action.moveToElement(tagLabel).click();
			
			Thread.sleep(1000);
			WebElement remarks = driver.findElement(By.id("react-project-vendors-0-quote_remarks"));
			remarks.sendKeys("any remarks");
			
			
			
			//handle upload
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-project-locations-0-attachments-btn")));
			WebElement locUploadButton= driver.findElement(By.id("react-project-locations-0-attachments-btn"));
			locUploadButton.click();
			
			Thread.sleep(2000);
			 s.type(null,"C:\\Users\\642124\\Documents\\testExcel.xlsx", 0);
			 s.type(Key.ENTER);
			 Thread.sleep(2000);
			 
			 //2nd tag doc
			 
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='react-select-project-locations-0-attachments-0-document_type-types--value']/div[1]")));
			 WebElement tagDoc2 = driver.findElement(By.xpath("//*[@id='react-select-project-locations-0-attachments-0-document_type-types--value']/div[1]"));
			
					 tagDoc2.click();
					 
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div[contains(text(),'Letter of Award')]")));
				
				WebElement tagDoc2Text = driver.findElement(By.xpath("//*/div[contains(text(),'Letter of Award')]"));
				tagDoc2Text.click();
				
				WebElement tagLabel2 = driver.findElement(By.xpath("//*[@id='react-project-locations-0-attachments-0-document_type-types-label']"));
				action.moveToElement(tagLabel2).click();
				
		
	}//end commonField
	@Test
	private static void cost() throws InterruptedException {
		// TODO Auto-generated method stub
		MainApp app= new MainApp();
		
		Thread.sleep(1000);
		 WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='react-select-project_cost-psg_payment_mode_id--value']/div[1]")));
		WebElement purchaseBox = driver.findElement(By.xpath("//*[@id='react-select-project_cost-psg_payment_mode_id--value']/div[1]"));
		
		Actions action = new Actions(driver);
		
		purchaseBox.click();
		
		WebElement purchaseBoxText = driver.findElement(By.xpath("//*/div[contains(text(),'Direct')]"));
	
		purchaseBoxText.click();
		
		WebElement costBillCurr = driver.findElement(By.id("react-project_cost-cost_in_billing_currency"));
		costBillCurr.sendKeys("200");
		
		WebElement costOTBillCurr = driver.findElement(By.id("react-project_cost-ot_cost_in_billing_currency"));
		costOTBillCurr.sendKeys("300");
		
		WebElement nextButton = driver.findElement(By.id("next-btn"));
		nextButton.click();
		
		WebElement spinner = driver.findElement(By.xpath("//*[@id=\"js-app\"]"));
	
		app.loadingWait(spinner);
		
		businessImpact();
	}
	@Test
	public static void businessImpact() throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-project_impact-impact_description")));
		
		WebElement impDesc= driver.findElement(By.id("react-project_impact-impact_description"));
		impDesc.sendKeys("some description");
		
		WebElement impTaskDesc= driver.findElement(By.id("react-project_impact-task_description"));
		impTaskDesc.sendKeys("some impact task description");
		
		WebElement measUnit= driver.findElement(By.id("react-project_impact-task_unit"));
		measUnit.sendKeys("km");
		WebElement unitDoneNow= driver.findElement(By.id("react-project_impact-task_now"));
		unitDoneNow.sendKeys("10");
		
		WebElement unitDoneEq= driver.findElement(By.id("react-project_impact-task_after"));
		unitDoneEq.sendKeys("20");
		

		WebElement workersNow = driver.findElement(By.id("react-project_impact-task_no_workers_now"));
		workersNow.sendKeys("5");
		
		WebElement workersAfter = driver.findElement(By.id("react-project_impact-task_no_workers_after"));
		workersAfter.sendKeys("7");
		

		WebElement manDaysNow = driver.findElement(By.id("react-project_impact-task_no_man_days_now"));
		manDaysNow.sendKeys("5");
		
		WebElement manDaysAfter = driver.findElement(By.id("react-project_impact-task_no_man_days_after"));
		manDaysAfter.sendKeys("7");
		
		WebElement nextButton = driver.findElement(By.id("next-btn"));
		nextButton.click();
		
		review();

		
	}
	@Test
	public static void review() {
		// TODO Auto-generated method stub
		MainApp app = new MainApp();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-declaration-criminal_liability_check-false")));
		
		WebElement crimCheckbox= driver.findElement(By.id("react-declaration-criminal_liability_check-false"));
		crimCheckbox.click();
		
		WebElement suitCheckbox= driver.findElement(By.id("react-declaration-civil_proceeding_check-false"));
		suitCheckbox.click();
		WebElement insolCheckbox= driver.findElement(By.id("react-declaration-insolvency_proceeding_check-false"));
		insolCheckbox.click();
		
		WebElement forthCheckbox= driver.findElement(By.id("react-declaration-project_incentives_check-false"));
		forthCheckbox.click();
		
		WebElement fifthCheckbox= driver.findElement(By.id("react-declaration-project_commence_check-false"));
		fifthCheckbox.click();
		
		WebElement sixthCheckbox= driver.findElement(By.id("react-declaration-related_party_check-false"));
		sixthCheckbox.click();
		
		WebElement seventhCheckbox= driver.findElement(By.id("react-declaration-defray_cost_check-false"));
		seventhCheckbox.click();
		
		
		
		WebElement ackCheckbox= driver.findElement(By.id("react-declaration-consent_acknowledgement_check"));
		ackCheckbox.click();
		

		WebElement reviewButton = driver.findElement(By.id("review-btn"));
		reviewButton.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"js-app\"]")));
		
		WebElement spinner = driver.findElement(By.xpath("//*[@id=\"js-app\"]"));
		app.loadingWait(spinner);
		
	}
}
