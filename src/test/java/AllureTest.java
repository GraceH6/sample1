import aquality.selenium.browser.AqualityServices;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;

import static aquality.selenium.browser.AqualityServices.getElementFactory;

public class AllureTest {

    private static final String GLOBAL_PARAMETER = "global value";

    @BeforeSuite
    public void setUp() {
        AqualityServices.getBrowser().goTo("https://demoqa.com/text-box");
    }

    @AfterSuite
    public void tearDown() {
        AqualityServices.getBrowser().quit();
    }

    @Test(enabled = false)
    public void someTests() {
        simpleTest();
    }

    @Step("Auth step")
    public void simpleTest() {
        Allure.addAttachment("screenshot", "image/png",
                new ByteArrayInputStream(AqualityServices.getBrowser().getScreenshot()), "png");
        var txbUserName = getElementFactory().getTextBox(By.xpath("//input[@id='userName']"), "username input");
        var txbEmail = getElementFactory().getTextBox(By.xpath("//input[@id='userEmail']"), "email input");
        txbUserName.getJsActions().scrollIntoView();
        txbUserName.clearAndType("Zhansaya");
        txbEmail.clearAndType("blabla@gmail.com");
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
