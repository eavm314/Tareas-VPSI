package tareas.mobileTesting2.factoryDevice;

public class FactoryDevices {

    public static IDevice make(String deviceType){
        IDevice device;
        switch (deviceType.toLowerCase()){
            default:
                device = new Android();
                break;
        }
        return device;
    }
}

