import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	static private int n;	//Anzahl der Parkpl�tze
	static private int m;	//Anzahl der Autos die heute kommen
	static private ArrayList<Integer> cars = new ArrayList<Integer>();

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(System.in);
		System.out.print("Bitte Path zum input eingeben: ");
		String path = s.nextLine();

		readIn(path);
		System.out.println(countWaiting(cars));
	}

	private static void readIn(String path) throws FileNotFoundException {
		File input = new File(path);
		Scanner r = new Scanner(input);

		String line1 = r.nextLine();
		String line2 = r.nextLine();

		String[] nm = line1.split(" ");
		String[] eintraege = line2.split(" ");

		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);

		for (String eintrag : eintraege) {
			cars.add(Integer.parseInt(eintrag));
		}


		System.out.println(line1 + "\n" + line2 + "\n");
		System.out.println(n +" "+ m +" " + " " + cars.get(2));

		r.close();
	}

	private static String count(ArrayList<Integer> cars){
		int carsInGarage=0;
		int maxCars=0;
		for(Integer i:cars){
			if(i>0){
				carsInGarage++;
				if(carsInGarage>maxCars){
					maxCars=carsInGarage;
				}
			}else if(i<0){
				carsInGarage--;
			}
		}
		String s=maxCars+"";
		return s;
	}

	private static String countWaiting(ArrayList<Integer> cars){
		int carsInGarage=0;
		int carsWaiting=0;
		int maxCars=0;
		int maxWaiting=0;
		for(Integer i:cars){
			if(i>0){
				if(carsInGarage<n){
					carsInGarage++;
					if(carsInGarage>maxCars){
						maxCars=carsInGarage;
					}
				}else{
					carsWaiting++;
					if(carsWaiting>maxWaiting){
						maxWaiting=carsWaiting;
					}
				}
			}else if(i<0){
				carsInGarage--;
				if(carsWaiting>0){
					carsWaiting--;
					carsInGarage++;
				}
			}
		}
		String s=maxCars+" "+maxWaiting;
		return s;
	}
}
