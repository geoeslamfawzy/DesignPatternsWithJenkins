package PageComponentes;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNavigation extends AbstractComponent {
    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");

    public FooterNavigation(WebDriver driver, By sectionElement) {
        super(driver,sectionElement); //when you inherit parent class- you should invoke parent class constructor
        //in your own child constructor


    }

    //method to handle flights
    //when selenium executes anay method in this class- scope of selenium
    //should be in the footer only-


    public String getFlightAttribute()
    {
        return find(flights).getAttribute("class");


    }
    public int getLinkCount()
    {
        return findElements(links).size();
    }

}
