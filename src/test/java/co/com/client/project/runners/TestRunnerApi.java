package co.com.client.project.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/features/Pokemon-back.feature"},
        glue = "co.com.client.project.stepdefinitions",
        tags = "@tag")

public class TestRunnerApi {
}
