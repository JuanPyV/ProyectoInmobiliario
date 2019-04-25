import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LecturaCSV<E> {
	
	
	
	
	public String referencia(String ref) { //ref es un número dado por el cliente
		String filename = "docs/Inmuebles.csv";
		File file = new File (filename);
		try {
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()) {
				String data = inputStream.next();
				String[] values = data.split(",");
				for (int i = 0; i)
				System.out.println(values[8] + "**");
			}
			inputStream.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "docs/Inmuebles.csv";
		File file = new File (filename);
		try {
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()) {
				String data = inputStream.next();
				String[] values = data.split(",");
				System.out.println(values[8] + "**");
			}
			inputStream.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
