package pl.sdacademy.unit.test.advance.exercises.parametrized.methodsource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    /*

    input/expectedResult
    0  / 0
    1  / 1
    4  / 3
    8  / 21
     */
    //tu możemy podawać dowolne parametry
    @ParameterizedTest
    //@MethodSource("dataProvider")
    @MethodSource("pl.sdacademy.unit.test.advance.exercises.parametrized.methodsource.provider.FibonacciTestDataProvider#dataProvider")
    //full package +.nazwa klasy + # + nazwa metody
    void shouldReturnCorrectValue(int input, int expectedResult){
        //bez given bo metoda jest statyczna
        //when
        int result = Fibonacci.getValueFromIndex(input);
        //then
        assertEquals(expectedResult,result); //junit
        assertThat(result).isEqualTo(expectedResult); //assertJ

    }

//    private static Stream<Arguments> dataProvider(){
//        return Stream.of(
//          Arguments.of(0,0),
//          Arguments.of(1,1),
//          Arguments.of(4,3),
//          Arguments.of(6,8),
//          Arguments.of(8,21)
//        );
//    }

}