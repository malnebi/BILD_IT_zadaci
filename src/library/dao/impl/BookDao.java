package library.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Maja Vasilic
 */
public class BookDao { // Dao - Data Access Object

	/**
	 * Method entering data of a book in db.
	 * 
	 * @param fields
	 *            of bibliographic description (expanded version)
	 */
	public static void enterBookDataFull(String udc, String authorFirstName,
			String authorLastName, String title, String subTitle,
			String parallelTitle, String publisherName, String publishingPlace,
			String printerName, String printingPlace, int publishingYear,
			int pageNumbers, int bookFormat, String bookIlustrations,
			String editionTitle, String parallelEditionTitle,
			String editionAuthorFirstName, String editionAuthorLastName,
			String notes, int printing, String subjectHeading,
			String professionHeading, String content, Date entryRecordDate,
			String edition) {

		// establish connection with db
		ConnectionUtil connection = new ConnectionUtil();
		PreparedStatement ps = null;

		try {
			Connection conn = connection.connect();
			ps = conn
					.prepareStatement(" INSERT into 'books'( 'udc','authorFirstName', 'authorLastName', 'title',"
							+ "'subTitle', 'parallelTitle', 'publisherName', 'publishingPlace', 'printerName', 'printingPlace',"
							+ "'publishingYear', 'pageNumbers', 'bookFormat','bookIlustrations', 'editionTitle', 'parallelEditionTitle', "
							+ "'editionAuthorFirstName','editionAuthorLastName', 'notes', 'printing','subjectHeading', "
							+ "'professionHeading', 'content', 'entryRecordDate', 'edition') VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			ps.setString(2, udc);
			ps.setString(3, authorFirstName);
			ps.setString(4, authorLastName);
			ps.setString(5, title);
			ps.setString(6, subTitle);
			ps.setString(7, parallelTitle);
			ps.setString(8, publisherName);
			ps.setString(9, publishingPlace);
			ps.setString(10, printerName);
			ps.setString(11, printingPlace);
			ps.setInt(12, publishingYear);
			ps.setInt(13, pageNumbers);
			ps.setInt(14, bookFormat);
			ps.setString(15, bookIlustrations);
			ps.setString(16, editionTitle);
			ps.setString(17, parallelEditionTitle);
			ps.setString(18, editionAuthorFirstName);
			ps.setString(19, editionAuthorLastName);
			ps.setString(20, notes);
			ps.setInt(21, printing);
			ps.setString(22, subjectHeading);
			ps.setString(23, professionHeading);
			ps.setString(24, content);
			ps.setDate(25, entryRecordDate);
			ps.setString(26, edition);

			ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectionUtil.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Method entering data of a book in db.
	 * 
	 * @param mandatory
	 *            fields of bibliographic description (shortened version).
	 * */
	public static void enterBookDataShort(String udc, String authorFirstName,
			String authorLastName, String title, String subTitle,
			String publisherName, String publishingPlace, int publishingYear,
			int pageNumbers, int bookFormat, String notes, int printing,
			String subjectHeading, String edition) {

		// establish connection with db
		ConnectionUtil connection = new ConnectionUtil();
		PreparedStatement ps = null;

		try {
			Connection conn = connection.connect();
			ps = conn
					.prepareStatement(" INSERT INTO books( udc, authorFirstName, authorLastName, title, subTitle, publisherName,"
							+ " publishingPlace, publishingYear, pageNumbers, bookFormat, notes, printing, subjectHeading,"
							+ " edition, entryRecordDate, isBookAvaliable) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			ps.setString(1, udc);
			ps.setString(2, authorFirstName);
			ps.setString(3, authorLastName);
			ps.setString(4, title);
			ps.setString(5, subTitle);
			ps.setString(6, publisherName);
			ps.setString(7, publishingPlace);
			ps.setInt(8, publishingYear);
			ps.setInt(9, pageNumbers);
			ps.setInt(10, bookFormat);
			ps.setString(11, notes);
			ps.setInt(12, printing);
			ps.setString(13, subjectHeading);
			ps.setString(14, edition);
			ps.setString(15, Support.getCurrentDate());
			ps.setBoolean(16, true);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectionUtil.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Method altering books data
	 * */
	public static void alterBookData(int bookID, int column,
			String queryToUpdate) {

		// establish connection with db
		ConnectionUtil connection = new ConnectionUtil();
		PreparedStatement update = null;

		try {
			Connection conn = connection.connect();
			// updates query in db at specified column with specified query
			update = conn.prepareStatement("UPDATE 'books' SET " + column
					+ " = ? WHERE `bookID` = '" + bookID + "' ");

			update.setString(1, queryToUpdate);
			update.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectionUtil.closeConnection();// close connection
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Method searchs a book by book id
	 */
	public static String searchBookByID(int bookID) {

		String s = "";
		// establish connection with db
		ConnectionUtil connection = new ConnectionUtil();
		PreparedStatement ps = null;

		try {
			Connection conn = connection.connect();
			ps = conn
					.prepareStatement("SELECT * FROM 'books' WHERE 'bookID' = ? "
							+ bookID);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				rs.beforeFirst();
				while (rs.next()) {
					s += "bookID\t" + rs.getInt("bookID") + " " + "\nUDK\t"
							+ rs.getString("udk") + " " + "\n"
							+ rs.getString("lastName") + ", "
							+ rs.getString("firstName") + "\n " + "      "
							+ rs.getBoolean("title") + " / "
							+ rs.getString("firstName") + " "
							+ rs.getString("lastName") + " . - "
							+ rs.getString("edition") + " . - "
							+ rs.getString("publisherName") + " : "
							+ rs.getString("publishingPlace") + ", "
							+ rs.getInt("publishingYear") + " ("
							+ rs.getString("printerName") + " : "
							+ rs.getString("printingPlace") + "). - "
							+ rs.getInt("pageNumbers") + " str. "
							+ rs.getInt("bookFormat") + " cm\n";

				}

			} else {
				s = "No data found!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectionUtil.closeConnection();// close connection
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return s;
	}

	/**
	 * Method searches a book by title
	 */
	public static String searchBookByTitle(int title) {
		String s = "";
		// establish connection with db
		ConnectionUtil connection = new ConnectionUtil();
		PreparedStatement ps = null;

		try {
			Connection conn = connection.connect();
			ps = conn
					.prepareStatement("SELECT * FROM 'books' WHERE 'bookID' = ? "
							+ title);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				rs.beforeFirst();
				while (rs.next()) {
					s += "bookID\t" + rs.getInt("bookID") + " " + "\nUDK\t"
							+ rs.getString("udk") + " " + "\n"
							+ rs.getString("lastName") + ", "
							+ rs.getString("firstName") + "\n " + "      "
							+ rs.getBoolean("title") + " / "
							+ rs.getString("firstName") + " "
							+ rs.getString("lastName") + " . - "
							+ rs.getString("edition") + " . - "
							+ rs.getString("publisherName") + " : "
							+ rs.getString("publishingPlace") + ", "
							+ rs.getInt("publishingYear") + " ("
							+ rs.getString("printerName") + " : "
							+ rs.getString("printingPlace") + "). - "
							+ rs.getInt("pageNumbers") + " str. "
							+ rs.getInt("bookFormat") + " cm\n";

				}

			} else {
				s = "No data found!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectionUtil.closeConnection();// close connection
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return s;

	}

	/**
	 * Method searches a book by authors name
	 */
	public static String searchBookByAuthorName(String firstName,
			String lastName) {
		String s = "";
		// establish connection with db
		ConnectionUtil connection = new ConnectionUtil();
		PreparedStatement ps = null;

		try {
			Connection conn = connection.connect();
			ps = conn
					.prepareStatement("SELECT * FROM 'books' WHERE 'authorFirstName' = ? "
							+ firstName + " 'authorLastName' = ? " + lastName);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				rs.beforeFirst();
				while (rs.next()) {
					s += "bookID\t" + rs.getInt("bookID") + " " + "\nUDK\t"
							+ rs.getString("udk") + " " + "\n"
							+ rs.getString("lastName") + ", "
							+ rs.getString("firstName") + "\n " + "      "
							+ rs.getBoolean("title") + " / "
							+ rs.getString("firstName") + " "
							+ rs.getString("lastName") + " . - "
							+ rs.getString("edition") + " . - "
							+ rs.getString("publisherName") + " : "
							+ rs.getString("publishingPlace") + ", "
							+ rs.getInt("publishingYear") + " ("
							+ rs.getString("printerName") + " : "
							+ rs.getString("printingPlace") + "). - "
							+ rs.getInt("pageNumbers") + " str. "
							+ rs.getInt("bookFormat") + " cm\n";
				}

			} else {
				s = "No data found!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectionUtil.closeConnection();// close connection
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return s;

	}

	/**
	 * 
	 * Method copy record data and enter it with new bookID. Taking over a
	 * record for a book which is valid for a new book we bring in DB.
	 * 
	 * @param bookID
	 *            id number of book whose record will be copied
	 * */

	public static void takeOverRecordForNewBook(int bookID) {

		ConnectionUtil connection = new ConnectionUtil();
		PreparedStatement ps = null;

		try {
			Connection conn = connection.connect();
			ps = conn
					.prepareStatement("SELECT * FROM `books` WHERE 'bookID' = "
							+ bookID);
			ResultSet result = ps.executeQuery(); // selecting data from db
			result.next();

			/** INSERT RECORD as a new record in DB */
			ps = conn
					.prepareStatement(" INSERT into 'books'( 'udc','authorFirstName', 'authorLastName', 'title',"
							+ "'subTitle', 'parallelTitle', 'publisherName', 'publishingPlace', 'printerName', 'printingPlace',"
							+ "'publishingYear', 'pageNumbers', 'bookFormat','bookIlustrations', 'editionTitle', 'parallelEditionTitle', "
							+ "'editionAuthorFirstName','editionAuthorLastName', 'notes', 'printing','subjectHeading', "
							+ "'professionHeading', 'content', 'entryRecordDate', 'edition') VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			ps.setString(2, result.getString(2));
			ps.setString(3, result.getString(3));
			ps.setString(4, result.getString(4));
			ps.setString(5, result.getString(5));
			ps.setString(6, result.getString(6));
			ps.setString(7, result.getString(7));
			ps.setString(8, result.getString(8));
			ps.setString(9, result.getString(9));
			ps.setString(10, result.getString(10));
			ps.setString(11, result.getString(11));
			ps.setInt(12, result.getInt(12));
			ps.setInt(13, result.getInt(13));
			ps.setInt(14, result.getInt(14));
			ps.setString(15, result.getString(15));
			ps.setString(16, result.getString(16));
			ps.setString(17, result.getString(17));
			ps.setString(18, result.getString(18));
			ps.setString(19, result.getString(19));
			ps.setString(20, result.getString(20));
			ps.setInt(21, result.getInt(21));
			ps.setString(22, result.getString(22));
			ps.setString(23, result.getString(23));
			ps.setString(24, result.getString(24));
			ps.setDate(25, result.getDate(25));
			ps.setString(26, result.getString(26));

			ps.execute();// inserting data in db

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectionUtil.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
