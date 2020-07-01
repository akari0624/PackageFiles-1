package pf01.event;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;

public class EnterKeyEventActionMapper extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private JFileChooser chooserRef;

	public EnterKeyEventActionMapper(JFileChooser chooser) {

		this.chooserRef = chooser;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		File file = chooserRef.getSelectedFile();
		if (file.isDirectory()) {
			chooserRef.setCurrentDirectory(file);
			chooserRef.rescanCurrentDirectory();
		}
	}

}