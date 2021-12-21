package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium02 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"2797316218000608");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"7.0");        //eger appActivity ve appPackage kullanacaksaniz app path gerekli degil
  //      desiredCapabilities.setCapability(MobileCapabilityType.APP,"/Users/ayyildiz/IdeaProjects/AppiumTurkish/Apps/apiDemos.apk");
        //app acilirken izin istediginde appActivity ve appPackage tanimlayarak bu sorunu gecebilirsiniz.
        // app telefonda acin
        //terminal veya CMD prompt acarak adb shell  yazin
        //sonra dumpsys window | grep -E "mCurrentFocus" komutunu girice appActivity ve appPackage bilgilerini ulasabilirsiniz
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\\_MyProjects\\Appium\\Apps\\GestureTool.apk");
//        desiredCapabilities.setCapability("appPackage","com.davemac327.gesture.tool");
//        desiredCapabilities.setCapability("appActivity","com.davemac327.gesture.tool.GestureBuilderActivity");
//http://localhost:4723/wd/hub
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);

        Thread.sleep(4000);
    }
}
