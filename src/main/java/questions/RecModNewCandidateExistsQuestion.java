package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import net.serenitybdd.screenplay.questions.Text;
import ui.RecruitmentModulePage;

public class RecModNewCandidateExistsQuestion implements Question<Boolean>{

    private final String expectedCandidateName;

    public RecModNewCandidateExistsQuestion(String expectedCandidateName) {
        this.expectedCandidateName = expectedCandidateName;
    }

    public static RecModNewCandidateExistsQuestion withName(String candidateName){
        return new RecModNewCandidateExistsQuestion(candidateName);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String actualCandidateName = Text.of(RecruitmentModulePage.CANDIDATE_LISTING).answeredBy(actor);
        System.out.println("Actual candidate name: " + actualCandidateName);
        System.out.println("Expected candidate name: " + expectedCandidateName);
        return actualCandidateName.equals(expectedCandidateName);
    }
}
