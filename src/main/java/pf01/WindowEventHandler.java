package pf01;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class WindowEventHandler implements WindowListener {
	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	public void windowOpened(WindowEvent we) {
	}

	public void windowClosing(WindowEvent we) {
		System.exit(0);
	}

	public void windowClosed(WindowEvent we) {
	}

	public void windowActivated(WindowEvent we) {
	}

	public void windowDeactivated(WindowEvent we) {
	}

	public void windowIconified(WindowEvent we) {
	}

	public void windowDeiconified(WindowEvent we) {
	}
}

/*
 * Location:
 * /home/morris/programing/PackageFile.jar!/pf01/WindowEventHandler.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */