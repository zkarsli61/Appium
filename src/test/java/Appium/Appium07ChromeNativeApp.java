package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium07ChromeNativeApp {
    @Test
    public void test() throws InterruptedException, MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"2797316218000608");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"7.0");

//        desiredCapabilities.setCapability("chromedriverExecutable","/Users/ayyildiz/IdeaProjects/AppiumTurkish/driver/chromedriver");

        // cmd + adb shell + dumpsys window windows | grep -E ‘mCurrentFocus’
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.android.chrome");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.google.android.apps.chrome.Main");
//        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
//http://localhost:4723/wd/hub
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
 /*
         Calisma:
         “https://amazon.com" git
         sign in tikla
         Verify “Welcome” text from sign in page
*/
 //       Thread.sleep(4000);
        driver.get("https://www.amazon.com/");
        System.out.println("1 "+driver.getContext());

//getContextHandles() mevcut olab app turlerini Set konteynira ekliyoruz
        Set contextNames = driver.getContextHandles();
        //burda mevcut app tururnu(context) bir bir yazdiriyoruz
        for (Object contextName : contextNames) {
            System.out.println(contextName);//NATIVE_APP   CHROMIUM
//            if (contextName.toString().contains("WEBVIEW")){
//                //alttaki kodda hangi app turunde calisacaksak onu set ediyoruz
//                driver.context((String) contextName);//WEBAPP DEVAM EDECEGIM
//                Thread.sleep(10000);
//            }
        }
        //artik set ettigimiz context ile test devam ediyiruz.
        System.out.println("2 "+driver.getContext());//
        driver.findElementByXPath("//android.view.View[@content-desc='Sign In ›']").click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElementByXPath("//android.view.View[@text='Welcome']").isDisplayed());

        System.out.println("3 "+driver.getContext());//
        driver.quit();

    }
}
