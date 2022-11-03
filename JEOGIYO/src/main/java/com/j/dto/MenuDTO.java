package com.j.dto;

public class MenuDTO {
	private String series;
	private String menuname;
	private int price;
	private String descmenu;
	private String kcal;
	private String sugar;
	private String protein;
	private String fat;
	private String na;
	private String imgname;
	
	public MenuDTO() {}
	public MenuDTO(String series,String menuname,int price, String descmenu,
			String kcal, String sugar, String protein, String fat, String na, String imgname) {
		this.series = series;
		this.menuname = menuname;
		this.price = price;
		this.descmenu = descmenu;
		this.kcal = kcal;
		this.sugar = sugar;
		this.protein = protein;
		this.fat = fat;
		this.fat = fat;
		this.imgname = imgname;
	}
	
	
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescmenu() {
		return descmenu;
	}
	public void setDescmenu(String descmenu) {
		this.descmenu = descmenu;
	}
	public String getKcal() {
		return kcal;
	}
	public void setKcal(String kcal) {
		this.kcal = kcal;
	}
	public String getSugar() {
		return sugar;
	}
	public void setSugar(String sugar) {
		this.sugar = sugar;
	}
	public String getProtein() {
		return protein;
	}
	public void setProtein(String protein) {
		this.protein = protein;
	}
	public String getFat() {
		return fat;
	}
	public void setFat(String fat) {
		this.fat = fat;
	}
	public String getNa() {
		return na;
	}
	public void setNa(String na) {
		this.na = na;
	}
	public String getImgname() {
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
}
