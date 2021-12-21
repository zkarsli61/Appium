package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium06ChromeWebApp {
    @Test
    public void test() throws InterruptedException, MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"2797316218000608");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        //http://chromedriver.chromium.org/download      bu linkten chrome versiyin builgisine ulasiyoruz
        //https://chromedriver.storage.googleapis.com/index.html  bu linkten butun versiyonlara ulasiyoruz


        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
//        desiredCapabilities.setCapability("chromedriverExecutable","C:\\_MyProjects\\Appium\\driver\\chromedriver.exe");

        WebDriverManager.chromedriver().setup();

        desiredCapabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,WebDriverManager.chromedriver().getDownloadedDriverPath());



//http://localhost:4723/wd/hub
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
         /*
         Calisma:
         “https://amazon.com" git
         sign in tikla
         Verify “Welcome” text from sign in page 
          */
        Thread.sleep(4000);
        driver.get("https://www.amazon.com/");
        System.out.println("1 "+driver.getContext());//CHROMIUM

        //remote device on chrome  https://developer.chrome.com/docs/devtools/remote-debugging/
        //chrome://inspect#devices  on chrome browser

        //https://appium.io/docs/en/commands/context/get-contexts/
        //getContextHandles() mevcut olab app turlerini Set konteynira ekliyoruz
        Set contextNames = driver.getContextHandles();
        //burda mevcut app tururnu(context) bir bir yazdiriyoruz
        for (Object contextName : contextNames) {
            System.out.println(contextName);//NATIVE_APP   CHROMIUM
//            }
        }

        driver.findElementByXPath("//a[@class='nav-a nav-show-sign-in']").click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElementByXPath("//h2").isDisplayed());

    }
}
