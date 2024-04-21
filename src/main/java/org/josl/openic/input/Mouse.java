package org.josl.openic.input;

import java.awt.*;

public abstract class Mouse extends Device {

    public abstract double getX();
    public abstract double getY();
    public abstract Point getLocation();

    public static Mouse CreateScreenMouse() {
        return new ScreenMouse();
    }

    public static int GetNumberOfButtons() {
        return MouseInfo.getNumberOfButtons();
    }

}
