package library;

import java.sql.Date;

/**
 * @author Maja Vasilic
 * 
 * */
public class Books {
	private static int idBook;
	private int bookID;

	// authorship data
	private String authorFirstName, authorLastName, title, subTitle,
			parallelTitle;
	private int publishingYear;

	// edition data
	private String edition;

	// publisher and printers
	private String publisherName, publishingPlace, printerName, printingPlace;

	// material description data
	private int pageNumbers, bookFormat;
	private String bookIlustrations;

	// edition collection
	private String editionAuthorFirstName, editionAuthorLastName, editionTitle,
			parallelEditionTitle;
	private int printing;// number of printed books this edition
	private String notes, content;
	private int bibliographiPages, isbn;

	// content description data
	private String professionHeading, subjectHeading, udc;

	private boolean status;
	private Date entryRecordDate, loanBookDate, returnBookDate;
	private int totalNumberOfBorrowedBooks, currentlyNumberOfBorrowedBooks;

	Users users;

	public Books() {
		idBook++;
		this.bookID = idBook; // unique number for a book
	}

	/** mandatory fields of bibliografic description (shortened description)*/
	public Books(String authorFirstName, String authorLastName, String title,
			int publishingYear, String publisherName, String publishingPlace,
			String printerName, String printingPlace, int pageNumbers) {
		idBook++;
		this.bookID = idBook; // unique number for a book
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		this.title = title;
		this.publisherName = publisherName;
		this.publishingPlace = publishingPlace;
		this.printerName = printerName;
		this.printingPlace = printingPlace;
		this.pageNumbers = pageNumbers;
	}

	public static int getIdBook() {
		return idBook;
	}

	public int getBookID() {
		return bookID;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getParallelTitle() {
		return parallelTitle;
	}

	public void setParallelTitle(String parallelTitle) {
		this.parallelTitle = parallelTitle;
	}

	public int getPublishingYear() {
		return publishingYear;
	}

	public void setPublishingYear(int publishingYear) {
		this.publishingYear = publishingYear;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublishingPlace() {
		return publishingPlace;
	}

	public void setPublishingPlace(String publishingPlace) {
		this.publishingPlace = publishingPlace;
	}

	public String getPrinterName() {
		return printerName;
	}

	public void setPrinterName(String printerName) {
		this.printerName = printerName;
	}

	public String getPrintingPlace() {
		return printingPlace;
	}

	public void setPrintingPlace(String printingPlace) {
		this.printingPlace = printingPlace;
	}

	public int getPageNumbers() {
		return pageNumbers;
	}

	public void setPageNumbers(int pageNumbers) {
		this.pageNumbers = pageNumbers;
	}

	public int getBookFormat() {
		return bookFormat;
	}

	public void setBookFormat(int bookFormat) {
		this.bookFormat = bookFormat;
	}

	public String getBookIlustrations() {
		return bookIlustrations;
	}

	public void setBookIlustrations(String bookIlustrations) {
		this.bookIlustrations = bookIlustrations;
	}

	public String getEditionAuthorFirstName() {
		return editionAuthorFirstName;
	}

	public void setEditionAuthorFirstName(String editionAuthorFirstName) {
		this.editionAuthorFirstName = editionAuthorFirstName;
	}

	public String getEditionAuthorLastName() {
		return editionAuthorLastName;
	}

	public void setEditionAuthorLastName(String editionAuthorLastName) {
		this.editionAuthorLastName = editionAuthorLastName;
	}

	public String getEditionTitle() {
		return editionTitle;
	}

	public void setEditionTitle(String editionTitle) {
		this.editionTitle = editionTitle;
	}

	public String getParallelEditionTitle() {
		return parallelEditionTitle;
	}

	public void setParallelEditionTitle(String parallelEditionTitle) {
		this.parallelEditionTitle = parallelEditionTitle;
	}

	public int getPrinting() {
		return printing;
	}

	public void setPrinting(int printing) {
		this.printing = printing;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getBibliographiPages() {
		return bibliographiPages;
	}

	public void setBibliographiPages(int bibliographiPages) {
		this.bibliographiPages = bibliographiPages;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getProfessionHeading() {
		return professionHeading;
	}

	public void setProfessionHeading(String professionHeading) {
		this.professionHeading = professionHeading;
	}

	public String getSubjectHeading() {
		return subjectHeading;
	}

	public void setSubjectHeading(String subjectHeading) {
		this.subjectHeading = subjectHeading;
	}

	public String getUdc() {
		return udc;
	}

	public void setUdc(String udc) {
		this.udc = udc;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getEntryRecordDate() {
		return entryRecordDate;
	}

	public void setEntryRecordDate(Date entryRecordDate) {
		this.entryRecordDate = entryRecordDate;
	}

	public Date getLoanBookDate() {
		return loanBookDate;
	}

	public void setLoanBookDate(Date loanBookDate) {
		this.loanBookDate = loanBookDate;
	}

	public Date getReturnBookDate() {
		return returnBookDate;
	}

	public void setRetunrBookDate(Date returnBookDate) {
		this.returnBookDate = returnBookDate;
	}

	public int getTotalNumberOfBorrowedBooks() {
		return totalNumberOfBorrowedBooks;
	}

	public void setTotalNumberOfBorrowedBooks(int totalNumberOfBorrowedBooks) {
		this.totalNumberOfBorrowedBooks = totalNumberOfBorrowedBooks;
	}

	public int getCurrentlyNumberOfBorrowedBooks() {
		return currentlyNumberOfBorrowedBooks;
	}

	public void setCurrentlyNumberOfBorrowedBooks(
			int currentlyNumberOfBorrowedBooks) {
		this.currentlyNumberOfBorrowedBooks = currentlyNumberOfBorrowedBooks;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
