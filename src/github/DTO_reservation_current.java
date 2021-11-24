package github;

import java.util.ArrayList;

public class DTO_reservation_current {
	private String rc_id;
	private String rc_shop;
	private int rc_count;
	private String rc_time;
	private String rc_date;
	private int rc_money;
	private String rc_menu;
	private int rc_table;
	
	DTO_reservation_current(String rc_id, String rc_shop , int rc_count, String rc_time,String rc_date, int rc_money,String rc_menu, int rc_table ){
		this.rc_id = rc_id;
		this.rc_shop = rc_shop;
		this.rc_count = rc_count;
		this.rc_time = rc_time;
		this.rc_date = rc_date;
		this.rc_money = rc_money;
		this.rc_menu = rc_menu;
		this.rc_table = rc_table;
		
	}
	String get_rc_id() {
		return rc_id;
	}
	
	String get_rc_shop() {
		return rc_shop;
	}	
	int get_rc_count() {
		return rc_count;
	}
	String get_rc_time() {
		return rc_time;
	}
	String get_rc_date() {
		return rc_date;
	}
	int get_rc_money() {
		return rc_money;
	}
	String get_rc_menu() {
		return rc_menu;
	}
	int get_rc_table() {
		return rc_table;
	}
	void set_rc_id(String str) {
		rc_id=str;
	}
	void set_rc_menu(ArrayList<String> menu) {
		for(int i=0;i<menu.size();i++) {
			rc_menu+=menu.get(i)+",";
		}
	}
	void set_rc_money(int money) {
		rc_money=money;
	}

}
