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

	//static final String contentText = "1.)�s�W�����׶s��K���]�A\n  src����classes�Ajava����class�C\n\n2.)�ɮצ�}�Шϥ�'\\'(���W�k�U�׽u)���Ϲj�C\n\n3.)�h�ɮצ�m�i�ϥ�';'(����)�Ϲj��m�C\n\n4.)�Y�������ɮסA���{���N�ۦ��л\�A�Фp�ߨϥΡC\n\n5.)�ɮץ���m�G�������]�����A���ɮ׽ƻs�ΡC\n\n  �ҡGD:\\project\\TBVD\\TBVD\\moiland-web100\\WebRoot\n\n6.)�s�ɦ�m�G���ɮץ��]���s�񤧦�m�C\n\n  �ҡGD:\\TBVD\\webapp\n\n7.)�ɮצ�m�G�������]�г����C\n\n  �ҡGREG\\RAA01\\RAA0101.jsp\n\n8.)���ɮצ�m�I��Enter��i������J�C\n\n9.)�p����������W���ɮסA�Щ��ɮץ���m�����JIP\n\n10.)�קאּ���]�ɵ{���j�p�g�ݬۦP\n\n11.)�קאּ�i�I���Ƨ�����H�U�Ҧ��ɮ�\n";
	static final String contentText = "�ާ@����:\n" 
			+ "�V�ӷ����|: ���w�����ɮרӷ����| \n  D:\\project\\workspace\\web_moi_kcg\n"
			+ "�V�ؼи��|: ���w���e�ɮץت��a���| \n  \\\\127.0.0.1\\moiland\\webapp\n"
			+ "�V�ɮצ�m: ��J�ɮצW��,�i�H��';'�Ÿ������h���ɮ� \n  WEB-INF\\src\\...\\AjaxReport.java; ADM\\ASL05\\ASL0502.jsp\n" + "\n"
			+ "�\�໡��:\n" 
			+ "�V��J�ɮצ�m: ���ѥi�妸��J�����ӷ����|�A\n  ���ɮצ�m��줺�e�A�妸�C���ɮצC��\n"
			+ "�V���e�ɮ�: ���ѥi�妸��J�����ӷ����|�A\n  ���ɮצC���ɮײM�椺�e�A���e�ܥؼи��|\n" + "�V�M���C��: �M���ɮצC���e\n"
			+ "�V�פJ�¤�r��: �H�¤�r�ɮסA�N�ɮפ��e�פJ���ɮצC��\n" + "�V������l/������: ���� java / classes ���|\n  src����classes�Ajava����class�C\n"
			+ "�V�[��WebRoot: �b�ɮצC���C�C�e��[�W'WebRoot\\\"�e��\n  WEB-INF����WebRoot\\WEB-INF�C\n"
			+ "�V�[��webapp: �b�ɮצC���C�C�e��[�W'webapp\\\"�e��\n  WEB-INF����webapp\\WEB-INF�C\n"
			+ "�V�ץXBat��: �N��J���ɮרҪ��]�\��A\n  �ץX���i��Windows���ҤU�W�O���檺.bat��\n" + "\n" 
			+ "��������:\n" 
			+ "�V�Y�������ɮסA���{���N�ۦ��л\�A�Фp�ߨϥΡC\n"
			+ "�V�Y�ؼи��|��AP Server ���������|�A\n  �Х��z�LWindows�ɮ��`�޳X�ݡA�q�L�n�J���ҫ�A�����e�C\n";
	static final String packageRecordTitle = "���e�ɮ׷J��";
	static JFrame f1 = new JFrame("�{�����e�u��(Ver.20200625)");
	static TextArea taTable = new TextArea(contentText, 25, 50);
	static Label lbTitleVersion = new Label("");
	static Label lbTitleContent = new Label("�ɮױ��e�{��");
	static Label lbGetFile = new Label("�ӷ����|�G");
	static Label lbSaveFile = new Label("�ؼи��|�G");
	static Label lbSelectFile = new Label("�ɮצ�m�G");
	static Label lbTalbe = new Label("�ɮצC��G");
	static Label lbInput = new Label("��J");
	static Label lbSwitch = new Label("�C�����");
	static Label lbOutput = new Label("��X");
	static TextField tfGetFile = new TextField("", 35);
	static TextField tfSaveFile = new TextField("", 35);
	static TextField tfSelectFile = new TextField("", 35);
	static TextField tfHidden = new TextField("", 35);
	static Button btGetFile = new Button("�s��");
	static Button btSaveFile = new Button("�s��");
	static Button btSelectFile = new Button("�s��");
	static Button btKeyin = new Button("��J�ɮצ�m");
	static Button btInput = new Button("�פJ�¤�r��");
	static Button btFoldInput = new Button("�q�ӷ����|�פJ�M��");
	static Button btPack = new Button("���e�ɮ�");
	static Button btClear = new Button("�M���C��");
	static Button btOutScript = new Button("�ץX�}��");
	static Button btInScript = new Button("�פJ�}��");
	static Button btSwitch = new Button("������l/������");
	static Button btADWebRoot = new Button("�[��WebRoot");
	static Button btADwebapp = new Button("�[��webapp");
	static Button btOutBat = new Button("�ץXBat��");
	static TextArea taMes = new TextArea("", 30, 100);
	static Label block = new Label("");

	public static void main(String[] args) throws Exception {
		f1.setLocation(300, 100);
		f1.setSize(550, 580);
		f1.setBackground(new Color(220, 220, 255));
		f1.addWindowListener(new WindowEventHandler());
		f1.setLayout(new java.awt.GridBagLayout());
		f1.setDefaultCloseOperation(3);
		f1.setFont(new Font("�L�n����", Font.BOLD, 26));
		
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
			// os�O windows
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
			// os �O unix-like
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