package GovTechSelenium.GovTechSelenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MainApp {
	public static WebDriver driver;
	@Test
	public static void launch(){
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\642124\\eclipse-workspace\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}

	
	public static void main(String[] args) throws InterruptedException, FindFailed {
		MainApp app= new MainApp();
		app.launch();
		 app.login();
		 
		 
	}
	@Test
	public static void login() throws InterruptedException, FindFailed {
		// TODO Auto-generated method stub
		
		//WebDriver driver = new ChromeDriver(); 
		//driver.manage().window().maximize();
		 driver.get("https://public:Let$BeC001@bgp-qa.gds-gov.tech");
		WebElement blueLogin = driver.findElement(By.id("login-button"));
		blueLogin.click();
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	//wait for 3 secs
		
		 WebDriverWait wait = new WebDriverWait(driver,30);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/form[1]/select")));
		
		Select loginDropdown = new Select(driver.findElement(By.xpath("/html/body/div[2]/form[1]/select")));
		
		loginDropdown.selectByVisibleText("S9111111A - 197702066M");

		WebElement login = driver.findElement(By.xpath("/html/body/div[2]/form[1]/button"));
		login.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grants']/div[2]/div/a[2]/section/div")));
		WebElement newGrant = driver.findElement(By.xpath("//*[@id='grants']/div[2]/div/a[2]/section/div"));
		newGrant.click();
			
		grant();
		
		
	}
	
	@Test
	public static void grant() throws InterruptedException, FindFailed {
		// TODO Auto-generated method stub
		MainApp app= new MainApp();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("item")));
List<WebElement> options = driver.findElements(By.className("itemname"));
		
		for(WebElement opt : options){
			String sectorName = opt.getText();
			
			if (sectorName.equals("Building & Construction")){
				opt.click();
				
				WebElement buldConst = driver.findElement(By.xpath("//*[@id='grant-wizard']/div[1]/div/div[3]/div[1]/div/div/ul/li[1]/div/label/div/div"));
				buldConst.click();
				break;
		}
		
	}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grant-wizard']/div[1]/div/div/div[2]/div/label/div/div")));
		
		WebElement selectGrant = driver.findElement(By.xpath("//*[@id='grant-wizard']/div[1]/div/div/div[2]/div/label/div/div"));
		
		selectGrant.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);	//wait for 1 secs
		List<WebElement> items = driver.findElements(By.className("itemname"));
		
		for(WebElement item: items){
			String itemName = item.getText();
			if (itemName.equals("Pre-scoped Productivity Solutions")){
				
				item.click();
				break;
			}
			
			
		}
		
		
		
		
Thread.sleep(2000);
		
		WebElement applyButton = driver.findElement(By.id("go-to-grant"));
		applyButton.click();
		
		Thread.sleep(2000);
		
		WebElement proceedButton = driver.findElement(By.id("keyPage-form-button"));
		
		proceedButton.click();
		
		eligibility();
		

}		//end grant
	@Test
	public static void eligibility() throws InterruptedException, FindFailed {
		// TODO Auto-generated method stub
		boolean clicked =true;
		Proposal prop = new Proposal();
		Form form = new Form();
		MainApp app= new MainApp();
		Thread.sleep(2000);
	
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='radio'][value='false']")));
		WebElement noRadioButton = driver.findElement(By.cssSelector("input[type='radio'][value='false']"));
		
		
		noRadioButton.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);	//wait for 1 secs
		if (noRadioButton.isSelected()){
			WebElement adv = driver.findElement(By.xpath("//*[@id='js-app']/div/div/div[2]/div[2]/div/div/div[1]/span/div/span/a"));
			adv.click();
			
			Thread.sleep(2000);
			
			
			Set<String> allWindows = driver.getWindowHandles();

			List<String> stringsList = new ArrayList(allWindows);
			driver.switchTo().window(stringsList.get(1));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			System.out.println(driver.getTitle());
			
			if(driver.getTitle().equalsIgnoreCase("Untitled")) {
				
				driver.switchTo().window(stringsList.get(0));
			}
			String url = driver.getCurrentUrl();
			
			driver.switchTo().window(stringsList.get(0));
			
			//Assert.assertNotEquals(url, "https://www.smeportal.sg/content/smeportal/en/moneymatters.html");
			
		
		
			//test here
			
			if (clicked==true) {
				
				WebElement saveButton = driver.findElement(By.id("save-btn"));
				saveButton.click();
				
				Thread.sleep(2000);
				
				goBackToHome(clicked);
				
				WebElement proceedButton = driver.findElement(By.xpath("//*[@id='keyPage-form-button']"));
				proceedButton.click();
				
				Thread.sleep(5000);
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='radio'][value='true']")));
				WebElement yesRadioButton = driver.findElement(By.cssSelector("input[type='radio'][value='true']"));
			
				Thread.sleep(1000);
				yesRadioButton.click();
					
					if (yesRadioButton.isSelected()){
						
						WebElement nextButton = driver.findElement(By.id("next-btn"));
						nextButton.click();
						WebElement spinner = driver.findElement(By.xpath("//*[@id=\"js-app\"]"));
						app.loadingWait(spinner);
						Form.form();
						
				}
			
			}//end else
			
		}	
		

		}
	

public void loadingWait(WebElement spinner) {
	// TODO Auto-generated method stub
	 WebDriverWait wait = new WebDriverWait(driver, 5000L);
	    wait.until(ExpectedConditions.visibilityOf(spinner)); // wait for loader to appear
	   
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	//wait for 3 secs
}

public static void goBackToHome(boolean clicked) throws FindFailed, InterruptedException {
	// TODO Auto-generated method stub
	
	MainApp app = new MainApp();
	WebDriverWait  wait = new WebDriverWait(driver,10);
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='bgp-navbar-collapse']/ul/li[1]/a")));
	WebElement myGrants =driver.findElement(By.xpath("//*[@id='bgp-navbar-collapse']/ul/li[1]/a"));
	
	Actions actions= new Actions(driver);
	actions.click(myGrants).build().perform();
	
	Thread.sleep(2000);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grants']/div[3]/section[1]/ul/li[2]/a")));
	
	WebElement drafts =driver.findElement(By.xpath("//*[@id='grants']/div[3]/section[1]/ul/li[2]/a"));
	drafts.click();
	
	//table
	
	WebElement table = driver.findElement(By.xpath("//*[@id='db-apps-drafts']/tbody"));//*[@id="db-apps-drafts"]/tbody
	//To locate rows of table. 
	List <WebElement> rows_table = table.findElements(By.tagName("tr"));
	//To calculate no of rows In table.
	int rows_count = rows_table.size();
	//Loop will execute till the last row of table.
	for (int row = 0; row < rows_count; row++) {
	    //To locate columns(cells) of that specific row.
	    List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
	    //To calculate no of columns (cells). In that specific row.
	    int columns_count = Columns_row.size();
	   
	    //Loop will execute till the last cell of that specific row.
	    for (int column = 0; column < columns_count; column++) {
	        // To retrieve text from that specific cell.
	        String celtext = Columns_row.get(column).getText();

	        if(row==0 && column==1 &&celtext.equalsIgnoreCase("untitled")) {
	        	
	        	WebElement found = driver.findElement(By.xpath("//*[@id='db-apps-drafts']/tbody/tr["+(row+1)+"]/td["+(column+1) +"]/a"));
	        	found.click();
	      
	        	return;
	        	
	  
	        }//end if
	        
	        
	    }//end for
	   
	}//end for
	

}

}
