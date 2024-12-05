package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import questions.LoginInvalidCredentials;
import questions.LoginValidQuestion;
import tasks.LoginTask;
import static org.hamcrest.Matchers.is;



public class LoginStepDefinitions extends BaseStepDefinitions {

    @Given("el usuario esta la pagina de inicio de sesion de OrangeHRM")
    public void elUsuarioEstaEnLaPaginaDeInicioDeSesion(){
        setupActor();
        actor.wasAbleTo(Open.url("https://opensource-demo.orangehrmlive.com/"));
    }

    @When("el usuario ingresa el nombre de usuario {string} y la contraseña {string}")
    public void elUsuarioIniciaSesionConLasCredenciales(String username, String password){
        actor.attemptsTo(LoginTask.withCredentials(username, password));
    }

    @When("el usuario hace click en el boton iniciar sesion")
    public void elUsuarioHaceClickEnElBotonIniciarSesion(){

    }

    @Then("el usuario debe ser redireccionado al dashboard")
    public void elUsuarioDebeSerRedireccionadoAlDashboard(){
        actor.should(
            GivenWhenThen.seeThat(LoginValidQuestion.isSuccessful(), is(true))
        );
    }

    @Then("el usuario debe poder visualizar el mensaje {string}")
    public void elUsuarioDebePoderVisualizarUnMensaje(String mensaje){
        actor.should(
            GivenWhenThen.seeThat(LoginInvalidCredentials.hasMessage(mensaje), is(true))
        );
    }


}
