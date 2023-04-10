package Controller;

import java.awt.EventQueue;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLayeredPane;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;
import javax.swing.JScrollPane;

import Model.Member_Management;
import Model.Order_Management;
import javax.swing.JTextPane;
import javax.swing.JTextArea;


public class purchase_rec extends JFrame {

	private static Container layeredPane;
	private JPanel contentPane;
	private static JTextField pg_num;

	private JButton last_page;
	private JButton next_page;
	protected Order_Management po;
	private JLabel member_account;
	private int page_num;
	protected static String acc;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					purchase_rec frame = new purchase_rec(acc);
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
	
	
	public purchase_rec(String acc) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		member_account = new JLabel("會員帳號：" + acc);
		member_account.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		member_account.setLocation(37, 70);
		member_account.setSize(375, 60);
		member_account.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(member_account);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 450, 700);
		contentPane.add(layeredPane);
		
		ArrayList<String[]> pur_rec_list = Order_Management.purchase_record_list(acc);
		
		page_num = 0;
		int block_num = Order_Management.purchase_record_list(acc).size() % 2;
		
		if(block_num == 1) {
			page_num = Order_Management.purchase_record_list(acc).size() / 2 + 1;
		} else {
			page_num = Order_Management.purchase_record_list(acc).size() / 2;
		}
		
		layeredPane.setLayout(null);
		ArrayList<JPanel> page_list = new ArrayList<JPanel>();
		for(int i = 0; i < page_num; i++) {
			if(block_num == 1) {
				if(i == page_num - 1) {
					JPanel page_last = new JPanel();
					page_last.setBounds(0, 149, 450, 521);
					page_last.setBackground(Color.PINK);
					layeredPane.add(page_last);
					page_last.setLayout(null);
					page_list.add(page_last);
			
					JPanel panel_last = new JPanel();
					panel_last.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
					panel_last.setBackground(new Color(255, 239, 213));
					panel_last.setBounds(5, 5, 440, 250);
					page_list.get(i).add(panel_last);
					panel_last.setLayout(null);
					page_last.add(panel_last);
					
					JTextArea textArea_last = new JTextArea();
					textArea_last.setBounds(5, 5, 430, 240);
					textArea_last.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 14));
					textArea_last.setEditable(false);
					panel_last.add(textArea_last);
					String pur_rec_last = Order_Management.show_purchase_record(pur_rec_list.get(i * 2));
					textArea_last.setText(pur_rec_last);
				} else {
					JPanel page = new JPanel();
					page.setBounds(0, 149, 450, 521);
					page.setBackground(Color.PINK);
					layeredPane.add(page);
					page.setLayout(null);
					page_list.add(page);
			
					JPanel panel = new JPanel();
					panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
					panel.setBackground(new Color(255, 239, 213));
					panel.setBounds(5, 5, 440, 250);
					page_list.get(i).add(panel);
					panel.setLayout(null);
					page.add(panel);
					
					JTextArea textArea = new JTextArea();
					textArea.setBounds(5, 5, 430, 240);
					textArea.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 14));
					textArea.setEditable(false);
					panel.add(textArea);
					String pur_rec = Order_Management.show_purchase_record(pur_rec_list.get(i * 2));
					textArea.setText(pur_rec);
					
					JPanel panel1 = new JPanel();
					panel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
					panel1.setBackground(new Color(255, 239, 213));
					panel1.setBounds(5, 265, 440, 250);
					page_list.get(i).add(panel1);
					panel1.setLayout(null);
					page.add(panel1);
					
					JTextArea textArea_1 = new JTextArea();
					textArea_1.setBounds(5, 5, 430, 240);
					textArea_1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 14));
					textArea_1.setEditable(false);
					panel1.add(textArea_1);
					String pur_rec_1 = Order_Management.show_purchase_record(pur_rec_list.get(i * 2 + 1));
					textArea_1.setText(pur_rec_1);
				}
	
				
			}else {
				JPanel page = new JPanel();
				page.setBounds(0, 149, 450, 521);
				page.setBackground(Color.PINK);
				layeredPane.add(page);
				page.setLayout(null);
				page_list.add(page);
		
				JPanel panel = new JPanel();
				panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				panel.setBackground(new Color(255, 239, 213));
				panel.setBounds(5, 5, 440, 250);
				page_list.get(i).add(panel);
				panel.setLayout(null);
				page.add(panel);
				
				JTextArea textArea = new JTextArea();
				textArea.setBounds(5, 5, 430, 240);
				textArea.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 14));
				textArea.setEditable(false);
				panel.add(textArea);
				String pur_rec = Order_Management.show_purchase_record(pur_rec_list.get(i * 2));
				textArea.setText(pur_rec);
				
				JPanel panel1 = new JPanel();
				panel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				panel1.setBackground(new Color(255, 239, 213));
				panel1.setBounds(5, 265, 440, 250);
				page_list.get(i).add(panel1);
				panel1.setLayout(null);
				page.add(panel1);
				
				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBounds(5, 5, 430, 240);
				textArea_1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 14));
				textArea_1.setEditable(false);
				panel1.add(textArea_1);
				String pur_rec_1 = Order_Management.show_purchase_record(pur_rec_list.get(i * 2 + 1));
				textArea_1.setText(pur_rec_1);
				
			}
			
		}
		
		Switch_Screen(page_list.get(0));
		
		JPanel control = new JPanel();
		control.setLayout(null);
		control.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		control.setBackground(new Color(253, 245, 230));
		control.setBounds(0, 0, 450, 60);
		contentPane.add(control);
		
		pg_num = new JTextField("1");
		pg_num.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		pg_num.setText("1");
		pg_num.setHorizontalAlignment(SwingConstants.CENTER);
		pg_num.setColumns(10);
		pg_num.setBounds(135, 17, 32, 26);
		control.add(pg_num);
		
		JButton pg_cfm = new JButton("確定");
		pg_cfm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int current_pg = Integer.parseInt(pg_num.getText());
				if(current_pg == 1) {
					last_page.setEnabled(false);
				} else {
					last_page.setEnabled(true);
				}
				if(current_pg == page_num) {
					next_page.setEnabled(false);
				} else {
					next_page.setEnabled(true);
				}
				Switch_Screen(page_list.get(current_pg - 1));
				
			}
		});
		pg_cfm.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		pg_cfm.setBounds(178, 17, 60, 29);
		if(page_num == 1) {
			pg_cfm.setEnabled(false);
		}
		control.add(pg_cfm);
		
		JButton check = new JButton("回功能選單");
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				func_selection func_sel = new func_selection();
				func_sel.welcome_line(Member_Management.get_nn_with_acc(acc));
				func_sel.set_pur_rec_btn();
				func_sel.setVisible(true);
				dispose();
			}
		});
		check.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		check.setBounds(340, 6, 100, 48);
		control.add(check);
		
		JLabel move_to_pg= new JLabel("移至第           頁");
		move_to_pg.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		move_to_pg.setBounds(80, 22, 117, 16);
		control.add(move_to_pg);
		move_to_pg.setHorizontalAlignment(SwingConstants.CENTER);
		
		last_page = new JButton("上一頁");
		last_page.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int current_pg = Integer.parseInt(pg_num.getText());
				if(current_pg == 2) {
					last_page.setEnabled(false);
				}
				if(current_pg == page_num) {
					next_page.setEnabled(true);
				}
				pg_num.setText(Integer.toString(current_pg - 1));
				Switch_Screen(page_list.get(current_pg - 2));
			}
		});
		last_page.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		last_page.setBounds(6, 6, 80, 48);
		last_page.setEnabled(false);
		control.add(last_page);
		
		
		next_page = new JButton("下一頁");
		next_page.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int current_pg = Integer.parseInt(pg_num.getText());
				if(current_pg == 1) {
					last_page.setEnabled(true);
				}
				if(current_pg == page_num - 1) {
					next_page.setEnabled(false);
				}
				pg_num.setText(Integer.toString(current_pg + 1));
				Switch_Screen(page_list.get(current_pg));
			}
		});
		next_page.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		next_page.setBounds(255, 6, 80, 48);
		if(page_num == 1) {
			next_page.setEnabled(false);
		}
		control.add(next_page);
	}
}
