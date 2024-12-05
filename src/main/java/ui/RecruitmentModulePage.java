package ui;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class RecruitmentModulePage {

    public static final Target SELECT_MODULE_RECRUITMENT = Target.the("module Recruitment")
            .located(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='Recruitment']"));

    public static final Target BUTTON_ADD_CANDIDATE = Target.the("button add")
            .located(By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary']"));

    public static final Target FIRSTNAME_INPUT = Target.the("FirstName input")
            .located(By.xpath("//input[@placeholder='First name']"));

    public static final Target LASTNAME_INPUT = Target.the("LastName input")
            .located(By.xpath("//input[@placeholder='Last Name']"));

    public static final Target EMAIL_INPUT = Target.the("Email input")
            .located(By.xpath("(//input[@placeholder='Type here' and contains(@class, 'oxd-input--active')])[1]"));

    public static final Target CONTACTNUMBER_INPUT = Target.the("ContactNumber input")
            .located(By.xpath("((//input[@placeholder='Type here'])[2])"));

    public static final Target SAVE_BUTTON = Target.the("Save button")
            .located(By.xpath("//button[normalize-space()='Save']"));

    //lista desplegable Vacancy
    public static final Target LIST_VACANCY = Target.the("lista de vacantes")
            .located(By.cssSelector(".oxd-select-text.oxd-select-text--active"));

    public static Target getVacancyOptions(String vacancy){
        return Target.the("Vacancy option:" + vacancy)
                .locatedBy("//div[contains(@class, 'oxd-select-dropdown --position-bottom')]//div[text()='test']")
                .of(vacancy);
    }

    // validate candidate list
    public static final Target KEYWORD_INPUT = Target.the("Keyword input")
            .located(By.xpath("//input[@placeholder='Enter comma seperated words...']"));

    public static final Target SEARCH_BUTTON = Target.the("boton search")
            .located(By.xpath("//button[normalize-space()='Search' and @type='submit']"));

    public static final Target CANDIDATE_LISTING = Target.the(("Candidato listado"))
            .located((By.cssSelector("div[role='rowgroup'] div:nth-child(1) div:nth-child(1) div:nth-child(3) div:nth-child(1)")));
}

