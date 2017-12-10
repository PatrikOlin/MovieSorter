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
		fileReader.getMovies();						// H�mtar arraylist med filmer
		System.out.println("Unsorted array:");		// f�r att printa ut den i console detta anv�nds
		fileReader.printArray();					// mest f�r att testa utan att �ppna och kolla filen hela tiden
		fileReader.transformAllNames();
		fileReader.sortAlphabetically();
		System.out.println("\nSorted array:");		// Samma som ovan. Printar ut den sorterade listan f�r att 
		fileReader.printArray();					// kunna se hur det ser ut utan att beh�va �ppna filen varje g�ng.
		fileReader.writeToFile();

	}

}
