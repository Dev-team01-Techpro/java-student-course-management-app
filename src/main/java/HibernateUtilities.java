import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtilities {

    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration con = new Configuration().configure("hibernate.cfg.xml").
                    addAnnotatedClass(Course.class).
                    addAnnotatedClass(Student.class);
            sessionFactory = con.buildSessionFactory();
        } catch (Exception e) {
            System.err.println("Session factory yuklenemedi!");
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    public static void closeSessionFactory() {
        getSessionFactory().close();
    }

    public static void beginTransaction(Session session) {
        session.beginTransaction();
    }

    public static void commitTransaction(Session session) {
        session.getTransaction().commit();
    }
}
