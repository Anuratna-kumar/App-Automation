package features;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.Getter;
import pages.CalculatorPages;
@Getter
public class CalculatorFeature {

    AppiumDriver<MobileElement> appiumDriver;
    CalculatorPages calPage;

    public int do_sum(){
        calPage.getTwo().click();
        calPage.getThree().click();
        calPage.getAdd().click();
        calPage.getResults().click();
        return Integer.valueOf(calPage.getResults().getText());
    }

    public CalculatorFeature(AppiumDriver<MobileElement> appiumDriver){
        this.appiumDriver = appiumDriver;
    }
}
