package com.test.testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(tags = " ", features = { "/Users/sagarliki/git/SwagLabs/SwagLabs/featureFile/product_perchase.feature",
		"/Users/sagarliki/git/SwagLabs/SwagLabs/featureFile/login.feature" }, glue = {
				"com.test.stepDefination" }, monochrome = true, plugin = { "pretty", "html:target/html/automation" })

public class RunnerClass extends AbstractTestNGCucumberTests {

}
