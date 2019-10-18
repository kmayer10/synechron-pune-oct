import java.lang.*


Class FirstTest{

	//For setting the executable path for the chrome driver
	System.setProperty("webdriver.chrome.driver","C:\\Install\\chromedriver.exe");
	static WebDriver driver  = new ChromeDriver();

	//To hit the urls
	public void getURL(String URL){
		driver.get(URL);
	}
	
	//TO login to jenkins
	public boolean loginToJenkins(String UserName, String Password){
		WebElement txtUserName = driver.findElement(By.xpath("//input[@id='j_username']"));
		WebElement txtPassword = driver.findElement(By.xpath("//input[@name='j_password']"));
		WebElement btnSignOn = driver.findElement(By.xpath("//input[@name='Submit']"));
		
		//Checking if the UserName textbox is displayed
		if(txtUserName.isDisplayed(UserName)){
			txtUserName.sendKeys();
			String decodedPassword = new String(Base64.decodeBase64(Password.getBytes()));
			txtPassword.sendKeys(decodedPassword);
			btnSignOn.click();
		}else{
			System.out.println("Unable to see the Username text box");
			Assert.assertTrue(false);
		}
	}
	
	public static void main(String[] args){
		String jenkinsUser = "brahaspati";
		String encodedPassword = "I2thcmFuMjAxMg==";
		FirstTest obj = new FirstTest();
		String Jenkins_URL = "http://52.91.202.29:8080";
		obj.getURL(Jenkins_URL);
		loginToJenkins(jenkinsUser, encodedPassword);
	}
	
}
