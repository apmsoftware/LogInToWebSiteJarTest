package com.aarya.misal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aarya.login.BrowserAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JarTest {
	private WebDriver driver;
	
	String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDX2yA1MSEa2UQknRS5vZZRp+IzcqIjP1Komk9buNLccfEqrJyzTfKYRB0KjqJ89FMx2/VcebcNPxYY2eHA8sSOlHe2+N6k3gakRhIyT7KYvsVFrrVpRwWmif2y295uAL7jihMX/iCXpUzeQDi4s12Mc1K3zBd+SJ9eGxi92rzfApp9aXUWH6qdkIcX1NCuhlY5FbA8QH50so7UhFg3yaw+V72Fv5ddzzjQOFwk9sWGN39BIbIwEHOp+P5BoO3e/ulejksPvKcFlX5OYHQfmVcqyghPLCDhm00xEbiBocmMOvagj+xrnwhzEVatN1oPGvI5pLdO9T2ZIKPqafqS5Z5tAgMBAAECggEAAsFQwW0Nm56fUIpSu+YwF325lOeHK0UBJJbHoYeT5W1s4xsN6vn5OTlRV5OnfknOEApbMOF61Sfze8C4MXLH0HwTpRm7GcadthYQ4GSFBo8UzIVk2mGmMFB9lP1acvP+e8AE6176goUBHKscLjtX29WS/jaULC/4HMbiw3WZyIzldIEiStg9TzAusMGnNNPxe2Rrw44Tia29zssYYjosY5I6xDc9+J3LY6YSEC5TmyFd2+kmAbwwC2iZvCLiPxTknTdw10RLIFiJyN61tMK+qDPay3AMknOeUQbn0HiCpS741GLbNLGd3NUgjgxFcKI6DtQkgxCQXEOJPPOogFIZwQKBgQDnl6DlM0z/kQXZthfwmgmbR8W2cA1Xfq3u+vQAZOlABbfmDEYwyAYH749kmpKtDV7SYuTJLJaD5+lpNh+1mNfAhMMnn1i5azbfvG/mPK9cb0TFJhGrZ1fvACDjyejQwp/Pk4PMddu6xRpasbB2C4qa1V9VmjmaTYfcKFvF4ByQTQKBgQDumu4dIPBOfrIxdJtgKY7YODCPJq7DRJWJf55d2IVXVfe5WLnDqecuSyxYUwgyWGoy+wDMlne1bbQIgF/lzsF+0EogUKylB5MQmNPDc68+14T1CBligMje/P/gFDMLjKs3KUyEelTOiWV/hl4xAuaVzmeNtj1rpjcnZfhWrMlWoQKBgBO7h6n/xP/Bi44RRdjqRwdEBkSVJ43c7VT/bOrbrkQWOKURRqnBYUIr1zvrL7Qu/3VNl9DMS8bRa8HbKrh+XWO57CbkHNsvl21Y0O/9G7P0hxeFNtwz4forOKIwAfZHnvZAy2oQYLh5MtWnbjGgqh6nL4hLq7zJ/llz1t31SnnBAoGAaByKEYOx105JCnNK6Ka5gXbjGVNTpjhi12AsBd7YL8d/FAy24b1c9kIu00tHpFAX5q7HJn3xNeTsTVlWfru8ikzwSzFoY4nujathm0L7EHyRsykZinWPMF1MeMXXkA6NFsCadqO6JXSmKQLETrZpTqyFWrxOCI66OiKwPYGfSIECgYBDDu4ZOE57WpXonw8iBuqlLtd9a/YrmwH+rpyRFvxxrRkyCMr+ByhvoZIZN3JWnWdroJmzj+gxj2E/KxqPLSLZFvr1yhxIzIltbZN5+7Ugnma169WMKLd6SBdQ94UwrGFqhzi8gsjV8Y0Hd4vf8JL0Yy8Uj8nruM/VEBFEMsCXIA==";
	// Encrypted UserName
	String encryptedUserName = "05+8oPq8oZuYECmUU6lH2JheyS6pyZAIOSzfnjxiL+alFdN0Z/GudI+ZjEreO8/KKAa3ZcsxDNx1nQzZ1uF4HFchdFs4ukF6QUySKoFi69reXwwfb3DUHe9cK7vKwgGSgU8vtYVbqQuZKxKF7vNCsLPAx1vJc1/wmPhHnWvRs0f7F3ffBAqpDB+EZ42LSt4l/Hq2SNvkMHP61wqDg+idRNfZbi5NGZmhOFjRE0CgOHoqVFeEbKXFk5cwOFk7Tob4aEacyrFX5deHKTqIdCcUaLX/zGYJztRR8J4kCIkfJyXZ+ojy/06SYVghqZy+IoFZgtc6F9+3WL82hDhxvRkgaA==";
	// Encrypted Password
	String encryptedPassword = "oTN6tNRsHBAuGiasthpXZTDtQd+7pRcZ687mmm4zqtPVdun25q9Vwf3AY3zoWcs8Vo7ZjUObUhKXJIqp9y4xJ5/IyjL8zVh43hjpSnoxFyhsU4E7/U/20LO4xIkcyPNlLsY0GCqx4BEQXAFfWyCwc0HK0XF8UlGXpWDtQN56TLG1LdutDMg6Tnv5Dv1PMwync750mapkmcQtnnXHL0cBoWB/IKUf6GSoJFKfOekFrQXoFsW6LkgUO19v0pqzkRUwrQYuXw/hVT2/CLRI33j9HhedSfw0bfi4pV3VA4iWPUttl9qYvcTlUll3fAvmuiD3AzI1Ohmu1LyuV+UadutXuw==";

	public JarTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
	}

	@BeforeClass
	public void setUp() {
		// Do Nothing
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement UsernameTextbox;

	@FindBy(xpath = "//input[@name='password']")
	WebElement PasswordTextbox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement LoginButton;

	@Test
	public void exampleTest() {
		// Test logic goes here
		try {
			String url = "https://the-internet.herokuapp.com/login";

//			BrowserAutomation auto = new BrowserAutomation();
//			driver = auto.performLogin(url, enUsername, enPassword, PRIVATE_KEY);
//			System.out.println("Page Title: " + driver.getTitle());

			driver.get(url);
			BrowserAutomation auto = new BrowserAutomation();
			String str = auto.performLoginUsingDriver(driver, UsernameTextbox, PasswordTextbox, LoginButton,
					encryptedUserName, encryptedPassword, privateKey);
			System.out.println("Page Title: " + driver.getTitle());

			driver.manage().window().maximize();
			driver.get("https://google.com");
			System.out.println("Page Title: " + driver.getTitle());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void tearDown() {
		// Quit the browser
		driver.quit();
	}
}
