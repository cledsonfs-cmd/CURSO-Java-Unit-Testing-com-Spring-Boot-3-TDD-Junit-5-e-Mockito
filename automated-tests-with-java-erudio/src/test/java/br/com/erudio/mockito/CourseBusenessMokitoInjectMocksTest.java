package br.com.erudio.mockito;

import br.com.erudio.business.CourseBuseness;
import br.com.erudio.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CourseBusenessMokitoInjectMocksTest {
    @Mock
    CourseService mockService;

    @InjectMocks
    CourseBuseness business;

    @Captor
    ArgumentCaptor<String> argumentCaptor;

    List<String> courses;

    @BeforeEach
    void setup() {
        //Given

        //business = new CourseBuseness(mockService);

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
    void testCoursesRelatedToSpring_When_UsingAMock() {
        //Give
        given(mockService.retrieveCourses("Leandro")).willReturn(courses);

        //When
        var filteredCourses = business.retriveCousesRelatedRoSpring("Leandro");

        //Then
        assertThat(filteredCourses.size(), is(4));
    }

    @DisplayName("Delete Courses not Related to Spring Capturing Arguments sould call Method deleteCourse V2")
    @Test
    void testDeleteCoursesNotRelatedToSpring_CapturingArguments_Should_CallMethod_deleteCourse() {
        //Give
        given(mockService.retrieveCourses("Leandro")).willReturn(courses);

        //When
        business.deleteCoursesNotRelatedToSpring("Leandro");

        //Than
        verify(mockService).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
        verify(mockService, never()).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello xx");
        verify(mockService, times(1)).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
        verify(mockService, atLeast(1)).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
        verify(mockService, atLeastOnce()).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
    }

    @DisplayName("Delete Courses not Related to Spring Capturing Arguments sould call Method deleteCourse V2")
    @Test
    void testDeleteCoursesNotRelatedToSpring_CapturingArguments_Should_CallMethod_deleteCourseV2() {
        //Give
        given(mockService.retrieveCourses("Leandro")).willReturn(courses);

        //When
        business.deleteCoursesNotRelatedToSpring("Leandro");

        //Than
        then(mockService).should().deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
        then(mockService).should(never()).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello xx");

    }

    @DisplayName("Delete Courses not Related to Spring Capturing Arguments sould call Method deleteCourse V2")
    @Test
    void testDeleteCoursesNotRelatedToSpring_CapturingArguments_Should_CallMethod_deleteCourseV3() {
        // Given / Arrange

        /*
        courses = Arrays.asList(
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker"
            );
            */

        given(mockService.retrieveCourses("Leandro"))
                .willReturn(courses);

        //ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        //String agileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";

        // When / Act
        business.deleteCoursesNotRelatedToSpring("Leandro");

        // then(mockService).should().deleteCourse(argumentCaptor.capture());
        // assertThat(argumentCaptor.getValue(), is("Agile Desmistificado com Scrum, XP, Kanban e Trello"));

        then(mockService).should(times(7)).deleteCourse(argumentCaptor.capture());
        assertThat(argumentCaptor.getAllValues().size(), is(7));

    }
}