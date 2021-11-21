package github;

public class DTO_menu_category {
	private String mc_category;
	private String mc_shop;
	
	DTO_menu_category(String mc_category,String mc_shop){
		this.mc_category=mc_category;
		this.mc_shop=mc_shop;
	}
	String get_mc_category() {
		return mc_category;
	}
	String get_mc_shop() {
		return mc_shop;
	}
}
