package Controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import Model.Member_Management;
import Dao.funcs_for_lnr;

public class lunchbox_oms_lnr extends JFrame {

	private JPanel contentPane;
	private JTextField input_account;
	private JPasswordField input_pwd;
	private JLabel clock_lbl;
	private JTextField nn_tf;
	private JTextField acc_tf;
	private JTextField mail_tf;
	private JPasswordField cfm_pwd_tf;
	private JPasswordField pwd_tf;
	private JLabel pwd_hint;
	private JLabel mail_hint;
	private JLabel img_hint_pwd_cfm;
	private JLabel img_hint_pwd;
	private JComboBox<String> bd_y;
	private JComboBox<String> bd_m;
	private JComboBox<String> bd_d;
	private JLabel nn_hint;
	private JLabel bd_hint;
	private JLabel acc_hint;
	private JLabel cfm_pwd_hint;
	private JComboBox<String> gender_jcb;
	private JLabel login_note;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lunchbox_oms_lnr frame = new lunchbox_oms_lnr();
					frame.setVisible(true);
					
					//fixed window
					frame.setResizable(false);
					
					//set window icon
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/spoon.png")));
					
					//remove auto-focus
					frame.getContentPane().requestFocusInWindow();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */

	public lunchbox_oms_lnr() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		tabbedPane.setBounds(0, 0, 438, 660);
		contentPane.add(tabbedPane);
		tabbedPane.setBackground(new Color(255, 192, 203));
		
		JPanel login = new JPanel();
		login.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		login.setBackground(Color.PINK);
		tabbedPane.addTab("會員登入", null, login, null);
		tabbedPane.setBackgroundAt(0, Color.PINK);
		login.setLayout(null);
		
		JPanel clock_pane = new JPanel();
		clock_pane.setBorder(null);
		clock_pane.setBackground(Color.PINK);
		clock_pane.setBounds(5, 580, 200, 30);
		login.add(clock_pane);
		clock_pane.setLayout(null);
		
		clock_lbl = new JLabel("");
		clock_lbl.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 10));
		clock_lbl.setBounds(5, 5, 190, 20);
		clock_pane.add(clock_lbl);
		funcs_for_lnr.clock(clock_lbl);
		
		JLabel login_page_title = new JLabel("真好吃便當店");
		login_page_title.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 48));
		login_page_title.setHorizontalAlignment(SwingConstants.CENTER);
		login_page_title.setBounds(6, 25, 405, 50);
		login.add(login_page_title);
		
		JLabel label_account = new JLabel("帳號");
		label_account.setBackground(Color.ORANGE);
		label_account.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 36));
		label_account.setHorizontalAlignment(SwingConstants.CENTER);
		label_account.setBounds(25, 91, 105, 68);
		login.add(label_account);
		
		input_account = new JTextField();
		input_account.setForeground(Color.GRAY);
		input_account.setText("請輸入帳號");
		input_account.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(input_account.getText().isEmpty()) {
					input_account.setForeground(Color.GRAY);
					input_account.setText("請輸入帳號");
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(input_account.getText().equals("請輸入帳號")) {
					input_account.setForeground(Color.BLACK);
					input_account.setText("");
				}
				funcs_for_lnr.pwd_requirement(pwd_tf, img_hint_pwd, pwd_hint);
			}
		});
		input_account.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 32));
		input_account.setBounds(142, 91, 250, 65);
		login.add(input_account);
		input_account.setColumns(10);
		
		JLabel label_pwd = new JLabel("密碼");
		label_pwd.setHorizontalAlignment(SwingConstants.CENTER);
		label_pwd.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 36));
		label_pwd.setBackground(Color.ORANGE);
		label_pwd.setBounds(25, 156, 105, 68);
		login.add(label_pwd);
		
		input_pwd = new JPasswordField();
		input_pwd.setForeground(Color.GRAY);
		input_pwd.setText("請輸入密碼");
		input_pwd.setEchoChar((char)0);
		input_pwd.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 32));
		input_pwd.setBounds(142, 156, 250, 65);
		input_pwd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(input_pwd.getPassword().length == 0) {
					input_pwd.setText("請輸入密碼");
					input_pwd.setEchoChar((char)0);
					input_pwd.setForeground(Color.GRAY);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				String pwd = String.valueOf(input_pwd.getPassword());
				if(pwd.equals("請輸入密碼")) {
					input_pwd.setForeground(Color.BLACK);
					input_pwd.setEchoChar('●');
					input_pwd.setText(null);
				}
			}
		});
		login.add(input_pwd);
		
		login_note = new JLabel("");
		login_note.setForeground(Color.RED);
		login_note.setHorizontalAlignment(SwingConstants.CENTER);
		login_note.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 14));
		login_note.setBounds(50, 300, 316, 39);
		login.add(login_note);
		
		JButton login_button = new JButton("登入");
		
		login_button.setBackground(new Color(255, 192, 203));
		login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//login condition
				char[] pwd_char_arr = input_pwd.getPassword();
				String pwd = "";
				for(int i = 0; i < pwd_char_arr.length; i++) {
					pwd = pwd + pwd_char_arr[i];
				}
				if((input_account.getText()).equals("請輸入帳號")) {
					login_note.setText("*請輸入帳號");
					input_account.requestFocus();
				}else if(Member_Management.acc_checker(input_account.getText())) {
					login_note.setText("*此帳號不存在，請輸入正確的帳號");
				}
				else {
					login_note.setText(Member_Management.pwd_checker(input_account.getText(), pwd));
				}
				if((login_note.getText()).equals("*登入成功")) {
					setVisible(false);
					func_selection func_sel = new func_selection();
					func_sel.welcome_line(Member_Management.get_nn_with_acc(input_account.getText()));
					func_sel.set_pur_rec_btn();
					func_sel.setVisible(true);
					dispose();
				}else {
					;
				}
			}
		});
		login_button.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 36));
		login_button.setBounds(142, 227, 250, 75);
		login.add(login_button);
		
		
		Image img = new ImageIcon(this.getClass().getResource("/lunchbox.png")).getImage();
		JLabel lb_cartoon_login = new JLabel("");
		lb_cartoon_login.setHorizontalAlignment(SwingConstants.CENTER);
		lb_cartoon_login.setIcon(new ImageIcon(img));
		lb_cartoon_login.setBounds(25, 322, 367, 286);
		login.add(lb_cartoon_login);
		
		JPanel register = new JPanel();
		register.setForeground(new Color(0, 0, 0));
		register.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		register.setBackground(Color.PINK);
		tabbedPane.addTab("註冊會員", null, register, null);
		register.setLayout(null);
		
		JLabel member_info = new JLabel("-- 基本資料 --");
		member_info.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 32));
		member_info.setHorizontalAlignment(SwingConstants.CENTER);
		member_info.setBounds(58, 5, 300, 60);
		register.add(member_info);
		
		JLabel nickname = new JLabel("暱稱");
		nickname.setHorizontalAlignment(SwingConstants.RIGHT);
		nickname.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		nickname.setBounds(36, 60, 80, 50);
		register.add(nickname);
		
		JLabel gender = new JLabel("性別");
		gender.setHorizontalAlignment(SwingConstants.RIGHT);
		gender.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		gender.setBounds(36, 124, 80, 50);
		register.add(gender);
		
		JLabel acc_name = new JLabel("帳號");
		acc_name.setHorizontalAlignment(SwingConstants.RIGHT);
		acc_name.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		acc_name.setBounds(36, 316, 80, 50);
		register.add(acc_name);
		
		JLabel birth_date = new JLabel("生日");
		birth_date.setHorizontalAlignment(SwingConstants.RIGHT);
		birth_date.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		birth_date.setBounds(36, 188, 80, 50);
		register.add(birth_date);
		
		
		JLabel mail_address = new JLabel("Email");
		mail_address.setHorizontalAlignment(SwingConstants.RIGHT);
		mail_address.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		mail_address.setBounds(36, 252, 80, 50);
		register.add(mail_address);
		
		JLabel password_1 = new JLabel("密碼");
		password_1.setHorizontalAlignment(SwingConstants.RIGHT);
		password_1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		password_1.setBounds(36, 380, 80, 50);
		register.add(password_1);
		
		JLabel password_2 = new JLabel("確認密碼");
		password_2.setHorizontalAlignment(SwingConstants.RIGHT);
		password_2.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		password_2.setBounds(36, 444, 80, 50);
		register.add(password_2);
		tabbedPane.setBackgroundAt(1, Color.PINK);
		tabbedPane.setForegroundAt(1, Color.BLACK);
		
		nn_tf = new JTextField();
		nn_tf.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		nn_tf.setBounds(128, 66, 200, 40);
		register.add(nn_tf);
		nn_tf.setColumns(10);
		
		nn_hint = new JLabel("");
		nn_hint.setForeground(Color.RED);
		nn_hint.setHorizontalAlignment(SwingConstants.CENTER);
		nn_hint.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 10));
		nn_hint.setBounds(33, 105, 350, 20);
		register.add(nn_hint);
		
		String[] gender_arr = new String[2];
		gender_arr[0] = "男";
		gender_arr[1] = "女";
		gender_jcb = new JComboBox(gender_arr);
		gender_jcb.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		gender_jcb.setBounds(128, 130, 200, 40);
		register.add(gender_jcb);
		
		bd_y = new JComboBox(funcs_for_lnr.get_y_arr());
		bd_y.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		bd_y.setBounds(128, 194, 120, 40);
		register.add(bd_y);
		
		bd_m = new JComboBox(funcs_for_lnr.get_m_arr());
		bd_m.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bd_d.removeAllItems();
				String[] d_arr = funcs_for_lnr.get_d_arr(bd_y, bd_m);
				for(int j = 0; j < d_arr.length; j++) {
					bd_d.addItem(d_arr[j]);
				}
			}
		});	
		bd_m.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		bd_m.setBounds(248, 194, 80, 40);
		register.add(bd_m);
		
		bd_d = new JComboBox<String>();
		bd_d.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				bd_d.removeAllItems();
				String[] d_arr = funcs_for_lnr.get_d_arr(bd_y, bd_m);
				for(int k = 0; k < d_arr.length; k++) {
					bd_d.addItem(d_arr[k]);
				}
			}
		});
		
		bd_d.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		bd_d.setBounds(328, 194, 80, 40);
		register.add(bd_d);
		
		bd_hint = new JLabel("");
		bd_hint.setForeground(Color.RED);
		bd_hint.setHorizontalAlignment(SwingConstants.CENTER);
		bd_hint.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 10));
		bd_hint.setBounds(33, 227, 350, 20);
		register.add(bd_hint);
		
		mail_tf = new JTextField();
		mail_tf.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		mail_tf.setBounds(128, 258, 200, 40);
		register.add(mail_tf);
		mail_tf.setColumns(10);
		
		mail_hint = new JLabel("");
		mail_hint.setText("");
		mail_hint.setForeground(Color.RED);
		mail_hint.setHorizontalAlignment(SwingConstants.CENTER);
		mail_hint.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 10));
		mail_hint.setBounds(33, 297, 350, 20);
		register.add(mail_hint);
		
		acc_tf = new JTextField();
		acc_tf.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		acc_tf.setBounds(128, 322, 200, 40);
		register.add(acc_tf);
		acc_tf.setColumns(10);
		
		acc_hint = new JLabel("");
		acc_hint.setForeground(Color.RED);
		acc_hint.setHorizontalAlignment(SwingConstants.CENTER);
		acc_hint.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 10));
		acc_hint.setBounds(33, 362, 350, 20);
		register.add(acc_hint);
		
		pwd_hint = new JLabel("");
		pwd_hint.setText("*密碼需介於8～16字元，並至少包含英文大、小寫字母與數字");
		pwd_hint.setForeground(Color.RED);
		pwd_hint.setHorizontalAlignment(SwingConstants.CENTER);
		pwd_hint.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 10));
		pwd_hint.setBounds(33, 425, 350, 20);
		register.add(pwd_hint);
		
		img_hint_pwd = new JLabel("");
		img_hint_pwd.setBounds(328, 380, 50, 50);
		register.add(img_hint_pwd);
		
		pwd_tf = new JPasswordField();
		pwd_tf.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		pwd_tf.setColumns(10);
		pwd_tf.setBounds(128, 386, 200, 40);
		pwd_tf.setText("請輸入密碼");
		pwd_tf.setEchoChar((char)0);
		pwd_tf.setForeground(Color.GRAY);
		register.add(pwd_tf);
		funcs_for_lnr.placeholder_pwd(pwd_tf, "請輸入密碼", img_hint_pwd, pwd_hint);
		
		cfm_pwd_hint = new JLabel("");
		cfm_pwd_hint.setForeground(Color.RED);
		cfm_pwd_hint.setHorizontalAlignment(SwingConstants.CENTER);
		cfm_pwd_hint.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 10));
		cfm_pwd_hint.setBounds(33, 490, 350, 20);
		register.add(cfm_pwd_hint);
		
		img_hint_pwd_cfm = new JLabel("");
		img_hint_pwd_cfm.setBounds(328, 444, 50, 50);
		register.add(img_hint_pwd_cfm);
		
		cfm_pwd_tf = new JPasswordField();
		cfm_pwd_tf.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		cfm_pwd_tf.setColumns(10);
		cfm_pwd_tf.setBounds(128, 450, 200, 40);
		cfm_pwd_tf.setText("請再次輸入密碼");
		cfm_pwd_tf.setEchoChar((char)0);
		cfm_pwd_tf.setForeground(Color.GRAY);
		register.add(cfm_pwd_tf);
		funcs_for_lnr.placeholder_pwd_cfm(cfm_pwd_tf, "請再次輸入密碼", img_hint_pwd_cfm, pwd_tf);
		
		JButton create_member_cfm = new JButton("建立會員");
		create_member_cfm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcs_for_lnr.field_checker(nn_tf, nn_hint, bd_d, bd_hint, mail_tf,
						mail_hint, acc_tf, acc_hint, pwd_tf, cfm_pwd_tf, pwd_hint, cfm_pwd_hint);
				if((nn_hint.getText()).equals("") && (bd_hint.getText()).equals("") &&
						(mail_hint.getText()).equals("") && (acc_hint.getText()).equals("") && 
						(pwd_hint.getText()).equals("")) {
					String nn = nn_tf.getText();
					String gender = (String) gender_jcb.getSelectedItem();
					String bd = (String) bd_y.getSelectedItem() + (String) bd_m.getSelectedItem() + (String) bd_d.getSelectedItem();
					String email = mail_tf.getText();
					String acc = acc_tf.getText();
					char[] pwd_char_arr = pwd_tf.getPassword();
					String pwd = "";
					for(int i = 0; i < pwd_char_arr.length; i++) {
						pwd = pwd + pwd_char_arr[i];
					}
					Member_Management new_mem = new Member_Management(nn, gender, bd, email, acc, pwd);
					new_mem.create_member_data();
					setVisible(false);
					lunchbox_oms_lnr back_to_login_pg = new lunchbox_oms_lnr();
					back_to_login_pg.setVisible(true);
					back_to_login_pg.getContentPane().requestFocusInWindow();
					dispose();
				}else {
					;
				}
			}
		});
		create_member_cfm.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 32));
		create_member_cfm.setBounds(108, 520, 200, 60);
		register.add(create_member_cfm);

		
	}

}
