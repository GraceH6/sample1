import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "hellocucumber",
        tags = "@third"
)
public class TestNgCucumberRunner extends AbstractTestNGCucumberTests {

}
