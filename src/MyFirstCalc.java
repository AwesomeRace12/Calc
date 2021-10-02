import javax.swing.*;
import java.util.Stack;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.imageio.ImageIO;
public class MyFirstCalc extends JFrame implements ActionListener{
	private static JTextField inputBox;
	final static int hex_base =16;
	JButton aButton, mButton, sButton, dButton, eButton, Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8, Button9,
	Button0,paren1Button, paren2Button, asButton, decimalButton, LButton, RButton, OButton, XButton, NButton, AButton, CButton, CEButton, ModButton,
	ButtonA, ButtonB, ButtonC, ButtonD, ButtonE, ButtonF, ButtonWord, ButtonByte, ButtonMS, ButtonM, ButtonHex, ButtonDec, ButtonOct, ButtonBin, ButtonBack,
	ButtonPic1, ButtonPic2, ButtonPic3, ButtonPic4, ButtonPic0;
	JLabel label1;
	private StringBuilder strBuild;
	JTextField textField1, ShowCalculation;
	JPanel panel,panel2,panel3;
	static boolean equalbefore = true, defaultzero = false;
	static boolean MainHex = false, MainDec = true, MainOct = false, MainBin = false;
	static String output = "";
	boolean isDot = false;
	boolean error;
	int divisor, dividend;
	double acc1 = 0;
	String tempNum;
	static int Binary=0, Hex=0, Dec=0, Oct=0, temp = 0;
	static String result = "";
	static int operator=0;
	//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel")

	public MyFirstCalc() {
		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1,2));
		add(panel3,BorderLayout.NORTH);
		/*
		ButtonPic0 = new JButton("Image1");
		ButtonPic0.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ButtonPic0.setPreferredSize(new Dimension(50,50));
		ButtonPic0.setIcon(new ImageIcon("C:\\Users\\aakar\\Desktop\\Pic.jpg"));
		panel.add(ButtonPic0);
		ButtonPic0.setBackground(Color.lightGray);
		ButtonPic0.setForeground(Color.black);
		*/
		label1 = new JLabel("PROGRAMMER");
		label1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label1.setHorizontalAlignment(JTextField.CENTER);
		panel3.add(label1);
		label1.setBackground(Color.white);
		label1.setForeground(Color.black);
		//label1.setEditable(false);
		
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(6,1));
		add(panel2,BorderLayout.CENTER);
		
		textField1 = new JTextField();
		textField1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField1.setHorizontalAlignment(JTextField.RIGHT);
		panel2.add(textField1);
		textField1.setBackground(Color.white);
		textField1.setForeground(Color.black);
		textField1.setEditable(false);
		
		ShowCalculation = new JTextField();
		ShowCalculation.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ShowCalculation.setHorizontalAlignment(JTextField.RIGHT);
		panel2.add(ShowCalculation);
		ShowCalculation.setBackground(Color.white);
		ShowCalculation.setForeground(Color.black);
		ShowCalculation.setEditable(false);
		
		ButtonHex = new JButton("HEX " + Hex);
		ButtonHex.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ButtonHex.setHorizontalAlignment(JTextField.LEFT);
		panel2.add(ButtonHex);
		ButtonHex.setBackground(Color.lightGray);
		ButtonHex.setForeground(Color.black);
		
		ButtonDec = new JButton("DEC " + Dec);
		ButtonDec.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ButtonDec.setHorizontalAlignment(JTextField.LEFT);
		panel2.add(ButtonDec);
		ButtonDec.setBackground(Color.lightGray);
		ButtonDec.setForeground(Color.black);
		
		ButtonOct = new JButton("OCT " + Oct);
		ButtonOct.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ButtonOct.setHorizontalAlignment(JTextField.LEFT);
		panel2.add(ButtonOct);
		ButtonOct.setBackground(Color.lightGray);
		ButtonOct.setForeground(Color.black);
		
		ButtonBin = new JButton("BIN " + Binary);
		ButtonBin.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ButtonBin.setHorizontalAlignment(JTextField.LEFT);
		panel2.add(ButtonBin);
		ButtonBin.setBackground(Color.lightGray);
		ButtonBin.setForeground(Color.black);
		

		
		aButton = new JButton("+");
		mButton = new JButton("X");
		sButton = new JButton("-");
		dButton = new JButton("/");
		eButton = new JButton("=");
		Button1 = new JButton("1");
		Button2 = new JButton("2");
		Button3 = new JButton("3");
		Button4 = new JButton("4");
		Button5 = new JButton("5");
		Button6 = new JButton("6");
		Button7 = new JButton("7");
		Button8 = new JButton("8");
		Button9 = new JButton("9");
		Button0 = new JButton("0");
		ButtonA = new JButton("A");
		ButtonB = new JButton("B");
		ButtonC = new JButton("C");
		ButtonD = new JButton("D");
		ButtonE = new JButton("E");
		ButtonF = new JButton("F");
		CButton = new JButton("C");
		CEButton = new JButton("CE");
		ModButton = new JButton("Mod");
		LButton = new JButton("Lsh");
		RButton = new JButton("Rsh");
		OButton = new JButton("Or");
		XButton = new JButton("Xor");
		NButton = new JButton("Not");
		AButton = new JButton("And");
		paren1Button = new JButton("(");
		paren2Button = new JButton(")");
		asButton = new JButton("+-");
		//ButtonHex = new JButton("HEX");
		//ButtonDec = new JButton("DEC");
		//ButtonOct = new JButton("OCT");
		//ButtonBin = new JButton("BIN");
		decimalButton = new JButton(".");
		ButtonWord = new JButton("WORD");
		ButtonMS = new JButton("MS");
		ButtonBack = new JButton("Back");
		label1 = new JLabel("Programmer");
		//textField2 = new JTextField(10);
		//panel = new JPanel();
		
		/*panel.add(aButton);
		panel.add(mButton);
		panel.add(sButton);
		panel.add(dButton);
		panel.add(eButton);
		panel.add(Button1);
		panel.add(Button2);
		panel.add(Button3);
		panel.add(Button4);
		panel.add(Button5);
		panel.add(Button6);
		panel.add(Button7);
		panel.add(Button8);
		panel.add(Button9);
		panel.add(Button0);
		panel.add(ButtonA);
		panel.add(ButtonB);
		panel.add(ButtonC);
		panel.add(ButtonD);
		panel.add(ButtonE);
		panel.add(ButtonF);
		panel.add(paren1Button);
		panel.add(paren2Button);
		panel.add(asButton);
		panel.add(decimalButton);
		panel.add(CButton);
		panel.add(CEButton);
		panel.add(ModButton);
		panel.add(LButton);
		panel.add(RButton);
		panel.add(OButton);
		panel.add(XButton);
		panel.add(NButton);
		panel.add(AButton);
		panel.add(label1);*/
		//add(panel, BorderLayout.CENTER);
		/*
		add(aButton, BorderLayout.NORTH);
		add(mButton, BorderLayout.SOUTH);
		add(sButton, BorderLayout.EAST);
		add(label1, BorderLayout.CENTER);
		add(textField1, BorderLayout.EAST);
		add(textField2, BorderLayout.WEST);
		*/
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(7,5));
		add(panel,BorderLayout.SOUTH);
		ButtonPic1 = new JButton("Image1");
		ButtonPic1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ButtonPic1.setPreferredSize(new Dimension(50,50));
		ButtonPic1.setIcon(new ImageIcon("C:\\Users\\aakar\\Desktop\\screen.jpg"));
		panel.add(ButtonPic1);
		ButtonPic1.setBackground(Color.lightGray);
		ButtonPic1.setForeground(Color.black);
		
		//Icon icon = new ImageIcon("screen.jpg");
		
		ButtonPic2 = new JButton("Image2");
		ButtonPic2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ButtonPic2.setPreferredSize(new Dimension(60,60));
		ButtonPic2.setIcon(new ImageIcon("C:\\Users\\aakar\\Desktop\\keyoad.jpg"));
		panel.add(ButtonPic2);
		ButtonPic2.setBackground(Color.lightGray);
		ButtonPic2.setForeground(Color.black);
		
		
		ButtonWord = new JButton("WORD");
		ButtonWord.setFont(new Font("Times New Roman", Font.PLAIN, 8));
		ButtonWord.setPreferredSize(new Dimension(60,60));
		panel.add(ButtonWord);
		ButtonWord.setBackground(Color.lightGray);
		ButtonWord.setForeground(Color.black);
		
		ButtonByte = new JButton("BYTE");
		ButtonByte.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		ButtonByte.setPreferredSize(new Dimension(60,60));
		panel.add(ButtonByte);
		ButtonByte.setBackground(Color.lightGray);
		ButtonByte.setForeground(Color.black);
		
		ButtonMS = new JButton("MS");
		ButtonMS.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ButtonMS.setPreferredSize(new Dimension(60,60));
		panel.add(ButtonMS);
		ButtonMS.setBackground(Color.lightGray);
		ButtonMS.setForeground(Color.black);
		
		ButtonM = new JButton("M");
		ButtonM.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ButtonM.setPreferredSize(new Dimension(60,60));
		panel.add(ButtonM);
		ButtonM.setBackground(Color.lightGray);
		ButtonM.setForeground(Color.black);
		
		LButton = new JButton("Lsh");
		LButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		LButton.setPreferredSize(new Dimension(60,60));
		panel.add(LButton);
		LButton.setBackground(Color.lightGray);
		LButton.setForeground(Color.black);
		
		RButton = new JButton("Rsh");
		RButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		RButton.setPreferredSize(new Dimension(60,60));
		panel.add(RButton);
		RButton.setBackground(Color.lightGray);
		RButton.setForeground(Color.black);
		
		OButton = new JButton("Or");
		OButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		OButton.setPreferredSize(new Dimension(60,60));
		panel.add(OButton);
		OButton.setBackground(Color.lightGray);
		OButton.setForeground(Color.black);
		
		XButton = new JButton("Xor");
		XButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		XButton.setPreferredSize(new Dimension(60,60));
		panel.add(XButton);
		XButton.setBackground(Color.lightGray);
		XButton.setForeground(Color.black);
		
		NButton = new JButton("Not");
		NButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		NButton.setPreferredSize(new Dimension(60,60));
		panel.add(NButton);
		NButton.setBackground(Color.lightGray);
		NButton.setForeground(Color.black);
		
		AButton = new JButton("And");
		AButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		AButton.setPreferredSize(new Dimension(60,60));
		panel.add(AButton);
		AButton.setBackground(Color.lightGray);
		AButton.setForeground(Color.black);
		
		ButtonPic3 = new JButton("Image3");
		ButtonPic3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ButtonPic3.setPreferredSize(new Dimension(60,60));
		ButtonPic3.setIcon(new ImageIcon("C:\\Users\\aakar\\Desktop\\uparrow.jpg"));
		panel.add(ButtonPic3);
		ButtonPic3.setBackground(Color.lightGray);
		ButtonPic3.setForeground(Color.black);
		
		ModButton = new JButton("Mod");
		ModButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ModButton.setPreferredSize(new Dimension(60,60));
		panel.add(ModButton);
		ModButton.setBackground(Color.lightGray);
		ModButton.setForeground(Color.black);
		
		CButton = new JButton("C");
		CButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		CButton.setPreferredSize(new Dimension(60,60));
		panel.add(CButton);
		CButton.setBackground(Color.lightGray);
		CButton.setForeground(Color.black);
		
		CEButton = new JButton("CE");
		CEButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		CEButton.setPreferredSize(new Dimension(60,60));
		panel.add(CEButton);
		CEButton.setBackground(Color.lightGray);
		CEButton.setForeground(Color.black);
		
		ButtonPic4 = new JButton("Image4");
		ButtonPic4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ButtonPic4.setPreferredSize(new Dimension(60,60));
		ButtonPic4.setIcon(new ImageIcon("C:\\Users\\aakar\\Desktop\\back.jpg"));
		panel.add(ButtonPic4);
		ButtonPic4.setBackground(Color.lightGray);
		ButtonPic4.setForeground(Color.black);
		
		dButton = new JButton("/");
		dButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		dButton.setPreferredSize(new Dimension(60,60));
		panel.add(dButton);
		dButton.setBackground(Color.lightGray);
		dButton.setForeground(Color.black);
		
		ButtonA = new JButton("A");
		ButtonA.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ButtonA.setPreferredSize(new Dimension(60,60));
		panel.add(ButtonA);
		ButtonA.setBackground(Color.lightGray);
		ButtonA.setForeground(Color.gray);
		
		ButtonB = new JButton("B");
		ButtonB.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ButtonB.setPreferredSize(new Dimension(60,60));
		panel.add(ButtonB);
		ButtonB.setBackground(Color.lightGray);
		ButtonB.setForeground(Color.gray);
		
		Button7 = new JButton("7");
		Button7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Button7.setPreferredSize(new Dimension(60,60));
		panel.add(Button7);
		Button7.setBackground(Color.white);
		Button7.setForeground(Color.black);
		
		Button8 = new JButton("8");
		Button8.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Button8.setPreferredSize(new Dimension(60,60));
		panel.add(Button8);
		Button8.setBackground(Color.white);
		Button8.setForeground(Color.black);
		
		Button9 = new JButton("9");
		Button9.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Button9.setPreferredSize(new Dimension(60,60));
		panel.add(Button9);
		Button9.setBackground(Color.white);
		Button9.setForeground(Color.black);
		
		mButton = new JButton("X");
		mButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mButton.setPreferredSize(new Dimension(60,60));
		panel.add(mButton);
		mButton.setBackground(Color.lightGray);
		mButton.setForeground(Color.black);
		
		ButtonC = new JButton("C");
		ButtonC.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ButtonC.setPreferredSize(new Dimension(60,60));
		panel.add(ButtonC);
		ButtonC.setBackground(Color.lightGray);
		ButtonC.setForeground(Color.gray);
		
		ButtonD = new JButton("D");
		ButtonD.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ButtonD.setPreferredSize(new Dimension(60,60));
		panel.add(ButtonD);
		ButtonD.setBackground(Color.lightGray);
		ButtonD.setForeground(Color.gray);
		
		Button4 = new JButton("4");
		Button4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Button4.setPreferredSize(new Dimension(60,60));
		panel.add(Button4);
		Button4.setBackground(Color.white);
		Button4.setForeground(Color.black);
		
		Button5 = new JButton("5");
		Button5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Button5.setPreferredSize(new Dimension(60,60));
		panel.add(Button5);
		Button5.setBackground(Color.white);
		Button5.setForeground(Color.black);
		
		Button6 = new JButton("6");
		Button6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Button6.setPreferredSize(new Dimension(60,60));
		panel.add(Button6);
		Button6.setBackground(Color.white);
		Button6.setForeground(Color.black);
		
		sButton = new JButton("-");
		sButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		sButton.setPreferredSize(new Dimension(60,60));
		panel.add(sButton);
		sButton.setBackground(Color.lightGray);
		sButton.setForeground(Color.black);
		
		ButtonE = new JButton("E");
		ButtonE.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ButtonE.setPreferredSize(new Dimension(60,60));
		panel.add(ButtonE);
		ButtonE.setBackground(Color.lightGray);
		ButtonE.setForeground(Color.gray);
		
		ButtonF = new JButton("F");
		ButtonF.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ButtonF.setPreferredSize(new Dimension(60,60));
		panel.add(ButtonF);
		ButtonF.setBackground(Color.lightGray);
		ButtonF.setForeground(Color.gray);
		
		Button1 = new JButton("1");
		Button1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Button1.setPreferredSize(new Dimension(60,60));
		panel.add(Button1);
		Button1.setBackground(Color.white);
		Button1.setForeground(Color.black);
		
		Button2 = new JButton("2");
		Button2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Button2.setPreferredSize(new Dimension(60,60));
		panel.add(Button2);
		Button2.setBackground(Color.white);
		Button2.setForeground(Color.black);
		
		Button3 = new JButton("3");
		Button3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Button3.setPreferredSize(new Dimension(60,60));
		panel.add(Button3);
		Button3.setBackground(Color.white);
		Button3.setForeground(Color.black);
		
		aButton = new JButton("+");
		aButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		aButton.setPreferredSize(new Dimension(60,60));
		panel.add(aButton);
		aButton.setBackground(Color.lightGray);
		aButton.setForeground(Color.black);
		
		paren1Button = new JButton("(");
		paren1Button.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		paren1Button.setPreferredSize(new Dimension(60,60));
		panel.add(paren1Button);
		paren1Button.setBackground(Color.lightGray);
		paren1Button.setForeground(Color.black);
		
		paren2Button = new JButton(")");
		paren2Button.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		paren2Button.setPreferredSize(new Dimension(60,60));
		panel.add(paren2Button);
		paren2Button.setBackground(Color.lightGray);
		paren2Button.setForeground(Color.black);
		
		asButton = new JButton("+-");
		asButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		asButton.setPreferredSize(new Dimension(60,60));
		panel.add(asButton);
		asButton.setBackground(Color.lightGray);
		asButton.setForeground(Color.black);
		
		Button0 = new JButton("0");
		Button0.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Button0.setPreferredSize(new Dimension(60,60));
		panel.add(Button0);
		Button0.setBackground(Color.white);
		Button0.setForeground(Color.black);
		
		decimalButton = new JButton(".");
		decimalButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		decimalButton.setPreferredSize(new Dimension(60,60));
		panel.add(decimalButton);
		decimalButton.setBackground(Color.lightGray);
		decimalButton.setForeground(Color.black);
		
		eButton = new JButton("=");
		eButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		eButton.setPreferredSize(new Dimension(60,60));
		panel.add(eButton);
		eButton.setBackground(Color.lightGray);
		eButton.setForeground(Color.black);
		
		
		
		
		aButton.addActionListener(this);
		mButton.addActionListener(this);
		sButton.addActionListener(this);
		dButton.addActionListener(this);
		eButton.addActionListener(this);
		Button1.addActionListener(this);
		Button2.addActionListener(this);
		Button3.addActionListener(this);
		Button4.addActionListener(this);
		Button5.addActionListener(this);
		Button6.addActionListener(this);
		Button7.addActionListener(this);
		Button8.addActionListener(this);
		Button9.addActionListener(this);
		Button0.addActionListener(this);
		ButtonA.addActionListener(this);
		ButtonB.addActionListener(this);
		ButtonC.addActionListener(this);
		ButtonD.addActionListener(this);
		ButtonE.addActionListener(this);
		ButtonF.addActionListener(this);
		paren1Button.addActionListener(this);
		paren2Button.addActionListener(this);
		asButton.addActionListener(this);
		decimalButton.addActionListener(this);
		ButtonWord.addActionListener(this);
		ButtonMS.addActionListener(this);
		ButtonDec.addActionListener(this);
		ButtonHex.addActionListener(this);
		ButtonOct.addActionListener(this);
		ButtonBin.addActionListener(this);
		CButton.addActionListener(this);
		CEButton.addActionListener(this);
		ButtonBack.addActionListener(this);
		ModButton.addActionListener(this);
		LButton.addActionListener(this);
		RButton.addActionListener(this);
		OButton.addActionListener(this);
		XButton.addActionListener(this);
		NButton.addActionListener(this);
		AButton.addActionListener(this);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		//strBuild = new StringBuilder();
		//strBuild = new StringBuilder(textField1.getText());
		if(equalbefore==true) {
			textField1.setText("");
			ButtonHex.setText("HEX" + Hex);
			ButtonDec.setText("DEC" + Dec);
			ButtonOct.setText("OCT" + Oct);
			ButtonBin.setText("BIN" + Binary);
			equalbefore = false;
		}
		/*if(e.getSource()==ButtonHex || e.getSource()==ButtonDec || e.getSource()==ButtonOct || e.getSource()==ButtonBin) {
			textField1.setText("0");
		}*/
		
		if(e.getSource()==Button0) {
			textField1.setText(textField1.getText().concat("0"));
		if(MainDec == true) {
			Hex = Integer.parseInt(textField1.getText());
			ButtonHex.setText("HEX " + dec2Hex(Hex));
			ButtonDec.setText("DEC " + textField1.getText());
			Oct = Integer.parseInt(textField1.getText());
			ButtonOct.setText("OCT " + dec2Oct(Oct));
			Binary = Integer.parseInt(textField1.getText());
			ButtonBin.setText("BIN " + dec2Bin(Binary));
		}
		else if(MainHex == true) {
			Dec = hex2Dec(textField1.getText());
			ButtonDec.setText("DEC " + Dec);
			ButtonHex.setText("HEX " + dec2Hex(Dec));
			Binary = Dec;
			ButtonBin.setText("BIN " + dec2Bin(Binary));
			Oct = Dec;
			ButtonOct.setText("OCT " + dec2Oct(Oct));
		}
		else if(MainBin == true) {
			Dec = Integer.parseInt(textField1.getText());
			String DecNum = String.valueOf(Dec);
			ButtonDec.setText("DEC " + bin2Dec(DecNum));
			Hex = bin2Dec(DecNum);
			ButtonHex.setText("HEX " + dec2Hex(Hex));
			ButtonBin.setText("BIN " + textField1.getText());
			Oct = bin2Dec(DecNum);
			ButtonOct.setText("OCT " + dec2Oct(Oct));
		}
		else {
			Dec = Integer.parseInt(textField1.getText());
			String DecNum = String.valueOf(Dec);
			ButtonDec.setText("DEC " + Oct2Dec(DecNum));
			Hex = Oct2Dec(DecNum);
			ButtonHex.setText("HEX " + dec2Hex(Hex));
			Binary = Oct2Dec(DecNum);
			ButtonBin.setText("BIN " + dec2Bin(Binary));
			ButtonOct.setText("OCT " + textField1.getText());
		}
		}
		else if(e.getSource()==Button1) {
			textField1.setText(textField1.getText().concat("1"));
			if(MainDec == true) {
				Hex = Integer.parseInt(textField1.getText());
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				ButtonDec.setText("DEC " + textField1.getText());
				Oct = Integer.parseInt(textField1.getText());
				ButtonOct.setText("OCT " + dec2Oct(Oct));
				Binary = Integer.parseInt(textField1.getText());
				ButtonBin.setText("BIN " + dec2Bin(Binary));
			}
			else if(MainHex == true) {
				Dec = hex2Dec(textField1.getText());
				ButtonDec.setText("DEC " + Dec);
				ButtonHex.setText("HEX " + dec2Hex(Dec));
				Binary = Dec;
				ButtonBin.setText("BIN " + dec2Bin(Binary));
				Oct = Dec;
				ButtonOct.setText("OCT " + dec2Oct(Oct));
			}
			else if(MainBin == true) {
				Dec = Integer.parseInt(textField1.getText());
				String DecNum = String.valueOf(Dec);
				ButtonDec.setText("DEC " + bin2Dec(DecNum));
				Hex = bin2Dec(DecNum);
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				ButtonBin.setText("BIN " + textField1.getText());
				Oct = bin2Dec(DecNum);
				ButtonOct.setText("OCT " + dec2Oct(Oct));
			}
			else {
				Dec = Integer.parseInt(textField1.getText());
				String DecNum = String.valueOf(Dec);
				ButtonDec.setText("DEC " + Oct2Dec(DecNum));
				Hex = Oct2Dec(DecNum);
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				Binary = Oct2Dec(DecNum);
				ButtonBin.setText("BIN " + dec2Bin(Binary));
				ButtonOct.setText("OCT " + textField1.getText());
			}
		}
		else if(e.getSource()==Button2) {
			textField1.setText(textField1.getText().concat("2"));
			if(MainDec == true) {
				Hex = Integer.parseInt(textField1.getText());
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				ButtonDec.setText("DEC " + textField1.getText());
				Oct = Integer.parseInt(textField1.getText());
				ButtonOct.setText("OCT " + dec2Oct(Oct));
				Binary = Integer.parseInt(textField1.getText());
				ButtonBin.setText("BIN " + dec2Bin(Binary));
			}
			else if(MainHex == true) {
				Dec = hex2Dec(textField1.getText());
				ButtonDec.setText("DEC " + Dec);
				ButtonHex.setText("HEX " + dec2Hex(Dec));
				Binary = Dec;
				ButtonBin.setText("BIN " + dec2Bin(Binary));
				Oct = Dec;
				ButtonOct.setText("OCT " + dec2Oct(Oct));
			}
			else if(MainBin == true) {
				Dec = Integer.parseInt(textField1.getText());
				String DecNum = String.valueOf(Dec);
				ButtonDec.setText("DEC " + bin2Dec(DecNum));
				Hex = bin2Dec(DecNum);
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				ButtonBin.setText("BIN " + textField1.getText());
				Oct = bin2Dec(DecNum);
				ButtonOct.setText("OCT " + dec2Oct(Oct));
			}
			else {
				Dec = Integer.parseInt(textField1.getText());
				String DecNum = String.valueOf(Dec);
				ButtonDec.setText("DEC " + Oct2Dec(DecNum));
				Hex = Oct2Dec(DecNum);
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				Binary = Oct2Dec(DecNum);
				ButtonBin.setText("BIN " + dec2Bin(Binary));
				ButtonOct.setText("OCT " + textField1.getText());
			}
		}
		else if(e.getSource()==Button3) {
			textField1.setText(textField1.getText().concat("3"));
			if(MainDec == true) {
				Hex = Integer.parseInt(textField1.getText());
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				ButtonDec.setText("DEC " + textField1.getText());
				Oct = Integer.parseInt(textField1.getText());
				ButtonOct.setText("OCT " + dec2Oct(Oct));
				Binary = Integer.parseInt(textField1.getText());
				ButtonBin.setText("BIN " + dec2Bin(Binary));
			}
			else if(MainHex == true) {
				Dec = hex2Dec(textField1.getText());
				ButtonDec.setText("DEC " + Dec);
				ButtonHex.setText("HEX " + dec2Hex(Dec));
				Binary = Dec;
				ButtonBin.setText("BIN " + dec2Bin(Binary));
				Oct = Dec;
				ButtonOct.setText("OCT " + dec2Oct(Oct));
			}
			else if(MainBin == true) {
				Dec = Integer.parseInt(textField1.getText());
				String DecNum = String.valueOf(Dec);
				ButtonDec.setText("DEC " + bin2Dec(DecNum));
				Hex = bin2Dec(DecNum);
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				ButtonBin.setText("BIN " + textField1.getText());
				Oct = bin2Dec(DecNum);
				ButtonOct.setText("OCT " + dec2Oct(Oct));
			}
			else {
				Dec = Integer.parseInt(textField1.getText());
				String DecNum = String.valueOf(Dec);
				ButtonDec.setText("DEC " + Oct2Dec(DecNum));
				Hex = Oct2Dec(DecNum);
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				Binary = Oct2Dec(DecNum);
				ButtonBin.setText("BIN " + dec2Bin(Binary));
				ButtonOct.setText("OCT " + textField1.getText());
			}
		}
		else if(e.getSource()==Button4) {
			textField1.setText(textField1.getText().concat("4"));
			if(MainDec == true) {
				Hex = Integer.parseInt(textField1.getText());
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				ButtonDec.setText("DEC " + textField1.getText());
				Oct = Integer.parseInt(textField1.getText());
				ButtonOct.setText("OCT " + dec2Oct(Oct));
				Binary = Integer.parseInt(textField1.getText());
				ButtonBin.setText("BIN " + dec2Bin(Binary));
			}
			else if(MainHex == true) {
				Dec = hex2Dec(textField1.getText());
				ButtonDec.setText("DEC " + Dec);
				ButtonHex.setText("HEX " + dec2Hex(Dec));
				Binary = Dec;
				ButtonBin.setText("BIN " + dec2Bin(Binary));
				Oct = Dec;
				ButtonOct.setText("OCT " + dec2Oct(Oct));
			}
			else if(MainBin == true) {
				Dec = Integer.parseInt(textField1.getText());
				String DecNum = String.valueOf(Dec);
				ButtonDec.setText("DEC " + bin2Dec(DecNum));
				Hex = bin2Dec(DecNum);
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				ButtonBin.setText("BIN " + textField1.getText());
				Oct = bin2Dec(DecNum);
				ButtonOct.setText("OCT " + dec2Oct(Oct));
			}
			else {
				Dec = Integer.parseInt(textField1.getText());
				String DecNum = String.valueOf(Dec);
				ButtonDec.setText("DEC " + Oct2Dec(DecNum));
				Hex = Oct2Dec(DecNum);
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				Binary = Oct2Dec(DecNum);
				ButtonBin.setText("BIN " + dec2Bin(Binary));
				ButtonOct.setText("OCT " + textField1.getText());
			}
		}
		else if(e.getSource()==Button5) {
			textField1.setText(textField1.getText().concat("5"));
			if(MainDec == true) {
				Hex = Integer.parseInt(textField1.getText());
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				ButtonDec.setText("DEC " + textField1.getText());
				Oct = Integer.parseInt(textField1.getText());
				ButtonOct.setText("OCT " + dec2Oct(Oct));
				Binary = Integer.parseInt(textField1.getText());
				ButtonBin.setText("BIN " + dec2Bin(Binary));
			}
			else if(MainHex == true) {
				Dec = hex2Dec(textField1.getText());
				ButtonDec.setText("DEC " + Dec);
				ButtonHex.setText("HEX " + dec2Hex(Dec));
				Binary = Dec;
				ButtonBin.setText("BIN " + dec2Bin(Binary));
				Oct = Dec;
				ButtonOct.setText("OCT " + dec2Oct(Oct));
			}
			else if(MainBin == true) {
				Dec = Integer.parseInt(textField1.getText());
				String DecNum = String.valueOf(Dec);
				ButtonDec.setText("DEC " + bin2Dec(DecNum));
				Hex = bin2Dec(DecNum);
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				ButtonBin.setText("BIN " + textField1.getText());
				Oct = bin2Dec(DecNum);
				ButtonOct.setText("OCT " + dec2Oct(Oct));
			}
			else {
				Dec = Integer.parseInt(textField1.getText());
				String DecNum = String.valueOf(Dec);
				ButtonDec.setText("DEC " + Oct2Dec(DecNum));
				Hex = Oct2Dec(DecNum);
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				Binary = Oct2Dec(DecNum);
				ButtonBin.setText("BIN " + dec2Bin(Binary));
				ButtonOct.setText("OCT " + textField1.getText());
			}
		}
		else if(e.getSource()==Button6) {
			textField1.setText(textField1.getText().concat("6"));
			if(MainDec == true) {
				Hex = Integer.parseInt(textField1.getText());
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				ButtonDec.setText("DEC " + textField1.getText());
				Oct = Integer.parseInt(textField1.getText());
				ButtonOct.setText("OCT " + dec2Oct(Oct));
				Binary = Integer.parseInt(textField1.getText());
				ButtonBin.setText("BIN " + dec2Bin(Binary));
			}
			else if(MainHex == true) {
				Dec = hex2Dec(textField1.getText());
				ButtonDec.setText("DEC " + Dec);
				ButtonHex.setText("HEX " + dec2Hex(Dec));
				Binary = Dec;
				ButtonBin.setText("BIN " + dec2Bin(Binary));
				Oct = Dec;
				ButtonOct.setText("OCT " + dec2Oct(Oct));
			}
			else if(MainBin == true) {
				Dec = Integer.parseInt(textField1.getText());
				String DecNum = String.valueOf(Dec);
				ButtonDec.setText("DEC " + bin2Dec(DecNum));
				Hex = bin2Dec(DecNum);
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				ButtonBin.setText("BIN " + textField1.getText());
				Oct = bin2Dec(DecNum);
				ButtonOct.setText("OCT " + dec2Oct(Oct));
			}
			else {
				Dec = Integer.parseInt(textField1.getText());
				String DecNum = String.valueOf(Dec);
				ButtonDec.setText("DEC " + Oct2Dec(DecNum));
				Hex = Oct2Dec(DecNum);
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				Binary = Oct2Dec(DecNum);
				ButtonBin.setText("BIN " + dec2Bin(Binary));
				ButtonOct.setText("OCT " + textField1.getText());
			}
		}
		else if(e.getSource()==Button7) {
			textField1.setText(textField1.getText().concat("7"));
			if(MainDec == true) {
				Hex = Integer.parseInt(textField1.getText());
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				ButtonDec.setText("DEC " + textField1.getText());
				Oct = Integer.parseInt(textField1.getText());
				ButtonOct.setText("OCT " + dec2Oct(Oct));
				Binary = Integer.parseInt(textField1.getText());
				ButtonBin.setText("BIN " + dec2Bin(Binary));
			}
			else if(MainHex == true) {
				Dec = hex2Dec(textField1.getText());
				ButtonDec.setText("DEC " + Dec);
				ButtonHex.setText("HEX " + dec2Hex(Dec));
				Binary = Dec;
				ButtonBin.setText("BIN " + dec2Bin(Binary));
				Oct = Dec;
				ButtonOct.setText("OCT " + dec2Oct(Oct));
			}
			else if(MainBin == true) {
				Dec = Integer.parseInt(textField1.getText());
				String DecNum = String.valueOf(Dec);
				ButtonDec.setText("DEC " + bin2Dec(DecNum));
				Hex = bin2Dec(DecNum);
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				ButtonBin.setText("BIN " + textField1.getText());
				Oct = bin2Dec(DecNum);
				ButtonOct.setText("OCT " + dec2Oct(Oct));
			}
			else {
				Dec = Integer.parseInt(textField1.getText());
				String DecNum = String.valueOf(Dec);
				ButtonDec.setText("DEC " + Oct2Dec(DecNum));
				Hex = Oct2Dec(DecNum);
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				Binary = Oct2Dec(DecNum);
				ButtonBin.setText("BIN " + dec2Bin(Binary));
				ButtonOct.setText("OCT " + textField1.getText());
			}
		}
		else if(e.getSource()==Button8) {
			textField1.setText(textField1.getText().concat("8"));
			if(MainDec == true) {
				Hex = Integer.parseInt(textField1.getText());
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				ButtonDec.setText("DEC " + textField1.getText());
				Oct = Integer.parseInt(textField1.getText());
				ButtonOct.setText("OCT " + dec2Oct(Oct));
				Binary = Integer.parseInt(textField1.getText());
				ButtonBin.setText("BIN " + dec2Bin(Binary));
			}
			else if(MainHex == true) {
				Dec = hex2Dec(textField1.getText());
				ButtonDec.setText("DEC " + Dec);
				ButtonHex.setText("HEX " + dec2Hex(Dec));
				Binary = Dec;
				ButtonBin.setText("BIN " + dec2Bin(Binary));
				Oct = Dec;
				ButtonOct.setText("OCT " + dec2Oct(Oct));
			}
			else if(MainBin == true) {
				Dec = Integer.parseInt(textField1.getText());
				String DecNum = String.valueOf(Dec);
				ButtonDec.setText("DEC " + bin2Dec(DecNum));
				Hex = bin2Dec(DecNum);
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				ButtonBin.setText("BIN " + textField1.getText());
				Oct = bin2Dec(DecNum);
				ButtonOct.setText("OCT " + dec2Oct(Oct));
			}
			else {
				Dec = Integer.parseInt(textField1.getText());
				String DecNum = String.valueOf(Dec);
				ButtonDec.setText("DEC " + Oct2Dec(DecNum));
				Hex = Oct2Dec(DecNum);
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				Binary = Oct2Dec(DecNum);
				ButtonBin.setText("BIN " + dec2Bin(Binary));
				ButtonOct.setText("OCT " + textField1.getText());
			}
		}
		else if(e.getSource()==Button9) {
			textField1.setText(textField1.getText().concat("9"));
			if(MainDec == true) {
				Hex = Integer.parseInt(textField1.getText());
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				ButtonDec.setText("DEC " + textField1.getText());
				Oct = Integer.parseInt(textField1.getText());
				ButtonOct.setText("OCT " + dec2Oct(Oct));
				Binary = Integer.parseInt(textField1.getText());
				ButtonBin.setText("BIN " + dec2Bin(Binary));
			}
			else if(MainHex == true) {
				Dec = hex2Dec(textField1.getText());
				ButtonDec.setText("DEC " + Dec);
				ButtonHex.setText("HEX " + dec2Hex(Dec));
				Binary = Dec;
				ButtonBin.setText("BIN " + dec2Bin(Binary));
				Oct = Dec;
				ButtonOct.setText("OCT " + dec2Oct(Oct));
			}
			else if(MainBin == true) {
				Dec = Integer.parseInt(textField1.getText());
				String DecNum = String.valueOf(Dec);
				ButtonDec.setText("DEC " + bin2Dec(DecNum));
				Hex = bin2Dec(DecNum);
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				ButtonBin.setText("BIN " + textField1.getText());
				Oct = bin2Dec(DecNum);
				ButtonOct.setText("OCT " + dec2Oct(Oct));
			}
			else {
				Dec = Integer.parseInt(textField1.getText());
				String DecNum = String.valueOf(Dec);
				ButtonDec.setText("DEC " + Oct2Dec(DecNum));
				Hex = Oct2Dec(DecNum);
				ButtonHex.setText("HEX " + dec2Hex(Hex));
				Binary = Oct2Dec(DecNum);
				ButtonBin.setText("BIN " + dec2Bin(Binary));
				ButtonOct.setText("OCT " + textField1.getText());
			}
		}
		else if(e.getSource()==ButtonHex) {
			defaultzero = false;
			MainHex = true;
			MainDec = false;
			MainOct = false;
			MainBin = false;
			whenHexClicked();
		}
		else if(e.getSource()==ButtonDec) {
			defaultzero = false;
			MainHex = false;
			MainDec = true;
			MainOct = false;
			MainBin = false;
			whenDecClicked();
		}
		else if(e.getSource()==ButtonOct) {
			defaultzero = false;
			MainHex = false;
			MainDec = false;
			MainOct = true;
			MainBin = false;
			whenOctClicked();
		}
		else if(e.getSource()==ButtonBin) {
			defaultzero = false;
			MainHex = false;
			MainDec = false;
			MainOct = false;
			MainBin = true;
			whenBinaryClicked();
		}
		else if(e.getSource()==ButtonA) {
			textField1.setText(textField1.getText().concat("A"));
		}
		else if(e.getSource()==ButtonB) {
			textField1.setText(textField1.getText().concat("B"));
		}
		else if(e.getSource()==ButtonC) {
			textField1.setText(textField1.getText().concat("C"));
		}
		else if(e.getSource()==ButtonD) {
			textField1.setText(textField1.getText().concat("D"));
		}
		else if(e.getSource()==ButtonE) {
			textField1.setText(textField1.getText().concat("E"));
		}
		else if(e.getSource()==ButtonF) {
			textField1.setText(textField1.getText().concat("F"));
		}
		else if(e.getSource()==aButton) {
			//textField1.setText(textField1.getText().concat("+"));
			output+= textField1.getText() + " + ";
			if(temp!=1) {
				ShowCalculation.setText(textField1.getText().concat("+"));
			}
			else {
				ShowCalculation.setText(output);
			}
			textField1.setText("");
			temp=1;
			
		}
		else if(e.getSource()==mButton) {
			//textField1.setText(textField1.getText().concat("*"));
			output+= textField1.getText() + " * ";
			if(temp!=1) {
				ShowCalculation.setText(textField1.getText().concat("*"));
			}
			else {
				ShowCalculation.setText(output);
			}
			textField1.setText("");
			temp=1;
		}
		else if(e.getSource()==sButton) {
			//textField1.setText(textField1.getText().concat("-"));
			output+= textField1.getText() + " - ";
			if(temp!=1) {
				ShowCalculation.setText(textField1.getText().concat("-"));
			}
			else {
				ShowCalculation.setText(output);
			}
			textField1.setText("");
			temp=1;
		}
		else if(e.getSource()==dButton) {
			//textField1.setText(textField1.getText().concat("/"));
			output+= textField1.getText() + " / ";
			if(temp!=1) {
				ShowCalculation.setText(textField1.getText().concat("/"));
			}
			else {
				ShowCalculation.setText(output);
			}
			textField1.setText("");
			temp=1;
		}
		else if(e.getSource()==paren1Button) {
			output+= textField1.getText() + " ( ";
			if(temp!=1) {
				ShowCalculation.setText(textField1.getText().concat("("));
			}
			else {
				ShowCalculation.setText(output);
			}
			textField1.setText("");
			temp=1;
		}
		else if(e.getSource()==paren2Button) {
			output+= textField1.getText() + " ) ";
			if(temp!=1) {
				ShowCalculation.setText(textField1.getText().concat(")"));
			}
			else {
				ShowCalculation.setText(output);
			}
			textField1.setText("");
			temp=1;
		}
		else if(e.getSource()==CButton) {
			
			textField1.setText(textField1.getText().concat("C"));
			textField1.setText("");
			ShowCalculation.setText("");
			
		}
		else if(e.getSource()==CEButton) {
			ShowCalculation.setText("0");
			defaultzero = false;
			Hex=0;
			Dec=0;
			Oct=0;
			Binary=0;
			ButtonHex.setText("HEX " + Hex);
			ButtonDec.setText("DEC " + Dec);
			ButtonOct.setText("OCT " + Oct);
			ButtonBin.setText("BIN " + Binary);
		}
		else if(e.getSource()==ButtonPic4) {
			String backbutton =null;
			if(textField1.getText().length() >0) {
				StringBuilder str = new StringBuilder(textField1.getText());
				str.deleteCharAt(textField1.getText().length()-1);
				backbutton = str.toString();
				textField1.setText(backbutton);
			}
			//textField1.setText(textField1.getText().substring(0, textField1.getText().length() - 1)); 
			/*
			if(!error){
				    if(textField1.getText().length() < 2) {
				        tempNum = "";
				        textField1.setText("0");
				    } 
				    else {
				        if((textField1.getText().charAt(textField1.getText().length() - 1) == '.' &&
				        textField1.getText().charAt(textField1.getText().length() - 2) == '0') ||
				        (textField1.getText().length() == 2 && textField1.getText().charAt(0) == '-'))    {
				            tempNum = "";
				            //textField1.setText("0");
				            isDot = false;
				        }   
				        else {	
				            if(textField1.getText().charAt(textField1.getText().length() - 1) == '.')
				            isDot = false;
				            tempNum = textField1.getText().substring(0, textField1.getText().length() - 1);
				            textField1.setText(tempNum);
				        }
				    }
				    acc1 = Double.parseDouble(textField1.getText()); // here, we assign the value
		}
		*/
		}
		else if(e.getSource()==ModButton) {
			textField1.setText(textField1.getText().concat("Mod"));
			/*
			output+= textField1.getText() + " Mod ";
			if(temp!=1) {
				ShowCalculation.setText(textField1.getText().concat("Mod"));
			}
			else {
				ShowCalculation.setText(output);
			}
			textField1.setText("");
			temp=1;
			*/
			findRemainder(divisor, dividend);
			
		}
		/*
		else if(e.getSource()==paren1Button) {
			textField1.setText(textField1.getText().concat("("));
		}
		else if(e.getSource()==paren2Button) {
			textField1.setText(textField1.getText().concat(")"));
		}
		*/
		else if(equalbefore=true) {
			
		}
		if(e.getSource()==eButton) {
			output += textField1.getText();
			String expression = postFix(output);
			textField1.setText("");
			ShowCalculation.setText("" + calcPostFix(expression));
			
			Hex = calcPostFix(expression);
			//Hex = Integer.parseInt(ShowCalculation.getText());
			ButtonHex.setText("HEX " + dec2Hex(Hex));
			Oct = calcPostFix(expression);
			ButtonOct.setText("OCT " + dec2Oct(Oct));
			Binary = calcPostFix(expression);
			ButtonBin.setText("BIN " + dec2Bin(Binary));
			ButtonDec.setText("DEC " + calcPostFix(expression));
			
			equalbefore = true;
			defaultzero = false;
			result = "";
			Hex =0;
			Dec =0;
			Oct =0;
			Binary =0;
		}
		
	}
		public void restartButtons() {
			aButton.removeActionListener(this);
			mButton.removeActionListener(this);
			sButton.removeActionListener(this);
			dButton.removeActionListener(this);
			eButton.removeActionListener(this);
			Button1.removeActionListener(this);
			Button2.removeActionListener(this);
			Button3.removeActionListener(this);
			Button4.removeActionListener(this);
			Button5.removeActionListener(this);
			Button6.removeActionListener(this);
			Button7.removeActionListener(this);
			Button8.removeActionListener(this);
			Button9.removeActionListener(this);
			Button0.removeActionListener(this);
			ButtonA.removeActionListener(this);
			ButtonB.removeActionListener(this);
			ButtonC.removeActionListener(this);
			ButtonD.removeActionListener(this);
			ButtonE.removeActionListener(this);
			ButtonF.removeActionListener(this);
		}
		public void whenHexClicked() {
			restartButtons();
			Button1.addActionListener(this);
			Button2.addActionListener(this);
			Button3.addActionListener(this);
			Button4.addActionListener(this);
			Button5.addActionListener(this);
			Button6.addActionListener(this);
			Button7.addActionListener(this);
			Button8.addActionListener(this);
			Button9.addActionListener(this);
			Button0.addActionListener(this);
			ButtonA.addActionListener(this);
			ButtonB.addActionListener(this);
			ButtonC.addActionListener(this);
			ButtonD.addActionListener(this);
			ButtonE.addActionListener(this);
			ButtonF.addActionListener(this);
			aButton.addActionListener(this);
			mButton.addActionListener(this);
			sButton.addActionListener(this);
			dButton.addActionListener(this);
			eButton.addActionListener(this);
			
			Button0.setForeground(Color.black);
			Button1.setForeground(Color.black);
			Button2.setForeground(Color.black);
			Button3.setForeground(Color.black);
			Button4.setForeground(Color.black);
			Button5.setForeground(Color.black);
			Button6.setForeground(Color.black);
			Button7.setForeground(Color.black);
			Button8.setForeground(Color.black);
			Button9.setForeground(Color.black);
			ButtonA.setForeground(Color.black);
			ButtonB.setForeground(Color.black);
			ButtonC.setForeground(Color.black);
			ButtonD.setForeground(Color.black);
			ButtonE.setForeground(Color.black);
			ButtonF.setForeground(Color.black);
			
			aButton.setForeground(Color.black);
			mButton.setForeground(Color.black);
			sButton.setForeground(Color.black);
			dButton.setForeground(Color.black);
			eButton.setForeground(Color.black);
		}
		public void whenDecClicked() {
			restartButtons();
			Button1.addActionListener(this);
			Button2.addActionListener(this);
			Button3.addActionListener(this);
			Button4.addActionListener(this);
			Button5.addActionListener(this);
			Button6.addActionListener(this);
			Button7.addActionListener(this);
			Button8.addActionListener(this);
			Button9.addActionListener(this);
			Button0.addActionListener(this);
			aButton.addActionListener(this);
			mButton.addActionListener(this);
			sButton.addActionListener(this);
			dButton.addActionListener(this);
			eButton.addActionListener(this);
			
			Button8.setForeground(Color.black);
			Button9.setForeground(Color.black);
			Button0.setForeground(Color.black);
			Button1.setForeground(Color.black);
			Button2.setForeground(Color.black);
			Button3.setForeground(Color.black);
			Button4.setForeground(Color.black);
			Button5.setForeground(Color.black);
			Button6.setForeground(Color.black);
			Button7.setForeground(Color.black);
			aButton.setForeground(Color.black);
			mButton.setForeground(Color.black);
			sButton.setForeground(Color.black);
			dButton.setForeground(Color.black);
			eButton.setForeground(Color.black);
		}
		
		public void whenOctClicked() {
			restartButtons();
			Button1.addActionListener(this);
			Button2.addActionListener(this);
			Button3.addActionListener(this);
			Button4.addActionListener(this);
			Button5.addActionListener(this);
			Button6.addActionListener(this);
			Button7.addActionListener(this);
			Button0.addActionListener(this);
			aButton.addActionListener(this);
			mButton.addActionListener(this);
			sButton.addActionListener(this);
			dButton.addActionListener(this);
			eButton.addActionListener(this);
			
			Button8.setForeground(Color.gray);
			Button9.setForeground(Color.gray);
			
			Button0.setForeground(Color.black);
			Button1.setForeground(Color.black);
			Button2.setForeground(Color.black);
			Button3.setForeground(Color.black);
			Button4.setForeground(Color.black);
			Button5.setForeground(Color.black);
			Button6.setForeground(Color.black);
			Button7.setForeground(Color.black);
			aButton.setForeground(Color.black);
			mButton.setForeground(Color.black);
			sButton.setForeground(Color.black);
			dButton.setForeground(Color.black);
			eButton.setForeground(Color.black);
		}
		public void whenBinaryClicked() {
			restartButtons();
			Button1.addActionListener(this);
			Button0.addActionListener(this);
			aButton.addActionListener(this);
			mButton.addActionListener(this);
			sButton.addActionListener(this);
			dButton.addActionListener(this);
			eButton.addActionListener(this);
			
			Button2.setForeground(Color.gray);
			Button3.setForeground(Color.gray);
			Button4.setForeground(Color.gray);
			Button5.setForeground(Color.gray);
			Button6.setForeground(Color.gray);
			Button7.setForeground(Color.gray);
			Button8.setForeground(Color.gray);
			Button9.setForeground(Color.gray);
			
			aButton.setForeground(Color.black);
			mButton.setForeground(Color.black);
			sButton.setForeground(Color.black);
			dButton.setForeground(Color.black);
			eButton.setForeground(Color.black);
		}
		public static String postFix(String tokenString){
			char[] token = tokenString.toCharArray(); // our token
			Stack<Character> operators = new Stack<Character>(); // stack for operators
			String output = "";
			for(int i = 0; i < token.length; i++) {	
				if(token[i] == ' ') 
					continue;
				else if(isOperand(token[i])) { // if token[i] is an operand
					output+= token[i];	
				}
				else if(isOperator(token[i])) { // if token[i] is an operator
					
					output += " ";
					while(!operators.empty() && operators.peek() != '(' && HasHigherPrec(operators.peek(), token[i] )) {
						
						output += operators.peek(); 
						operators.pop();						  		
					}
					operators.push(token[i]);
				}
				
				else if(token[i] == '(') { // push the opening parenthesis into the stack
					operators.push(token[i]);
				}
				
				else if(token[i] == ')') { // push the closing parenthesis into the stack which should cancel out both parenthesis
					while(!operators.empty() && operators.peek() != '(') {
						output += operators.peek();
						operators.pop(); // pop the current operators that are in the stack
					}
					operators.pop();	// pop the opening parenthesis
				}			
			}
			while(!operators.empty()) {
				output += operators.peek();
				operators.pop();
			}	
			return output;
		}
		public static boolean isOperator(char token) {	
			if(token == '+' || token == '-' || token == '*' || token == '/' || token == '^' ) 
				return true;
			return false;
		}
		//checks to see if the token is an operand
		public static boolean isOperand(char token) {
			if(token >= '0' && token <= '9')
				return true;
			else if(token >= 'a' && token <= 'z')
				return true;
			else if (token >= 'A' && token <= 'z')
				return true;
			return false;
		}
		public static boolean HasHigherPrec(char operator1, char operator2) {
		int op1Weight = 0;
		int op2Weight = 0;
		if(operator1 == '+' || operator1 == '-')
			op1Weight = 1;
		if(operator1 == '*' || operator1 == '/')
			op1Weight = 2;
		if(operator2 == '+' || operator2 == '-')
			op2Weight = 1;
		if(operator2 == '*' || operator2 == '/')
			op2Weight = 2;
		else {
			op1Weight = -1;
			op2Weight = -1;
		}
		if(op1Weight == op2Weight) {
			return true;
		}
		return op1Weight > op2Weight? true : false;	
		}
		public static boolean isOpeningParenthesis(Stack<Character> operators) { 
			if(operators.peek() == '(')
				return true;
			
			return false;
		}
		public static boolean isClosingParenthesis(Stack<Character> operators) {  
			
			if(operators.peek() == ')') {
				operators.pop();
				return true;
			}
			return false;
		}
		public static boolean isRightAssociative(char token) {	
			if(token == '^')
				return true;
			
			return false;
		}
		public static int calcPostFix(String token) {
			Stack<Integer> operands = new Stack<Integer>(); // stack for operands
			
			 for(int i = 0; i < token.length(); i++) {                                                                                                                                                                                                                                                                                                                                         
				 
				 if(isOperand(token.charAt(i))){		//if current token is an operand
					 StringBuffer sbuf = new StringBuffer();
					 int j = i;	
						while(j < token.length() && !isOperator(token.charAt(j)) && token.charAt(j) != ' ') {
							sbuf.append(token.charAt(j++));
						}
						operands.push(Integer.parseInt(sbuf.toString()));
						i = j;	
				 }
						if(isOperator(token.charAt(i))) {// token is currently a operator
							
							int operand2 = operands.pop();
							int operand1 = operands.pop();
							 switch(token.charAt(i)) { //determine which operator is being used
							 case '+':
								 operands.push(operand1 + operand2);
								 break;
							 case '-':
								 operands.push(operand1 - operand2);
								 break;
							 case '*':
								 operands.push(operand1 * operand2);
								 break;
							 case '/':
								 operands.push(operand1 / operand2);
								 break;
							 case '%':
								 operands.push(operand1 % operand2);
								 break;
							 }	
						 }	 
				 }
			 return operands.pop();	//the final result from the stack
		}
		//decimal to binary conversion function
		public static String dec2Bin(int num) {
			if(num ==0) {
				return "0";
			}
			else if(num == 1) {
				return "1";
			}
			if(num % 2 ==0) {
				return dec2Bin(num / 2) + "0";
			}
			else {
				return dec2Bin(num / 2) + "1";
			}
		}
		//decimal to hex conversion function
		public static String dec2Hex(int num) {
			if(num < 10) {
				return num + "";
			}
			else if(num < hex_base) {
				return character(num);
			}
			else
			{
				return dec2Hex(num / hex_base) + dec2Hex(num % hex_base);
			}
		}
		private static String character(int num) {
			String string = "";
			switch(num) {
			case 10:
				string = "A";
				break;
			case 11:
				string = "B";
				break;
			case 12:
				string = "C";
				break;
			case 13:
				string = "D";
				break;
			case 14:
				string = "E";
				break;
			case 15:
				string = "F";
				break;
			}
			return string;
		}
		//decimal to octal conversion
		public static String dec2Oct(int val) {
			String Octal = Integer.toOctalString(val);
			return Octal;
		}
		//binary to decimal conversion
		public static int bin2Dec(String binaryString) {
			if(binaryString.isEmpty()) {
				return 0;
			}
			else {
				return ((binaryString.charAt(0) - '0') * (int)Math.pow(2, binaryString.length()-1)) + bin2Dec(binaryString.substring(1));
			}
		}
		//hex to decimal conversion
	    public static int hex2Dec(String HexString) {
		       int convertedval = 0;
		       HexString = HexString.toUpperCase();
		       String values = "0123456789ABCDEF";
		       if(HexString.length()>0) {
		           char ch = HexString.charAt(0);
		           int digit = values.indexOf(ch);
		           convertedval = digit*(int)Math.pow(16, HexString.length()-1) + hex2Dec(HexString.substring(1));
		       }
		       return convertedval;
		   }
	    //Octal to decimal conversion function
	    public static int Oct2Dec(String Oct) {
			int Decimal = Integer.parseInt(Oct,8);
			return Decimal;
		}
	    //finding the mod function
	    public static int findRemainder(int divisor, int dividend) {
	    	int remainder = dividend % divisor;
	    	return remainder;
	    }
	}	
