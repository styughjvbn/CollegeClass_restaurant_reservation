package github;

public class DTO_manager_login {
	private String ID;
	private String PW;
	private String HP;
	private String Shop;
	DTO_manager_login(String ID,String PW,String HP,String Shop){
		this.ID=ID;
		this.PW=PW;
		this.HP=HP;
		this.Shop=Shop;
	}
	DTO_manager_login(String ID,String PW){
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
	String get_Shop() {
		return Shop;
	}
}
