package org.josl.openic.input;

import javax.swing.plaf.basic.BasicListUI;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class Keyboard extends Device {

	private final Map<Integer, Boolean> pressedKeys = new HashMap<>();

	public Keyboard() {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(event -> {
			synchronized (Keyboard.class) {
				if (event.getID() == KeyEvent.KEY_PRESSED)
					pressedKeys.put(event.getKeyCode(), true);
				else if (event.getID() == KeyEvent.KEY_RELEASED)
					pressedKeys.put(event.getKeyCode(), false);
				return false;
			}
		});
	}

	public boolean isKeyPressed(int keyCode) {
		return pressedKeys.getOrDefault(keyCode, false);
	}

}