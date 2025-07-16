package SeleniumWebComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DatePicker {
    public static void main(String[] args) {
       
        WebDriver driver = new ChromeDriver();

        try {
            
            driver.manage().window().maximize();

            driver.get("https://jqueryui.com/datepicker/");

           
            WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
            driver.switchTo().frame(iframe);

            
            WebElement dateInput = driver.findElement(By.id("datepicker"));
            dateInput.click();

           
            WebElement nextMonthButton = driver.findElement(By.cssSelector(".ui-datepicker-next"));
            nextMonthButton.click();

            
            Thread.sleep(500); 
            WebElement date22 = driver.findElement(By.xpath("//a[text()='22']"));
            date22.click();

            String selectedDate = dateInput.getAttribute("value");
            System.out.println("Selected Date: " + selectedDate);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
          
            driver.quit();
        }
    }
}
