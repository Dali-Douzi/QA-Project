package com.exam.hooks;

import com.exam.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver();
        System.out.println("✓ Browser initialized");
    }

    @After
    public void tearDown(Scenario scenario) {
        // AUTOMATIC SCREENSHOT ON FAILURE
        if (scenario.isFailed()) {
            System.out.println("❌ Scenario FAILED: " + scenario.getName());
            takeScreenshot(scenario, "FAILED");
        } else {
            System.out.println("✓ Scenario PASSED: " + scenario.getName());
        }

        DriverManager.quitDriver();
    }

    @AfterStep
    public void afterEachStep(Scenario scenario) {
        // Optional: Screenshot after each step for detailed reporting
        if (scenario.isFailed()) {
            takeScreenshot(scenario, "STEP-FAILED");
        }
    }

    private void takeScreenshot(Scenario scenario, String prefix) {
        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", prefix + "-" + scenario.getName());
            System.out.println("📸 Screenshot captured: " + scenario.getName());
        } catch (Exception e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}