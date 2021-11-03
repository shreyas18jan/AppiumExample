package com.example.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;

public class AppiumDemoUtils {
    public ThreadLocal<AppiumDriver<MobileElement>> driver = new ThreadLocal<>();
    AppiumDriverLocalService service;

    public void setDriver(AppiumDriver<MobileElement> driver) {
        this.driver.set(driver);
    }

    public AppiumDriver<MobileElement> getDriver() {
        return this.driver.get();
    }

    void startAppiumServer(int serverPort) throws IOException {

        InputStream inputStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("capabilities.properties");
        Properties desiredCapabilitiesProp=new Properties();
        desiredCapabilitiesProp.load(inputStream);

        HashMap<String, String> environment = new HashMap<>();
        environment.put("ANDROID_HOME", desiredCapabilitiesProp.getProperty("appium.android.home"));
        environment.put("JAVA_HOME", desiredCapabilitiesProp.getProperty("appium.java.home"));

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withAppiumJS(new File(desiredCapabilitiesProp.getProperty("appium.command.path")))
                .usingDriverExecutable(new File(desiredCapabilitiesProp.getProperty("node.command.path")))
                .withIPAddress("127.0.0.1")
                .usingPort(serverPort)
                .withEnvironment(environment);

        service = AppiumDriverLocalService.buildService(builder);

        // Starting the Service
        service.start();
        System.out.println("Appium Service Started !");
    }

    public void initiateDriver(String udid, int serverPort, int port) throws Exception {

        startAppiumServer(serverPort);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, udid);
        capabilities.setCapability(MobileCapabilityType.UDID, udid);
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, port);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.androidappexample");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.example.androidappexample.MainActivity");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 0);
        setDriver(new AndroidDriver<>(new URL("http://127.0.0.1:" + serverPort + "/wd/hub"), capabilities));
    }

    public void closeDriver() {
        getDriver().quit();
        service.stop();
    }
}
