package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import ui.LoginPage;

public class LoginValidQuestion implements Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {
        return LoginPage.DASHBOARD_HEADER.resolveFor(actor).isVisible();
    }

    public static LoginValidQuestion isSuccessful(){
        return new LoginValidQuestion();
    }


}
