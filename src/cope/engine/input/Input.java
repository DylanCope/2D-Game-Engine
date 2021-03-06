package cope.engine.input;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import cope.engine.util.Vector;

public class Input implements KeyListener, FocusListener,
				MouseListener, MouseMotionListener {
	
	private Vector position = new Vector(0, 0);
	private boolean[] keys = new boolean[65536];
	private boolean[] mouseButtons = new boolean[4];
	
	public boolean getKey(int key) {
		return keys[key];
	}
	
	public boolean getMouse(int button) {
		return mouseButtons[button];
	}
	
	public Vector getMousePosition() {
		return position;
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		position = new Vector(event.getX(), event.getY());
	}

	@Override
	public void mouseMoved(MouseEvent event) {
		position = new Vector(event.getX(), event.getY());
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		
	}

	@Override
	public void mouseExited(MouseEvent event) {
		
	}

	@Override
	public void mousePressed(MouseEvent event) {
		System.out.println(position);
		int button = event.getButton();

		if (0 < button && button < mouseButtons.length)
			mouseButtons[button] = true;
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		
		int button = event.getButton();
		
		if (0 < button && button < mouseButtons.length)
			mouseButtons[button] = false;
		
	}

	@Override
	public void focusGained(FocusEvent event) {
		
	}

	@Override
	public void focusLost(FocusEvent event) {
		
		for (int i = 0; i < keys.length; i++)
			keys[i] = false;
		
		for (int i = 0; i < mouseButtons.length; i++)
			mouseButtons[i] = false;
		
	}

	@Override
	public void keyPressed(KeyEvent event) {
		
		int key = event.getKeyCode();
		
		if (0 < key && key < keys.length)
			keys[key] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent event) {
		
		int key = event.getKeyCode();
		
		if (0 < key && key < keys.length)
			keys[key] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent event) {
		
	}
	
	
	
}
