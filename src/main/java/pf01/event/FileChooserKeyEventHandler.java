package pf01.event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.JFileChooser;

public class FileChooserKeyEventHandler implements KeyListener {

	private JFileChooser chooserRef;

	public FileChooserKeyEventHandler(JFileChooser chooser) {

		this.chooserRef = chooser;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			File file = chooserRef.getSelectedFile();
			if (file.isDirectory()) {
				chooserRef.setCurrentDirectory(file);
				chooserRef.rescanCurrentDirectory();

				e.consume();
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}
