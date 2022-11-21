package cl.felipeGonzalez;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSerchTest {

	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriber.chrome.driver", "/src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGooglePage() {

		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.clear();
		searchbox.sendKeys("quality-stream Introducción a la Automatización de Pruebas de Software");
		searchbox.submit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		assertEquals("quality-stream Introducción a la Automatización de Pruebas de Software - Google Search", driver.getTitle());

	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
