package library;

import java.util.Date;

/**
 * @author Maja Vasilic
 */
public class Users {

	private static int userID;
	private String firstName;
	private String lastName;
	private String gender;
	private boolean isAdmin;
	private String schoolStatus; // professor, student (grade), associate ...
	private String professorChief; // students only field
	private String userName;
	private String password;
	private boolean isLogedIn;
	private Date userRegistrationDate;
	private Date userArchiveDate; // date when user is no longer library user
	private int numOfCurrentlyBorrowedBooks = 0;
	private int numOfAllBorrowedBooks = 0;
	final int maxBooks = 3;
	
	public Users() {
		userID++;
	}

	public Users(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	// // for profesors and associated (without profesorChief)
	// public Users(String firstName, String lastName, String gender,
	// boolean isAdmin, String schoolStatus, String userName,
	// String password, Date userRegistrationDate, Date userArchiveDate,
	// int numOfCurrentlyBorrowedBooks) {
	// userID++;
	// this.firstName = firstName;
	// this.lastName = lastName;
	// this.gender = gender;
	// this.isAdmin = isAdmin;
	// this.schoolStatus = schoolStatus;
	// this.userName = userName;
	// this.password = password;
	// this.userRegistrationDate = userRegistrationDate;
	// this.userArchiveDate = userArchiveDate;
	// this.numOfCurrentlyBorrowedBooks = numOfCurrentlyBorrowedBooks;
	// }
	//
	// // for students (with professorChief)
	// Users(String firstName, String lastName, String gender,
	// String schoolStatus, boolean isAdmin, String professorChief,
	// String userName, String password, Date userRegistrationDate,
	// Date userArchiveDate, int numOfCurrentlyBorrowedBooks) {
	// // userID++;
	// this.firstName = firstName;
	// this.lastName = lastName;
	// this.gender = gender;
	// this.isAdmin = isAdmin;
	// this.schoolStatus = schoolStatus;
	// this.professorChief = professorChief;
	// this.userName = userName;
	// this.password = password;
	// this.userRegistrationDate = userRegistrationDate;
	// this.userArchiveDate = userArchiveDate;
	// this.numOfCurrentlyBorrowedBooks = numOfCurrentlyBorrowedBooks;
	// }

	public int getIdUser() {
		return userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getSchoolStatus() {
		return schoolStatus;
	}

	public void setSchoolStatus(String schoolStatus) {
		this.schoolStatus = schoolStatus;
	}

	public String getProfessorChief() {
		return professorChief;
	}

	public void setProfessorChief(String professorChief) {
		this.professorChief = professorChief;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLogedIn() {
		return isLogedIn;
	}

	public void setLogedIn(boolean isLogedIn) {
		this.isLogedIn = isLogedIn;
	}

	public Date getUsersRegistrationDate() {
		return userRegistrationDate;
	}

	public void setUsersRegistrationDate(Date userRegistrationDate) {
		this.userRegistrationDate = userRegistrationDate;
	}

	public Date getCheckdOutDate() {
		return userArchiveDate;
	}

	public void setCheckdOutDate(Date userArchiveDate) {
		this.userArchiveDate = userArchiveDate;
	}

	//
	public int getNumOfCurrentlyBooks() {
		return numOfCurrentlyBorrowedBooks;
	}

	// increase number of borrowed books
	public void numberOfBooksUp(int userID) {
		this.numOfCurrentlyBorrowedBooks++;
	}

	// decrease number of borrowed books
	public void numberOfBooksDown(int userID) {
		this.numOfCurrentlyBorrowedBooks--;
	}

	public int getNumOfAllBorrowedBooks() {
		return numOfAllBorrowedBooks;
	}

	public void setNumOfAllBorrowedBooks(int numOfAllBorrowedBooks) {
		this.numOfAllBorrowedBooks = numOfAllBorrowedBooks;
	}

}
