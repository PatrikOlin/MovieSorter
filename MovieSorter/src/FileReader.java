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

	// L�ser filen och s�tter tempActor som det f�rsta scannern l�ser, tempTitle som det andra och tempMisc som resten av raden. Genom att
	// l�ta tempMisc ta resten av raden f�r vi med all data fr�n originalfilen, men d� den bara sorterar efter Title och Actor spelar det ingen
	// vad f�ltet misc inneh�ller och att det ser olika ut f�r alla objekten.
	// S� l�nge som scannern sedan har en ny rad s� skapar vi ett nytt objekt av klassen Movie, d�r vi anger tempActor, tempTitle och tempMisc
	// f�r att fylla objektets f�lt.
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

	// Anv�nder metoden "transformName" f�r att �ndra alla namn i Arraylisten till "Efternamn, F�rnamn".
	public void transformAllNames() {
		for(Movie movie : movies) {
			movie.transformName();
		}
	}
	
	public List<Movie> getMovies() {
		return movies;
	}
	
	// Skriver ut arrayen i console. Detta anv�nds mest f�r att kunna kolla outputen direkt utan att beh�va �ppna filen.
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
