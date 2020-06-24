package main.java.pf01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

class GetFile implements ActionListener {
	public void actionPerformed(ActionEvent ae) {
		JFileChooser chooser = new JFileChooser(PF0101.tfGetFile.getText());
		chooser.setMultiSelectionEnabled(false);
		chooser.setFileSelectionMode(1);
		if (chooser.showOpenDialog(PF0101.f1.getContentPane()) == 0) {
			PF0101.tfGetFile.setText(chooser.getSelectedFile().getAbsolutePath());
		}
	}
}

/*
 * Location: /home/morris/programing/PackageFile.jar!/pf01/getFile.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */