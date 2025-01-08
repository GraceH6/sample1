import aquality.selenium.browser.AqualityServices;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.ByteArrayInputStream;

public class AllureTest {
    private static final String GLOBAL_PARAMETER = "global value";

    @BeforeMethod
    public void setUp() {
        AqualityServices.getBrowser().goTo("https://demoqa.com/text-box");
    }

    @AfterMethod
    public void tearDown() {
        AqualityServices.getBrowser().quit();
    }

    @Test
    public void someTests() {
        simpleTest();
    }

    @Step("Bla-Bla-Bla")
    public void simpleTest() {
        Allure.addAttachment("screenshot", "image/png",
                new ByteArrayInputStream(AqualityServices.getBrowser().getScreenshot()), "png");
        AqualityServices.getElementFactory().getTextBox(By.xpath("//input[@id='userName']"),
                "username input").clearAndType("Zhansaya");
        AqualityServices.getElementFactory().getTextBox(By.xpath("//input[@id='userEmail']"),
                "email input").clearAndType("blabla@gmail.com");
        Allure.addAttachment("screenshot", new ByteArrayInputStream(AqualityServices.getBrowser().getScreenshot()));
    }

    @Step("Step lambdaTest")
    public void lambdaStepTest() {
        final String localParameter = "parameter value";
        Allure.step(String.format("Parent lambda step with parameter [%s]", localParameter), (step) -> {
            step.parameter("parameter", localParameter);
            Allure.step(String.format("Nested lambda step with global parameter [%s]", GLOBAL_PARAMETER));
        });
    }
}
