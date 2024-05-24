package br.com.erudio.business;

import br.com.erudio.service.CourseService;
import br.com.erudio.service.stubs.CourseServiceStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseBusenessStubTest {

    @Test
    void testCoursesRelatedToSpring_When_UsingAStub(){
        //Given
        CourseService stubService = new CourseServiceStub();
        CourseBuseness buseness = new CourseBuseness(stubService);

        //When
        var filteredCourses = buseness.retriveCousesRelatedRoSpring("Leandro");

        //Then
        assertEquals(4, filteredCourses.size());
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAFooBarStudent(){
        //Given
        CourseService stubService = new CourseServiceStub();

        CourseBuseness buseness = new CourseBuseness(stubService);

        //When
        var filteredCourses = buseness.retriveCousesRelatedRoSpring("Foo Bar");

        //Then
        assertEquals(0, filteredCourses.size());
    }
}