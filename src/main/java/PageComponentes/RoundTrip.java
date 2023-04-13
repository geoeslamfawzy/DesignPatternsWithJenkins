package PageComponentes;

import AbstractComponents.AbstractComponent;
import AbstractComponents.SearchFlightAvailability;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class RoundTrip extends AbstractComponent implements SearchFlightAvailability {
    private By roundRadioIcon =By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By seniorCitizenCheckBox = By.id("ctl00_mainContent_chk_SeniorCitizenDiscount");
    private By to =By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By search =By.id("ctl00_mainContent_btn_FindFlights");

    public RoundTrip(WebDriver driver, By sectionElement){
        super(driver, sectionElement);
    }
    @Override
    public void checkAvailability(HashMap<String, String> reservationDetails) throws InterruptedException {
        System.out.println("I'm inside the round trip");
        find(roundRadioIcon).click();
        selectOriginCity(reservationDetails.get("from"));
        selectDestinationCity(reservationDetails.get("destination"));
        makeStateReady(s->find(search).click());
    }

    public void selectOriginCity(String origin){
        find(this.from).click();
        find(By.xpath("//a[@value='"+origin+"']")).click();
    }
    public void selectDestinationCity(String destination){
        find(this.to).click();
        find(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    public void makeStateReady(Consumer<RoundTrip> consumer) throws InterruptedException {
        waitForElementToBeClickable(seniorCitizenCheckBox);
        Thread.sleep(2000);
        find(seniorCitizenCheckBox).click();
        consumer.accept(this);
        System.out.println("I'm Done");
    }
}
