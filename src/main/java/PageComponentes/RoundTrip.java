package PageComponentes;

import AbstractComponents.AbstractComponent;
import AbstractComponents.SearchFlightAvailability;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RoundTrip extends AbstractComponent implements SearchFlightAvailability {
    private By roundRadioIcon =By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By familyAndFriendsCheckBox = By.id("ctl00_mainContent_chk_friendsandfamily");
    private By to =By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By search =By.id("ctl00_mainContent_btn_FindFlights");

    public RoundTrip(WebDriver driver, By sectionElement){
        super(driver, sectionElement);
    }
    @Override
    public void checkAvailability(String from, String destination) {
        System.out.println("I'm inside the round trip");
        find(roundRadioIcon).click();
        selectOriginCity(from);
        selectDestinationCity(destination);
        find(familyAndFriendsCheckBox).click();
        find(search).click();
    }

    public void selectOriginCity(String origin){
        find(this.from).click();
        find(By.xpath("//a[@value='"+origin+"']")).click();
    }
    public void selectDestinationCity(String destination){
        find(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }
}
