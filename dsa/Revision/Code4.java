package dsa.Revision;

import java.util.*;
import java.text.*;

public class Code4 {
	
    public static void main(String[] args) {
    	System.out.println("Currency");
        Scanner sc = new Scanner(System.in);
        double payment = sc.nextDouble();
        sc.close();

        // US
        NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US);

        // India (customized to show Rs.)
        Locale indiaLocale = new Locale("en", "IN");
        DecimalFormat indiaFormat = (DecimalFormat) NumberFormat.getCurrencyInstance(indiaLocale);
        DecimalFormatSymbols symbols = indiaFormat.getDecimalFormatSymbols();
        symbols.setCurrencySymbol("Rs.");
        indiaFormat.setDecimalFormatSymbols(symbols);

        // China
        NumberFormat chinaFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);

        // France
        NumberFormat franceFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        System.out.println("US: " + usFormat.format(payment));
        System.out.println("India: " + indiaFormat.format(payment));
        System.out.println("China: " + chinaFormat.format(payment));
        System.out.println("France: " + franceFormat.format(payment));
    }
}