package SeleniumWebComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class DragAndDrop {
    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();

        try {
            
            driver.get("https://jqueryui.com/droppable/");
            driver.manage().window().maximize();

           
            WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
            driver.switchTo().frame(iframe);

            WebElement source = driver.findElement(By.id("draggable"));
            WebElement target = driver.findElement(By.id("droppable"));
            Actions actions = new Actions(driver);
            actions.dragAndDrop(source, target).perform();
            String targetText = target.getText();
            if (targetText.equals("Dropped!")) {
                System.out.println("✅ Text successfully changed to 'Dropped!'");
            } else {
                System.out.println("❌ Text did not change as expected");
            }

            String backgroundColor = target.getCssValue("background-color");
            String hexColor = Color.fromString(backgroundColor).asHex();

            System.out.println("🎨 Background Color after drop: " + hexColor);
            if (!backgroundColor.isEmpty() && !targetText.equals("Drop here")) {
                System.out.println("✅ Drag and drop operation successful.");
            } else {
                System.out.println("❌ Drag and drop verification failed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           
            driver.quit();
        }
    }
}

