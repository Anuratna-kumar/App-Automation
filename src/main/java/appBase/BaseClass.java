package appBase;

import constants.GenericValues;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {

    public static AppiumDriver<MobileElement> appiumDriver;
    protected AppiumDriverLocalService service;

    @BeforeTest(alwaysRun = true)
    @Parameters({"deviceName","udid","platformName","platformVersion","wda","port"})
    public void setUp(String deviceName,@Optional String udid, String platformName, String platformVersion,String wda,String port){
        service = new AppiumServiceBuilder().usingPort(Integer.valueOf(port)).build();
        service.start();

        if(service == null || !service.isRunning())
            throw new AppiumServerHasNotBeenStartedLocallyException("appium server node is not started");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
        cap.setCapability(MobileCapabilityType.UDID,platformName.equalsIgnoreCase("iOS")?"":udid);
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,platformVersion);
        cap.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT,wda);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,platformName.equalsIgnoreCase("iOS")?GenericValues.ios_automationName:GenericValues.android_automationName);
        cap.setCapability("noReset",true);
        cap.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT,500000);
        cap.setCapability(MobileCapabilityType.APP,platformName.equalsIgnoreCase("iOS")?GenericValues.iosApp_path:GenericValues.androidApp_path);
        URL url = null;
        try {
            url = new URL(GenericValues.url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        appiumDriver = new AppiumDriver<MobileElement>(service.getUrl(),cap);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        if(appiumDriver!= null)
            appiumDriver.quit();

        if(service!=null)
            service.stop();
    }
}
