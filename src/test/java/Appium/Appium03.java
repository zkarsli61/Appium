package Appium;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Appium03 {
    @Test
    public void test() throws InterruptedException, MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"2797316218000608");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"7.0");//        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\\_MyProjects\\Appium\\Apps\\GestureTool.apk");
//        desiredCapabilities.setCapability(MobileCapabilityType.APP,"./Apps/GestureTool.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,new File("./Apps/GestureTool.apk").getAbsolutePath());
        System.out.println(new File("./Apps/GestureTool.apk").getAbsolutePath());
        //noReset
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
//http://localhost:4723/wd/hub
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(4000);
       //id ile bulduk
       // driver.findElementById("com.davemac327.gesture.tool:id/addButton").click();
       // id bu sekildede yazabilirsiniz
        // driver.findElementById("addButton").click();
        //xpath index ile bulduk
       // driver.findElementByXPath("(//android.widget.Button)[2]").click();
        //xpath text
        driver.findElementByXPath("//android.widget.Button[@text='Test']").click();
  /*
        lunch GestureTool app
        click test button
        verify title "Test a gesture"
        close app
         */
        Thread.sleep(3000);
         String expectedTitle = "Test a gesture";
         String actualTitle = driver.findElementById("android:id/title").getText();

        Assert.assertEquals(actualTitle,expectedTitle);

       //session kapat
        driver.quit();


    }
}
