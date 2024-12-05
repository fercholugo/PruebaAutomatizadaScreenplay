package stepdefinitions;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import questions.RecModNewCandidateExistsQuestion;
import tasks.LoginTask;
import tasks.RecruitmentModuleTask;
import static org.hamcrest.Matchers.is;
import java.util.List;
import java.util.Map;

public class RecruitmentModuleStepDefinitions extends BaseStepDefinitions {

    @And("el usuario estando en la dashboard navega al modulo Recruitment")
    public void elUsuarioNavegaAlModuloRecruitment(){
        setupActor();
        actor.attemptsTo(new RecruitmentModuleTask());
    }

    @When("el usuario hace clic en Add para agregar un nuevo candidato")
    public void elUsuarioHaceClicEnAdd(){
        RecruitmentModuleTask.clickAddButton(actor);
    }

    @And("el usuario diligencia el formulario con la siguiente informacion:")
    public void elUsuarioDiligenciaFormAddCandidate(DataTable dataTable){

        List<Map<String, String>> candidateDataList = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> candidateData : candidateDataList){

            String firstName = candidateData.get("FirstName");
            String lastName = candidateData.get("LastName");
            String email = candidateData.get("Email");
            String contactNumber = candidateData.get("ContactNumber");
            String keyword = candidateData.get("Keyword");
            String vacancy = candidateData.get("Vacancy");

            RecruitmentModuleTask.fillCandidateForm(actor, firstName, lastName, email, contactNumber, keyword, vacancy);
        }
    }

    @And("el usuario hace clic en Save")
    public void elUsuarioHaceClicEnSave(){
        RecruitmentModuleTask.clickSaveButton(actor);
    }

    @Then("el candidato debe aparecer en la lista de candidatos")
    public void ElCandidatoSeGuardoYlisto() {
        String keywordCandidate = actor.recall("keywordCandidate");
        //realizamos la busqueda del candidato
        RecruitmentModuleTask.validateCandidateCreatedByKeyword(actor, keywordCandidate);

        String candidateName = actor.recall("candidateName");
        //validamos que el candidato este listado
        actor.should(
                GivenWhenThen.seeThat(RecModNewCandidateExistsQuestion.withName(candidateName), is(true))
        );
    }

}
