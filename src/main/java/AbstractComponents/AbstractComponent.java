package AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class AbstractComponent {
    WebElement sectionElement;
    WebDriver driver;
    public AbstractComponent(WebDriver driver, By sectionElement) {
        this.driver = driver;
        this.sectionElement =driver.findElement(sectionElement);
    }
    public WebElement find(By findElementBy)
    {
        return sectionElement.findElement(findElementBy);
    }

    public List<WebElement> findElements(By findElementBy)
    {
        return sectionElement.findElements(findElementBy);
    }

}
