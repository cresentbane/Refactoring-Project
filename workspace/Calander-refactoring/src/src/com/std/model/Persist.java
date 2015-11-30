package src.com.std.model;

import java.io.IOException;

public interface Persist {
	void save() throws IOException, ClassNotFoundException;
}
