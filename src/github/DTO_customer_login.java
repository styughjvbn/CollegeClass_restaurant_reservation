package github;

public class DTO_customer_login {
	private String ID;
	private String PW;
	private String HP;
	private String Gender;
	private String Name;
	private String Age;
	
	DTO_customer_login(String ID,String PW,String HP,String Gender, String Name,String Age){
		this.ID=ID;
		this.PW=PW;
		this.HP=HP;
		this.Gender=Gender;
		this.Name=Name;
		this.Age=Age;
	}
	DTO_customer_login(String ID,String PW){
		this.ID=ID;
		this.PW=PW;
	}
	String get_ID() {
		return ID;
	}
	String get_PW() {
		return PW;
	}
	String get_HP() {
		return HP;
	}
	String get_Gender() {
		return Gender;
	}
	String get_Name() {
		return Name;
	}
	String get_Age() {
		return Age;
	}
}
