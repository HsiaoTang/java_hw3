package Controller;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

import Model.Member_Management;

public class order_confirmed extends JFrame {

	private JPanel contentPane;
	private JLabel welcome_label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					order_confirmed frame = new order_confirmed();
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
	
	public void welcome_line(String member_nn) {
		welcome_label.setText(member_nn);
	}
	
	
	/**
	 * Create the frame.
	 */
	public order_confirmed() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setResizable(false);
		
		JButton place_order = new JButton("回功能選單");
		place_order.setBounds(131, 255, 220, 51);
		place_order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//login condition
				
				
				
				setVisible(false);
				func_selection fun_sel = new func_selection();
				fun_sel.welcome_line(welcome_label.getText());
				fun_sel.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		
		JLabel hi = new JLabel("嗨！");
		hi.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 36));
		hi.setHorizontalAlignment(SwingConstants.RIGHT);
		hi.setBounds(6, 60, 179, 60);
		contentPane.add(hi);
		
		welcome_label = new JLabel("");
		welcome_label.setBounds(218, 60, 220, 60);
		welcome_label.setHorizontalAlignment(SwingConstants.LEFT);
		welcome_label.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 36));
		welcome_label.setBackground(new Color(255, 245, 238));
		contentPane.add(welcome_label);
	
		JLabel you_would_like = new JLabel("訂單建立成功！");
		you_would_like.setHorizontalAlignment(SwingConstants.CENTER);
		you_would_like.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 36));
		you_would_like.setBounds(101, 119, 270, 60);
		contentPane.add(you_would_like);
		place_order.setBackground(new Color(255, 192, 203));
		place_order.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 36));
		contentPane.add(place_order);
		
		JButton order_search = new JButton("離開");
		order_search.setBounds(131, 431, 220, 51);
		order_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				setVisible(false);
				dispose();
				System.exit(ABORT);
			}
		});
		order_search.setBackground(new Color(255, 192, 203));
		order_search.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 36));
		contentPane.add(order_search);
	}
}

