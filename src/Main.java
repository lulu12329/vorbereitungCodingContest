import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static private int n;	//Anzahl der Parkplätze
	static private int m;	//Anzahl der Autos die heute kommen
	static private ArrayList<Integer> cars = new ArrayList<Integer>();
	
	private static void readIn(String path) throws FileNotFoundException {
		File input = new File(path);
		Scanner r = new Scanner(input);
		
		String line1 = r.nextLine();
		String line2 = r.nextLine();
		
		String[] nm = line1.split(" ");
		String[] einträge = line2.split(" ");
		
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		
		for (String eintrag : einträge) {
			cars.add(Integer.parseInt(eintrag));
		}
				
				
		System.out.println(line1 + "\n" + line2 + "\n");
		System.out.println(n +" "+ m +" " + " " + cars.get(2));
		
		r.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(System.in);
		System.out.print("Bite Path zum input eingeben: ");
		String path = s.nextLine();
		
		readIn(path);
	}

}
