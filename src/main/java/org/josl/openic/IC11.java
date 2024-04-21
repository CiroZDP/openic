package org.josl.openic;

import java.awt.*;

public class IC11 {

    private IC11() {}

    public static void icSetRelativeMousePos(int relpos) {
        IC.setMouseRelativePos(relpos);
    }

    public static void icSetMousePos(Point p) {
        IC.setMousePos(p);
    }

    public static Point icGetMousePos() {
        return IC.getMousePos();
    }

    public static int icGetMouseX() {
        return IC.getMouseX();
    }

    public static int icGetMouseY() {
        return IC.getMouseY();
    }

}
