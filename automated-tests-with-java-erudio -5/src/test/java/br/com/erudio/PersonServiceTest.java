package br.com.erudio;

import br.com.erudio.model.Person;
import br.com.erudio.service.IPersonService;
import br.com.erudio.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonServiceTest {

    Person person;
    IPersonService service;

    @BeforeEach
    void setup(){
        service = new PersonService();
        person = new Person("Keith", "Moon", "kmoon@erudio.com.br", "Wembley - UK", "Male");
    }

    @DisplayName("When Create a Person with Success Shold Contains Id in Returned a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_SholdContainsIdnReturnedPersonObject() {
        //Given

        //When
        try {
            Person  actual =service.createPerson(person);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        //Then
        assertNotNull(person.getId(),  () -> "The Id" +
                " id Missing!");
    }

    @DisplayName("When Create a Person with Success Shold Return a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_SholdReturnPersonObject() {
        //Given

        //When
        Person  actual = null;
        try {
            actual = service.createPerson(person);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        //Then
        assertNotNull(actual, () -> "The createPerson() should not have return null!");
    }

    @DisplayName("When Create a Person with Success Shold Contains FirstName in Returned a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_SholdContainsFirstNameInReturnedPersonObject() {
        //Given

        //When
        Person  actual = null;
        try {
            actual = service.createPerson(person);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        //Then
        assertEquals(person.getFirstName(),actual.getFirstName(),  () -> "The FirstName id Diferent!");
    }

    @DisplayName("When Create a Person with Success Shold Contains LastName in Returned a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_SholdContainsLasttNameInReturnedPersonObject() {
        //Given

        //When
        Person  actual = null;
        try {
            actual = service.createPerson(person);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        //Then
        assertEquals(person.getLastName(),actual.getLastName(),  () -> "The LastName id Diferent!");
    }

    @DisplayName("When Create a Person with Success Shold Contains Address in Returned a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_SholdContainsAddressInReturnedPersonObject() {
        //Given

        //When
        Person  actual = null;
        try {
            actual = service.createPerson(person);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        //Then
        assertEquals(person.getAddress(),actual.getAddress(),  () -> "The Address id Diferent!");
    }

    @DisplayName("When Create a Person with Success Shold Contains Email in Returned a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_SholdContainsEmailInReturnedPersonObject() {
        //Given

        //When
        Person  actual = null;
        try {
            actual = service.createPerson(person);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        //Then
        assertEquals(person.getEmail(),actual.getEmail(),  () -> "The Email id Diferent!");
    }

    @DisplayName("When Create a Person with Success Shold Contains Email in Returned a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_SholdContainsGenderInReturnedPersonObject() {
        //Given

        //When
        Person  actual = null;
        try {
            actual = service.createPerson(person);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        //Then
        assertEquals(person.getGender(),actual.getGender(),  () -> "The Gender" +
                " id Diferent!");
    }

    @DisplayName("When Create a Person with e-mail Shold throw Exception")
    @Test
    void testCreatePerson_WhithNullEmail_SholdThrowIllegalArgumentException() {
        //Given
        person.setEmail(null);

        //When

        //Then
        assertThrows(IllegalArgumentException.class, () -> service.createPerson(person), () -> "Empty e-mail should have cause an IllegalArgumentException" );
    }

    @DisplayName("When Create a Person with e-mail Shold message")
    @Test
    void testCreatePerson_WhithNullEmail_SholdThrowIllegalArgumentExceptionMessage() {
        //Given
        person.setEmail(null);
        var expectMessage = "The Person e-mail is null or empty!";

        //When & Then
        IllegalArgumentException exception =  assertThrows(IllegalArgumentException.class,
                () -> service.createPerson(person),
                () -> "Exception error message is incorrect!" );

        assertEquals(expectMessage, exception.getMessage());
    }
}
