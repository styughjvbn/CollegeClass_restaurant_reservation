package github;

public class DTO_shop {
	private String shop_name;
	private byte shop_holyday;
	private int shop_open;
	private int shop_close;
	private int shop_table_num;
	private String shop_address;
	
	DTO_shop(String shop_name, byte shop_holyday, int shop_open, int shop_close, int shop_table_num, String shop_address)
	{
		this.shop_name = shop_name;
		this.shop_holyday = shop_holyday;
		this.shop_open = shop_open;
		this.shop_close = shop_close;
		this.shop_table_num = shop_table_num;
		this.shop_address = shop_address;
	}
	
	String get_shop_name() {
		return shop_name;
	}
	
	byte get_shop_holyday() {
		return shop_holyday;
	}
	int get_shop_open() {
		return shop_open;
	}
	int get_shop_close() {
		return shop_close;
	}
	int get_shop_table_num() {
		return shop_table_num;
	}
	String get_shop_address() {
		return shop_address;
	}
}
