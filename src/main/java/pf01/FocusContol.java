package main.java.pf01;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import org.apache.commons.lang.StringUtils;

public class FocusContol implements FocusListener {

	@Override
	public void focusGained(FocusEvent e) {
		if(StringUtils.isNotBlank(PF0101.taTable.getText()) && PF0101.taTable.getText().startsWith("¾Þ§@»¡©ú"))
		PF0101.taTable.setText("");
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(StringUtils.isBlank(PF0101.taTable.getText()))
		PF0101.taTable.setText(PF0101.contentText);
	}

}
