package ru.android_studio;

import net.lightbody.bmp.BrowserMobProxy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;


public class Main {

    private static final String CHROMEDRIVER = "chromedriver";
    private static BrowserMobProxy proxy; // for use proxy, use Props proxy.enable = true

    public static void main(String[] args) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        File file = new File(CHROMEDRIVER);
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("chrome.switches", "--disable-extensions");
        capabilities.setBrowserName("chrome");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        ChromeDriver chromeDriver = new ChromeDriver(capabilities);
        chromeDriver.get("http://test.com");
    }
}
