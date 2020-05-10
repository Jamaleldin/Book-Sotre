package application;


import java.util.Date;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;

public class Book {
	// Book details
	int ISBN;
	String title, authorName, publisherName, category;
	Double price;
	Date publicationYear;
	// Action to be taken for the book, selection and removal
	JFXButton removeBtn;
	JFXCheckBox selectChbx;
	// Constructor for tables that shows books information
	public Book(int iSBN, String title, String authorName, String publisherName, String category, Double price,
			Date publicationYear, JFXCheckBox selectChbx) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.authorName = authorName;
		this.publisherName = publisherName;
		this.category = category;
		this.price = price;
		this.publicationYear = publicationYear;
		this.selectChbx = selectChbx;
	}
	// Constructor for Books in cart
	public Book(String title, Double price, JFXButton removeBtn) {
		this.title = title;
		this.price = price;
		this.removeBtn = removeBtn;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
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
	public Date getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(Date publicationYear) {
		this.publicationYear = publicationYear;
	}
	public JFXButton getRemoveBtn() {
		return removeBtn;
	}
	public void setRemoveBtn(JFXButton removeBtn) {
		this.removeBtn = removeBtn;
	}
	public JFXCheckBox getSelectChbx() {
		return selectChbx;
	}
	public void setSelectChbx(JFXCheckBox selectChbx) {
		this.selectChbx = selectChbx;
	}
	
}
