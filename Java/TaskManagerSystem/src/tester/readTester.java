package tester;
import static com.utils.IoUtils.readData;

import java.io.IOException;
import java.util.HashMap;

import com.core.Task;
public class readTester {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HashMap<Integer, Task> abc = readData();
		
		abc.values().stream().forEach(System.out::println);
	}

}
