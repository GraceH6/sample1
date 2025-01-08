package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepDefinitions {

    private String today;
    private String actualAnswer;

    @Given("today is Sunday")
    public void today_is_sunday() {
        // Write code here that turns the phrase above into concrete actions
       today = "Sunday";
    }

    @Given("today is Friday")
    public void todayIsFriday() {
        today = "Friday";
        System.out.println("Second one");
    }

    @Given("the user is on the login page")
    public void givenForThird() {
        System.out.println("given");
    }

    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_friday_yet() {
        // Write code here that turns the phrase above into concrete actions
        actualAnswer = IsItFriday.isItFriday(today);
    }

    @When("the user enters username {string} and password {string}")
    public void whenForThird(String username, String password) {
        System.out.println(username + " and " + password);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Then("the result should be {string}")
    public void thenForThird(String result) {
        System.out.println(result);
    }
}
