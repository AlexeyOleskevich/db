package models;

import org.hibernate.Session;

public class CourseService {

    private Session session;

    public CourseService(Session session) {
        this.session = session;
    }
    public void insertCourse (Course course) {
        session.save(course);
    }

    public Course readCourse(Course course) {
        return session.get(Course.class, course.getId());
    }

    public void updateCourse(Course course) {
        session.saveOrUpdate(course);
    }

    public void deleteCourse(Course course) {
        session.delete(course);
    }
}
