import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CourseService {
    public void addCourse(String name, String code, int credit, String department) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Course.class).addAnnotatedClass(Student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Course course = new Course(name, code, credit, department);

        session.save(course);
        tx.commit();
        session.close();
        sf.close();
    }
}
