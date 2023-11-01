package tareas.mobileTesting2.factoryDevice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public interface IDevice {
    AndroidDriver create();
}
