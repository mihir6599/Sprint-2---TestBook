package pages;

import java.io.File;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import base.testBook_Base;

public class login extends testBook_Base{
	
	///////////////////////     Login     ///////////////////////
	static @FindBy(xpath="//a[text()='Login']") WebElement login_button;
	static @FindBy(id = "loginUsername") WebElement email_field;
	static @FindBy(xpath = "//button[@ng-click='proceedToLogin(user)']") WebElement next_button;
	static @FindBy(name = "pswd") WebElement password_field;
	static @FindBy(xpath = "//button[text()='Login']") WebElement user_login_button;
	@FindBy(id = "onBoardingIframe") WebElement login_frame;
	static @FindBy(xpath="//li[@class='dropdown-item ng-scope'])[8]/a") WebElement logout;
	
	
	///////////////////////     .....     ///////////////////////
	static @FindBy(xpath="//div[@data-error = 'Please enter a valid email or mobile']") WebElement error;
	static @FindBy(xpath="//svg[@class = 'pass-show']") WebElement edit;
	
	
	///////////////////////     Get Pass     ///////////////////////
	static @FindBy(xpath="//a[text()='Get Pass']") WebElement get_pass;
	static @FindBy(xpath="//div[@class = 'passes-container']/div[1]") WebElement pass_1;
	static @FindBy(xpath="//div[@class = 'passes-container']/div[2]") WebElement pass_2;
	static @FindBy(xpath="//div[@class = 'passes-container']/div[3]") WebElement pass_3;
	
	///////////////////////     Card     ///////////////////////
	@FindBy(xpath="//div[text()='Card']") WebElement card;
	@FindBy(id="card_number") WebElement cardno;
	@FindBy(id="card_expiry") WebElement expiry;
	@FindBy(id="card_cvv") WebElement cvv;
	@FindBy(id="footer-cta") WebElement pay;
	static @FindBy(name = "card[number]") WebElement card_no;
	@FindBy(xpath="//iframe[@class='razorpay-checkout-frame']") WebElement paymentframe;
	
	///////////////////////     Live Classes     ///////////////////////
	static @FindBy(xpath="//a[text()=' Free Live Classes ']") WebElement free_live_classes;
	static @FindBy(xpath="//div[@class = 'video-lessons-body']/a[1]") WebElement live_1;
	static @FindBy(xpath="//div[text()='Classes']") WebElement classes;
	static @FindBy(xpath="//div[@class = 'tab-btns']/div[2]") WebElement classes_qa;
	static @FindBy(xpath="//div[@class = 'pav-repeat grill-pav-repeat']/div[2]") WebElement live_qa_1;
	static @FindBy(xpath="//div[@class = 'pav-repeat grill-pav-repeat']/div[3]") WebElement live_qa_2;
	static @FindBy(xpath="//div[@class = 'pav-repeat grill-pav-repeat']/div[4]") WebElement live_qa_3;
	static @FindBy(xpath="//div[@class = 'class-card-body h-auto']/h1") WebElement live_name;
	static @FindBy(xpath = "//button[text()='Skip Saved Cards']") WebElement skip_card;
	static @FindBy(xpath = "//button[@id='otp-sec']") WebElement skip_saving_card;
	
	static @FindBy(xpath="//div[@id = 'positiveBtn']") WebElement cancel_payment;
	static @FindBy(xpath="//div[@id = 'modal-close']") WebElement close;
	static @FindBy(xpath="//button[@id = 'fd-hide']") WebElement retry;
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	public login() {
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void openurl() throws Exception{
		driver.get(prop.getProperty("url"));
		System.out.println("User is on Testbook Website.");
		Thread.sleep(20000);
		new Actions(driver).moveToElement(login_button).moveByOffset(30, 30).click().perform();
		System.out.println("Pop up Disabled");
		//System.out.println(driver.switchTo().alert().getText()); 
	}
	
	public void click_login() throws Exception {
		//Thread.sleep(3000);
		login_button.click();
		System.out.println("User is on login page.");
		Thread.sleep(1000);
		try{driver.switchTo().frame(login_frame);}
		catch(Exception e) {}
		
	}
	public void enter_email(String email) throws Exception {
		Thread.sleep(3000);
		email_field.isDisplayed();
		email_field.clear();
		email_field.sendKeys(email);
		Thread.sleep(1000);
		next_button.click();
		System.out.println("User enters email - " + email);
		Thread.sleep(1000);
		//driver.findElement(By.xpath("(//button[text()='Login']")).click();
		//if(driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed()) {
	}
	
	public void enter_password(String password) throws Exception  {
		password_field.sendKeys(password);
		//wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pswd"))));
		user_login_button.click();
		System.out.println("User enters password - " + password);
		Thread.sleep(10000);
		new Actions(driver).click().perform();
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("(//img[@class='circle-img'])[2]")).click();
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("(//li[@class='dropdown-item ng-scope'])[5]/a")).click();
		//System.out.println("clicked");
		//Thread.sleep(2000);
		//driver.quit();//close if any/all browsers which are open
		
	}
	

	public void logout() throws Exception  {
		driver.switchTo().parentFrame();
	    //driver.switchTo().defaultContent();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@class='circle-img'])[2]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//li[@class='dropdown-item ng-scope'])[8]/a")).click();
		System.out.println("Logout");
		Thread.sleep(2000);
		driver.quit();//close if any/all browsers which are open
				
	}
	
	
	public void click_live_classes() throws Exception  {
		Thread.sleep(1000);
		//free_live_classes.click();
		classes_qa.click();
		System.out.println("User clicked on free live classes");
		Thread.sleep(2000);
		live_qa_1.click();
	}
	
	public void click_get_pass() throws Exception {
		
		try {wait.until(ExpectedConditions.elementToBeSelected(get_pass));}
		catch (Exception e) {}
		
		get_pass.click();
		System.out.println("Clicked on Get Pass");
		validate_get_pass();
		try {wait.until(ExpectedConditions.elementToBeSelected(pass_1));}
		catch (Exception e) {}
		//wait.until(ExpectedConditions.visibilityOfElementLocated(pass_1));
		pass_1.click();
		System.out.println("Pass selected");
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("(//button[text()='Login']")).click();
		//if(driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed()) {
	}
	
	public void card_payment() throws Exception {
		//try {wait.until(ExpectedConditions.elementToBeSelected(get_pass));}
		//catch (Exception e) {}
		Thread.sleep(3000);
		try{driver.switchTo().frame(paymentframe);}
		catch(Exception e) {}
		//driver.switchTo().frame(paymentframe);
		//driver.switchTo().frame(payment_frame);
		card.click();
		System.out.println("Card Payment selected");
		skip_card.click();
		Thread.sleep(2000);
		//card_no.sendKeys("4375510167960019");
		
		 File file=new File("C:\\Demo\\testbook_sprint2.xlsx");
		 FileInputStream fin=new FileInputStream(file);
		 XSSFWorkbook wb = new XSSFWorkbook(fin);
		 XSSFSheet ws = wb.getSheet("Sheet1");
		 Row row;
		 for (int r=1;r<=ws.getLastRowNum();r++)
		 {
			 row=ws.getRow(r);
			 cardno.click();
			 cardno.sendKeys(row.getCell(0).getStringCellValue());
			 expiry.click();	
			 expiry.sendKeys(row.getCell(1).getStringCellValue());
			 cvv.click();
			 cvv.sendKeys(row.getCell(2).getStringCellValue());	
			 Thread.sleep(5000);
			 pay.click();	
		 }
			//fin.close();
		wb.close();
		//cardno.clear();
		//expiry.clear();
		//cvv.clear();
		skip_saving_card.click();
		Thread.sleep(5000);
		//new Actions(driver).click().perform();
		//Thread.sleep(1000);
		//cancel_payment.click();
	}
	
	public void cancel_payment() throws Exception {
		new Actions(driver).click().perform();
		Thread.sleep(1000);
		cancel_payment.click();
		new Actions(driver).click().perform();
		Thread.sleep(1000);
		retry.click();
		Thread.sleep(1000);
		close.click();
	}
	
	public void validate_dashboard() throws Exception{
		if(driver.getTitle().contains("Dashboard | Testbook")) {
			
			String ExpectedTitle = "Dashboard | Testbook";
			Assert.assertEquals(ExpectedTitle, driver.getTitle());
			
			System.out.println("User is on dashboard after login.");
			log = ext.createTest("Dashboard Display");
			log.log(Status.PASS, "User was successfully logged in.");
			takescreenshot("Dashboard_page.png");
		}
		else {
			System.out.println("User is not logged in.");
			log = ext.createTest("Dashboard Display");
			log.log(Status.FAIL, "User not logged in.");
			takescreenshot("Dashboard_page.png");
		}
	}
	
	public void email_validate(String email) throws Exception{
		if(user_login_button.isDisplayed()) {
			System.out.println("User enterred a valid email id");
			log = ext.createTest("Email Validation");
			log.log(Status.PASS, "User enterred a valid email id ");
			//System.out.println(email);
			takescreenshot("email - "+ email +".png");
		}
		else {
			System.out.println("User enterred an invalid email id");
			log = ext.createTest("Email Validation");
			log.log(Status.FAIL, "User enterred an invalid email id");
			takescreenshot("email - "+ email +".png");
		}	
	}
	
	public void validate_live_class() throws Exception{
		if(live_name.getText().contains(driver.getTitle()) ) {
			System.out.println("Live Class name - " + live_name.getText());
			log = ext.createTest("Live Class");
			log.log(Status.PASS, "User redirected to the desired live class");
			takescreenshot("live_class.png");
		}
		else {
			System.out.println("Live Class name - " + live_name.getText());
			log = ext.createTest("Live Class");
			log.log(Status.FAIL, "User was not redirected to the desired live class");
			takescreenshot("live_class.png");
		}
	}
	
	public void validate_get_pass() throws Exception{
		if(driver.getTitle().contains("Buy TestBook Pass for")) {
			System.out.println("User is on Buy Pass Page");
			log = ext.createTest("Buy Pass page");
			log.log(Status.PASS, "User is on Buy Pass Page");
			takescreenshot("buy_pass_page.png");
		}
		else {
			System.out.println("User is not on Buy Pass Page");
			log = ext.createTest("Buy Pass page");
			log.log(Status.FAIL, "User is not on Buy Pass Page");
			takescreenshot("buy_pass_page.png");
		}
	}
}
