package hello;

import java.io.File;
import java.io.IOException;

public class qqq {

	public static void main(String[] args) throws Exception {

		File file = new File("D:/a");
		boolean b=file.exists();
		System.out.println(b);
		boolean b1=file.createNewFile();
		System.out.println(b1);
		boolean b2=file.delete();
		System.out.println(b2);


	}
}
