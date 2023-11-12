import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtilities {

    private static final SessionFactory sessionFactory;

    static {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Course.class).
                addAnnotatedClass(Student.class);
        sessionFactory = con.buildSessionFactory();
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }

    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public static void beginTransaction(Session session) {
        session.beginTransaction();
    }

    public static void commitTransaction(Session session) {
        session.getTransaction().commit();
    }
}
