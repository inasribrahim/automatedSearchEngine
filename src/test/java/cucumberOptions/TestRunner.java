package cucumberOptions;

import cucumber.api.CucumberOptions;
import resources.base;

import org.testng.annotations.Test;
// format = 
//@RunWith(Cucumber.class)
@Test
@CucumberOptions(  
	    features = "src/test/java/features",
	    glue="stepDefinations",
	    plugin= {"pretty","html:target/cucumber-html-report"}
	    )
public class TestRunner extends base  {

}
 