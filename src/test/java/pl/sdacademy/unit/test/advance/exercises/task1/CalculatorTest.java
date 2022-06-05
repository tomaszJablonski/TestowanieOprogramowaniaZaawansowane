package pl.sdacademy.unit.test.advance.exercises.task1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("dataProvider")
    void shouldPlusANumber(int input1,int input2,int expectedResult) {
        //when
        int result = Calculator.plus(input1,input2);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> dataProvider(){
        return Stream.of(
                Arguments.of(4,5,9),
                Arguments.of(5,5,10),
                Arguments.of(1,5,6),
                Arguments.of(3,5,8)
        );
    }

    @ParameterizedTest
    @MethodSource("dataProviderForDivide")
    void shouldDivideANumber(int input1,int input2, int expectedResult ){
        //when
        int result = Calculator.dividing(input1,input2);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> dataProviderForDivide(){
        return Stream.of(
                Arguments.of(5,1,5),
                Arguments.of(10,5,2),
                Arguments.of(15,5,3),
                Arguments.of(6,2,3)
        );
    }
    @ParameterizedTest
    @MethodSource("dataProviderForFailDivide")
    void shouldThrowExceptionWhenDivideASecondNumberWithZero(int input1,int input2){
        //when & then
        assertThatThrownBy(()->Calculator.dividing(input1,input2))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("You can not divide with zero");

    }

    private static Stream<Arguments> dataProviderForFailDivide(){
        return Stream.of(
                Arguments.of(5,0),
                Arguments.of(2,0),
                Arguments.of(15,0),
                Arguments.of(30,0)
        );
    }


}