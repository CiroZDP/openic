package org.josl.openic;

public class IC12 {

    private IC12() {}

    public static void icSetMousePos(double x, double y) {
        IC.setMousePos(x, y);
    }

    public static double icGetMouseDX() {
        return IC.getMouseDX();
    }

    public static double icGetMouseDY() {
        return IC.getMouseDY();
    }


}
