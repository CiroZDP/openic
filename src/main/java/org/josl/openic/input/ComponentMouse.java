package org.josl.openic.input;

import java.awt.*;
import java.awt.event.*;

public final class ComponentMouse extends AbstractMouseButtonDetector
        implements MouseListener
{

    private Component parent;
    private MouseListener listener = null;

    private final boolean[] buttons = new boolean[Mouse.GetNumberOfButtons()];

    public ComponentMouse(Component parent) {
        this.parent = parent;
        parent.addMouseListener(this);
    }

    public ComponentMouse append(Component parent) {
        this.parent = parent;
        return this;
    }

    private void setButton(int button, boolean state) {
        buttons[button] = state;
    }

    public void appendListener(MouseListener listener) {
        this.listener = listener;
    }

    public MouseListener getListener() {
        return listener;
    }

    public void removeListener() {
        this.appendListener(null);
    }

    @Override
    public Point getLocation() {
        Point location = parent.getMousePosition();
        if (location == null)
            return new Point(0, 0);

        return location;
    }
    
    public boolean[] getButtons() {
        return buttons;
    }

    @Override
    public double getX() {
        return getLocation().getX();
    }

    @Override
    public double getY() {
        return getLocation().getY();
    }

    @Override
    public boolean isButtonPressed(int button) {
        return buttons[button];
    }

    @Override
    public void mousePressed(MouseEvent mouse) {
        if (listener != null)
            listener.mousePressed(mouse);

        setButton(mouse.getButton(), true);
    }

    @Override
    public void mouseReleased(MouseEvent mouse) {
        if (listener != null)
            listener.mouseReleased(mouse);

        setButton(mouse.getButton(), false);
    }

    @Override
    public void mouseClicked(MouseEvent mouse) {
        if (listener != null)
            listener.mouseClicked(mouse);
    }

    @Override
    public void mouseEntered(MouseEvent mouse) {
        if (listener != null)
            listener.mouseEntered(mouse);
    }

    @Override
    public void mouseExited(MouseEvent mouse) {
        if (listener != null)
            listener.mouseExited(mouse);
    }

}
