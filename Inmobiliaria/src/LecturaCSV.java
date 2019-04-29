import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LecturaCSV {

	
	public static void main(String[] args) throws IOException {

		String filename = "docs/Inmuebles2.csv";
		int pos = 0;
		File file = new File(filename);
		String[] array = new String[20];
		datosInmobiliaria[] datos = new datosInmobiliaria[50000];
		try {
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext()) {
				String data = inputStream.next();
				String[] values = data.split(",");
				datosInmobiliaria objto = new datosInmobiliaria(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8]);
				datos[pos] = objto;
				pos++;
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 20; i++) {
			System.out.println(datos[i].getRef());
		}
	}

}
