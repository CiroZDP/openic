package org.josl.openic.input;

import net.java.games.input.Controller;

public abstract class Device {

    protected Controller controller;
    public long ID = -1;

    public Device(Controller controller) {
        this.controller = controller;
    }

    public Device() {
        this(null);
    }

    public final Controller getController() {
        return this.controller;
    }

}
