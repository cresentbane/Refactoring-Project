package src.com.std.model;

import java.io.IOException;

/**
 * An interface used by the classes that import or export 
 * calendar files.
 * @author aliqa
 */
public interface Persist {
	void save() throws IOException, ClassNotFoundException;
}
