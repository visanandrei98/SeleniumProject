package Part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSelenium {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    //@beforeClass folosita inainte ca browserul sa deschida pagina. Setam ca driver sa fie ChromeDriver, iar imaginea sa fie maximizata;

    @Test
    public void testLogin() throws InterruptedException {
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        Thread.sleep(2000);
        WebElement dashboardText = driver.findElement(By.tagName("h6"));
        String actualResult = dashboardText.getText();
        String expectedResult = "Dashboard";
        Assert.assertEquals(actualResult, expectedResult);

    }

    @AfterClass
    public void afterOpen(){
        //driver.quit();

    }


}
