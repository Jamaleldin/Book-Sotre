package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;

public class BooksModel {
	// Book details
	private int ISBN;
	private String title;
	private String publisherName;
	private String publicationYear;
	private double price;
	private String category;
	private int noCopies;
	private int threshold;
	private String authorName;
	private int cartQuantity;

	// Action to be taken for the book, selection and removal
	JFXButton removeBtn;
	JFXCheckBox selectChbx;

	// Constructor for tables that shows books information
	public BooksModel(Integer iSBN, String title, String authorName, String publisherName, String category, Double price,
			String publicationYear, JFXCheckBox selectChbx) {
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

	// Constructor for books information
	public BooksModel() {

	}

	// Constructor for Books in cart
	public BooksModel(String title, Double price, JFXButton removeBtn) {
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

	public String getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}

	public int getNoCopies() {
		return noCopies;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	public void setNoCopies(int noCopies) {
		this.noCopies = noCopies;
	}

	public int getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
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
