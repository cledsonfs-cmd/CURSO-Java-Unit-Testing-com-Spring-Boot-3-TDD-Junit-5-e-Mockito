package br.com.erudio;

import org.junit.jupiter.api.*;

//@Order(3)
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderedByOrderTest {

    StringBuilder actualValue = new StringBuilder("");

    @AfterEach
    void afterEach() {
        System.out.println("The actual value is:" + actualValue);
    }

    @Test
    @Order(0)
    void testA(){
        System.out.println("Running Teste A");
        actualValue.append("1");
    }

    @Test
    @Order(3)
    void testB(){
        System.out.println("Running Teste B");
        actualValue.append("2");
    }

    @Test
    @Order(2)
    void testC(){
        System.out.println("Running Teste C");
        actualValue.append("3");
    }

    @Test
    @Order(1)
    void testD(){
        System.out.println("Running Teste D");
        actualValue.append("4");
    }
}
