package org.josl.openic;

import org.josl.openic.input.Device;
import org.josl.openic.input.Keyboard;
import org.josl.openic.input.Mouse;

import java.awt.*;
import java.util.*;
import java.util.List;

import static org.josl.openic.IC10.*;

public class IC {

	private static Robot bot;
	private static long idIndex = 0;
	private static final List<Device> devices = new ArrayList<>();
	private static final Map<Device.Type, Long> defaultDevices = new HashMap<>();

	static {
		Robot bot = null;
		try {
			bot = new Robot();
		} catch (Exception ignored) {
			System.err.println("WARNING: Can't create class java.awt.Robot!");
		}

		IC.bot = bot;
	}

	private IC() {}

	public static long genDeviceId() {
		return idIndex++;
	}

	public static boolean init() {
		return true;
	}

	public static long bindDevice(Device.Type type, Device device, int _default, long id) {
		devices.add((int) id, device);
		if (_default == IC_TRUE)
			defaultDevices.put(type, id);

		return device.ID = id;
	}

	public static void setMouseRelativePos(int relpos) {

		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;

		float x = 0;
		float y = switch (relpos) {
            case IC_LEFT, IC_LEFT_TOP, IC_TOP -> {
                x = 0;
                yield 0;
            }
            case IC_LEFT_BOTTOM, IC_BOTTOM -> {
                x = 0;
                yield h;
            }
            case IC_CENTER -> {
                x = (float) w / 2;
                yield (float) h / 2;
            }
            case IC_RIGHT_TOP, IC_RIGHT -> {
                x = w;
                yield 0;
            }
            case IC_RIGHT_BOTTOM -> {
                x = w;
                yield h;
            }
            default -> 0;
        };

        setMousePos(x, y);

	}

	public static void setMousePos(double x, double y) {
		bot.mouseMove((int) x, (int) y);
	}

	public static void setMousePos(Point p) {
		setMousePos(p.getX(), p.getY());
	}

	public static Point getMousePos() {
		return getDefaultMouse().getLocation();
	}

	public static double getMouseDX() {
		return getDefaultMouse().getX();
	}

	public static double getMouseDY() {
		return getDefaultMouse().getY();
	}

	public static int getMouseX() {
		return (int) getMouseDX();
	}

	public static int getMouseY() {
		return (int) getMouseDY();
	}

	public static boolean isKeyPressed(int keyCode) {
		return getDefaultKeyboard().isKeyPressed(keyCode);
	}

	public static Keyboard getDefaultKeyboard() {
		return (Keyboard) devices.get(
				(int) (long) defaultDevices.get(Device.Type.KEYBOARD));
	}

	public static Mouse getDefaultMouse() {
        return (Mouse) devices.get(
				(int) (long) defaultDevices.get(Device.Type.MOUSE));
	}

	public static boolean isBotWorking() {
		return bot != null;
	}
}
