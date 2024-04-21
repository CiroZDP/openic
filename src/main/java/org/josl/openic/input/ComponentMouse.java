package org.josl.openic.input;

import java.awt.*;
import java.awt.event.*;

public final class ComponentMouse extends AbstractMouseButtonDetector
        implements MouseListener, MouseButtonDetector
{

    private Component parent;

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
        setButton(mouse.getButton(), true);
    }

    @Override
    public void mouseReleased(MouseEvent mouse) {
        setButton(mouse.getButton(), false);
    }

    @Override
    public void mouseClicked(MouseEvent mouse) {
    }

    @Override
    public void mouseEntered(MouseEvent mouse) {
    }

    @Override
    public void mouseExited(MouseEvent mouse) {
    }

}
