package main.java.pf01;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.channels.FileChannel;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.lang.StringUtils;

class ActionControlInWindowsOS implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String action = new String(e.getActionCommand());
		if ("清除列表".equals(action)) {
			clear();
		} else if ("瀏覽檔案".equals(action)) {
			keyin();
		} else if ("推送檔案".equals(action)) {
			pack();
		} else if ("匯入純文字檔".equals(action)) {
			input();
		} else if ("匯出腳本".equals(action)) {
			outScript();
		} else if ("輸入檔案位置".equals(action)) {
			keyin();
		} else if ("切換原始/執行檔".equals(action)) {
			switchSourceAndCode();
		} else if ("加減WebRoot".equals(action)) {
			switchADWebRoot();
		} else if ("加減webapp".equals(action)) {
			switchADwebapp();
		} else if ("匯出Bat檔".equals(action)) {
			outBat();
		} else if ("從來源路徑匯入清單".equals(action)) {
			folderInput();
		} else {
			JOptionPane.showMessageDialog(null, "按鍵錯誤", "警告", 2);
		}
	}

	public static void switchADWebRoot() {
		String tablePath = PF0101.taTable.getText();
		if (tablePath.contains("WebRoot")) {
			tablePath = tablePath.replaceAll("WebRoot", "");
		} else {
			String[] temp = tablePath.split("\n");
			tablePath = "";
			for (String tmp : temp) {
				if (tmp.contains("/")) {
					tmp = tmp.replace("/", "\\");
				}
				if ((tmp.length() > 0) && (!tmp.equals(""))) {
					if (tmp.substring(0, 1).equals("\\")) {
						tmp = ("WebRoot" + tmp + "\n");
						tablePath = tablePath + tmp;
					} else {
						tmp = ("WebRoot\\" + tmp + "\n");
						tablePath = tablePath + tmp;
					}
				} else {
					tablePath = tablePath + "\n";
				}
			}
		}
		PF0101.taTable.setText(tablePath);
	}

	public static void switchADwebapp() {
		String tablePath = PF0101.taTable.getText();
		if (tablePath.contains("webapp")) {
			tablePath = tablePath.replaceAll("webapp", "");
		} else {
			String[] temp = tablePath.split("\n");
			tablePath = "";
			for (String tmp : temp) {
				if (tmp.contains("/")) {
					tmp = tmp.replace("/", "\\");
				}
				if ((tmp.length() > 0) && (!tmp.equals(""))) {
					if (tmp.substring(0, 1).equals("\\")) {
						tmp = ("webapp" + tmp + "\n");
						tablePath = tablePath + tmp;
					} else {
						tmp = ("webapp\\" + tmp + "\n");
						tablePath = tablePath + tmp;
					}
				} else {
					tablePath = tablePath + "\n";
				}
			}
		}
		PF0101.taTable.setText(tablePath);
	}

	public static void switchSourceAndCode() {
		String tablePath = PF0101.taTable.getText();
		String savePath = PF0101.tfSaveFile.getText();

		if ((tablePath.contains("src")) || (savePath.contains("WebRoot"))) {
			tablePath = tablePath.replaceAll("src", "classes");
			if (tablePath.contains("java"))
				tablePath = tablePath.replaceAll("java", "class");
			if (tablePath.contains("WebRoot"))
				tablePath = tablePath.replaceAll("WebRoot", "webapp");
			if (savePath.contains("WebRoot"))
				savePath = savePath.replaceAll("WebRoot", "webapp");
		} else if ((tablePath.contains("classes")) || (savePath.contains("webapp"))) {
			tablePath = tablePath.replaceAll("classes", "src");
			if (tablePath.contains("class"))
				tablePath = tablePath.replaceAll("class", "java");
			if (tablePath.contains("webapp"))
				tablePath = tablePath.replaceAll("webapp", "WebRoot");
			if (savePath.contains("webapp")) {
				savePath = savePath.replaceAll("webapp", "WebRoot");
			}
		}
		PF0101.taTable.setText(tablePath);
		PF0101.tfSaveFile.setText(savePath);
	}

	public static void clear() {
		PF0101.taTable.setText("");
	}

	public static void keyin() {
		String getPath = PF0101.tfGetFile.getText();
		String savePath = PF0101.tfSaveFile.getText();
		String selectPath = PF0101.tfSelectFile.getText();
		PF0101.tfGetFile.setBackground(new Color(255, 255, 255));
		PF0101.tfSaveFile.setBackground(new Color(255, 255, 255));
		PF0101.tfSelectFile.setBackground(new Color(255, 255, 255));
		PF0101.taTable.setBackground(new Color(255, 255, 255));
		if (PF0101.tfSelectFile.getText().equals(""))
			return;
		if (getPath.equals("")) {
			PF0101.tfGetFile.setBackground(new Color(255, 160, 160));
			JOptionPane.showMessageDialog(null, "尚未輸入來源路徑", "警告", 2);
			return;
		}
//		if (savePath.equals("")) {
//			PF0101.tfSaveFile.setBackground(new Color(255, 160, 160));
//			JOptionPane.showMessageDialog(null, "尚未輸入目標路徑", "警告", 2);
//			return;
//		}
		if (selectPath.equals("")) {
			PF0101.tfSelectFile.setBackground(new Color(255, 160, 160));
			JOptionPane.showMessageDialog(null, "尚未輸入檔案位置", "警告", 2);
			return;
		}
		if ((!getPath.substring(1, 2).equals(":")) && (!getPath.substring(1, 2).equals("\\"))) {
			PF0101.tfGetFile.setBackground(new Color(255, 160, 160));
			JOptionPane.showMessageDialog(null, "來源路徑須為絕對路徑", "警告", 2);
			return;
		}
//		if ((!savePath.substring(1, 2).equals(":")) && (!savePath.substring(1, 2).equals("\\"))) {
//			PF0101.tfSaveFile.setBackground(new Color(255, 160, 160));
//			JOptionPane.showMessageDialog(null, "目標路徑須為絕對路徑", "警告", 2);
//			return;
//		}
		if (StringUtils.isNotBlank(PF0101.taTable.getText()) && PF0101.taTable.getText().startsWith("操作說明")) {
			PF0101.taTable.setText("");
		}

		String[] temp = PF0101.tfSelectFile.getText().split(";");
		for (String tmp : temp) {
			if (tmp.contains("/")) {
				tmp = tmp.replace("/", "\\");
			}
			if ((tmp.length() > 2) && ((tmp.substring(1, 2).equals(":")) || (tmp.substring(1, 2).equals("\\")))) {
				tmp = tmp.substring(getPath.length() + 1);
			}
			PF0101.taTable.append(tmp + "\n");
		}
		PF0101.tfSelectFile.setText("");
	}

	public static void pack() {
		String getPath = PF0101.tfGetFile.getText();
		String savePath = PF0101.tfSaveFile.getText();
		String tablePath = PF0101.taTable.getText();
		StringBuffer errMes = new StringBuffer("");
		StringBuffer okMes = new StringBuffer("");
		StringBuffer sucMes = new StringBuffer("");
		StringBuffer creMes = new StringBuffer("");
		PF0101.taMes.setText("");
		PF0101.tfGetFile.setBackground(new Color(255, 255, 255));
		PF0101.tfSaveFile.setBackground(new Color(255, 255, 255));
		PF0101.tfSelectFile.setBackground(new Color(255, 255, 255));
		PF0101.taTable.setBackground(new Color(255, 255, 255));
		int sucCount = 0, errCount = 0;
		if (getPath.equals("")) {
			PF0101.tfGetFile.setBackground(new Color(255, 160, 160));
			JOptionPane.showMessageDialog(null, "尚未輸入來源路徑", "警告", 2);
			return;
		}
		if (savePath.equals("")) {
			PF0101.tfSaveFile.setBackground(new Color(255, 160, 160));
			JOptionPane.showMessageDialog(null, "尚未輸入目標路徑", "警告", 2);
			return;
		}
		if (tablePath.equals("")) {
			PF0101.taTable.setBackground(new Color(255, 160, 160));
			JOptionPane.showMessageDialog(null, "尚未輸入檔案位置", "警告", 2);
			return;
		}
		if ((!getPath.substring(1, 2).equals(":")) && (!getPath.substring(1, 2).equals("\\"))) {
			PF0101.tfGetFile.setBackground(new Color(255, 160, 160));
			JOptionPane.showMessageDialog(null, "來源路徑須為絕對路徑", "警告", 2);
			return;
		}
		if ((!savePath.substring(1, 2).equals(":")) && (!savePath.substring(1, 2).equals("\\"))) {
			PF0101.tfSaveFile.setBackground(new Color(255, 160, 160));
			JOptionPane.showMessageDialog(null, "目標路徑須為絕對路徑", "警告", 2);
			return;
		}
		if (tablePath.substring(1, 2).equals(":")) {
			PF0101.taTable.setBackground(new Color(255, 160, 160));
			JOptionPane.showMessageDialog(null, "檔案列表不能為絕對路徑", "警告", 2);
			return;
		}

		sucMes.append("\n========================\n");
		sucMes.append("      成功推送紀錄\n");
		sucMes.append("========================\n");
		errMes.append("\n========================\n");
		errMes.append("      推送失敗紀錄\n");
		errMes.append("========================\n");
		creMes.append("\n========================\n");
		creMes.append("      建立資料夾紀錄\n");
		creMes.append("========================\n");

		String[] temp = tablePath.split("\n");
		for (String tmp : temp) {
			if (tmp.contains("/")) {
				tmp = tmp.replace("/", "\\");
			}
			if (!temp.equals("")) {
				String[] box = tmp.split("\\\\");
				String selectFilePath = new String();
				for (int j = 0; j < box.length - 1; j++) {
					selectFilePath = selectFilePath + "\\" + box[j];
				}
				try {
					File saveFile = new File(savePath + "\\" + selectFilePath);
					File getFile = new File(getPath + "\\" + tmp);
					File selectFile = new File(savePath + "\\" + tmp);
					String[] check = new File(getPath + "\\" + tmp).getParentFile().list();
					if (check != null) {
						int checkFileName = 0;
						for (int j = 0; j < check.length; j++) {
							if (check[j].equals(box[(box.length - 1)])) {
								checkFileName++;
							}
						}
						if (checkFileName == 1) {
							if (!saveFile.exists()) {
								creMes.append(savePath + "\\" + selectFilePath + "\n");
								saveFile.mkdirs();
							}
							FileChannel inChannel = new FileInputStream(getPath + "\\" + tmp).getChannel();
							FileChannel outChannel = new FileOutputStream(savePath + "\\" + tmp).getChannel();
							long lastTime = getFile.lastModified();
							sucMes.append("來源檔案" + getPath + "\\" + tmp + "\n");
							sucMes.append("  移動到" + savePath + "\\" + tmp + "\n\n");
							outChannel.transferFrom(inChannel, 0L, inChannel.size());
							inChannel.close();
							outChannel.close();
							sucCount++;
							selectFile.setLastModified(lastTime);
						} else if (getFile.exists()) {
							errMes.append("來源檔案路徑大小寫錯誤： " + getPath + "\\" + tmp + " \n");
							errCount++;
						} else {
							errMes.append("來源檔案不存在： " + getPath + "\\" + tmp + " \n");
							errCount++;
						}
					} else {
						errMes.append("來源路徑不存在： " + getPath + "\\ \n");
						errCount++;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		okMes.append("推送檔案總數: " + temp.length + " 個, 成功推送: " + sucCount + " 個, 推送失敗: " + errCount + " 個\n");
		String msg = okMes.append(errMes).append(creMes).append(sucMes).toString();

		JOptionPane.showMessageDialog(null, PF0101.taMes, PF0101.packageRecordTitle, 1);
	}

	public static void folderInput() {
		String getPath = PF0101.tfGetFile.getText();
		if (getPath.equals("")) {
			PF0101.tfGetFile.setBackground(new Color(255, 160, 160));
			JOptionPane.showMessageDialog(null, "尚未輸入來源路徑", "警告", 2);
			return;
		}
		if ((!getPath.substring(1, 2).equals(":")) && (!getPath.substring(1, 2).equals("\\"))) {
			PF0101.tfGetFile.setBackground(new Color(255, 160, 160));
			JOptionPane.showMessageDialog(null, "來源路徑須為絕對路徑", "警告", 2);
			return;
		}
		if (getPath.contains("/")) {
			getPath = getPath.replace("/", "\\");
		}
		File folder = new File(getPath);
		StringBuffer path = new StringBuffer("");
		if (folder.exists() && folder.isDirectory()) {
			getFiles(folder,path);
			if(PF0101.taTable.getText().startsWith("操作")) {
				PF0101.taTable.setText(path.toString());
			} else {
				PF0101.taTable.setText(PF0101.taTable.getText()+path.toString());
			}
		} else {
			PF0101.tfGetFile.setBackground(new Color(255, 160, 160));
			JOptionPane.showMessageDialog(null, "來源路徑不存在或不為目錄", "警告", 2);
			return;
		}
	}
	
	public static void getFiles(File folder,StringBuffer path) {
		for(File f:folder.listFiles()) {
			if(f.isDirectory()) {
				getFiles(f, path);
			} else {
				path.append(f.getPath()+"\n");
			}
		}
	}

	public static void input() {
		try {
			PF0101.tfGetFile.setBackground(new Color(255, 255, 255));
			PF0101.tfSaveFile.setBackground(new Color(255, 255, 255));
			PF0101.tfSelectFile.setBackground(new Color(255, 255, 255));
			PF0101.taTable.setBackground(new Color(255, 255, 255));
			String getPath = PF0101.tfGetFile.getText();
			String savePath = PF0101.tfSaveFile.getText();
//			if (getPath.equals("")) {
//				PF0101.tfGetFile.setBackground(new Color(255, 160, 160));
//				JOptionPane.showMessageDialog(null, "尚未輸入來源路徑", "警告", 2);
//				return;
//			}
//			if (savePath.equals("")) {
//				PF0101.tfSaveFile.setBackground(new Color(255, 160, 160));
//				JOptionPane.showMessageDialog(null, "尚未輸入目標路徑", "警告", 2);
//				return;
//			}
//			if ((!getPath.substring(1, 2).equals(":")) && (!getPath.substring(1, 2).equals("\\"))) {
//				PF0101.tfGetFile.setBackground(new Color(255, 160, 160));
//				JOptionPane.showMessageDialog(null, "來源路徑須為絕對路徑", "警告", 2);
//				return;
//			}
//			if ((!savePath.substring(1, 2).equals(":")) && (!savePath.substring(1, 2).equals("\\"))) {
//				PF0101.tfSaveFile.setBackground(new Color(255, 160, 160));
//				JOptionPane.showMessageDialog(null, "目標路徑須為絕對路徑", "警告", 2);
//				return;
//			}
			String inputPath = new String();
			JFileChooser chooser = new JFileChooser();
			chooser.setMultiSelectionEnabled(false);
			chooser.setFileSelectionMode(0);
			chooser.changeToParentDirectory();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", new String[] { "TXT" });
			chooser.setFileFilter(filter);
			if (chooser.showOpenDialog(PF0101.f1.getContentPane()) == 0) {
				inputPath = chooser.getSelectedFile().getAbsolutePath();
				FileReader fr = new FileReader(inputPath);
				BufferedReader br = new BufferedReader(fr);
				String input = new String();
				while ((input = br.readLine()) != null) {
					if (StringUtils.isNotBlank(PF0101.taTable.getText())
							&& PF0101.taTable.getText().startsWith("操作說明")) {
						PF0101.taTable.setText("");
					}
					if ((input.substring(1, 2).equals(":")) || (input.substring(1, 2).equals("\\"))) {
						input = input.substring(getPath.length() + 1);
					}
					PF0101.taTable.append(input + "\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void outScript() {
		try {
			String getPath = PF0101.tfGetFile.getText();
			String savePath = PF0101.tfSaveFile.getText();
			String tablePath = PF0101.taTable.getText();
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", new String[] { "TXT" });
			chooser.setFileFilter(filter);
			chooser.setFileSelectionMode(1);
			if (chooser.showSaveDialog(PF0101.f1.getContentPane()) == 0) {
				File jf = chooser.getSelectedFile();
				File scriptFile = new File(jf.getAbsolutePath() + ".txt");
				FileWriter fwriter = new FileWriter(scriptFile);
				fwriter.write(getPath + "\r\n");
				fwriter.write(savePath + "\r\n");
				fwriter.write(tablePath + "\r\n");
				fwriter.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void outBat() {
		try {
			String getPath = PF0101.tfGetFile.getText();
			String savePath = PF0101.tfSaveFile.getText();
			String tablePath = PF0101.taTable.getText();
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", new String[] { "TXT" });
			chooser.setFileFilter(filter);
			chooser.setFileSelectionMode(1);
			if (chooser.showSaveDialog(PF0101.f1.getContentPane()) == 0) {
				File jf = chooser.getSelectedFile();
				File scriptFile = new File(jf.getAbsolutePath() + ".bat");
				FileWriter fwriter = new FileWriter(scriptFile);
				fwriter.write("@來源路徑\r\n");
				fwriter.write("set getPath=" + getPath + "\r\n");
				fwriter.write("@目標路徑\r\n");
				fwriter.write("set savePath=" + savePath + "\r\n");
				String[] temp = tablePath.split("\n");
				for (String tmp : temp) {
					if (tmp.contains("/")) {
						tmp = tmp.replace("/", "\\");
					}
					fwriter.write("mkdir %savePath%\\" + tmp.substring(0, tmp.lastIndexOf("\\")) + "\r\n");
					fwriter.write("copy /Y %getPath%\\" + tmp + " %savePath%\\" + tmp + "\r\n");
				}
				fwriter.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/*
 * Location: /home/morris/programing/PackageFile.jar!/pf01/actionControl.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */