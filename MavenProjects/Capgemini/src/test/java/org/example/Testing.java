package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class Testing {
    
//    @ParameterizedTest
//    @CsvSource({
//            "10, 20, 30",
//            "5, 7, 12",
//            "-6.0 , 9.0, 3.0"
//    })
//    void addTest(double a, double b, double expected){
//        Calc calc = new Calc();
//        double result = calc.add(a, b);
//        assertEquals(expected, result, a + " + " + b + " should equal " + expected);
//    }

//    @Test
//    void addInvalidStringTest(){
//        Calc calc = new Calc();
//        assertThrows(IllegalArgumentException.class, ()-> calc.add("11", "25"));
//    }
//
//    @Test
//    void addInvalidNonNumericStringTest(){
//        Calc calc = new Calc();
//        assertThrows(IllegalArgumentException.class, ()-> calc.add("abc", "123"));
//    }
    @ParameterizedTest
    @CsvSource({
            "11, 25",
            "abc, 10",
            "5, xyz",
            "hello, world"
    })
    void addInvalidString(String a, String b) {

        Calc calc = new Calc();

        assertThrows(IllegalArgumentException.class,
                () -> calc.add(a, b));
    }
}
