
package main.java.pf01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

public class SelectFile implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent ae) {
		PF0101.tfSelectFile.setText("");
		JFileChooser chooser = new JFileChooser(PF0101.tfGetFile.getText());

		if (!PF0101.tfHidden.getText().equals("")) {
			chooser = new JFileChooser(PF0101.tfHidden.getText());
		}

		chooser.setMultiSelectionEnabled(true);
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		// KeyListener fileChooserKeyEventHandler = new
		// FileChooserKeyEventHandler(chooser);
		// chooser.addKeyListener(fileChooserKeyEventHandler);

		// chooser.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ENTER"),
		// "fileChooserKeyEvent");
		// chooser.getActionMap().put("fileChooserKeyEvent", new
		// EnterKeyEventActionMapper(chooser));
		// logger.info("event binded");

		if (chooser.showOpenDialog(PF0101.f1.getContentPane()) == JFileChooser.APPROVE_OPTION) {
			File[] selectFile = chooser.getSelectedFiles();

			// 原：selectFile[0].getAbsoluteFile() 會造成無法編譯
			String hiddenFile = selectFile[0].getAbsoluteFile().toString();
			for (int i = 0; i < selectFile.length; i++) {
				getAllFile(selectFile[i]);
			}

			PF0101.tfHidden.setText(hiddenFile);

			if (System.getProperty("os.name").toLowerCase().contains("windows")) {

				ActionControlInWindowsOS.keyin();
			} else {

				ActionControlInUnixLikeOS.keyin();
			}

		}

		// chooser.removeKeyListener(fileChooserKeyEventHandler);
		// logger.info("event Handler removed");
	}

	public void getAllFile(File file) {
		if (file.isDirectory()) {
			File[] fileArr = file.listFiles();
			for (int i = 0; i < fileArr.length; i++) {
				if (fileArr[i].isDirectory()) {
					getAllFile(fileArr[i]);
				} else {
					PF0101.tfSelectFile.setText(PF0101.tfSelectFile.getText() + fileArr[i].getAbsolutePath() + ";");
				}
			}
		} else {
			PF0101.tfSelectFile.setText(PF0101.tfSelectFile.getText() + file.getAbsolutePath() + ";");
		}
	}
}

/*
 * Location: /home/morris/programing/PackageFile.jar!/pf01/selectFile.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */