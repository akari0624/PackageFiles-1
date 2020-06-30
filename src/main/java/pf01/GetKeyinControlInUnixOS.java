package main.java.pf01;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

//Auto Complete
public class GetKeyinControlInUnixOS implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		String value = PF0101.tfGetFile.getText();
		if (this.appearNumber(value, ".") < 3 && !value.contains(":")) {
			if (e.getKeyChar() == '/') {
				if (value.startsWith("/") && value.length() < 2)
					PF0101.tfGetFile.setText("//172.16.");
				PF0101.tfGetFile.setCaretPosition(PF0101.tfGetFile.getText().length());
			} else if (value.startsWith("//") && e.getKeyChar() == '1') {
				if (value.startsWith("//1"))
					PF0101.tfGetFile.setText("//172.");
				if (value.startsWith("//172.1"))
					PF0101.tfGetFile.setText("//172.16.");
				if (value.startsWith("//172.16.31"))
					PF0101.tfGetFile.setText("//172.16.31.7/");
				PF0101.tfGetFile.setCaretPosition(PF0101.tfGetFile.getText().length());
			} else if (value.startsWith("//") && e.getKeyChar() == '2') {
				if (value.startsWith("//172.16.32"))
					PF0101.tfGetFile.setText("//172.16.32.39/");
				if (value.startsWith("//172.16.32.42"))
					PF0101.tfGetFile.setText("//172.16.32.42/");
				PF0101.tfGetFile.setCaretPosition(PF0101.tfGetFile.getText().length());
			} else if (value.startsWith("//") && e.getKeyChar() == '4') {
				if (value.startsWith("//172.16.32.4"))
					PF0101.tfGetFile.setText("//172.16.32.46/");
				PF0101.tfGetFile.setCaretPosition(PF0101.tfGetFile.getText().length());
			} else if (value.startsWith("//") && e.getKeyChar() == '5') {
				if (value.startsWith("//172.16.5"))
					PF0101.tfGetFile.setText("//172.16.52.7/");
				PF0101.tfGetFile.setCaretPosition(PF0101.tfGetFile.getText().length());
			}
		} else if (e.getKeyCode() != 8) {
			String parentPath = value.substring(0, value.lastIndexOf("/") + 1);
			String targetPath = value.substring(value.lastIndexOf("/") + 1);
			File folder = new File(parentPath);
			if (folder.isDirectory()) {
				String[] list = folder.list();
				String target = "";
				int cnt = 0;
				for (String p : list) {
					if ((StringUtils.containsIgnoreCase(p, targetPath)) && new File(parentPath, p).isDirectory()) {
						if (StringUtils.equalsIgnoreCase(p, targetPath)) {
							cnt = 1;
							target = p;
							break;
						} else {
							target = p;
							cnt++;
						}
					}
				}
				if (cnt == 1) {
					PF0101.tfGetFile.setText(parentPath + target + "/");
					PF0101.tfGetFile.setCaretPosition(PF0101.tfGetFile.getText().length());
				}
			}
		}
	}

	public static int appearNumber(String srcText, String findText) {
		int count = 0;
		Pattern p = Pattern.compile(findText);
		Matcher m = p.matcher(srcText);
		while (m.find()) {
			count++;
		}
		return count;
	}

}
