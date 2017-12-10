/*
 * 
 *  Namn: Patrik Olin
 *  Datum 2017-10-10
 * 	Kurs: Java SE, Iftac
 *  Laboration 2
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileReader {
	
	private List<Movie> movies = new ArrayList<>();

	// Läser filen och sätter tempActor som det första scannern läser, tempTitle som det andra och tempMisc som resten av raden. Genom att
	// låta tempMisc ta resten av raden får vi med all data från originalfilen, men då den bara sorterar efter Title och Actor spelar det ingen
	// vad fältet misc innehåller och att det ser olika ut för alla objekten.
	// Så länge som scannern sedan har en ny rad så skapar vi ett nytt objekt av klassen Movie, där vi anger tempActor, tempTitle och tempMisc
	// för att fylla objektets fält.
	public void readFile() {
		try {
				Scanner reader = new Scanner(new File("movies.txt"));
				String tempActor = null;
				String tempTitle = null;
				String tempMisc = null;
				while(reader.hasNextLine()) {
					tempActor = reader.next();
					tempTitle = reader.next();
					tempMisc = reader.nextLine();
					Movie movie = new Movie(tempActor, tempTitle, tempMisc);
					movies.add(movie);
				}
				reader.close();
		} catch (FileNotFoundException e) {
			e.getStackTrace();
		}
	}

	// Använder metoden "transformName" för att ändra alla namn i Arraylisten till "Efternamn, Förnamn".
	public void transformAllNames() {
		for(Movie movie : movies) {
			movie.transformName();
		}
	}
	
	public List<Movie> getMovies() {
		return movies;
	}
	
	// Skriver ut arrayen i console. Detta används mest för att kunna kolla outputen direkt utan att behöva öppna filen.
	public void printArray() {
		for(Movie movie : movies) {
			System.out.println(movie);
			
		}
	}
	
	// Sorterar listan i alfabetisk ordning utefter reglerna uppsatta i MovieComparator
	public void sortAlphabetically() {
		MovieComparator comparator = new MovieComparator();
		Collections.sort(movies, comparator);
	}
	
	// Skriver ut arrayen till filen "sorted_movies.txt"
	public void writeToFile() {
		PrintWriter outputFile = null;
		try {
			outputFile = new PrintWriter(new File("sorted_movies.txt"));
			for(Movie movie : movies) {
				outputFile.println(movie);;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (outputFile != null) {
				outputFile.close();
			}
		}
		
	}

}
