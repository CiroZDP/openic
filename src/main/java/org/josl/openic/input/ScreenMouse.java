package org.josl.openic.input;

import java.awt.*;

public final class ScreenMouse extends Mouse {

    @Override
    public double getX() {
        return getLocation().getX();
    }

    @Override
    public double getY() {
        return getLocation().getY();
    }

    @Override
    public Point getLocation() {
        return MouseInfo.getPointerInfo().getLocation();
    }

}
