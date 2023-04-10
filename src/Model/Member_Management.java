package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Member_Management {
	private String member_name;
	private String member_gender;
	private String member_bd;
	private String member_email;
	private String member_acc;
	private String member_pwd;
	
	public Member_Management(String name, String gender, String bd, String email, String acc, String pwd){
		this.member_name = name;
		this.member_gender = gender;
		this.member_bd = bd;
		this.member_email = email;
		this.member_acc = acc;
		this.member_pwd = pwd;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_gender() {
		return member_gender;
	}

	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}

	public String getMember_bd() {
		return member_bd;
	}

	public void setMember_bd(String member_bd) {
		this.member_bd = member_bd;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_acc() {
		return member_acc;
	}

	public void setMember_acc(String member_acc) {
		this.member_acc = member_acc;
	}

	public String getMember_pwd() {
		return member_pwd;
	}

	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}
	
	public void create_member_data(){
		File member_data = new File("./member_data.csv");
		
		if(!(member_data.exists())) {
			try {
				member_data.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		String new_member = this.member_name + "," +
							this.member_gender + "," +
							this.member_bd + "," + 
							this.member_email + "," + 
							this.member_acc + "," + 
							this.member_pwd;
		try {
			FileWriter data_writer = new FileWriter(member_data.getName(), true);
			BufferedWriter writer = new BufferedWriter(data_writer);
			writer.write(new_member);
			writer.newLine();
			writer.close();	
		}catch(IOException e) {
			e.printStackTrace();
		}
				

	
	}
	public static boolean acc_checker(String acc) {
		File member_data = new File("./member_data.csv");
		if(!(member_data.exists())) {
			return true;
		}else {
			try {
				FileReader data_reader = new FileReader(member_data.getName());
				BufferedReader reader = new BufferedReader(data_reader);
				String data = reader.readLine();
				while(data != null) {
					String[] member_fields = data.split(",");
					if(!(acc.equals(member_fields[4]))) {
						data = reader.readLine();
						continue;
					}else {
						reader.close();
						return false;
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return true;
	}
	public static String pwd_checker(String acc, String pwd) {
		File member_data = new File("./member_data.csv");
		if(!(member_data.exists())) {
			return "*請建立會員資料";
		}else {
			try {
				FileReader data_reader = new FileReader(member_data.getName());
				BufferedReader reader = new BufferedReader(data_reader);
			
				String data = reader.readLine();
				while(data != null) {
					String[] member_fields = data.split(",");
					if(acc.equals(member_fields[4])) {
						if(pwd.equals(member_fields[5])) {
							reader.close();
							return "*登入成功";
						}else {
							reader.close();
							return "*密碼錯誤";
						}
					}else {
						data = reader.readLine();
						continue;
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return "*請建立會員資料";
	}
	
	public static String get_nn_with_acc(String acc) {
		try {
			FileReader data_reader = new FileReader("./member_data.csv");
			BufferedReader reader = new BufferedReader(data_reader);
		
			String data = reader.readLine();
			while(data != null) {
				String[] member_fields = data.split(",");
				if(acc.equals(member_fields[4])) {
					reader.close();
					return member_fields[0];
				}else {
					data = reader.readLine();
					continue;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "not found";
		
	}
	
	public static String get_acc_with_nn(String nn) {
		try {
			FileReader data_reader = new FileReader("./member_data.csv");
			BufferedReader reader = new BufferedReader(data_reader);
		
			String data = reader.readLine();
			while(data != null) {
				String[] member_fields = data.split(",");
				if(nn.equals(member_fields[0])) {
					reader.close();
					return member_fields[4];
				}else {
					data = reader.readLine();
					continue;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "not found";
		
	}
	


}
