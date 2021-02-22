package testClass;

import appBase.BaseClass;
import features.CalculatorFeature;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTests extends BaseClass {

    CalculatorFeature feature = new CalculatorFeature(appiumDriver);

    @Test
    public void verifySum(){
        Assert.assertEquals("5",feature.do_sum());
    }

    @Test
    public void verifySub(){

    }

    @Test
    public void verifyMul(){

    }

    @Test
    public void verifyDiv(){

    }

}
