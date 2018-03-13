package library;

import java.util.Scanner;
import library.dao.impl.BookDao;
import library.dao.impl.Circulation;
import library.dao.impl.Support;
import library.dao.impl.UsersDao;

public class LibApp {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("**************************");
		System.out.println("Wellcome to Library app!");
		System.out.println("____________________________");

		 System.out.println("Please login.");
		 System.out.println();
		
		 System.out.println("Enter username: ");
		 String userName = input.nextLine();
		
		 System.out.println("Enter password: ");
		 String password = input.nextLine();
		
		 Users user = new Users(userName, password);
		
		 System.out.println("*** MAIN MENUE****");
		
		 // check if user is admin
		 if (UsersDao.isAdmin(user)) {
		 mainMenueAdmin();
		
		 } else if (UsersDao.isAlreadyRegistered(userName) == false) {
		 System.out.println("You are not a library member. ");
		
		 // BookDao.searchBookByAuthorName(firstName, lastName);
		 }
		
		 else {
		 mainMenueRegularUser();
		 }

		// UsersDao.archiveUser("majarila", 20);

		Circulation.loanBook(17, 1);
	}

	public static void mainMenueAdmin() {

		System.out.println("1. Enter new user. ");
		System.out.println("2. Enter new book. ");
		System.out.println("3. Loan book to a user. ");
		System.out.println("4. Return book to library");
		System.out.println("5. Exit app");

		System.out.println("Select option:");

		int userInput = Support.checkInputInt(1, 5, input);
		//
		switch (userInput) {
		case 1:
			enterNewUser();
			break;
		case 2:
			enterNewBook();
			break;
		case 3:
			// loan book to a user
			System.out.println("This option is under construction");
			break;
		case 4:
			// return book to a library
			System.out.println("This option is under construction");
			break;
		case 5:
			// exit application
			System.exit(1);
			break;
		}
	}

	public static void mainMenueRegularUser() {
		// // main menue for regular user
		System.out.println("1. Search for a book.  ");
		System.out.println("2. See list of avaliable books. ");
		System.out.println("3. Check if you have any borrowed books. ");
		System.out.println("4. See list of all borrowed books.");
		System.out.println("5. Exit app. ");
		System.out.println("Select option:");

		int userInput = Support.checkInputInt(1, 5, input);
		//
		switch (userInput) {
		case 1:
			System.out.println("This option is under construction");
			break;
		case 2:
			System.out.println("This option is under construction");

			break;
		case 3:
			System.out.println("This option is under construction");

			break;
		case 4:
			System.out.println("This option is under construction");

			break;
		case 5:
			System.exit(1);
			break;
		}
	}

	public static void enterNewUser() {

		// clear entry
		input.nextLine();

		System.out.println("Enter users first name:");
		String firstName = input.nextLine();

		System.out.println("Enter users last name:");
		String lastName = input.nextLine();

		System.out.println("Enter School status:");
		String schoolStatus = input.nextLine();

		System.out.println("Enter professor chief:");
		String professorChief = input.nextLine();

		System.out.println("Is user admin: [1] yes, [2] no");
		int a = Support.checkInputInt(1, 2, input);
		boolean isAdmin = true;

		if (a == 1) {
			isAdmin = true;
		} else {
			isAdmin = false;
		}

		input.nextLine();

		System.out.println("gender:");
		String gender = input.nextLine();

		System.out.println("Enter username:");
		String userName = input.nextLine();

		boolean b = UsersDao.isAlreadyRegistered(userName);

		while (b == true) {

			System.out
					.println("Name is allready taken, please choose another one.");
			userName = input.nextLine();
			b = UsersDao.isAlreadyRegistered(userName);
		}

		System.out.println("Enter password:");
		String password = input.nextLine();

		// UsersDao.userRegistrationInDatabase( "Pavle", "Vasiliæ",
		// "uèenik", "Ljilja Ljubièiæ", false, "male",
		// newUser.getNumOfAllBorrowedBooks(), "pavlek",
		// "pavlek");

		String date = Support.getCurrentDate();
		UsersDao.userRegistrationInDatabase(firstName, lastName, schoolStatus,
				professorChief, gender, isAdmin, userName, password, date);

		System.out
				.println("The users info is recorded. If you like to enter data for new user press 1. ");
		System.out.println("To back to main menue press 2.");
		int userInput = Support.checkInputInt(1, 2, input);
		if (userInput == 1) {
			enterNewUser();
		} else {
			mainMenueAdmin();
		}
	}

	public static void enterNewBook() {
		// clear entry
		input.nextLine();

		System.out.println("Enter books UDC: ");
		String udc = input.nextLine();

		System.out.println("Enter authors first name: ");
		String aFirstName = input.nextLine();

		System.out.println("Enter authors last name: ");
		String aLastName = input.nextLine();

		System.out.println("Enter books title: ");
		String title = input.nextLine();

		System.out.println("Enter books subtitle: ");
		String subTitle = input.nextLine();

		System.out.println("Enter publisher name: ");
		String pubName = input.nextLine();

		System.out.println("Enter publishing place: ");
		String pubPlace = input.nextLine();

		System.out.println("Enter publishing year: ");
		int pubYear = input.nextInt();
		input.nextLine();

		System.out.println("Enter books pages: ");
		int pages = input.nextInt();

		System.out.println("Enter books format: ");
		int format = input.nextInt();

		input.nextLine();
		System.out.println("Enter notes if there has any: ");
		String notes = input.nextLine();

		System.out.println("Enter books printing: ");
		int printing = input.nextInt();
		input.nextLine();
		System.out.println("Enter books subject heading: ");
		String subHeading = input.nextLine();

		System.out.println("Enter books edition: ");
		String edition = input.nextLine();

		BookDao.enterBookDataShort(udc, aFirstName, aLastName, title, subTitle,
				pubName, pubPlace, pubYear, pages, format, notes, printing,
				subHeading, edition);

		// BookDao.enterBookDataShort("821", "LAv ", "Tolstoj", "Rat i mir",
		// " ",
		// "", "", 2015, 152, 21, "nea toga", 12, " ", "");

		System.out
				.println("The book info is recorded to a database. If you like to enter data for new book press 1. ");
		System.out.println("To back to main menue press 2.");
		int userInput = Support.checkInputInt(1, 2, input);
		if (userInput == 1) {
			enterNewBook();
		} else {
			mainMenueAdmin();
		}

	}

	public static void loanBook() {

		System.out.println("Enter bookID: ");
		int bookID = input.nextInt();
		System.out.println("Enter users ID: ");
		int userID = input.nextInt();

		Circulation.loanBook(userID, bookID);
		// check if user has too many books

	}

	public static void returnBook() {

		System.out.println("Enter bookID: ");
		int bookID = input.nextInt();
		System.out.println("Enter users ID: ");
		int userID = input.nextInt();

		Circulation.returnBook(bookID, userID);
	}

}
