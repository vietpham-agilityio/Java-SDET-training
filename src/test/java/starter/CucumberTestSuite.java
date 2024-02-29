package starter;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "io.cucumber.core.plugin.SerenityReporterParallel,pretty,timeline:build/test-results/timeline")
/**
 * - use FILTER_TAGS_PROPERTY_NAME execution below, when need to use cucumber tag formula
 * - in console shows all features
 */
//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@tagId")
/**
 *  - use junit 5 execution as IncludeTags below, when simple execution
 *  - in console shows only one scenario execution
 */
//@IncludeTags("tag00")
//@ExcludeTags("tag01")
public class CucumberTestSuite {
}
