package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Order_Management {
	private String member;
	private Integer order_id;
	private Integer braised_p;
	private Integer thigh_c;
	private Integer drumstick_c;
	private Integer rib_p;
	private Integer belly_p;
	private Integer fillet_p;
	private Integer sum;
	private String create_time;
	
	public Order_Management() {
		super();
	}
	
	public Order_Management(String member, int braised_p, int thigh_c, int drumstick_c, int rib_p, int belly_p,
			int fillet_p) {
		super();
		if(braised_p >= 0 && thigh_c >= 0 && drumstick_c >= 0 && rib_p >= 0 && belly_p >= 0 && fillet_p >= 0) {
			this.create_time = set_create_time();
			this.order_id = set_order_id();
			this.member = member;
			this.braised_p = braised_p;
			this.thigh_c = thigh_c;
			this.drumstick_c = drumstick_c;
			this.rib_p = rib_p;
			this.belly_p = belly_p;
			this.fillet_p = fillet_p;
			this.sum = braised_p * 65 + thigh_c * 70 + drumstick_c * 75 + rib_p * 90 + belly_p * 85 + fillet_p * 80;
		}
	}
	
	public String getCreate_time() {
		return create_time;
	}
	
	public Integer getOrder_id() {
		return order_id;
	}
	public Integer getSum() {
		return sum;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public Integer getBraised_p() {
		return braised_p;
	}
	public void setBraised_p(Integer braised_p) {
		this.braised_p = braised_p;
	}
	public Integer getThigh_c() {
		return thigh_c;
	}
	public void setThigh_c(Integer thigh_c) {
		this.thigh_c = thigh_c;
	}
	public Integer getDrumstick_c() {
		return drumstick_c;
	}
	public void setDrumstick_c(Integer drumstick_c) {
		this.drumstick_c = drumstick_c;
	}
	public Integer getRib_p() {
		return rib_p;
	}
	public void setRib_p(Integer rib_p) {
		this.rib_p = rib_p;
	}
	public Integer getBelly_p() {
		return belly_p;
	}
	public void setBelly_p(Integer belly_p) {
		this.belly_p = belly_p;
	}
	public Integer getFillet_p() {
		return fillet_p;
	}
	public void setFillet_p(Integer fillet_p) {
		this.fillet_p = fillet_p;
	}

	
	public static String show_item(String item_n, int item_q, int item_p) {
		if(item_q > 0) {
			String item_line = item_n + "：" + item_q + " * " + item_p + " = " + item_q * item_p + "\n";
			return item_line;
		}
		else {
			return "";
		}
	}
	public String show_sum() {
		this.sum = braised_p * 65 + thigh_c * 70 + drumstick_c * 75 + rib_p * 90 + belly_p * 85 + fillet_p * 80;
		String sum = "總計：" + this.sum + "元";
		return sum;
	}
	
	public String show_sum_discount() {
		this.sum = braised_p * 65 + thigh_c * 70 + drumstick_c * 75 + rib_p * 90 + belly_p * 85 + fillet_p * 80;
		String sum = "折扣後金額：" + (int)(this.sum * 0.8) + "元";
		return sum;
	}
	
	public int set_order_id() {
		File order_data = new File("./order_data.csv");
		if(!order_data.exists()) {
			try {
				order_data.createNewFile();
				return 1;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				FileReader data_reader = new FileReader(order_data.getName());
				BufferedReader reader = new BufferedReader(data_reader);
				
				String data = reader.readLine();
				int order_num = 0;
				while(data != null) {
					order_num++;
					data = reader.readLine();
				}
				return order_num + 1;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return 1;
	}
	
	public void create_order_data(JLabel member_acc_label, JTextArea order_detail_txt, JCheckBox member_discount,JTextField paid_amount_typed) {
		File order_data = new File("./order_data.csv");
		if(!order_data.exists()) {
			try {
				order_data.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			String[] member_acc_tbt = (member_acc_label.getText()).split("：");
			String member_account = member_acc_tbt[member_acc_tbt.length - 1];
			String discount_rate = "";
			
			if(member_discount.isSelected()) {
				discount_rate = "0.8";
			}else {
				discount_rate = "1";
			}
			
			String new_order = member_account + "," +
					this.create_time + "," +
					this.order_id + "," +
					this.braised_p + "," +
					this.thigh_c + "," + 
					this.drumstick_c + "," + 
					this.rib_p + "," + 
					this.belly_p + "," +
					this.fillet_p + "," +
					discount_rate + "," +
					paid_amount_typed.getText();
			try {
				FileWriter data_writer = new FileWriter(order_data.getName(), true);
				BufferedWriter writer = new BufferedWriter(data_writer);
				writer.write(new_order);
				writer.newLine();
				writer.close();	
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public String set_create_time() {
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		  LocalDateTime now = LocalDateTime.now();
		  return dtf.format(now);
	}
	
	public static ArrayList<String[]> purchase_record_list(String acc) {
		ArrayList<String[]> order_list = new ArrayList<String[]>();
		try {
			FileReader data_reader = new FileReader("./order_data.csv");
			BufferedReader reader = new BufferedReader(data_reader);
		
			String data = reader.readLine();
			while(data != null) {
				String[] order_fields = data.split(",");
				if(acc.equals(order_fields[0])) {
					data = reader.readLine();
					order_list.add(order_fields);
				}else {
					data = reader.readLine();
					continue;
				}
			}
			return order_list;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order_list;
	}
	
	public static String show_purchase_record(String[] purchase_record) {
		String rec_display = "建立時間：" + purchase_record[1] + "    " +
							 "訂單編號：" + String.format("%05d", Integer.parseInt(purchase_record[2])) + "\n" +
							 show_item("肉燥便當", Integer.parseInt(purchase_record[3]), 65) +
							 show_item("焢肉便當", Integer.parseInt(purchase_record[7]), 85) +
							 show_item("雞腿便當", Integer.parseInt(purchase_record[5]), 75) +
							 show_item("里肌便當", Integer.parseInt(purchase_record[8]), 80) +
							 show_item("排骨便當", Integer.parseInt(purchase_record[6]), 90) +
							 show_item("腿排便當", Integer.parseInt(purchase_record[4]), 70);
		int sum = Integer.parseInt(purchase_record[3]) * 65 +
				  Integer.parseInt(purchase_record[7]) * 85 +
				  Integer.parseInt(purchase_record[5]) * 75 +
				  Integer.parseInt(purchase_record[8]) * 80 +
				  Integer.parseInt(purchase_record[6]) * 90 +
				  Integer.parseInt(purchase_record[4]) * 70;
		if(Double.parseDouble(purchase_record[8]) == 0.8) {
			rec_display = rec_display + "享會員8折優惠" + "\n" + 
						  "總計：" + 0.8 * sum + "元" + "\n" +
						  "支付：" + purchase_record[10] + "元" + "\n" +
						  "找回：" + (Integer.parseInt(purchase_record[10]) - 0.8 * sum) + "元";
		} else {
			rec_display = rec_display +
						  "總計：" + sum + "元" + "\n" +
						  "支付：" + purchase_record[10] + "元" + "\n" +
						  "找回：" + (Integer.parseInt(purchase_record[10]) - sum) + "元";
		}
		
		return rec_display;
	}

}
