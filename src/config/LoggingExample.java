package config;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jon Mrowczynski
 */
public class LoggingExample {
	
	/**
	 * The relative path that contains the log files.
	 */
	private static final String LOGS_PARENT_PATH = "path/2/logs";
	
	/**
	 * Always want to give each {@link Logger} a unique name. Helps to minimize writing conflicts and better track
	 * what parts of the code is logging each message. The full name of a class is unique in a non-modular Java
	 * program.
	 */
	private static final Logger logger = Logger.getLogger(LoggingExample.class.getName());
	
	// static initializers are only executed once! These are often used to help set up the class rather than objects.
	static {
		new File(LOGS_PARENT_PATH).mkdirs(); // Create the directory along with any and all parent directories.
	}
	
	public static void main(String[] args) {
		logger.setLevel(Level.ALL); // Make sure that the logger at least is okay with logging every message.
		
		// These logging Levels are usually not logged (or even used for smaller programs) unless debugging.
		// Don't want to log too much, otherwise can slow down the program.
		logger.finest("Logging a " + Level.FINEST + " message. Contains info of the smallest possible detail.");
		logger.finer("Logging a " + Level.FINER + " message. Contains info of a smaller detail.");
		logger.fine("Logging a " + Level.FINE + " message. Contains info a small detail.");
		
		// Sometimes printed if interested in your program's config info such as number of threads being used.
		logger.config("Logging a " + Level.CONFIG + " message. Some configuration detail about the program.");
		
		// These types of Levels should almost always be logged since they contain vital info about the program's
		// operation.
		logger.info("Logging a " + Level.INFO + " message. Contains some important information.");
		logger.warning("Logging a " + Level.WARNING + " message. Usually should take a look at...");
		logger.severe("Logging a " + Level.SEVERE + " message. Something fatal happened.");
	}
}