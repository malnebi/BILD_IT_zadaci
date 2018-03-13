package library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.Users;

/**
 * @author Maja Vasilic
 * @methods loanBook(userID, bookID), returnBook(userID, bookID), isBookAvaliable(bookID)
 */

public class Circulation {

	public static void loanBook(int userID, int bookID) {
		// check if a book is avaliable for loan
		if (isBookAvaliable(bookID) == true) {

			ConnectionUtil connection = new ConnectionUtil();
			PreparedStatement updateToCirculation = null;

			try {
				Connection conn = connection.connect();
				/** Create statement */
				Statement st1 = conn.createStatement();
				Statement st2 = conn.createStatement();

				/** Create ResultSet for users table and books table */
				ResultSet usersRS = st1
						.executeQuery(" SELECT firstName, lastName, userName FROM users WHERE userID = "
								+ userID);
				ResultSet bookRS = st2
						.executeQuery(" SELECT authorFirstName, authorLastName, title FROM books WHERE bookID = "
								+ bookID);

				String auFN = null, auLN = null, title = null, fN = null, lN = null, userN = null;

				while (bookRS.next()) {
					auFN = bookRS.getString("authorFirstName");
					auLN = bookRS.getString("authorLastName");
					title = bookRS.getString("title");
				}

				while (usersRS.next()) {
					fN = usersRS.getString("firstName");
					lN = usersRS.getString("lastName");
					userN = usersRS.getString("userName");
				}

				// **Insert into circulation table*/
				updateToCirculation = conn
						.prepareStatement("INSERT INTO circulation (bookID, userID, loanBookDate, isBookAvaliable, "
								+ "authorFirstName, authorLastName, title, userFirstName, userLastName, userName)"
								+ " VALUES (?,?,?,?,?,?,?,?,?,?)");

				updateToCirculation.setInt(1, bookID);
				updateToCirculation.setInt(2, userID);
				updateToCirculation.setString(3, Support.getCurrentDate());
				updateToCirculation.setBoolean(4, false);
				updateToCirculation.setString(5, auFN);
				updateToCirculation.setString(6, auLN);
				updateToCirculation.setString(7, title);
				updateToCirculation.setString(8, fN);
				updateToCirculation.setString(9, lN);
				updateToCirculation.setString(10, userN);
				// execute statement
				updateToCirculation.executeUpdate();
				// say book is not avaliable now, setting its "isAvaliable"
				// field to false in "books" table
				PreparedStatement loanUpdate = conn
						.prepareStatement(" UPDATE books SET isBookAvaliable = ? WHERE bookID = "
								+ bookID);
				loanUpdate.setBoolean(1, false);
				loanUpdate.executeUpdate();
				// send message to the user
				System.out.println("Book '" + title + "' is now loaned to "
						+ fN + " " + lN);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					ConnectionUtil.closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("Sorry. Book is not avaliable.");
		}
	}

	public static void returnBook(int bookID, int userID) {
		ConnectionUtil connection = new ConnectionUtil();
		PreparedStatement updateToCirculation = null;

		try {
			Connection conn = connection.connect();

			// **update circulation table*/
			updateToCirculation = conn
					.prepareStatement(" UPDATE circulation SET isBookAvaliable = ? WHERE bookID = "
							+ bookID);

			updateToCirculation.setBoolean(1, true);
			updateToCirculation.executeUpdate();

			// say book is avaliable now, setting its "isAvaliable"
			// field to false in "books" table
			PreparedStatement loanUpdate = conn
					.prepareStatement(" UPDATE books SET isBookAvaliable = ? WHERE bookID = "
							+ bookID);
			loanUpdate.setBoolean(1, true);
			loanUpdate.executeUpdate();

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

	public static boolean isBookAvaliable(int bookID) {

		boolean result = true;

		ConnectionUtil con = new ConnectionUtil();
		PreparedStatement ps = null;
		String sql = "SELECT isBookAvaliable FROM books WHERE bookID='"
				+ bookID + "';";

		try {
			// establish connection to a database
			Connection connection = con.connect();
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.beforeFirst();

			if (rs.next()) {
				// check if book is avaliable and return false if not
				if (rs.getBoolean("isBookAvaliable") == true) {
					result = true;
				} else
					result = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectionUtil.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;

	}

	public static int currentlyNumberOfUsersBooks(Users user) {
		return user.getNumOfCurrentlyBooks();
	}

	public static int totalLoanedBooks() {
		return 1;
	}

	public static ArrayList<String> totalBooksOfUser(Users user) {

		ArrayList<String> list = new ArrayList<>();
		return list;
	}

}