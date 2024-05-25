package br.com.erudio.business;

import br.com.erudio.service.CourseService;

import java.util.ArrayList;
import java.util.List;

//CourseBuseness = SUT - System (Method) Under Test
public class CourseBuseness {

    private CourseService service;

    public CourseBuseness(CourseService service) {
        this.service = service;
    }

    public List<String> retriveCousesRelatedRoSpring(String student){
        
        var filteredCurses = new ArrayList<String>();
        if("Foo Bar".equals(student)) return filteredCurses;

        var allCourses = service.retrieveCourses(student);

        for (String course: allCourses) {
            if(course.contains("Spring")){
                filteredCurses.add(course);
            }
        }

        return filteredCurses;
    }

    public void deleteCoursesNotRelatedToSpring(String student){

        var allCourses = service.retrieveCourses(student);

        for (String course: allCourses) {
            if(!course.contains("Spring")){
                service.deleteCourse(course);
            }
        }
    }


}
