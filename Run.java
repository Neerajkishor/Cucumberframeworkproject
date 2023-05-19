package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= ".//Features",
		////features= ".//Features/SearchCustomerEmail.feature",
		glue="StepDefinition",
		dryRun= false,
		monochrome= true,
		//tags = "@regression" ,
		tags= "@sanity",
		//plugin= {"pretty","json:target/cucumber-reports/reports_json.json"}
		//xml-- //plugin= {"pretty","junit:target/cucumber-reports/reports_xml.xml"}
		plugin= {"pretty","html:target/cucumber-reports/reports.html", "junit:target/cucumber-reports/reports_xml.xml"}
		
		)

public class Run {

}
