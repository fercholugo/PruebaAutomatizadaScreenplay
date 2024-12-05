package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SelectVacancyOption implements Interaction {

    private final String vacancyLetter;

    //constructor
    public SelectVacancyOption(String vacancyLetter){
        this.vacancyLetter = vacancyLetter;
    }

    public static SelectVacancyOption byTyping(String vacancyLetter){
        return Tasks.instrumented(SelectVacancyOption.class, vacancyLetter);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        Actions actions = new Actions(driver);
        actions.sendKeys(vacancyLetter)
               .pause(500)
               .sendKeys(Keys.ENTER)
               .perform();
    }
}
