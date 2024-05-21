package br.com.erudio.math;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Test Math Operation in SimpleMath Class")
class SimpleMathTest3 {

    SimpleMath math;

    @BeforeAll
    static void setup(){
        System.out.println("Before All");
    }

    @AfterAll
    static void cleanup(){
        System.out.println("After All");
    }

    @BeforeEach
    void beforeEachMethod(){
        System.out.println("Before Each");
        math = new SimpleMath();
    }

    @AfterEach
    void afterEachMethod(){
        System.out.println("After Each");

    }

    //test[System Under Test]_[Condition or State Change]_[Expected Result]
    @Test
    @DisplayName("Test 6.2 + 2 = 8.2")
    void testSum_When_SixDotTwoIsAddedByTwo_ShouldReturnEightDotTwo() {
        System.out.println("Test 6.2 + 2 = 8.2");
        //BDD
        //Given (Arrange)
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        double expected = 8.2D;

        //When (Act)
        Double actual = math.sum(firstNumber, secondNumber);

        //Then (Assert)
        assertEquals(expected, actual, () -> "The "+firstNumber+" + "+secondNumber+" did not produce "+expected+"!");
    }

    @Test
    @DisplayName("Test 6.2 - 2 = 4.2")
    void testSubtraction_When_SixDotTwoIsSubtractionByTwo_ShouldReturnFourDotTwo() {
    System.out.println("Test 6.2 - 2 = 4.2");
        SimpleMath math = new SimpleMath();
        double firstNumber = 6.2D;
        double secondNumber = 2D;

        Double actual = math.subtraction(firstNumber, secondNumber);
        double expected = 4.2D;
        assertEquals(expected, actual, () -> "The "+firstNumber+" - "+secondNumber+" did not produce "+expected+"!");
    }

    @Test
    @DisplayName("Test 6.2 * 2 = 12.4")
    void testMultiplication_When_SixDotTwoIsMultiplicationByTwo_ShouldReturnTwelveDotFour() {
        System.out.println("Test 6.2 * 2 = 12.4");

        double firstNumber = 6.2D;
        double secondNumber = 2D;

        Double actual = math.multiplication(firstNumber, secondNumber);
        double expected = 12.4D;
        assertEquals(expected, actual, () -> "The "+firstNumber+" * "+secondNumber+" did not produce "+expected+"!");
    }

    @Test
    @DisplayName("Test 6.2 / 2 = 3.1")
    void testDivision_When_SixDotTwoIsDivisionByTwo_ShouldReturnThreeDotOne() {
        System.out.println("Test 6.2 / 2 = 3.1");

        double firstNumber = 6.2D;
        double secondNumber = 2D;

        Double actual = math.division(firstNumber, secondNumber);
        double expected = 3.1D;
        assertEquals(expected, actual, () -> "The "+firstNumber+" / "+secondNumber+" did not produce "+expected+"!");
    }

    //@Disabled("TODO: We need still work on it!")
    @Test
    @DisplayName("Test Division by Zero")
    void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException() {
        //given
        double firstNumber = 6.2D;
        double secondNumber = 0D;
        var expectedException = "Impossible to divide by zero";
        //when & then
        ArithmeticException actual = assertThrows(ArithmeticException.class, () -> math.division(firstNumber, secondNumber),
                () -> "Division by zero shold throw an ArithmeticException!");

        assertEquals(expectedException, actual.getMessage(), () -> "Unexpected Arithmetic Exception: "+actual.getMessage());
    }

    @Test
    @DisplayName("Test (6.2 + 2)/2 = 4.1")
    void testMean_When_SixDotTwoIsSumByTwoAndDividedByTwo_ShouldReturnFourDotOne() {
        System.out.println("Test 6.2 + 2 = 4.1");

        double firstNumber = 6.2D;
        double secondNumber = 2D;

        Double actual = math.mean(firstNumber, secondNumber);
        double expected = 4.1D;
        assertEquals(expected, actual, () -> "The ("+firstNumber+" + "+secondNumber+")/2 did not produce "+expected+"!");
    }

    @Test
    @DisplayName("Test Square Root of 25 = 5")
    void testSquareRoot_When_SquareRoot_Of_TwentyfiveTwo_ShouldReturnFive() {
        System.out.println("Test Square Root of 25 = 5");

        double number = 25D;

        Double actual = math.squareRoot(number);
        double expected = 5D;
        assertEquals(expected, actual, () -> "The Square number of "+number+" did not produce "+expected+"!");
    }

    @Disabled("Display Name")
    @Test
    void testABCD_When_XYZ_Shold(){
        System.out.println("Test BDD");
        //Give / Arrange
        //When / Act
        //Then / Assert
    }


}