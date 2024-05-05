package org.josl.openic.input;

public abstract class Device {

    public static enum Type {
        KEYBOARD, MOUSE, JOYSTICK, GAMEPAD, STICK;
    }

    public long ID = -1;

}
