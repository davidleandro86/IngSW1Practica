package com.fca.calidad.funcionales;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class UadyVirtualLoginTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "/Users/leand/Documents/chromedriver/chromedriver.exe");
	  driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLogin() throws Exception {
    driver.get("https://es.uadyvirtual.uady.mx/course/index.php?categoryid=75");
    driver.findElement(By.id("page-course-index-category")).click();
    driver.findElement(By.xpath("//nav[@id='essentialnavbar']/div/div/div/div/div/div/ul/li/a/em")).click();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("A15211385");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Dniko1994");
    driver.findElement(By.id("loginbtn")).click();
    
    WebElement texto = driver.findElement(By.id("custom_menu"));
    String resultadoEsperado = "div";
    String resultadoEjecucion = texto.getTagName();
    assertThat(resultadoEsperado, equalTo(resultadoEjecucion));
    
   
    
    
  }
  @Test
  public void testLoginfail() throws Exception {
    driver.get("https://es.uadyvirtual.uady.mx/course/index.php?categoryid=75");
    driver.findElement(By.id("page-course-index-category")).click();
    driver.findElement(By.xpath("//nav[@id='essentialnavbar']/div/div/div/div/div/div/ul/li/a/em")).click();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("A15211385");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("contraseña");
    driver.findElement(By.id("loginbtn")).click();
    
    WebElement texto = driver.findElement(By.id("loginerrormessage"));
    String resultadoEsperado = "a";
    String resultadoEjecucion = texto.getTagName();
    assertThat(resultadoEsperado, equalTo(resultadoEjecucion));
    
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
