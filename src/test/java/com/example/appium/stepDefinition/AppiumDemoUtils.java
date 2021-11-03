package com.example.appium.stepDefinition;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AppiumDemoUtils {
    private static AndroidDriver<MobileElement> androidDriver;

    static void setDriverToNull(){
        androidDriver = null;
    }

    static AndroidDriver<MobileElement> getDriver(){
        return androidDriver;
    }

    static void preRequisite(String udid, int port) throws Exception {

        InputStream inputStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("capabilities.properties");
        Properties desiredCapabilitiesProp=new Properties();
        desiredCapabilitiesProp.load(inputStream);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, udid);
        capabilities.setCapability(MobileCapabilityType.UDID, udid);
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, port);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.androidappexample");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.example.androidappexample.MainActivity");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 0);
        androidDriver = new AndroidDriver<>(new URL(desiredCapabilitiesProp.get("appium.address").toString()), capabilities);
        androidDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
