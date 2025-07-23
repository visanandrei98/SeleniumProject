package part3_4.com.demoqa.base;

import com.demoqa.pages.HomePage;
import com.base.BasePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static utilities.Utility.setUtilityDriver;

public class BaseTest {

    private WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;
    private final String DEMOQA_URL = "https://demoqa.com/";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void loadApplication() {
        driver.get(DEMOQA_URL);
        basePage = new BasePage();
        basePage.setDriver(driver);
        setUtilityDriver();
        homePage = new HomePage();
    }

    @AfterMethod
    public void takeFailedResultScreenshot(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);

            // Creăm folderul dacă nu există
            String folderPath = System.getProperty("user.dir") + "/resources/screenshots";
            File screenshotDir = new File(folderPath);
            if (!screenshotDir.exists()) {
                boolean created = screenshotDir.mkdirs(); // creează toate directoarele necesare
                if (created) {
                    System.out.println("Created screenshots directory at: " + folderPath);
                }
            }

            // Creăm fișierul final cu nume: data_numeTest.png
            String fileName = java.time.LocalDate.now() + "_" + testResult.getName() + ".png";
            File destination = new File(screenshotDir, fileName);

            try {
                // Copiem fișierul folosind Java standard
                Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Screenshot saved at: " + destination.getAbsolutePath());
            } catch (IOException e) {
                throw new RuntimeException("Failed to save screenshot", e);
            }
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
