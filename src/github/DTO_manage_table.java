package github;

public class DTO_manage_table {
	private int mt_table;
	private String mt_shop;
	private int mt_size;
	private int mt_x;
	private int mt_y;
	
	DTO_manage_table(int mt_table,String mt_shop,int mt_size,int mt_x,int mt_y){
		this.mt_table=mt_table;
		this.mt_shop= mt_shop;
		this.mt_size= mt_size;
		this.mt_x= mt_x;
		this.mt_y= mt_y;
	}
	int get_mt_table() {
		return mt_table;
	}
	String get_mt_shop() {
		return mt_shop;
	}
	int get_mt_size() {
		return mt_size;
	}
	int get_mt_x() {
		return mt_x;
	}
	int get_mt_y() {
		return mt_y;
	}
}