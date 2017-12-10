/*
 * 
 *  Namn: Patrik Olin
 *  Datum 2017-10-10
 * 	Kurs: Java SE, Iftac
 *  Laboration 2
 * 
 */

public class MovieSorterApp {

	public static void main(String[] args) {
		
		FileReader fileReader = new FileReader();
		fileReader.readFile();
		fileReader.getMovies();						// Hämtar arraylist med filmer
		System.out.println("Unsorted array:");		// för att printa ut den i console detta används
		fileReader.printArray();					// mest för att testa utan att öppna och kolla filen hela tiden
		fileReader.transformAllNames();
		fileReader.sortAlphabetically();
		System.out.println("\nSorted array:");		// Samma som ovan. Printar ut den sorterade listan för att 
		fileReader.printArray();					// kunna se hur det ser ut utan att behöva öppna filen varje gång.
		fileReader.writeToFile();

	}

}
