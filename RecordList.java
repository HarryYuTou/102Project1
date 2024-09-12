package project2;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * The RecordList class extends ArrayList<Record> and provides methods to get the first and last sessions of a user.
 */
public class RecordList extends ArrayList<Record> {
	
	Session session = null;
	
	/**
     * Returns the first login session for the specified user.
     *
     * @param user the name of the user.
     * @return the first login session for the user.
     * @throws IllegalArgumentException if the user is null or empty.
     * @throws NoSuchElementException if no first session is found for the user.
     */
    public Session getFirstSession(String user) {
        Record login = null;
        Record logout = null;
        
        if(user == null || user.trim().equals("")) {
        	throw new IllegalArgumentException("Invalid user!");
        }

        for (Record record : this) {
            if (record.getUsername().equals(user)) {
                if (record.isLogin()) {
                    login = record;
                } 
                if (login != null) {
                    logout = record;
                    break;
                }
            }
        }

        if (login == null) {
        	throw new NoSuchElementException("No first session found for user " + user);
        }
        
        session = new Session(login, logout);

        return session;
    }

    /**
     * Returns the last login session for the specified user.
     *
     * @param user the name of the user.
     * @return the last login session for the user.
     * @throws IllegalArgumentException if the user is null or empty.
     * @throws NoSuchElementException if no last session is found for the user.
     */
    public Session getLastSession(String user) {

        if(user == null || user.trim().equals("")) {
        	throw new IllegalArgumentException("Invalid user!");
        }
        
        Record login = null;
        Record logout = null;

        for (int i = this.size() - 1; i >= 0; i--) {
            Record record = this.get(i);
            if (record.getUsername().equals(user)) {
                if (record.isLogout()) {
                    logout = record;
                } 
                if (logout != null) {
                	login = record;
                    break;
                }
            }
        }

        if (logout == null) {
        	throw new NoSuchElementException("No last session found for user " + user);
        }
        
        session = new Session(login, logout);
        return session;
    }

}
