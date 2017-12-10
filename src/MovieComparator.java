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

	// Jämför först huvudrollsinnehavare via getActor. Om huvudrollsinnehavaren är samma så 
	// sätts flag till 0. Om flag är 0, jämför då titeln och sortera efter den.
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
