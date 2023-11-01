package tareas.mobileTesting2.session;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import tareas.mobileTesting2.factoryDevice.Android;
import tareas.mobileTesting2.factoryDevice.FactoryDevices;

public class Session {

    private static Session session = null;
    private AndroidDriver device;

    private Session(){
        device = FactoryDevices.make("android").create();
    }

    public static Session getSession(){
        if (session == null)
            session = new Session();
        return session;
    }

    public void closeApp(){
        device.quit();
        session = null;
    }

    public AndroidDriver getDevice() {
        return device;
    }
}
