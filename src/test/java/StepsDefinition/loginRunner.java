package StepsDefinition;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/*-Para que runner funcione con testNG
1) Descargar el archivo jar de cucumber-testng y colocarlo en la ruta de clases.
2) Hacer que TestRunner extienda AbstractTestNGCucumberTests y eliminar la anotación RunWith() como se muestra.
*/
//@RunWith(Cucumber.class) cuando trabajo con junit
@CucumberOptions(features="src/test/resources/Features", glue={"StepsDefinition"},
plugin = { "pretty", "html:target/htmlReport/reports.html"}   //para trabajar con la reporteria online.
		
/*
 * #para generar reportes  //generar 3 reportes(html,json,xml)
 * plugin = { "pretty",
 * "html:target/htmlReport/reports.html"} plugin = { "pretty",
 * "json:target/jsonReport/reports/cucumber.json"} plugin = { "pretty",
 * "junit:target/junitReport/reports/cucumber.xml"}
 */
		)
public class loginRunner extends AbstractTestNGCucumberTests{  //para trabajr con testNG debes heredar de AbstractTestNGCucumberTests{}

}
