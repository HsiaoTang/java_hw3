package Dao;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Controller.func_selection;
import Controller.lunchbox_oms_lnr;
import Model.Member_Management;

public class funcs_for_lnr {
	
	public static void clock(JLabel clock_lbl){
		Thread clock = new Thread() {
			public void run() {
				try {
					while(true) {
						Calendar cal = new GregorianCalendar();
						int year = cal.get(Calendar.YEAR);
						String month = String.format("%02d", cal.get(Calendar.MONTH) + 1);
						String day = String.format("%02d", cal.get(Calendar.DAY_OF_MONTH));
						
						String hour = String.format("%02d", cal.get(Calendar.HOUR_OF_DAY));
						String min = String.format("%02d", cal.get(Calendar.MINUTE));
						String sec = String.format("%02d", cal.get(Calendar.SECOND));

						clock_lbl.setText("時間：" + hour + ":" + min + ":" +sec + "  " + "日期：" + year + "/" + month + "/" + day);
						sleep(1000);
					}
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();		
	}
	
	public static boolean mail_checker(String mail_addr) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (mail_addr.equals("")) {
            return false;
        }
        return pat.matcher(mail_addr).matches();
	}
	
	public static String[] get_y_arr(){
		String[] y_arr = new String[100];
		Calendar cal = new GregorianCalendar();
		int year = cal.get(Calendar.YEAR);
		for(int i = 0; i < y_arr.length; i++) {
			y_arr[i] = Integer.toString(year - i);
		}
		
		return y_arr;
	}
	
	public static String[] get_m_arr() {
		String[] m_arr = new String[12];
		for(int i = 0; i < m_arr.length; i++) {
			m_arr[i] = String.format("%02d", i + 1);
		}
		return m_arr;
	}
	
	public static String[] get_d_arr(JComboBox<String> bd_y, JComboBox<String> bd_m) {
		int year = Integer.parseInt((String) bd_y.getSelectedItem());
		int month = (bd_m.getSelectedIndex());
		Calendar bd = Calendar.getInstance();
		bd.set(Calendar.YEAR, year);
		bd.set(Calendar.MONTH, month);
		int days = bd.getActualMaximum(Calendar.DAY_OF_MONTH);
		String[] d_arr = new String[days];
		for(int i = 0; i < d_arr.length; i++) {
			d_arr[i] = String.format("%02d", i + 1);
		}
		return d_arr;
	}
	
	public static void placeholder_pwd(JPasswordField pwd_tf, String ph, JLabel img_hint_pwd, JLabel pwd_hint) {
		pwd_tf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(pwd_tf.getPassword().length == 0) {
					pwd_tf.setText(ph);
					pwd_tf.setEchoChar((char)0);
					pwd_tf.setForeground(Color.GRAY);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				String pwd = String.valueOf(pwd_tf.getPassword());
				if(pwd.equals(ph)) {
					pwd_tf.setText(null);
					pwd_tf.setForeground(Color.BLACK);
					pwd_tf.setEchoChar('●');
				}
				pwd_requirement_listener(pwd_tf, img_hint_pwd, pwd_hint);
				
			}
		});
	}
	
	public static void placeholder_pwd_cfm(JPasswordField cfm_pwd_tf, String ph, JLabel img_hint_pwd_cfm, JPasswordField pwd_tf) {
		cfm_pwd_tf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(cfm_pwd_tf.getPassword().length == 0) {
					cfm_pwd_tf.setText(ph);
					cfm_pwd_tf.setEchoChar((char)0);
					cfm_pwd_tf.setForeground(Color.GRAY);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				String pwd = String.valueOf(cfm_pwd_tf.getPassword());
				if(pwd.equals(ph)) {
					cfm_pwd_tf.setText(null);
					cfm_pwd_tf.setForeground(Color.BLACK);
					cfm_pwd_tf.setEchoChar('●');
				}
				pwd_cfm_listener(img_hint_pwd_cfm, pwd_tf, cfm_pwd_tf);
				
			}
		});
	}
	
	public static void pwd_requirement(JPasswordField pwd_tf, JLabel img_hint_pwd, JLabel pwd_hint) {
		Image green_check = new ImageIcon(lunchbox_oms_lnr.class.getResource("/green_check.png")).getImage();
		Image red_cross = new ImageIcon(lunchbox_oms_lnr.class.getResource("/red_cross.png")).getImage();
		img_hint_pwd.setIcon(new ImageIcon(red_cross));
		char[] pwd = pwd_tf.getPassword();
		int upper_char = 0;
		int lower_char = 0;
		int digit_char = 0;
		int else_char = 0;
		int pwd_len = 0;
		for(int i = 0; i < pwd.length; i++) {
			if(pwd_tf.getForeground().equals(Color.BLACK)) {
				if(Character.isDigit(pwd[i])) {
					digit_char++;
				}
				else if(Character.isUpperCase(pwd[i])){
					upper_char++;
				}
				else if(Character.isLowerCase(pwd[i])){
					lower_char++;
				}
				else {
					else_char++;
				}
			}
		}
		pwd_len = upper_char + lower_char + digit_char + else_char;
		if(upper_char != 0 && lower_char != 0 && digit_char != 0 && pwd_len >= 8) {
			img_hint_pwd.setIcon(new ImageIcon(green_check));
			pwd_hint.setText("");
		}else {
			img_hint_pwd.setIcon(new ImageIcon(red_cross));
			pwd_hint.setText("*密碼需介於8～16字元，並至少包含英文大、小寫字母與數字");
		}
	}
	
	public static void pwd_requirement_listener(JPasswordField pwd_tf, JLabel img_hint_pwd, JLabel pwd_hint) {
		
		pwd_tf.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				pwd_requirement(pwd_tf, img_hint_pwd, pwd_hint);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
//				// TODO Auto-generated method stub
				pwd_requirement(pwd_tf, img_hint_pwd, pwd_hint);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				pwd_requirement(pwd_tf, img_hint_pwd, pwd_hint);
			}

		});
	}
	public static void pwd_cfm_requirement(JLabel img_hint_pwd_cfm, JPasswordField pwd_tf, JPasswordField cfm_pwd_tf) {
		Image green_check = new ImageIcon(lunchbox_oms_lnr.class.getResource("/green_check.png")).getImage();
		Image red_cross = new ImageIcon(lunchbox_oms_lnr.class.getResource("/red_cross.png")).getImage();
		img_hint_pwd_cfm.setIcon(new ImageIcon(red_cross));
		if(Arrays.equals(pwd_tf.getPassword(), cfm_pwd_tf.getPassword()) && (cfm_pwd_tf.getPassword().length >= 8)) {
			img_hint_pwd_cfm.setIcon(new ImageIcon(green_check));
		}else {
			img_hint_pwd_cfm.setIcon(new ImageIcon(red_cross));
		}
	}
	
	public static void pwd_cfm_listener(JLabel img_hint_pwd_cfm, JPasswordField pwd_tf, JPasswordField cfm_pwd_tf) {
		
		cfm_pwd_tf.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				pwd_cfm_requirement(img_hint_pwd_cfm, pwd_tf, cfm_pwd_tf);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
//				// TODO Auto-generated method stub
				pwd_cfm_requirement(img_hint_pwd_cfm, pwd_tf, cfm_pwd_tf);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				pwd_cfm_requirement(img_hint_pwd_cfm, pwd_tf, cfm_pwd_tf);
			}

		});
	}
	
	public static void field_checker(JTextField nn_tf, JLabel nn_hint, JComboBox<String> bd_d, JLabel bd_hint, JTextField mail_tf,
			JLabel mail_hint, JTextField acc_tf, JLabel acc_hint, JPasswordField pwd_tf, JPasswordField cfm_pwd_tf, JLabel pwd_hint, JLabel cfm_pwd_hint) {
		if(nn_tf.getText().equals("")) {
			nn_hint.setText("＊請確實填入暱稱");
		}else {
			nn_hint.setText("");
		}
		if(bd_d.getSelectedItem() == null) {
			bd_hint.setText("＊請確實填入生日");
		}else {
			bd_hint.setText("");
		}
		if(!(mail_checker(mail_tf.getText()))) {
			mail_hint.setText("*請確實輸入Email");
		}else {
			mail_hint.setText("");
		}
		if(acc_tf.getText().equals("")) {
			acc_hint.setText("*請確實輸入帳號");
		}else {
			acc_hint.setText("");
		}
		if(!(Arrays.equals(pwd_tf.getPassword(), cfm_pwd_tf.getPassword()))) {
			cfm_pwd_hint.setText("*請確實填入密碼");
		}else {
			cfm_pwd_hint.setText("");
		}
		if(!Member_Management.acc_checker(acc_tf.getText())) {
			acc_hint.setText("*此帳號已被使用，請改用其他名稱");
		}
	
	}


}
