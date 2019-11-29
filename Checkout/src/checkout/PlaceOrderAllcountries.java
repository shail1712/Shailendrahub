package checkout;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



public class PlaceOrderAllcountries extends Elements{
	
	static WebDriver webDriver;
	
	Logger logger = Logger.getLogger("UBUY");
	@Test//(retryAnalyzer=analyzer.RetryAnalyzer.class)
	public static void captureScreenMethod() throws Exception{
		
			/*System.setProperty("webdriver.chrome.driver", "D:\\SeleniumPrograms\\DataDrivenFramWork\\Lib\\chromedriver.exe");
			webDriver = new ChromeDriver();
			webDriver.manage().window().maximize();*/
			
			// Headless Browser
			System.setProperty("webdriver.chrome.driver", "D:\\SeleniumPrograms\\DataDrivenFramWork\\Lib\\chromedriver.exe");
			System.setProperty("webdriver.chrome.logfile", "D:\\SeleniumPrograms\\DataDrivenFramWork\\Lib\\chromedriver.txt");
			ChromeOptions op = new ChromeOptions();
			op.addArguments("window-size=1400,800");
			op.addArguments("headless");
			webDriver = new ChromeDriver(op);
			
		
			//D:\SeleniumPrograms\DataDrivenFramWork\FileReader\ReadURL.xlsx
			//FileInputStream file = new FileInputStream(new File("E:\\Latest WorkSpace\\SeleniumPrograms\\DataDrivenFramWork\\FileReader\\ReadURL.xlsx"));
			FileInputStream file = new FileInputStream(new File("D:\\SeleniumPrograms\\DataDrivenFramWork\\FileReader\\ReadURL.xlsx"));
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			for(int i=0; i<=sheet.getLastRowNum(); i++)
			//for(int i=0; i<=2; i++)
			{
				
				try{
			String url = sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println(url);
			webDriver.get(url);
			//System.out.println("test1");
			System.out.println("");
			
			String country = webDriver.findElement(By.xpath("//div[@class='dropdown country-selector']")).getText();
			
			//String textInBold = "Java_Prof_Level";
			//System.out.print("\033[0;1m" + country);
			System.out.printf("%100s\n", country);
			//System.out.println("\n" +BOLD+ country);

			
			//System.out.println(country);
			
			/*webDriver.findElement(By.xpath("//li[@class='carts_box cats_section']//a")).click();
			
			try {
				if(webDriver.findElement(By.xpath(".//*[@class='brand_cat_sku_seo']")).isEnabled())
				{
					webDriver.findElement(By.xpath(".//*[@class='brand_cat_sku_seo']")).click();
					System.out.println("Remove");
				}
				
				
				
			} catch (Exception e) {
					
			}*/
			
		
			WebElement element5 = (new WebDriverWait(webDriver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(search)));

			element5.sendKeys("laptop");
			System.out.println("Search Laptop");
			webDriver.findElement(By.xpath(clickonSaerchButton)).click();
			webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			webDriver.findElement(By.xpath(SelectProducts)).click();
			System.out.println("Select Products");
			Thread.sleep(2000);
			WebElement element1 = (new WebDriverWait(webDriver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(AddToCart)));
			element1.click();	
			String CurrentURL =webDriver.getCurrentUrl();
			System.out.println(CurrentURL);
			
			String productPrice =webDriver.findElement(By.xpath("//h3[@class='product-price']")).getText();
			System.out.println(productPrice);
			
			String sku = webDriver.findElement(By.xpath("//td[contains(text(),'ASIN')]")).getText();
			System.out.println(sku);
			System.out.println("Click on Add to cart button");
			String Parent_Window = webDriver.getWindowHandle();
			for (String Child_Window : webDriver.getWindowHandles())
			{		
			webDriver.switchTo().window(Child_Window); 
			webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement element = webDriver.findElement(By.xpath(PopUp));
			JavascriptExecutor executor = (JavascriptExecutor)webDriver;
			executor.executeScript("arguments[0].click();",element);
			}
			webDriver.switchTo().window(Parent_Window);
			System.out.println("Click on View cart & checkout");
			webDriver.findElement(By.xpath(ProceedToCheckOut)).click();
			System.out.println("Click on proceed to checkout button");
			webDriver.findElement(By.xpath(UserName)).sendKeys("shailendra.singh@ubuy.co.in");
			System.out.println("Enter USerName");
			webDriver.findElement(By.xpath(Password)).sendKeys("testing123");
			System.out.println("Enter PAssword");
			webDriver.findElement(By.xpath(LoginButton)).click();
			System.out.println("Click on Login Button");
			Thread.sleep(4000);
			webDriver.findElement(By.xpath(NewAdress)).click();
			System.out.println("Select New Address Radio button");
			webDriver.findElement(By.xpath(FirstNAme)).sendKeys("shailendra");
			System.out.println("Enter First name");
			webDriver.findElement(By.xpath(LAstName)).sendKeys("singh");
			System.out.println("Enter Last Name");
			webDriver.findElement(By.xpath(TelephoneNumber)).sendKeys("1234567802");
			String stee =webDriver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[2]/div[2]/div[2]/div[1]/form[1]/fieldset[1]/div[3]/div[3]/span[1]")).getText();
			System.out.println("Telephone code is "+stee);
			System.out.println("Enter Telephone number");
			
			
			String billingregion =State;
			String billingcity=state1;
			Boolean is_billingcity = false;
			WebElement ele1;
			try {
			ele1 = webDriver.findElement(By.xpath(billingregion));	
			} catch (Exception e) {
			ele1 = webDriver.findElement(By.xpath(billingcity));
			is_billingcity=true;	
			}
			if(ele1.isEnabled())
			{
			if(is_billingcity)
				{	
			Select city1 = new Select(ele1);
			city1.selectByIndex(3);
				}
			else {
					
			Select city2 = new Select(ele1);
			city2.selectByIndex(3);
				}
			}
			System.out.println("Select Billing City or Region");
			
			
			 String input_city = "//input[@id='billing:city']";
			 String select_city ="//select[@id='billing:city']";
			 
			 Boolean is_select= false;
			 WebElement ele ;
			 
			 try {
				  ele = webDriver.findElement(By.xpath(input_city));
				
			} catch (Exception e) {
				 ele = webDriver.findElement(By.xpath(select_city));
				is_select=true;
			}
	         if (ele.isEnabled())
	        	 
	         {
	 
	        	if (is_select)
	        	{
	        		Select cityfromdrop = new Select(ele);	
	         		cityfromdrop.selectByIndex(1);
	        	}
	        	
	        	
	        	else  {
	        		
	        		ele.sendKeys("2589566");
	        	}
	        	
	         }
			webDriver.findElement(By.xpath(House)).sendKeys("ElecTronicMarket");
			System.out.println("Enter Hosue");
			webDriver.findElement(By.xpath(Street)).sendKeys("Ridhi Sidhi");
			System.out.println("Enter Street Name");
			try {
				if(webDriver.findElement(By.xpath("//input[@id='billing:address_block']")).isEnabled())
				{
					webDriver.findElement(By.xpath("//input[@id='billing:address_block']")).sendKeys("T block");	
				}
				
			} catch (Exception e) {
				
			}
			try {
				if(webDriver.findElement(By.xpath("//input[@id='billing:address_appartment']")).isEnabled())
				{
					webDriver.findElement(By.xpath("//input[@id='billing:address_appartment']")).sendKeys("265");
					System.out.println("Enter Enter Apartment building name");
				}
				
				
				
			} catch (Exception e) {
					
			}
			
			
			
			try {
				if(webDriver.findElement(By.xpath("//input[@id='billing:address_avenue']")).isEnabled())
				{
					webDriver.findElement(By.xpath("//input[@id='billing:address_avenue']")).sendKeys("265");
					System.out.println("Enter Avenue Zones");
				}
				
				
				
			} catch (Exception e) {
					
			}
			
			System.out.println("Enter block");
			try {
				if(webDriver.findElement(By.xpath(Zip)).isEnabled())
				{
					webDriver.findElement(By.xpath(Zip)).sendKeys("5454545454");
					
				}
				
			} catch (Exception e) {	
			}
			
			System.out.println("Enter Zip Code");
			
		
			// South Africa Id number
			/*if(country=="South Africa")*/
			/*try {
				if(webDriver.findElement(By.xpath("//input[@id='billing:idnumber']")).isEnabled())
				{
					webDriver.findElement(By.xpath("//input[@id='billing:idnumber']")).sendKeys("2586932568965");
					System.out.println("enter Id Number");
				}
			
				
				
			} catch (Exception e) {
					
			}
			*/
			
			// Jordan ID number
			try {
				if(webDriver.findElement(By.xpath("//input[@id='billing:idnumber']")).isEnabled())
				{
					
					webDriver.findElement(By.xpath("//input[@id='billing:idnumber']")).sendKeys("1234567890");
					System.out.println("enter Id Number");
				}
				
			} catch (Exception e) {
				
			}
				webDriver.findElement(By.xpath(ContinueButton)).click();
				
				Thread.sleep(4000);
				System.out.println("Click on Continue button");
				webDriver.findElement(By.xpath(ShippingSelect)).click();
				System.out.println("Seletc Shipping method");
				webDriver.findElement(By.xpath(ContinueFromShipping)).click();
				System.out.println("Click on continue button from shipping method page");
				webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				WebElement element2 = webDriver.findElement(By.xpath("//*[@id='p_method_cybersecure' and @name='payment[method]']"));
				/*WebElement element2 = webDriver.findElement(By.xpath("//body/div/main/section[@class='container-lg']/div[@class='cell checkout']/div[@class='canvas']/"
					+ "div[@id='opc-payment']/div[@class='payment-information a-item']/div[@id='step-form-payment']/form[@id='co-payment-form']/fieldset/ul[@id='checkout-payment-method-load']/li[3]/label[1] "));*/
				JavascriptExecutor executor = (JavascriptExecutor)webDriver;
				executor.executeScript("arguments[0].click();",element2);
				System.out.println("Select Payment Method (Cyber-Source)");
				Select Card =new Select(webDriver.findElement(By.xpath(CardType)));
				Card.selectByIndex(2);
				//logger.info("Select card type ");
				webDriver.findElement(By.xpath(CardNumber)).sendKeys("5105105105105100");
				System.out.println("Enter Card Number");
				Select ExpiryDate = new Select(webDriver.findElement(By.xpath(ExpiryMonth)));
				ExpiryDate.selectByVisibleText("03 - March");
				System.out.println("Seletc Expiry Date");
				Select ExpiryDateYear = new Select(webDriver.findElement(By.xpath(ExpiryYear)));
				ExpiryDateYear.selectByVisibleText("2023");
				System.out.println("Select Expiry year" );
				webDriver.findElement(By.xpath(CardVerificationNumber)).sendKeys("123");
				System.out.println("Enter Cvv number");
				Thread.sleep(5000);
				webDriver.findElement(By.xpath(ContinueFromPaymentOption)).click();
				System.out.println("Click on Continue button from payment option page");
				webDriver.findElement(By.xpath(PlaceOrderFinal)).click();
				String st = webDriver.findElement(By.xpath(PlaceOrderFinal)).getText();
				Thread.sleep(5000);
				System.out.println("Click on"+st);
				System.out.println("-------------------------------------------------------");
				
			
			}
				catch(ElementNotVisibleException ignore)
				{
					ignore.printStackTrace();	
					
					
				}
				
			}
			

			
	}
			
	


	@AfterMethod
	public static  void screenShot(ITestResult result) throws Exception{
	
		
		if(ITestResult.FAILURE==result.getStatus()){
			try{
				
				
				String CurrentURL =webDriver.getCurrentUrl();
				System.out.println(CurrentURL);
	
					TakesScreenshot screenshot=(TakesScreenshot)webDriver;
					File file = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
					System.out.println("here 4");
					FileUtils.copyFile(file, new File("D:\\Headless\\headless_screenshot.png"));
					System.out.println("Successfully captured a screenshot");
					
					EmailAttachment attachment = new EmailAttachment();
					attachment.setPath("D:\\Headless\\headless_screenshot.png");
			     	attachment.setDisposition(EmailAttachment.ATTACHMENT);
				 	attachment.setDescription("Error");
				 	attachment.setName("ErrorImage");
				 
				  	EmailAttachment attachment1 = new EmailAttachment();
				  	attachment1.setPath("D:\\SeleniumPrograms\\DataDrivenFramWork\\Lib\\chromedriver.txt");
				  	attachment1.setDisposition(EmailAttachment.ATTACHMENT);
				  	attachment1.setDescription("Error");
				  	attachment1.setName("ErrorLog");
				  	EmailAttachment attachment2 = new EmailAttachment();
				  	attachment2.setPath("D:\\SeleniumPrograms\\DataDrivenFramWork\\test-output\\emailable-report.html");
				  	attachment2.setDisposition(EmailAttachment.ATTACHMENT);
				  	attachment2.setDescription("Error");
				  	attachment2.setName("ErrorLog");
				
				  	MultiPartEmail email = new MultiPartEmail();
				  	email.setHostName("smtp.gmail.com");
					email.setSmtpPort(465);
					email.setAuthenticator(new DefaultAuthenticator("Shailendra1707198912@gmail.com", "testing123ubuy"));
					email.setSSLOnConnect(true);
					email.setFrom("Shailendra1707198912@gmail.com");
					email.setSubject("Error in website");
					
					email.setMsg("If a test fails, we have got a mail with log and images"+ CurrentURL);
					email.addTo("shailendra.singh@ubuy.com");
					//email.addCc("ramesh.saini@ubuy.com");
					//email.addBcc("fahad.khan@ubuy.com");
					//email.addBcc("anuj.bansal@ubuy.com");
				//	email.addBcc("akhil@ubuy.com");
					email.attach(attachment);
					email.attach(attachment1);
					email.attach(attachment2);
					email.send();
					System.out.println("9");
					System.out.println("Mail sent succesfully");
					}
					catch (Exception e){
					System.out.println("Exception while taking screenshot "+e.getMessage());
					
					captureScreenMethod();
					} 
			
					}
					webDriver.quit();
					
					}
	
	
					}