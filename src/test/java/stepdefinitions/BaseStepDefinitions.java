package stepdefinitions;



import net.serenitybdd.annotations.Managed;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class BaseStepDefinitions {

    @Managed
    protected WebDriver navegador;
    protected Actor actor = Actor.named("Usuario");

    protected void setupActor(){
        actor.can(BrowseTheWeb.with(navegador));
    }


}
