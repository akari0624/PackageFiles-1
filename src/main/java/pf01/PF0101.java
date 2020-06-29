package main.java.pf01;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JFrame;

public class PF0101 {

	//static final String contentText = "1.)新增切換案鈕方便打包，\n  src←→classes，java←→class。\n\n2.)檔案位址請使用'\\'(左上右下斜線)做區隔。\n\n3.)多檔案位置可使用';'(分號)區隔位置。\n\n4.)若有重複檔案，此程式將自行覆蓋，請小心使用。\n\n5.)檔案母位置：為不打包部分，供檔案複製用。\n\n  例：D:\\project\\TBVD\\TBVD\\moiland-web100\\WebRoot\n\n6.)存檔位置：為檔案打包須存放之位置。\n\n  例：D:\\TBVD\\webapp\n\n7.)檔案位置：為須打包覆部分。\n\n  例：REG\\RAA01\\RAA0101.jsp\n\n8.)於檔案位置點擊Enter鍵可直接輸入。\n\n9.)如須抓取網路上之檔案，請於檔案母位置先行輸入IP\n\n10.)修改為打包時程式大小寫需相同\n\n11.)修改為可點選資料夾抓取以下所有檔案\n";
	static final String contentText = "操作說明:\n" 
			+ "–來源路徑: 指定本機檔案來源路徑 \n  D:\\project\\workspace\\web_moi_kcg\n"
			+ "–目標路徑: 指定推送檔案目的地路徑 \n  \\\\127.0.0.1\\moiland\\webapp\n"
			+ "–檔案位置: 輸入檔案名稱,可以用';'符號切分多個檔案 \n  WEB-INF\\src\\...\\AjaxReport.java; ADM\\ASL05\\ASL0502.jsp\n" + "\n"
			+ "功能說明:\n" 
			+ "–輸入檔案位置: 提供可批次輸入本機來源路徑，\n  依檔案位置欄位內容，批次列於檔案列表\n"
			+ "–推送檔案: 提供可批次輸入本機來源路徑，\n  依檔案列表的檔案清單內容，推送至目標路徑\n" + "–清除列表: 清空檔案列表內容\n"
			+ "–匯入純文字檔: 以純文字檔案，將檔案內容匯入至檔案列表中\n" + "–切換原始/執行檔: 切換 java / classes 路徑\n  src←→classes，java←→class。\n"
			+ "–加減WebRoot: 在檔案列表中每列前方加上'WebRoot\\\"前輟\n  WEB-INF←→WebRoot\\WEB-INF。\n"
			+ "–加減webapp: 在檔案列表中每列前方加上'webapp\\\"前輟\n  WEB-INF←→webapp\\WEB-INF。\n"
			+ "–匯出Bat檔: 將輸入的檔案例表打包功能，\n  匯出成可於Windows環境下獨力執行的.bat檔\n" + "\n" 
			+ "提醒說明:\n" 
			+ "–若有重複檔案，此程式將自行覆蓋，請小心使用。\n"
			+ "–若目標路徑為AP Server 等網路路徑，請先透過Windows檔案總管訪問，通過登入驗證後再做推送。\n";
	static final String packageRecordTitle = "推送檔案彙整";
	static JFrame f1 = new JFrame("程式推送工具(Ver.20200625)");
	static TextArea taTable = new TextArea(contentText, 25, 50);
	static Label lbTitleVersion = new Label("");
	static Label lbTitleContent = new Label("檔案推送程式");
	static Label lbGetFile = new Label("來源路徑：");
	static Label lbSaveFile = new Label("目標路徑：");
	static Label lbSelectFile = new Label("檔案位置：");
	static Label lbTalbe = new Label("檔案列表：");
	static Label lbInput = new Label("輸入");
	static Label lbSwitch = new Label("列表切換");
	static Label lbOutput = new Label("輸出");
	static TextField tfGetFile = new TextField("", 30);
	static TextField tfSaveFile = new TextField("", 30);
	static TextField tfSelectFile = new TextField("", 30);
	static TextField tfHidden = new TextField("", 30);
	static Button btGetFile = new Button("瀏覽");
	static Button btSaveFile = new Button("瀏覽");
	static Button btSelectFile = new Button("瀏覽");
	static Button btKeyin = new Button("輸入檔案位置");
	static Button btInput = new Button("匯入純文字檔");
	static Button btFoldInput = new Button("從來源路徑匯入");
	static Button btPack = new Button("推送檔案");
	static Button btClear = new Button("清除列表");
	static Button btOutScript = new Button("匯出腳本");
	static Button btInScript = new Button("匯入腳本");
	static Button btSwitch = new Button("切換原始/執行檔");
	static Button btADWebRoot = new Button("加減WebRoot");
	static Button btADwebapp = new Button("加減webapp");
	static Button btOutBat = new Button("匯出Bat檔");
	static TextArea taMes = new TextArea("", 30, 100);
	static Label block = new Label("");

	public static void main(String[] args) throws Exception {
		f1.setLocation(300, 100);
		f1.setSize(500, 580);
		f1.setBackground(new Color(220, 220, 255));
		f1.addWindowListener(new WindowEventHandler());
		f1.setLayout(new java.awt.GridBagLayout());
		f1.setDefaultCloseOperation(3);
		f1.setFont(new Font("微軟正黑", Font.BOLD, 26));
		
		GridBagConstraints c1 = new GridBagConstraints();
		btGetFile.setBackground(new Color(220, 220, 255));
		btSaveFile.setBackground(new Color(220, 220, 255));
		btSelectFile.setBackground(new Color(220, 220, 255));
		btKeyin.setBackground(new Color(220, 220, 255));
		btFoldInput.setBackground(new Color(220, 220, 255));
		btInput.setBackground(new Color(220, 220, 255));
		btPack.setBackground(new Color(220, 220, 255));
		btClear.setBackground(new Color(220, 220, 255));
		btOutScript.setBackground(new Color(220, 220, 255));
		btInScript.setBackground(new Color(220, 220, 255));
		btSwitch.setBackground(new Color(220, 220, 255));
		btADWebRoot.setBackground(new Color(220, 220, 255));
		btADwebapp.setBackground(new Color(220, 220, 255));
		btOutBat.setBackground(new Color(220, 220, 255));
		lbInput.setAlignment(Label.CENTER);
		lbOutput.setAlignment(Label.CENTER);
		lbSwitch.setAlignment(Label.CENTER);

		c1.gridx = 0;
		c1.gridy = 0;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 2;
		c1.anchor = 18;
		f1.add(lbTitleVersion, c1);

		c1.gridx = 0;
		c1.gridy = 1;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 0;
		c1.anchor = 17;
		f1.add(lbGetFile, c1);

		c1.gridx = 1;
		c1.gridy = 1;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 0;
		c1.anchor = 17;
		f1.add(tfGetFile, c1);

		c1.gridx = 3;
		c1.gridy = 1;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 2;
		c1.anchor = 17;
		f1.add(btGetFile, c1);

		c1.gridx = 0;
		c1.gridy = 2;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 0;
		c1.anchor = 17;
		f1.add(lbSaveFile, c1);

		c1.gridx = 1;
		c1.gridy = 2;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 0;
		c1.anchor = 17;
		f1.add(tfSaveFile, c1);

		c1.gridx = 3;
		c1.gridy = 2;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 2;
		c1.anchor = 17;
		f1.add(btSaveFile, c1);

		c1.gridx = 0;
		c1.gridy = 3;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 0;
		c1.anchor = 17;
		f1.add(lbSelectFile, c1);

		c1.gridx = 1;
		c1.gridy = 3;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 0;
		c1.anchor = 17;
		f1.add(tfSelectFile, c1);

		c1.gridx = 3;
		c1.gridy = 3;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 2;
		c1.anchor = 17;
		f1.add(btSelectFile, c1);
		
		
		

		//input function start
		c1.gridx = 3;
		c1.gridy = 7;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 2;
		c1.anchor = 17;
		f1.add(lbInput, c1);

		c1.gridx = 3;
		c1.gridy = 8;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 2;
		c1.anchor = 17;
		f1.add(btKeyin, c1);

		c1.gridx = 3;
		c1.gridy = 9;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 2;
		c1.anchor = 17;
		f1.add(btFoldInput, c1);

		c1.gridx = 3;
		c1.gridy = 10;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 2;
		c1.anchor = 17;
		f1.add(btInput, c1);

		c1.gridx = 3;
		c1.gridy = 11;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 2;
		c1.anchor = 17;
		f1.add(lbSwitch, c1);
		

		c1.gridx = 3;
		c1.gridy = 12;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 2;
		c1.anchor = 17;
		f1.add(btClear, c1);

		c1.gridx = 3;
		c1.gridy = 13;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 2;
		c1.anchor = 17;
		f1.add(btSwitch, c1);

		c1.gridx = 3;
		c1.gridy = 15;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 2;
		c1.anchor = 17;
		f1.add(btADWebRoot, c1);

		c1.gridx = 3;
		c1.gridy = 16;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 2;
		c1.anchor = 17;
		f1.add(btADwebapp, c1);

		c1.gridx = 3;
		c1.gridy = 17;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 2;
		c1.anchor = 17;
		f1.add(lbOutput, c1);
		
		c1.gridx = 3;
		c1.gridy = 18;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 2;
		c1.anchor = 17;
		f1.add(btPack, c1);
		
		
		c1.gridx = 3;
		c1.gridy = 19;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 2;
		c1.anchor = 17;
		f1.add(btOutBat, c1);
		
		//function end
		
		

		c1.gridx = 0;
		c1.gridy = 5;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 2;
		c1.anchor = 17;

		c1.gridx = 0;
		c1.gridy = 6;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 2;
		c1.anchor = 17;
		f1.add(lbTalbe, c1);

		c1.gridx = 0;
		c1.gridy = 7;
		c1.gridwidth = 3;
		c1.gridheight = 14;
		c1.weightx = 0.0D;
		c1.weighty = 0.0D;
		c1.fill = 2;
		c1.anchor = 17;
		f1.add(taTable, c1);

		if (System.getProperty("os.name").toLowerCase().contains("windows")) {
			// os是 windows
			btKeyin.addActionListener(new ActionControlInWindowsOS());
			btPack.addActionListener(new ActionControlInWindowsOS());
			btClear.addActionListener(new ActionControlInWindowsOS());
			btGetFile.addActionListener(new GetFile());
			btSaveFile.addActionListener(new SaveFile());
			btSelectFile.addActionListener(new SelectFile());
			btFoldInput.addActionListener(new ActionControlInWindowsOS());
			btInput.addActionListener(new ActionControlInWindowsOS());
			btOutScript.addActionListener(new ActionControlInWindowsOS());
			btSwitch.addActionListener(new ActionControlInWindowsOS());
			btADWebRoot.addActionListener(new ActionControlInWindowsOS());
			btADwebapp.addActionListener(new ActionControlInWindowsOS());
			btOutBat.addActionListener(new ActionControlInWindowsOS());
		} else {
			// os 是 unix-like
			btKeyin.addActionListener(new ActionControlInUnixLikeOS());
			btPack.addActionListener(new ActionControlInUnixLikeOS());
			btClear.addActionListener(new ActionControlInUnixLikeOS());
			btGetFile.addActionListener(new GetFile());
			btSaveFile.addActionListener(new SaveFile());
			btSelectFile.addActionListener(new SelectFile());
			btFoldInput.addActionListener(new ActionControlInUnixLikeOS());
			btInput.addActionListener(new ActionControlInUnixLikeOS());
			btOutScript.addActionListener(new ActionControlInUnixLikeOS());
			btSwitch.addActionListener(new ActionControlInUnixLikeOS());
			btADWebRoot.addActionListener(new ActionControlInUnixLikeOS());
			btADwebapp.addActionListener(new ActionControlInUnixLikeOS());
			btOutBat.addActionListener(new ActionControlInUnixLikeOS());
		}
		taTable.addFocusListener(new FocusContol());
		tfSaveFile.addKeyListener(new KeyinControl());
		f1.setVisible(true);
	}
}

/*
 * Location: /home/morris/programing/PackageFile.jar!/pf01/PF0101.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */