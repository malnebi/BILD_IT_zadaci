package library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import library.Users;
import library.dao.impl.ConnectionUtil;

/**
 * 
 * @author Maja Vasilic
 * 
 *         Class - provides user data manipulation ........................
 *         Methods - userRegistration(), isAlreadyRegistred(),
 *         updateUsersInfo(), logIn(), logOut(), isAdmin(), searchUser(),
 *         getActiveUsers(), getAllUsers(), getArchiveUsers(), archiveUser()
 */
public class UsersDao {

	/**
	 * @method registers new user by writing data in a db.
	 */
	public static void userRegistrationInDatabase(String firstName,
			String lastName, String schoolStatus, String professorChief,
			String gender, boolean isAdmin, String userName, String password,
			String userRegistrationDate) {

		// Invoke ConnectionUtil Class to establish connection with the db
		ConnectionUtil connection = new ConnectionUtil();
		PreparedStatement ps = null;

		try {
			Connection conn = connection.connect();

			/** Insert queries into DB */
			ps = conn
					.prepareStatement(" INSERT INTO `users`(firstName, lastName, schoolStatus, professorChief, gender, "
							+ " isAdmin, userName, password, userRegistrationDate ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, schoolStatus);
			ps.setString(4, professorChief);
			ps.setString(5, gender);
			ps.setBoolean(6, isAdmin);
			ps.setString(7, userName);
			ps.setString(8, password);
			ps.setString(9, userRegistrationDate);

			ps.executeUpdate(); // execute update

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// close connection with the db
				ConnectionUtil.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Method checks if user exists in the database *
	 */
	public static boolean isAlreadyRegistered(String userNameSearch) {

		// * Invoke ConnectionUtil Class to establish MySQL connection with the
		// DB
		ConnectionUtil connection = new ConnectionUtil();
		PreparedStatement prepStat = null; // declare PreparedStatement
											// interface
		try {
			Connection mysqlConnect = connection.connect();
			/** Select `userName` column from the table `users` */
			prepStat = mysqlConnect
					.prepareStatement(" SELECT `userName` FROM `users` ");
			ResultSet rs = prepStat.executeQuery(); // execute function
			while (rs.next()) {
				// Check if column "userName" from "users" is equal to input's
				// user name
				if (rs.getString("userName").equals(userNameSearch)) {
					return true; // If user IS found, return true
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				/** Close connection with the Database */
				ConnectionUtil.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false; // If user is NOT found, return false
	}

	/**
	 * @method provides update of information about user
	 *
	 * @param userName
	 *            User name of user that we are going to edit.
	 * @param column
	 *            Field that is going to be edited.
	 * @param queryToUpdate
	 *            New value for the field that we are editing.
	 */
	public static void updateUsersInfoInDatabase(String userName,
			String column, String queryToUpdate) {
		// establish connection with DB
		ConnectionUtil connection = new ConnectionUtil();
		PreparedStatement update = null;

		try {
			Connection conn = connection.connect();
			// updates query in db at specified column with specified query
			update = conn.prepareStatement("UPDATE 'users' SET " + column
					+ " = ? WHERE `userName` = '" + userName + "' ");

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
	 * @return returns Users object if login success and returns null if it
	 *         fails
	 */
	public static Users logIn(String userName, String password) {

		// Instantiate the Users object with specified userName and password as
		// arguments
		Users user = new Users(userName, password);
		/** Invoke ConnectionUtil Class to establish connection with the DB */
		ConnectionUtil connection = new ConnectionUtil();
		PreparedStatement prepStat, insertQuery = null;

		try {
			Connection mysqlConnect = connection.connect();
			prepStat = mysqlConnect
					.prepareStatement(" SELECT userName, password, isOnline FROM users ");
			insertQuery = mysqlConnect
					.prepareStatement(" UPDATE users SET isOnline = ? WHERE `userName` = '"
							+ user.getUserName() + "' ");
			insertQuery.setBoolean(1, true);
			ResultSet rs = prepStat.executeQuery();

			if (!rs.next()) {
				System.out.println(" No data found!");
				return null;
			} else {
				rs.beforeFirst();
				while (rs.next()) {
					// check if userName from `users` corresponds input's
					// userName and check same for password
					if (rs.getString("userName").equals(userName)
							&& rs.getString("password").equals(password)) {
						// If `isOnline` column is set to 'false' (user is
						// offline)
						if (rs.getString("isOnline").equals("false")) {
							insertQuery.executeUpdate(); // execute update
							return user; // return user object (user is online
											// now)
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				/** Close connection with the database */
				ConnectionUtil.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null; // otherwise return null
	}

	/**
	 * @return will check db every time user makes a choice and if user is
	 *         offline wont let him do stuff
	 */
	public static boolean isActive(String userName) {
		boolean result = true;

		ConnectionUtil con = new ConnectionUtil();
		PreparedStatement preparedStatment = null;
		try {

			Connection connection = con.connect();
			preparedStatment = connection
					.prepareStatement("SELECT isOnline FROM users WHERE userName='"
							+ userName + "';");
			ResultSet rs = preparedStatment.executeQuery();
			rs.beforeFirst();
			if (rs.next()) {
				// if user is found check if its online and return false if not
				if (rs.getString("isOnline").equals("false")) {
					result = false;
				} else
					result = true;
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

	/**
	 * @param userSession
	 *            sets current login user to null
	 */
	public static void logOut(Users userSession) {
		// Instantiate Users object
		userSession = new Users(userSession.getUserName(),
				userSession.getPassword());
		// Invoke ConnectionUtil Class to establish connection with the db
		ConnectionUtil connection = new ConnectionUtil();
		PreparedStatement insertQuery = null;
		try {
			Connection mysqlConnect = connection.connect();
			// * Update `users` table, set column `isOnline` to 'false' for the
			// current user
			insertQuery = mysqlConnect
					.prepareStatement(" UPDATE `users` SET `isOnline` = 'false' WHERE `userName` = '"
							+ userSession.getUserName() + "' ");
			insertQuery.executeUpdate(); // execute update
			userSession.setUserName(null); // set userName to null
			userSession.setPassword(null); // set password to null
			userSession = null; // set object to null
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				/** Close connection with the database */
				ConnectionUtil.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return return true if its admin false if not
	 */
	public static boolean isAdmin(Users user) {

		// Invoke ConnectionUtil Class to establish MySQL connection with the DB
		ConnectionUtil connection = new ConnectionUtil();
		PreparedStatement prepStat = null; // declare PreparedStatement
											// interface
		try {
			Connection mysqlConnect = connection.connect();
			prepStat = mysqlConnect
					.prepareStatement(" SELECT `isAdmin`, `userName` FROM `users` ");
			ResultSet rs = prepStat.executeQuery(); // execute function
			if (!rs.next()) {
				System.out.println("no data found!");
			} else {
				rs.beforeFirst();
				while (rs.next()) { // while table contains some data
					// check if column "userName" from "users" is equal to
					// input's user name string
					if (rs.getString("userName").equals(user.getUserName())) {
						// check if user is admin
						if (rs.getBoolean("isAdmin") == true) {
							return true; // if it's admin, return true
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				/** Close connection with the Database */
				ConnectionUtil.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false; // if it's not admin, return false
	}

	/**
	 * @return String value of all users that are not having admin rights.
	 */
	public static String getUsersFromDB() {

		String s = "";

		// invoke ConnectionUtil Class to establish MySQL connection with the DB
		ConnectionUtil connection = new ConnectionUtil();
		PreparedStatement prepStat = null; // declare PreparedStatement
											// interface
		try {
			Connection mysqlConnect = connection.connect();
			prepStat = mysqlConnect
					.prepareStatement(" SELECT `userName` FROM `users` WHERE `isAdmin` = 'false' ");
			ResultSet rs = prepStat.executeQuery(); // execute function
			while (rs.next()) {
				s += "[" + rs.getString("userName") + "]\n";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// close connection with the DB
				ConnectionUtil.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return s;
	}

	/**
	 * Method searchs for a user in a DB based on firstname, lastname or
	 * username and print its data
	 */
	public static String searchUser(String firstName, String lastName) {

		String s = "";
		// establish connection with DB
		ConnectionUtil connection = new ConnectionUtil();
		PreparedStatement ps = null;

		try {
			Connection conn = connection.connect();
			ps = conn
					.prepareStatement("SELECT * FROM users WHERE 'firstName' = ? AND 'lastName'= ? ");
			// actual values are set to paramiters
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				rs.beforeFirst();
				while (rs.next()) {
					s += "[userName]\t" + rs.getString("userName") + " "
							+ "[password]\t" + rs.getString("password") + " "
							+ "[firstName]\t" + rs.getString("firstName") + " "
							+ "[lastName]\t" + rs.getString("lastName") + " "
							+ "[isAdmin]\t" + rs.getBoolean("isAdmin") + " "
							+ "[gender]\t" + rs.getString("gender") + " "
							+ "[schoolStatus]\t" + rs.getString("schoolStatus")
							+ "" + "[professorChief]\t"
							+ rs.getString("professorChief") + " \n";
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
	 * @param userName
	 *            User name of user that we are searching
	 * @return returns String data about our user
	 */
	public static String findUserByUserName(String userName) {
		String result = "";

		ConnectionUtil con = new ConnectionUtil();
		PreparedStatement preparedStatement = null;

		try {
			Connection connection = con.connect();
			preparedStatement = connection
					.prepareStatement("SELECT * FROM users WHERE `userName` = '"
							+ userName + "' ");
			ResultSet rs = preparedStatement.executeQuery();
			if (!rs.next()) {
				result = null;
			} else {
				result = "[userName]\t" + rs.getString("userName") + " \n"
						+ "[password]\t" + rs.getString("password") + " \n"
						+ "[name]\t\t" + rs.getString("Name") + " \n"
						+ "[lastName]\t" + rs.getString("lastName") + " \n"
						+ "[isAdmin]\t" + rs.getBoolean("isAdmin") + " \n"
						+ "[gender]\t" + rs.getString("gender") + " \n"
						+ "[idCard]\t" + rs.getString("idCard");
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

	/**
	 * @return returns String data about our user
	 */
	public static String findUserByName(String Name)
			throws ClassNotFoundException, SQLException {
		String result = "";
		ConnectionUtil con = new ConnectionUtil();
		PreparedStatement preparedStatement = null;

		try {
			Connection connection = con.connect();
			preparedStatement = connection
					.prepareStatement("SELECT * FROM users WHERE `Name` = '"
							+ Name + "' ");
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				rs.beforeFirst();
				while (rs.next()) {

					result += "[userName]\t" + rs.getString("userName") + " "
							+ "[password]\t" + rs.getString("password") + " "
							+ "[name]\t" + rs.getString("Name") + " "
							+ "[lastName]\t" + rs.getString("lastName") + " "
							+ "[isAdmin]\t" + rs.getBoolean("isAdmin") + " "
							+ "[gender]\t" + rs.getString("gender") + " "
							+ "[idCard]\t" + rs.getString("idCard") + "\n";
				}
			} else {
				result += "No data found!";
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

	/**
	 * Method search for a user based on it's ID card
	 */
	public static String findUserByIDCard(String string)
			throws ClassNotFoundException, SQLException {

		String result = "";
		ConnectionUtil con = new ConnectionUtil();
		PreparedStatement preparedStatement = null;

		try {
			Connection connection = con.connect();
			preparedStatement = connection
					.prepareStatement("SELECT * FROM users WHERE `idCard` = '"
							+ string + "' ");
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				rs.beforeFirst();
				while (rs.next()) {
					result += "[userName]\t" + rs.getString("userName") + " "
							+ "[password]\t" + rs.getString("password") + " "
							+ "[name]\t" + rs.getString("Name") + " "
							+ "[lastName]\t" + rs.getString("lastName") + " "
							+ "[isAdmin]\t" + rs.getBoolean("isAdmin") + " "
							+ "[gender]\t" + rs.getString("gender") + " "
							+ "[idCard]\t" + rs.getString("idCard") + "\n";
				}
			} else {
				result += "No data found!";
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

	/**
	 * Method moves user's data to an archive when he's no longer a user of the
	 * library.
	 */
	public static void archiveUser(String userName, int userID) {

		ConnectionUtil connection = new ConnectionUtil();
		PreparedStatement ps = null;

		try {

			Connection conn = connection.connect();
			ps = conn.prepareStatement("SELECT * FROM users WHERE userID = "
					+ userID + "OR userName = " + userName);
			ResultSet rs = ps.executeQuery();

			/* INSERT data FROM users table TO users_archive */
			if (rs.next()) {
				ps = conn
						.prepareStatement("INSERT into 'users_archive' ('firstName', 'lastName', 'schoolStatus',"
								+ " professorChief', 'userRegitrationDate', 'gender','isAdmin', 'userName', "
								+ "'password', 'userArchiveDate', allBorrowedBooks' ) VALUES (?, ?, ?, ?, ?, ?, ?, , ?, ?, ?)");
				// set data to archive table from users table
				ps.setString(1, rs.getString(2)); // firstName in 'usesrs'
				ps.setString(2, rs.getString(3)); // lastName in 'users' ...
				ps.setString(3, rs.getString(4)); // schoolStatus
				ps.setString(4, rs.getString(5)); // professorChief
				ps.setDate(5, rs.getDate(7)); // userRegistrationDate
				ps.setString(6, rs.getString(8)); // gender
				ps.setBoolean(7, rs.getBoolean(9)); // isAdmin
				ps.setString(8, rs.getString(10));// userName
				ps.setString(9, rs.getString(11));// password
				ps.setString(10, Support.getCurrentDate());// date of archiving
				ps.setString(11, totalLoansOfUser(userID));// all borrowed
															// books
															// of one user
				ps.executeQuery();

				/* DELETE data (row) tranfered from 'users' table */
				Statement s = conn.createStatement();
				s.executeUpdate("DELETE  FROM users WHERE 'id'= "
						+ rs.getInt(1) + "");
				// print message
				System.out.println("User " + rs.getString(2) + " is removed.");
			}

			else {
				System.out.println("The name is not on the list.");
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
	}

	private static String totalLoansOfUser(int userID) {
		return null;
	}

	/**
	 * @return a list of ACTIVE USERS in library
	 */
	public static ArrayList<Users> listOfActiveUsers(Users user) {

		ArrayList<Users> result = new ArrayList<Users>();

		return result;
	}

	/**
	 * @return a list of ALL USERS in library
	 */
	public static ArrayList<Users> listOfAllUsers() {
		ArrayList<Users> result = new ArrayList<Users>();

		return result;

	}

}