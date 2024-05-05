package org.josl.openic;

import org.josl.openic.input.Device;

public class IC15 {

    private IC15() {}

    public static long icGenDeviceId() {
        return IC.genDeviceId();
    }

    public static long icBindDevice(Device.Type type, Device device, int _default, long id) {
        return IC.bindDevice(type, device, _default, id);
    }

    public static boolean icIsBotWorking() {
        return IC.isBotWorking();
    }

    public static boolean icInit() {
        return IC.init();
    }

}
