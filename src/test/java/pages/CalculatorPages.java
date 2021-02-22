package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Getter
public class CalculatorPages {

    @FindBy(id = "com.oneplus.calculator:id/digit_2")
    private MobileElement two;

    @FindBy(id = "com.oneplus.calculator:id/digit_3")
    private MobileElement three;

    @FindBy(id = "com.oneplus.calculator:id/op_add")
    private MobileElement add;

    @FindBy(id = "com.oneplus.calculator:id/eq")
    private MobileElement equals;

    @FindBy(id = "com.oneplus.calculator:id/result")
    private MobileElement results;

    public CalculatorPages(AppiumDriver<MobileElement> appiumDriver){
        PageFactory.initElements(appiumDriver,this);
    }
}
