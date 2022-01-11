package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/Feature"}
        , glue = {"StepsDefinition"}
        , tags = "@Run")
public class TestRunner {

}
