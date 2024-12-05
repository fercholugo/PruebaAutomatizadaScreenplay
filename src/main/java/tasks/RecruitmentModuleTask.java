package tasks;

import interactions.SelectVacancyOption;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.EventualConsequence.*;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.targets.EnsureFieldVisible;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.findby.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.RecruitmentModulePage;

import net.serenitybdd.screenplay.GivenWhenThen.*;

import java.time.Duration;

import static org.hamcrest.Matchers.equalTo;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RecruitmentModuleTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        try{
            Alert alert = BrowseTheWeb.as(actor).getDriver().switchTo().alert();
            alert.accept();
            System.out.println("Alerta cerrada");
        } catch (NoAlertPresentException e){
            System.out.println("No se detecto ninguna alerta");
        }
        actor.attemptsTo(
            WaitUntil.the(RecruitmentModulePage.SELECT_MODULE_RECRUITMENT, isClickable()),
            Click.on(RecruitmentModulePage.SELECT_MODULE_RECRUITMENT)
        );
    }

    //function addCandidate
    public static void clickAddButton(Actor actor){
        actor.attemptsTo(
            WaitUntil.the(RecruitmentModulePage.BUTTON_ADD_CANDIDATE, isClickable()),
            Click.on(RecruitmentModulePage.BUTTON_ADD_CANDIDATE)
        );
    }

    //function formAddCandidate
    public static void fillCandidateForm(Actor actor, String firstName, String lastName, String email, String contactNumber, String keyword, String vacancy){
        actor.remember("candidateKeywordDate", keyword);
        actor.remember("candidateName", firstName);
        actor.attemptsTo(
            WaitUntil.the(RecruitmentModulePage.FIRSTNAME_INPUT, isVisible()).forNoMoreThan(10).seconds(),
            Enter.theValue(firstName).into(RecruitmentModulePage.FIRSTNAME_INPUT),
            Enter.theValue(lastName).into(RecruitmentModulePage.LASTNAME_INPUT),

            //seleccion de lista desplegable
            Click.on(RecruitmentModulePage.LIST_VACANCY),
            SelectVacancyOption.byTyping("t"),


            Enter.theValue(email).into(RecruitmentModulePage.EMAIL_INPUT),
            Enter.theValue(contactNumber).into(RecruitmentModulePage.CONTACTNUMBER_INPUT),
            Enter.theValue(keyword).into(RecruitmentModulePage.KEYWORD_INPUT)
        );
    }

    // click buttonSave
    public static void clickSaveButton(Actor actor){
        actor.attemptsTo(
                WaitUntil.the(RecruitmentModulePage.SAVE_BUTTON, isClickable()),
                Click.on(RecruitmentModulePage.SAVE_BUTTON)
        );
    }

    //validate Candidate Created By Keyword
    public static void validateCandidateCreatedByKeyword(Actor actor, String keyword) {
        keyword = actor.recall("candidateKeywordDate");
        String candidateName = actor.recall("candidateName");
        actor.attemptsTo(
                WaitUntil.the(RecruitmentModulePage.KEYWORD_INPUT, isVisible()).forNoMoreThan(50).seconds(),
                Click.on(RecruitmentModulePage.KEYWORD_INPUT),
                Enter.theValue(keyword).into(RecruitmentModulePage.KEYWORD_INPUT),
                WaitUntil.the(RecruitmentModulePage.SEARCH_BUTTON, isClickable()),
                Click.on(RecruitmentModulePage.SEARCH_BUTTON),
                //validate CandidateListing
                Scroll.to(RecruitmentModulePage.CANDIDATE_LISTING),
                WaitUntil.the(RecruitmentModulePage.CANDIDATE_LISTING, isVisible())
        );
    }






}
