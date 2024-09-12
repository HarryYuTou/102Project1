package project2;

import java.util.Date;

/**
 * The Record class represents the individual records from the input log file.
 */
public class Record {
	private int terminal;
	private boolean login;
	private String username;
	private Date time;

	 /**
     * Constructs a new Record object.
     *
     * @param terminal a positive integer representing the terminal number.
     * @param login a boolean value indicating if the Record object represents a login record (true) or logout record (false).
     * @param username the name of the user.
     * @param time a Date object representing the date and time at which the user logged in or logged out.
     * @throws IllegalArgumentException if the terminal number is not positive.
     */
	public Record(int terminal, boolean login, String username, Date time) {
		if (terminal <= 0) {
			throw new IllegalArgumentException("Terminal number must be positive.");
		}
		this.terminal = terminal;
		this.login = login;
		this.username = username;
		this.time = time;
	}

	public int getTerminal() {
		return terminal;
	}

	public boolean isLogin() {
		return login;
	}

	public boolean isLogout() {
		return !login;
	}

	public String getUsername() {
		return username;
	}

	public Date getTime() {
		return time;
	}
}
