package com.rea.robot.bbd.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/cucumber" },
        features = "classpath:cucumber/robot.feature",
        glue = {"com.rea.robot.bdd"}
)
public class RobotSimulatorBDDTest {
}
