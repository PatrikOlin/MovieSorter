/*
 * 
 *  Namn: Patrik Olin
 *  Datum 2017-10-10
 * 	Kurs: Java SE, Iftac
 *  Laboration 2
 * 
 */

import java.util.Comparator;

public class MovieComparator implements Comparator<Object> {

	// J�mf�r f�rst huvudrollsinnehavare via getActor. Om huvudrollsinnehavaren �r samma s� 
	// s�tts flag till 0. Om flag �r 0, j�mf�r d� titeln och sortera efter den.
	@Override
	public int compare(Object arg0, Object arg1) {
		Movie movie0 = (Movie) arg0;
		Movie movie1 = (Movie) arg1;

		int flag = movie0.getActor().compareTo(movie1.getActor());
		if (flag == 0) {
			return movie0.getTitle().compareTo(movie1.getTitle());
		} else {
			return flag;
		}
	}
}
