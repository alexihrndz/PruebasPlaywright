package co.arhernandez.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/autenticacion.feature",
    glue = {"co.arhernandez.stepdefinitions"},
    snippets = SnippetType.CAMELCASE,
    tags = "@LoginBanistmo2")
public class Login {}
