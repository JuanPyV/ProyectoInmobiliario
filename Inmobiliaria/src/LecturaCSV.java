import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LecturaCSV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s;
		try {
			s = new Scanner (new File("docs/Inmuebles.csv"));
			
			ArrayList<String> listS	 = new ArrayList<String>();
			
			while (s.hasNextLine()) {
				listS.add(s.nextLine());
			}
			
			System.out.println(listS);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
