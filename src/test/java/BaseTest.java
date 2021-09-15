import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        tags = {"@task-1, @task-2, @task-3"},
        plugin = {
                "json:target/cucumber-reports/cucumber.json"
        }
)
public class BaseTest {
}
