package project2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 * The LoginStats class is responsible for reading the data file,
 * obtaining user input, performing some data validation and handling all errors.
 */
public class LoginStats {
	
	/**
     * The main method of the LoginStats class.
     * It reads the data file, creates Record objects and adds them to a RecordList.
     * It handles IOExceptions that may occur during file reading.
     *
     * @param args the command line arguments. args[0] is expected to be the name of the data file.
     */
	public static void main(String[] args) {
        RecordList records = new RecordList();
        String fileName = args[0];
//        String fileName = "src/record.txt";

        BufferedReader reader;
        RecordList recordList = new RecordList();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                String[] words = line.split(" ");
                int terminal = Integer.parseInt(words[0]);
                long time = Long.parseLong(words[1]);
                String username = words[2];
                boolean isLogin = terminal > 0 ? true : false;
                Date date = new Date(time);
                Record record = new Record(terminal, isLogin, username, date);
                recordList.add(record);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Welcome to Login Stats!");
        System.out.println("Available commands:");
        System.out.println("  first USERNAME   -   retrieves first login session for the USER");
        System.out.println("  last USERNAME    -   retrieces last login session for the USER");
        System.out.println("  quit             -   terminates this program");
        
        while (true) {
        	Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            String[] inputs = line.split(" ");
            String command = inputs[0];
            if("quit".equals(command)) {
            	break;
            }
            String username = inputs[1];
            if ("first".equals(command)) {
                Session session = recordList.getFirstSession(username);
                checkSession(session,username);
                System.out.println(session);
            }
            else if ("last".equals(command)) {
                Session session = recordList.getLastSession(username);
                checkSession(session,username);
                System.out.println(session);
            } else {
                System.out.println("This is not a valid command. Try again.");
            }
        }
    }

	/**
	 * Checks if the session is null and prints a message if it is.
	 *
	 * @param session the session to check
	 * @param username the username for the session
	 */
	private static void checkSession(Session session,String username) {
		
	    if (session == null) {
	        System.out.println("No user matching "+username+" found.");
	        return;
	    }
	}
}
