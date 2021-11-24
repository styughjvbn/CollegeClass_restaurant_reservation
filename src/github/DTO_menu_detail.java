package github;

public class DTO_menu_detail {
	
	private String md_name;
	private String md_category;
	private int md_price;
	
	
	DTO_menu_detail(String md_name, String md_category, int md_price){
		this.md_name = md_name;
		this.md_category = md_category;
		this.md_price = md_price;
	}
	String get_md_name() {
		return md_name;
	}
	
	String get_md_category() {
		return md_category;
	}
	
	int get_md_price() {
		return md_price;
	}
	

}
