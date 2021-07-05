package co.arhernandez.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features =
        "/Users/alexihrndz/Documents/Banistmo/PruebasPlaywright/src/test/resources/features/prueba.feature",
    glue = {"co.arhernandez.stepdefinitions"},
    snippets = SnippetType.CAMELCASE)
public class PruebaRunner {}
