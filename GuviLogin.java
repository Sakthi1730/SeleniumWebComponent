package SeleniumWebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GuviLogin {
    public static void main(String[] args) {
   
        WebDriver driver = new ChromeDriver();

        String testName = "Test User";
        String testEmail = "testuser" + System.currentTimeMillis() + "@example.com";
        String testPassword = "SecurePass123";

        try {
            
            driver.get("https://www.guvi.in/");
            driver.manage().window().maximize();
            Thread.sleep(3000); 
            WebElement signupBtn = driver.findElement(By.linkText("Signup"));
            signupBtn.click();
            Thread.sleep(3000); 
            driver.findElement(By.name("fullName")).sendKeys(testName);
            driver.findElement(By.name("email")).sendKeys(testEmail);
            driver.findElement(By.name("password")).sendKeys(testPassword);

            driver.findElement(By.cssSelector("button[type='submit']")).click();
            Thread.sleep(5000); 
            String signupTitle = driver.getTitle();
            if (signupTitle.toLowerCase().contains("welcome") || driver.getCurrentUrl().contains("welcome")) {
                System.out.println("✅ Signup successful. Title: " + signupTitle);
            } else {
                System.out.println("❌ Signup may have failed. Title: " + signupTitle);
            }

            driver.findElement(By.linkText("Login")).click();
            Thread.sleep(3000); 
            driver.findElement(By.name("email")).sendKeys(testEmail);
            driver.findElement(By.name("password")).sendKeys(testPassword);

            driver.findElement(By.cssSelector("button[type='submit']")).click();
            Thread.sleep(5000); 
            String loginTitle = driver.getTitle();
            if (loginTitle.toLowerCase().contains("dashboard") || driver.getCurrentUrl().contains("dashboard")) {
                System.out.println("Login successful. Title: " + loginTitle);
            } else {
                System.out.println("Login may have failed. Title: " + loginTitle);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
            driver.quit();
        }
    }
}
