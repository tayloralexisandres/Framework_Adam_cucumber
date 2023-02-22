package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    @After  //it should come form cucumber java NOT JUNIT
    public void tearDown(Scenario scenario)  {

        //  if (scenario.isFailed()){
        byte[] data = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(data,"image/png", scenario.getName());
        //}



        Driver.closeDriver();
    }

}
