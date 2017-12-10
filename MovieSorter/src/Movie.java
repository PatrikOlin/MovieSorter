/*
 * 
 *  Namn: Patrik Olin
 *  Datum 2017-10-10
 * 	Kurs: Java SE, Iftac
 *  Laboration 2
 * 
 */

public class Movie {

	private String title;
	private String actor;
	private String misc;

	public Movie(String title, String actor, String misc) {
		super();
		this.title = title;
		this.actor = actor;
		this.misc = misc;
	}

	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	// F�r att sortera efter efternamnet s� bygger vi om str�ngen Actor s� att den ser ut "Efternamn, F�rnamn" ist�llet f�r "f�rnamn_efternamn".
	public void transformName() {
		String string = getActor();
		String[] parts = string.split("_");
		String firstName = parts[0];
		String lastName = parts[1];
		actor =  lastName + ", " + firstName;
	}

	// toString f�r att snygga till lite.
	@Override
	public String toString() {
		return title + " " + actor + " " + misc;
	}

}
