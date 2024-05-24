package br.com.erudio.math;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DemoRepeatedTest {
    SimpleMath math;

    @BeforeEach
    void beforeEachMethod(){
        System.out.println("Before Each");
        math = new SimpleMath();
    }

    //@Disabled("TODO: We need still work on it!")
    //@RepeatedTest(3)
    @RepeatedTest(value = 3,name = "{displayName}. Repetition {currentRepetition} of {totlaRepetition}")
    @DisplayName("Test Division by Zero")
    void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException(
            RepetitionInfo repetitionInfo,
            TestInfo testInfo
    ) {
        System.out.println("RepetitionInfo: " + repetitionInfo);
        System.out.println("TestInfo: " + testInfo);
        //given
        double firstNumber = 6.2D;
        double secondNumber = 0D;
        var expectedException = "Impossible to divide by zero";
        //when & then
        ArithmeticException actual = assertThrows(ArithmeticException.class, () -> math.division(firstNumber, secondNumber),
                () -> "Division by zero shold throw an ArithmeticException!");

        assertEquals(expectedException, actual.getMessage(), () -> "Unexpected Arithmetic Exception: "+actual.getMessage());
    }
}
