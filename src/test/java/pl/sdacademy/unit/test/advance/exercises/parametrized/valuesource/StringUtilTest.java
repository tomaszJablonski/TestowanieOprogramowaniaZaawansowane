package pl.sdacademy.unit.test.advance.exercises.parametrized.valuesource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {""," ","   "})
    public void shouldReturnTrueIfStringIsBlank(String input){
           //when
        boolean result = StringUtil.isBlank(input);

        //then
        assertTrue(result);  //junit
        assertThat(result).isTrue(); //assertJ
    }

    @ParameterizedTest
    @ValueSource(strings = {"java"," java","java "," java "})
    public void shouldReturnFalseIfStringIsNotBlank(String input){
           //when
        boolean result = StringUtil.isBlank(input);
        //then
        assertFalse(result); // junit
        assertThat(result).isFalse(); //assertJ
    }
    //W ValueSource nie możemy podać null jako wartość
    //więc trzeba napisać zwykły test.
    @Test
    void shouldReturnTrueIfStringIsNull(){
           // given
           String input  = null;
           //when
        boolean result = StringUtil.isBlank(input);
        //Można też napisać bez sekcji given bo można to skrócić.
        // Tak jak poniżej
        //boolean result = StringUtil.isBlank(null);

        //then
        assertTrue(result); // junit
        assertThat(result); // assertJ

    }


}