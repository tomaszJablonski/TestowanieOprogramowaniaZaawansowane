package pl.sdacademy.unit.test.advance.exercises.parametrized.csvsource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {

    /*
    Test case-y

    true:
    kajak
    kobyla ma prawy bok
    sedes

    false:
    java
    programowanie
     */

    @ParameterizedTest
    @CsvSource({"kajak,true",
                "kobyla ma maly bok,true",
                "sedes,true",
               })
    void shouldVerifyIfStringIsPalindormeIsTrue(String input,Boolean expectedResult){
        //when

        boolean result = PalindromeChecker.isPalindrome(input);

        //then
        assertEquals(expectedResult,result); //junit
        assertThat(result).isEqualTo(expectedResult); //assertj

    }

    @ParameterizedTest
    @CsvSource({
            "java,false",
            "programowanie,false"})
    void shouldVerifyIfStringIsPalindormeIsFalse(String input,Boolean expectedResult){
        //when

        boolean result = PalindromeChecker.isPalindrome(input);

        //then
        assertEquals(expectedResult,result); //junit
        assertThat(result).isEqualTo(expectedResult); //assertj

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/palindrome.csv",
                    delimiter = '|')
    void shouldVerifyIfStringIsPalindorme_CsvFileSource(String input,Boolean expectedResult){
        //when
        boolean result = PalindromeChecker.isPalindrome(input);

        //then
        assertEquals(expectedResult,result); //junit
        assertThat(result).isEqualTo(expectedResult); //assertj

    }



}