package Controller;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.*;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;

import Dao.funcs_for_od;
import Model.Member_Management;
import Model.Order_Management;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class lunchbox_oms_od extends JFrame {

	private static Container layeredPane;
	private JPanel contentPane;
	private static JTextField pg_num;
	private JTextField braised_p_num;
	private JTextField belly_p_num;
	private JTextField drumstick_c_num;
	private JTextField fillet_p_num;
	private JTextField rib_p_num;
	private JTextField thigh_c_num;
	private JPanel menu_p1;
	private JPanel menu_p2;
	private JPanel menu_p3;
	private JButton last_page;
	private JButton next_page;
	private JLabel member_account;
	private JTextField paid_amount_input;
	private JPanel check_page;
	protected Order_Management po;
	private JCheckBox member_discount;
	private String for_display;
	private String for_display_discount;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lunchbox_oms_od frame = new lunchbox_oms_od();
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
	public static void Switch_Screen(JPanel p) {
		layeredPane.removeAll();
		layeredPane.add(p);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	public void getAccount(String input_acc) {
		member_account.setText("會員帳號：" + input_acc);
	}	
	
	public lunchbox_oms_od() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 450, 700);
		contentPane.add(layeredPane);
		layeredPane.setLayout(null);
		
		menu_p1 = new JPanel();
		menu_p1.setBackground(Color.PINK);
		menu_p1.setBounds(0, 75, 450, 625);
		layeredPane.add(menu_p1);
		menu_p1.setLayout(null);
		
		Image img = new ImageIcon(this.getClass().getResource("/braised_p.png")).getImage();
		JLabel braised_p_pic = new JLabel("");
		braised_p_pic.setHorizontalAlignment(SwingConstants.CENTER);
		braised_p_pic.setIcon(new ImageIcon(img));
		braised_p_pic.setBounds(6, 0, 230, 230);
		menu_p1.add(braised_p_pic);
		
		Image img_1 = new ImageIcon(this.getClass().getResource("/belly_p.png")).getImage();
		JLabel belly_p = new JLabel("");
		belly_p.setHorizontalAlignment(SwingConstants.CENTER);
		belly_p.setIcon(new ImageIcon(img_1));
		belly_p.setBounds(6, 300, 230, 230);
		menu_p1.add(belly_p);
		
		JLabel lb_braised_P = new JLabel("肉燥便當");
		lb_braised_P.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		lb_braised_P.setHorizontalAlignment(SwingConstants.CENTER);
		lb_braised_P.setBounds(6, 240, 230, 50);
		menu_p1.add(lb_braised_P);
		
		JLabel lb_belly_p = new JLabel("焢肉便當");
		lb_belly_p.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		lb_belly_p.setHorizontalAlignment(SwingConstants.CENTER);
		lb_belly_p.setBounds(6, 540, 230, 50);
		menu_p1.add(lb_belly_p);
		
		braised_p_num = new JTextField();
		braised_p_num.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				funcs_for_od.set_zero(braised_p_num);
			}
		});
		braised_p_num.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		braised_p_num.setHorizontalAlignment(SwingConstants.CENTER);
		braised_p_num.setText("0");
		braised_p_num.setBounds(248, 89, 196, 57);
		menu_p1.add(braised_p_num);
		braised_p_num.setColumns(10);
		
		JButton add_braised_p = new JButton("＋");
		add_braised_p.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(braised_p_num.getText());
				braised_p_num.setText(Integer.toString(i + 1));
			}
		});
		add_braised_p.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		add_braised_p.setBounds(248, 6, 196, 57);
		menu_p1.add(add_braised_p);
		
		JButton rm_braised_p = new JButton("－");
		rm_braised_p.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(braised_p_num.getText()).equals("0")) {
					int i = Integer.parseInt(braised_p_num.getText());
					braised_p_num.setText(Integer.toString(i - 1));
				}
			}
		});
		rm_braised_p.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		rm_braised_p.setBounds(248, 172, 196, 57);
		menu_p1.add(rm_braised_p);
		
		JPanel braised_p_p = new JPanel();
		braised_p_p.setBackground(new Color(255, 245, 238));
		braised_p_p.setBounds(248, 233, 196, 57);
		menu_p1.add(braised_p_p);
		braised_p_p.setLayout(null);
		
		JLabel braised_p_p_lb = new JLabel("65元");
		braised_p_p_lb.setBounds(6, 6, 184, 45);
		braised_p_p_lb.setBackground(new Color(255, 240, 245));
		braised_p_p_lb.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		braised_p_p_lb.setHorizontalAlignment(SwingConstants.CENTER);
		braised_p_p.add(braised_p_p_lb);
		
		belly_p_num = new JTextField();
		belly_p_num.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				funcs_for_od.set_zero(belly_p_num);
			}
		});
		belly_p_num.setText("0");
		belly_p_num.setHorizontalAlignment(SwingConstants.CENTER);
		belly_p_num.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		belly_p_num.setColumns(10);
		belly_p_num.setBounds(248, 380, 196, 57);
		menu_p1.add(belly_p_num);
		
		JButton add_belly_p = new JButton("＋");
		add_belly_p.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(belly_p_num.getText());
				belly_p_num.setText(Integer.toString(i + 1));
			}
		});
		add_belly_p.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		add_belly_p.setBounds(248, 300, 196, 57);
		menu_p1.add(add_belly_p);
		
		JButton rm_belly_p = new JButton("－");
		rm_belly_p.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(belly_p_num.getText()).equals("0")) {
					int i = Integer.parseInt(belly_p_num.getText());
					belly_p_num.setText(Integer.toString(i - 1));
				}
			}
		});
		rm_belly_p.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		rm_belly_p.setBounds(248, 473, 196, 57);
		menu_p1.add(rm_belly_p);
		
		JPanel belly_p_p = new JPanel();
		belly_p_p.setBackground(new Color(255, 245, 238));
		belly_p_p.setBounds(248, 533, 196, 57);
		menu_p1.add(belly_p_p);
		belly_p_p.setLayout(null);
		
		JLabel belly_p_p_lb = new JLabel("85元");
		belly_p_p_lb.setBackground(new Color(255, 240, 245));
		belly_p_p_lb.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		belly_p_p_lb.setHorizontalAlignment(SwingConstants.CENTER);
		belly_p_p_lb.setBounds(6, 6, 184, 45);
		belly_p_p.add(belly_p_p_lb);
		
		menu_p2 = new JPanel();
		menu_p2.setBackground(Color.PINK);
		menu_p2.setBounds(0, 75, 450, 625);
		layeredPane.add(menu_p2);
		menu_p2.setLayout(null);
		
		Image img_2 = new ImageIcon(this.getClass().getResource("/drumstick_c.png")).getImage();
		JLabel drumstick_c_pic = new JLabel("");
		drumstick_c_pic.setBounds(6, 0, 230, 230);
		drumstick_c_pic.setHorizontalAlignment(SwingConstants.CENTER);
		drumstick_c_pic.setIcon(new ImageIcon(img_2));
		menu_p2.add(drumstick_c_pic);
		
		Image img_3 = new ImageIcon(this.getClass().getResource("/fillet_p.png")).getImage();
		JLabel fillet_p_pic = new JLabel("");
		fillet_p_pic.setHorizontalAlignment(SwingConstants.CENTER);
		fillet_p_pic.setIcon(new ImageIcon(img_3));
		fillet_p_pic.setBounds(6, 300, 230, 230);
		menu_p2.add(fillet_p_pic);
		
		JLabel lb_drumstick_c = new JLabel("雞腿便當");
		lb_drumstick_c.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		lb_drumstick_c.setHorizontalAlignment(SwingConstants.CENTER);
		lb_drumstick_c.setBounds(6, 240, 230, 50);
		menu_p2.add(lb_drumstick_c);
		
		JLabel lb_fillet_p = new JLabel("里肌便當");
		lb_fillet_p.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		lb_fillet_p.setHorizontalAlignment(SwingConstants.CENTER);
		lb_fillet_p.setBounds(6, 540, 230, 50);
		menu_p2.add(lb_fillet_p);
		
		drumstick_c_num = new JTextField();
		drumstick_c_num.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				funcs_for_od.set_zero(drumstick_c_num);
			}
		});
		drumstick_c_num.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		drumstick_c_num.setHorizontalAlignment(SwingConstants.CENTER);
		drumstick_c_num.setText("0");
		drumstick_c_num.setBounds(248, 89, 196, 57);
		menu_p2.add(drumstick_c_num);
		drumstick_c_num.setColumns(10);
		
		JButton add_drumstick_c = new JButton("＋");
		add_drumstick_c.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(drumstick_c_num.getText());
				drumstick_c_num.setText(Integer.toString(i + 1));
			}
		});
		add_drumstick_c.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		add_drumstick_c.setBounds(248, 6, 196, 57);
		menu_p2.add(add_drumstick_c);
		
		JButton rm_drumstick_c = new JButton("－");
		rm_drumstick_c.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(drumstick_c_num.getText()).equals("0")) {
					int i = Integer.parseInt(drumstick_c_num.getText());
					drumstick_c_num.setText(Integer.toString(i - 1));
				}
			}
		});
		rm_drumstick_c.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		rm_drumstick_c.setBounds(248, 172, 196, 57);
		menu_p2.add(rm_drumstick_c);
		
		JPanel drumstick_c_p = new JPanel();
		drumstick_c_p.setBackground(new Color(255, 245, 238));
		drumstick_c_p.setBounds(248, 233, 196, 57);
		menu_p2.add(drumstick_c_p);
		drumstick_c_p.setLayout(null);
		
		JLabel drumstick_c_p_lb = new JLabel("75元");
		drumstick_c_p_lb.setBackground(new Color(255, 240, 245));
		drumstick_c_p_lb.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		drumstick_c_p_lb.setHorizontalAlignment(SwingConstants.CENTER);
		drumstick_c_p_lb.setBounds(6, 6, 184, 45);
		drumstick_c_p.add(drumstick_c_p_lb);
		
		fillet_p_num = new JTextField();
		fillet_p_num.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				funcs_for_od.set_zero(fillet_p_num);
			}
		});
		fillet_p_num.setText("0");
		fillet_p_num.setHorizontalAlignment(SwingConstants.CENTER);
		fillet_p_num.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		fillet_p_num.setColumns(10);
		fillet_p_num.setBounds(248, 380, 196, 57);
		menu_p2.add(fillet_p_num);
		
		JButton add_fillet_p = new JButton("＋");
		add_fillet_p.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(fillet_p_num.getText());
				fillet_p_num.setText(Integer.toString(i + 1));
			}
		});
		add_fillet_p.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		add_fillet_p.setBounds(248, 300, 196, 57);
		menu_p2.add(add_fillet_p);
		
		JButton rm_fillet_p = new JButton("－");
		rm_fillet_p.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(fillet_p_num.getText()).equals("0")) {
					int i = Integer.parseInt(fillet_p_num.getText());
					fillet_p_num.setText(Integer.toString(i - 1));
				}
			}
		});
		rm_fillet_p.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		rm_fillet_p.setBounds(248, 473, 196, 57);
		menu_p2.add(rm_fillet_p);
		
		JPanel fillet_p_p = new JPanel();
		fillet_p_p.setBackground(new Color(255, 245, 238));
		fillet_p_p.setBounds(248, 533, 196, 57);
		menu_p2.add(fillet_p_p);
		fillet_p_p.setLayout(null);
		
		JLabel fillet_p_p_lb = new JLabel("80元");
		fillet_p_p_lb.setBackground(new Color(255, 240, 245));
		fillet_p_p_lb.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		fillet_p_p_lb.setHorizontalAlignment(SwingConstants.CENTER);
		fillet_p_p_lb.setBounds(6, 6, 184, 45);
		fillet_p_p.add(fillet_p_p_lb);
		
		menu_p3 = new JPanel();
		menu_p3.setBackground(Color.PINK);
		menu_p3.setBounds(0, 75, 450, 614);
		menu_p3.setLayout(null);
		layeredPane.add(menu_p3);
		
		Image img_4 = new ImageIcon(this.getClass().getResource("/rib_p.png")).getImage();
		JLabel rib_p_pic = new JLabel("");
		rib_p_pic.setHorizontalAlignment(SwingConstants.CENTER);
		rib_p_pic.setIcon(new ImageIcon(img_4));
		rib_p_pic.setBounds(6, 0, 230, 230);
		menu_p3.add(rib_p_pic);
		
		Image img_5 = new ImageIcon(this.getClass().getResource("/thigh_c.png")).getImage();
		JLabel thigh_c_pic = new JLabel("");
		thigh_c_pic.setHorizontalAlignment(SwingConstants.CENTER);
		thigh_c_pic.setIcon(new ImageIcon(img_5));
		thigh_c_pic.setBounds(6, 300, 230, 230);
		menu_p3.add(thigh_c_pic);
		
		JLabel lb_rib_p = new JLabel("排骨便當");
		lb_rib_p.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		lb_rib_p.setHorizontalAlignment(SwingConstants.CENTER);
		lb_rib_p.setBounds(6, 240, 230, 50);
		menu_p3.add(lb_rib_p);
		
		JLabel lb_thigh_c = new JLabel("腿排便當");
		lb_thigh_c.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		lb_thigh_c.setHorizontalAlignment(SwingConstants.CENTER);
		lb_thigh_c.setBounds(6, 540, 230, 50);
		menu_p3.add(lb_thigh_c);
		
		rib_p_num = new JTextField();
		rib_p_num.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				funcs_for_od.set_zero(rib_p_num);
			}
		});
		rib_p_num.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		rib_p_num.setHorizontalAlignment(SwingConstants.CENTER);
		rib_p_num.setText("0");
		rib_p_num.setBounds(248, 89, 196, 57);
		menu_p3.add(rib_p_num);
		rib_p_num.setColumns(10);
		
		JButton add_rib_p = new JButton("＋");
		add_rib_p.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(rib_p_num.getText());
				rib_p_num.setText(Integer.toString(i + 1));
			}
		});
		add_rib_p.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		add_rib_p.setBounds(248, 6, 196, 57);
		menu_p3.add(add_rib_p);
		
		JButton rm_rib_p = new JButton("－");
		rm_rib_p.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(rib_p_num.getText()).equals("0")) {
					int i = Integer.parseInt(rib_p_num.getText());
					rib_p_num.setText(Integer.toString(i - 1));
				}
			}
		});
		rm_rib_p.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		rm_rib_p.setBounds(248, 172, 196, 57);
		menu_p3.add(rm_rib_p);
		
		JPanel rib_p_p = new JPanel();
		rib_p_p.setBackground(new Color(255, 245, 238));
		rib_p_p.setBounds(248, 233, 196, 57);
		menu_p3.add(rib_p_p);
		rib_p_p.setLayout(null);
		
		JLabel rib_p_p_lb = new JLabel("90元");
		rib_p_p_lb.setBackground(new Color(255, 240, 245));
		rib_p_p_lb.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		rib_p_p_lb.setHorizontalAlignment(SwingConstants.CENTER);
		rib_p_p_lb.setBounds(6, 6, 184, 45);
		rib_p_p.add(rib_p_p_lb);
		
		thigh_c_num = new JTextField();
		thigh_c_num.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				funcs_for_od.set_zero(thigh_c_num);
			}
		});
		thigh_c_num.setText("0");
		thigh_c_num.setHorizontalAlignment(SwingConstants.CENTER);
		thigh_c_num.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		thigh_c_num.setColumns(10);
		thigh_c_num.setBounds(248, 380, 196, 57);
		menu_p3.add(thigh_c_num);
		
		JButton add_thigh_c = new JButton("＋");
		add_thigh_c.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(thigh_c_num.getText());
				thigh_c_num.setText(Integer.toString(i + 1));
			}
		});
		add_thigh_c.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		add_thigh_c.setBounds(248, 300, 196, 57);
		menu_p3.add(add_thigh_c);
		
		JButton rm_thigh_c = new JButton("－");
		rm_thigh_c.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(thigh_c_num.getText()).equals("0")) {
					int i = Integer.parseInt(thigh_c_num.getText());
					thigh_c_num.setText(Integer.toString(i - 1));
				}
			}
		});
		rm_thigh_c.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		rm_thigh_c.setBounds(248, 473, 196, 57);
		menu_p3.add(rm_thigh_c);
		
		JPanel thigh_c_p = new JPanel();
		thigh_c_p.setBackground(new Color(255, 245, 238));
		thigh_c_p.setBounds(248, 533, 196, 57);
		menu_p3.add(thigh_c_p);
		thigh_c_p.setLayout(null);
		
		JLabel thigh_c_p_lb = new JLabel("70元");
		thigh_c_p_lb.setBackground(new Color(255, 240, 245));
		thigh_c_p_lb.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		thigh_c_p_lb.setHorizontalAlignment(SwingConstants.CENTER);
		thigh_c_p_lb.setBounds(6, 6, 184, 45);
		thigh_c_p.add(thigh_c_p_lb);
		
		check_page = new JPanel();
		check_page.setBackground(Color.PINK);
		check_page.setBounds(0, 75, 450, 599);
		layeredPane.add(check_page);
		check_page.setLayout(null);
		
		member_account = new JLabel("");
		member_account.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		member_account.setLocation(37, 0);
		member_account.setSize(375, 60);
		member_account.setHorizontalAlignment(SwingConstants.CENTER);
		check_page.setBounds(0, 75, 450, 614);
		check_page.add(member_account);
		
		JTextArea order_detail_txt = new JTextArea("");
		order_detail_txt.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		order_detail_txt.setBounds(5, 5, 390, 340);
		check_page.add(order_detail_txt);
		
		JScrollPane order_detail = new JScrollPane(order_detail_txt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		order_detail.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		order_detail.setBackground(new Color(255, 218, 185));
		order_detail.setBounds(25, 70, 400, 350);
		check_page.add(order_detail);

		JLabel paid_amount = new JLabel("支付");
		paid_amount.setHorizontalAlignment(SwingConstants.CENTER);
		paid_amount.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		paid_amount.setBounds(25, 450, 130, 57);
		check_page.add(paid_amount);
		
		paid_amount_input = new JTextField();
		paid_amount_input.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				funcs_for_od.set_zero(paid_amount_input);
			}
		});
		paid_amount_input.setText("0");
		paid_amount_input.setHorizontalAlignment(SwingConstants.CENTER);
		paid_amount_input.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		paid_amount_input.setBounds(160, 450, 130, 57);
		check_page.add(paid_amount_input);
		paid_amount_input.setColumns(10);
		
		JButton change_cal = new JButton("試算");
		change_cal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int	change = 0; 
				if(member_discount.isSelected()) {
					 change = Integer.parseInt(paid_amount_input.getText()) - (int)(0.8 * po.getSum());
					 order_detail_txt.setText(for_display_discount);
				}
				else {
					change = Integer.parseInt(paid_amount_input.getText()) - po.getSum();
					order_detail_txt.setText(for_display);
				}
				 if(change >= 0) {
					 order_detail_txt.append("\t支付：" + paid_amount_input.getText() + "元\n" 
				 + "\t找回：" + change + "元");
					 order_detail_txt.setEditable(false);
				 }
				 else {
					 JOptionPane.showMessageDialog(null, "支付金額不足，請重新輸入。");
				 }
			}
		});
		change_cal.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		change_cal.setBounds(295, 450, 130, 57);
		check_page.add(change_cal);
		
		
		JButton print_order_detail = new JButton("列印");
		print_order_detail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcs_for_od.layout_to_print(member_account, member_discount, paid_amount_input, po);
			}
		});
		print_order_detail.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		print_order_detail.setBounds(25, 525, 130, 57);
		check_page.add(print_order_detail);
		
		member_discount = new JCheckBox("會員8折優惠");
		member_discount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int braised_p = Integer.parseInt(braised_p_num.getText());
				int belly_p = Integer.parseInt(belly_p_num.getText());
				int drumstick_c = Integer.parseInt(drumstick_c_num.getText());
				int fillet_p = Integer.parseInt(fillet_p_num.getText());
				int rib_p = Integer.parseInt(rib_p_num.getText());
				int thigh_c = Integer.parseInt(thigh_c_num.getText());
				
				for_display_discount = "時間：" + po.getCreate_time() + "\n"
						+ "訂單編號：" + String.format("%05d" ,po.getOrder_id()) + "\n"
						+ "\t訂單明細\n" 
						+ "--------------------------------\n" 
						+ Order_Management.show_item("      肉燥便當", braised_p, 65)
						+ Order_Management.show_item("      焢肉便當", belly_p, 85)
						+ Order_Management.show_item("      雞腿便當", drumstick_c, 75)
						+ Order_Management.show_item("      里肌便當", fillet_p, 80)
						+ Order_Management.show_item("      排骨便當", rib_p, 90)
						+ Order_Management.show_item("      腿排便當", thigh_c, 70)
						+ "--------------------------------\n"
						+ "\t" + po.show_sum() + "\n";
				order_detail_txt.setText(for_display_discount);
				if(member_discount.isSelected()) {
					order_detail_txt.append("\t"+ po.show_sum_discount() + "\n");
				}
				for_display_discount = order_detail_txt.getText();
			}
		});
		member_discount.setBounds(315, 426, 128, 23);
		check_page.add(member_discount);
		
		JButton pay_bill = new JButton("付款");
		pay_bill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int	change = 0;
				if(po.getSum() > 0) {
					if(member_discount.isSelected()) {
						 change = Integer.parseInt(paid_amount_input.getText()) - (int)(0.8 * po.getSum());
					}
					else {
						change = Integer.parseInt(paid_amount_input.getText()) - po.getSum();
					}
					
					if(change >= 0) {
						po.create_order_data(member_account, order_detail_txt, member_discount, paid_amount_input);
						setVisible(false);
						order_confirmed oc_pg = new order_confirmed();
						String acc = (member_account.getText().split("："))[1];
						oc_pg.welcome_line(Member_Management.get_nn_with_acc(acc));
						oc_pg.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "支付金額不足，請重新輸入。");
					}
				} else {
					JOptionPane.showMessageDialog(null, "未選購商品。");
				}
			}
		});
		pay_bill.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		pay_bill.setBounds(160, 525, 130, 57);
		check_page.add(pay_bill);
		
		JButton exit = new JButton("離開");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		exit.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		exit.setBounds(295, 525, 130, 57);
		check_page.add(exit);
		
		
		Switch_Screen(menu_p1);
		
		JPanel control = new JPanel();
		control.setLayout(null);
		control.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		control.setBackground(new Color(253, 245, 230));
		control.setBounds(0, 0, 450, 60);
		contentPane.add(control);
		
		pg_num = new JTextField();
		pg_num.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		pg_num.setText("1");
		pg_num.setHorizontalAlignment(SwingConstants.CENTER);
		pg_num.setColumns(10);
		pg_num.setBounds(135, 17, 32, 26);
		control.add(pg_num);
		
		JButton pg_cfm = new JButton("確定");
		pg_cfm.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		pg_cfm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pg_num.getText().equals("1")) {
					Switch_Screen(menu_p1);
					pg_num.setText("1");
				}
				else if(pg_num.getText().equals("2")) {
					Switch_Screen(menu_p2);
					pg_num.setText("2");
				}
				else if(pg_num.getText().equals("3")) {
					Switch_Screen(menu_p3);
					pg_num.setText("3");
				}
			}
		});
		pg_cfm.setBounds(178, 17, 60, 29);
		control.add(pg_cfm);
		
		JButton check = new JButton("結帳");
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(check_page);
				pg_num.setText("-");
				last_page.setEnabled(true);
				next_page.setEnabled(false);
				
				int braised_p = Integer.parseInt(braised_p_num.getText());
				int belly_p = Integer.parseInt(belly_p_num.getText());
				int drumstick_c = Integer.parseInt(drumstick_c_num.getText());
				int fillet_p = Integer.parseInt(fillet_p_num.getText());
				int rib_p = Integer.parseInt(rib_p_num.getText());
				int thigh_c = Integer.parseInt(thigh_c_num.getText());
				String member_acc = member_account.getText().split("：")[1];
				
				po = new Order_Management(member_acc, braised_p, thigh_c, drumstick_c
						, rib_p, belly_p, fillet_p);
			
				for_display = "時間：" + po.getCreate_time() + "\n"
						+ "訂單編號：" + String.format("%05d" ,po.getOrder_id()) + "\n"
						+ "\t訂單明細\n" 
						+ "--------------------------------\n" 
						+ Order_Management.show_item("      肉燥便當", braised_p, 65)
						+ Order_Management.show_item("      焢肉便當", belly_p, 85)
						+ Order_Management.show_item("      雞腿便當", drumstick_c, 75)
						+ Order_Management.show_item("      里肌便當", fillet_p, 80)
						+ Order_Management.show_item("      排骨便當", rib_p, 90)
						+ Order_Management.show_item("      腿排便當", thigh_c, 70)
						+ "--------------------------------\n"
						+ "\t" + po.show_sum() + "\n";
			
				order_detail_txt.setText(for_display);
				order_detail_txt.setEditable(false);
				
			}
		});
		check.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		check.setBounds(340, 3, 100, 30);
		control.add(check);
		
		JButton clear_all = new JButton("清空");
		clear_all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				braised_p_num.setText("0");
				belly_p_num.setText("0");
				drumstick_c_num.setText("0");
				fillet_p_num.setText("0");
				rib_p_num.setText("0");
				thigh_c_num.setText("0");
				order_detail_txt.setText("");
				paid_amount_input.setText("");
			}
		});
		clear_all.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		clear_all.setBounds(340, 27, 100, 30);
		control.add(clear_all);
		
		JLabel move_to_pg= new JLabel("移至第           頁");
		move_to_pg.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		move_to_pg.setBounds(80, 22, 117, 16);
		control.add(move_to_pg);
		move_to_pg.setHorizontalAlignment(SwingConstants.CENTER);
		
		last_page = new JButton("上一頁");
		last_page.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		last_page.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pg_num.getText().equals("1")) {
					setVisible(false);
					func_selection func_sel = new func_selection();
					String acc = (member_account.getText().split("：")[1]);
					func_sel.welcome_line(Member_Management.get_nn_with_acc(acc));
					func_sel.setVisible(true);
					dispose();
				}
				else if(pg_num.getText().equals("2")) {
					Switch_Screen(menu_p1);
					pg_num.setText("1");
					next_page.setEnabled(true);
				}
				else if(pg_num.getText().equals("3")) {
					Switch_Screen(menu_p2);
					pg_num.setText("2");
					last_page.setEnabled(true);
					next_page.setEnabled(true);
				}
				else if(pg_num.getText().equals("-")) {
					Switch_Screen(menu_p3);
					pg_num.setText("3");
					last_page.setEnabled(true);
					next_page.setEnabled(false);
				}
			}
		});
		last_page.setBounds(6, 6, 80, 48);
		control.add(last_page);
		
		next_page = new JButton("下一頁");
		next_page.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		next_page.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pg_num.getText().equals("1")) {
					Switch_Screen(menu_p2);
					pg_num.setText("2");
					last_page.setEnabled(true);
					next_page.setEnabled(true);
				}
				else if(pg_num.getText().equals("2")) {
					Switch_Screen(menu_p3);
					pg_num.setText("3");
					last_page.setEnabled(true);
					next_page.setEnabled(false);
				}
			}
		});
		next_page.setBounds(255, 6, 80, 48);
		control.add(next_page);
	}
}
