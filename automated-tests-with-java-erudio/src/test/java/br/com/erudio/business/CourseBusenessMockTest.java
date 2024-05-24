package br.com.erudio.business;

import br.com.erudio.service.CourseService;
import br.com.erudio.service.stubs.CourseServiceStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseBusenessMockTest {
    CourseService mockService;
    CourseBuseness buseness ;
    List<String> courses;

    @BeforeEach
    void setup(){
        //Given
        mockService = Mockito.mock(CourseService.class);
        buseness = new CourseBuseness(mockService);
        courses = Arrays.asList(
                "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker"
        );
    }
    @Test
    void testCoursesRelatedToSpring_When_UsingAMock(){
        //Give
        Mockito.when(mockService.retriveCurses("Leandro")).thenReturn(courses);

        //When
        var filteredCourses = buseness.retriveCousesRelatedRoSpring("Leandro");

        //Then
        assertEquals(4, filteredCourses.size());
    }

}