package runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/java/features",
    glue = "stepdefinitions",
    plugin = {"pretty"},
    tags = "@AddCandidate"
)
public class RecruitmentModuleRunner {
}
