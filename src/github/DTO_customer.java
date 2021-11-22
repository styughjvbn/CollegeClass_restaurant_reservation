package github;

public class DTO_customer {
	private String ID;
	private String PW;
	private String HP;
	private byte Gender;
	private String Name;
	private int Age;
	private int money;
	
	DTO_customer(String ID,String PW,String HP,byte Gender, String Name,int Age,int money){
		this.ID=ID;
		this.PW=PW;
		this.HP=HP;
		this.Gender=Gender;
		this.Name=Name;
		this.Age=Age;
		this.money=money;
	}
	DTO_customer(String ID,String PW,String HP,byte Gender, String Name,int Age){
		this.ID=ID;
		this.PW=PW;
		this.HP=HP;
		this.Gender=Gender;
		this.Name=Name;
		this.Age=Age;
	}
	DTO_customer(String ID,String PW){
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
	byte get_Gender() {
		return Gender;
	}
	String get_Name() {
		return Name;
	}
	int get_Age() {
		return Age;
	}
	int get_money() {
		return money;
	}
}
