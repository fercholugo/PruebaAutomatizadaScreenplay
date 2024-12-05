    package questions;

    import net.serenitybdd.screenplay.Actor;
    import net.serenitybdd.screenplay.Question;
    import net.serenitybdd.screenplay.questions.Text;
    import ui.LoginPage;

    public class LoginInvalidCredentials implements Question<Boolean> {

        private final String expectedMessage;

        private LoginInvalidCredentials(String expectedMessage){
            this.expectedMessage = expectedMessage;
        }

        public static LoginInvalidCredentials hasMessage(String message){
            return new LoginInvalidCredentials(message);
        }

        @Override
        public Boolean answeredBy(Actor actor) {
            String actualMessage = Text.of(LoginPage.ERROR_MESSAGE_INVALID_CREDENTIALS).answeredBy(actor);
            System.out.println("valor de actualMessage : "+ actualMessage);
            System.out.println("valor de expectedMessage : "+ expectedMessage);
            return actualMessage.contains(expectedMessage);
        }
    }
