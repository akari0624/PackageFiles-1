package pf01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaveFile implements ActionListener {
	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	public void actionPerformed(ActionEvent ae) {
		JFileChooser chooser = new JFileChooser(PF0101.tfSaveFile.getText());
		chooser.setMultiSelectionEnabled(false);
		chooser.setFileSelectionMode(1);
		if (chooser.showOpenDialog(PF0101.f1.getContentPane()) == 0) {
			PF0101.tfSaveFile.setText(chooser.getSelectedFile().getAbsolutePath());
		}
	}
}

/*
 * Location: /home/morris/programing/PackageFile.jar!/pf01/saveFile.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */