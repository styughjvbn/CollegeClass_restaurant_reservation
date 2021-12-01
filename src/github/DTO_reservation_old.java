package github;

public class DTO_reservation_old {
	private String id;
	private String shop;
	private String time;
	private String date;
	private int count;
	private int money;
	private int age;
	private String menu;
	private byte gender;
	
	DTO_reservation_old(String id, String shop, String time, String date, int count, int money, String menu,int age, byte gender){
		this.id = id;
		this.shop = shop;
		this.time = time;
		this.date = date;
		this.count = count;
		this.money = money;
		this.age = age;
		this.menu = menu;
		this.gender = gender;
	}
	String get_id() {
		return id;
	}
	String get_shop() {
		return shop;
	}
	String get_time() {
		return time;
	}
	String get_date() {
		return date;
	}
	int get_count() {
		return count;
	}
	int get_money() {
		return money;
	}
	int get_age() {
		return age;
	}
	String get_menu() {
		return menu;
	}
	byte get_gender() {
		return gender;
	}
	

}
