package com.digital.reader.model;

public class Book {
	

	private int bId;
	
	private String logo;

	private String title;
	
	private String category;
	
	private Double price;
	
	
	private String publisher;
	
	private String publishedDate;
	
	private String chapterOrContent;
	
	private boolean active ;
	
	private String author;

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getChapterOrContent() {
		return chapterOrContent;
	}

	public void setChapterOrContent(String chapterOrContent) {
		this.chapterOrContent = chapterOrContent;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Book(int bId, String logo, String title, String category, Double price, String publisher,
			String publishedDate, String chapterOrContent, boolean active, String author) {
		super();
		this.bId = bId;
		this.logo = logo;
		this.title = title;
		this.category = category;
		this.price = price;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.chapterOrContent = chapterOrContent;
		this.active = active;
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "Book [bId=" + bId + ", logo=" + logo + ", title=" + title + ", category=" + category + ", price="
				+ price + ", publisher=" + publisher + ", publishedDate=" + publishedDate + ", chapterOrContent="
				+ chapterOrContent + ", active=" + active + ", author=" + author + "]";
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	

}
