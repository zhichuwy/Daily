package com.yang.util.JsonFileParse;

import java.util.List;

public class Da {
	private String intent;
	private String title;
	private int container;
	private int screen;
	private int cellX;
	private int cellY;
	private int spanX;
	private int spanY;
	private int itemType;
	private int category;
	
	private List<Xiao> contents;
	
	
	public String getIntent() {
		return intent;
	}
	public void setIntent(String intent) {
		this.intent = intent;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Xiao> getContents() {
		return contents;
	}
	public void setContents(List<Xiao> contents) {
		this.contents = contents;
	}
	public int getContainer() {
		return container;
	}
	public void setContainer(int container) {
		this.container = container;
	}
	public int getScreen() {
		return screen;
	}
	public void setScreen(int screen) {
		this.screen = screen;
	}
	public int getCellX() {
		return cellX;
	}
	public void setCellX(int cellX) {
		this.cellX = cellX;
	}
	public int getCellY() {
		return cellY;
	}
	public void setCellY(int cellY) {
		this.cellY = cellY;
	}
	public int getSpanX() {
		return spanX;
	}
	public void setSpanX(int spanX) {
		this.spanX = spanX;
	}
	public int getSpanY() {
		return spanY;
	}
	public void setSpanY(int spanY) {
		this.spanY = spanY;
	}
	public int getItemType() {
		return itemType;
	}
	public void setItemType(int itemType) {
		this.itemType = itemType;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
}
