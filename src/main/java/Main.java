import models.Course;
import models.CourseService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        CourseService service = new CourseService(session);

        try{
            session.beginTransaction();
            Course math = new Course("math", 2);
            service.insertCourse(math);

            Course retrievedCourse = service.readCourse(math);
            System.out.println("Get request: " + retrievedCourse.getTitle());

            retrievedCourse.setTitle("abc");
            service.updateCourse(retrievedCourse);

            service.deleteCourse(retrievedCourse);



            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
