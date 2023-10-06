import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo {

    ExtentReports extentReports;
    @BeforeTest
    public void config(){
        // ExtentReports ExtentSparkReporter
        String path = (System.getProperty("user.dir") + "\\reports\\index.html");
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");
        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Tester", "Hakan");
    }

    @Test
    public void initialDemo() {
        ExtentTest test = extentReports.createTest("Initial Demo");
       /* System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\duran\\chromedriver-win64\\chromedriver.exe");*/
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        driver.quit();
        test.fail("Result do not match");
        extentReports.flush();
    }
}
