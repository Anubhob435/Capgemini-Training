package src.WeeklyTests;

import java.util.Comparator;

public class MyIntegerComparator implements Comparator<Integer>{

	public int compare(Integer i2, Integer i1) {
	
	if(i1 > i2 ) {
	return -1;}
	
	else if (i1 < i2) {
	return 1;
	}
	return 0;
	}

}