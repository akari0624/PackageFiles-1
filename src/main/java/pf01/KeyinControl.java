package main.java.pf01;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Auto Complete
public class KeyinControl implements KeyListener {

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
		String value = PF0101.tfSaveFile.getText();
		if(e.getKeyChar() == '\\') {
			if(value.startsWith("\\"))
				PF0101.tfSaveFile.setText("\\\\172.16.");
			PF0101.tfSaveFile.setCaretPosition(PF0101.tfSaveFile.getText().length());
		} else if(value.startsWith("\\\\") && e.getKeyChar() == '1') {
			if(value.startsWith("\\\\1"))
				PF0101.tfSaveFile.setText("\\\\172.");
			if(value.startsWith("\\\\172.1"))
				PF0101.tfSaveFile.setText("\\\\172.16.");
			if(value.startsWith("\\\\172.16.31"))
				PF0101.tfSaveFile.setText("\\\\172.16.31.7\\opt\\moiland\\");
			PF0101.tfSaveFile.setCaretPosition(PF0101.tfSaveFile.getText().length());
		} else if(value.startsWith("\\\\") && e.getKeyChar() == '2') {
			if(value.startsWith("\\\\172.16.32"))
				PF0101.tfSaveFile.setText("\\\\172.16.32.39\\opt\\moiland\\");
			if(value.startsWith("\\\\172.16.32.42"))
				PF0101.tfSaveFile.setText("\\\\172.16.32.42\\opt\\moiland\\");
			PF0101.tfSaveFile.setCaretPosition(PF0101.tfSaveFile.getText().length());
		} else if(value.startsWith("\\\\") && e.getKeyChar() == '4') {
			if(value.startsWith("\\\\172.16.32.4"))
				PF0101.tfSaveFile.setText("\\\\172.16.32.46\\opt\\moiland\\");
			PF0101.tfSaveFile.setCaretPosition(PF0101.tfSaveFile.getText().length());
		} else if(value.startsWith("\\\\") && e.getKeyChar() == '5') {
			if(value.startsWith("\\\\172.16.5"))
				PF0101.tfSaveFile.setText("\\\\172.16.52.7\\opt\\moiland\\");
			PF0101.tfSaveFile.setCaretPosition(PF0101.tfSaveFile.getText().length());
		}
	}

}
