package pf01;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.CompletableFuture;
import java.lang.Thread;

import org.apache.commons.lang.StringUtils;

//Auto Complete
public class GetKeyinControlInWinOS implements KeyListener {
	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private long previousKeyReleaseTime = 0L;
	private long keyReleaseThreshold = 800;
	private boolean isScaningFolder = false;


	private void doFolderScan(String parentPath, String targetPath) {
		isScaningFolder = true;
		CompletableFuture.supplyAsync(() -> {
			try {
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
						return target;
					}
				}else {
					return "";
				}
			} catch(Exception ex) {
					log.error("I/O went wrong");
			}

			return "";

	}).whenComplete((target, exception) -> {
		isScaningFolder = false;
		EventQueue.invokeLater(()->{
			log.info("run on which thread? "+ Thread.currentThread().getName());
			if(!target.equals("")) {
				PF0101.tfGetFile.setText(parentPath + target + "/");
				PF0101.tfGetFile.setCaretPosition(PF0101.tfGetFile.getText().length());
			}
			if(exception != null) {
				log.error("I/O went wrong when doing job in for/join thread pool:"+ exception.toString());
			}
		});
	});
	}
	
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
		if (this.appearNumber(value, "\\.") < 3 && !value.contains(":")) {
			if (e.getKeyChar() == '\\') {
				if (value.startsWith("\\") && value.length() < 2)
					PF0101.tfGetFile.setText("\\\\172.16.");
				PF0101.tfGetFile.setCaretPosition(PF0101.tfGetFile.getText().length());
			} else if (value.startsWith("\\\\") && e.getKeyChar() == '1') {
				if (value.startsWith("\\\\1"))
					PF0101.tfGetFile.setText("\\\\172.");
				if (value.startsWith("\\\\172.1"))
					PF0101.tfGetFile.setText("\\\\172.16.");
				if (value.startsWith("\\\\172.16.31"))
					PF0101.tfGetFile.setText("\\\\172.16.31.7\\");
				PF0101.tfGetFile.setCaretPosition(PF0101.tfGetFile.getText().length());
			} else if (value.startsWith("\\\\") && e.getKeyChar() == '2') {
				if (value.startsWith("\\\\172.16.32"))
					PF0101.tfGetFile.setText("\\\\172.16.32.39\\");
				if (value.startsWith("\\\\172.16.32.42"))
					PF0101.tfGetFile.setText("\\\\172.16.32.42\\");
				PF0101.tfGetFile.setCaretPosition(PF0101.tfGetFile.getText().length());
			} else if (value.startsWith("\\\\") && e.getKeyChar() == '4') {
				if (value.startsWith("\\\\172.16.32.4"))
					PF0101.tfGetFile.setText("\\\\172.16.32.46\\");
				PF0101.tfGetFile.setCaretPosition(PF0101.tfGetFile.getText().length());
			} else if (value.startsWith("\\\\") && e.getKeyChar() == '5') {
				if (value.startsWith("\\\\172.16.5"))
					PF0101.tfGetFile.setText("\\\\172.16.52.7\\");
				PF0101.tfGetFile.setCaretPosition(PF0101.tfGetFile.getText().length());
			}
		} else if (e.getKeyCode() != 8) {
			String parentPath = value.substring(0, value.lastIndexOf("/") + 1);
			String targetPath = value.substring(value.lastIndexOf("/") + 1);

			long thisTimeMills = System.currentTimeMillis();
			long diffTimeMill = thisTimeMills - previousKeyReleaseTime;
			previousKeyReleaseTime = thisTimeMills;
			
			if(diffTimeMill > keyReleaseThreshold && !isScaningFolder)	{
				log.info("do FolderScan");
				doFolderScan(parentPath, targetPath);
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
