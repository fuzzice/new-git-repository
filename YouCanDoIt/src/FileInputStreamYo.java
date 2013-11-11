import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileInputStreamYo {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String path = "/Users/Awesome/Desktop/screenshot";
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);

		;
	}
}
