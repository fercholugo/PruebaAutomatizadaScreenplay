package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.LoginPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginTask implements Task {

    private String username;
    private String password;

    public LoginTask(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static LoginTask withCredentials(String username, String password) {
        return new LoginTask(username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginPage.USERNAME_FIELD, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(username).into(LoginPage.USERNAME_FIELD),
                WaitUntil.the(LoginPage.PASSWORD_FIELD, isClickable()),
                Enter.theValue(password).into(LoginPage.PASSWORD_FIELD),
                WaitUntil.the(LoginPage.LOGIN_BUTTON, isClickable()),
                Click.on(LoginPage.LOGIN_BUTTON)


        );
    }
}
