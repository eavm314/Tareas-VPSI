package tareas.mobileTesting.session;

import io.appium.java_client.AppiumDriver;
import tareas.mobileTesting.factoryDevice.FactoryDevices;

public class Session {

    private static Session session = null;
    private AppiumDriver device;

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

    public AppiumDriver getDevice() {
        return device;
    }
}
