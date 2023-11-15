import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CourseService {

    private Session session;

    public void addCourse(String name, String code, int credit, String department) {
        session = HibernateUtilities.getSessionFactory().openSession();
        HibernateUtilities.beginTransaction(session);

        Course course = new Course(name, code, credit, department);
        session.save(course);

        HibernateUtilities.commitTransaction(session);
        HibernateUtilities.closeSession(session);
    }

    public String getCourseByCode(String code) {
        session = HibernateUtilities.getSessionFactory().openSession();
        HibernateUtilities.beginTransaction(session);

        String hql = "FROM Course c WHERE c.code=:code";//:code ile kullanicidan aldigimiz string degiskeni hql sorgusunda kullandik.
        //String hql="FROM Course c WHERE c.code="+id; int degisken icin buna gerek yok.
        List<Course> courseList = session.createQuery(hql, Course.class).setParameter("code", code).getResultList();

//        for (Course course : courseList)
//        {
//            System.out.println(course);
//        }

        HibernateUtilities.commitTransaction(session);
        HibernateUtilities.closeSession(session);
        return courseList.get(0).getCode();
    }

    public Course getCourse(String code) {
        session = HibernateUtilities.getSessionFactory().openSession();
        HibernateUtilities.beginTransaction(session);

        String hql = "FROM Course c WHERE c.code=:code";//:code ile kullanicidan aldigimiz string degiskeni hql sorgusunda kullandik.
        //String hql="FROM Course c WHERE c.code="+id; int degisken icin buna gerek yok.
        List<Course> courseList = session.createQuery(hql, Course.class).setParameter("code", code).getResultList();

//        for (Course course : courseList)
//        {
//            System.out.println(course);
//        }

        HibernateUtilities.commitTransaction(session);
        HibernateUtilities.closeSession(session);
        return courseList.get(0);
    }

    public void removeCourse(String code) {

        session = HibernateUtilities.getSessionFactory().openSession();
        HibernateUtilities.beginTransaction(session);

        String hql = "DELETE FROM Course c WHERE c.code=:code";//:code ile kullanicidan aldigimiz string degiskeni hql sorgusunda kullandik.
        //String hql="FROM Course c WHERE c.code="+id; int degisken icin buna gerek yok.
        int deleteResult = session.createQuery(hql).setParameter("code", code).executeUpdate();

        if (deleteResult > 0) {
            System.out.println(" Kayit silindi");
        } else {
            System.out.println("Boyle bir kurs bulunamadi");
        }

        HibernateUtilities.commitTransaction(session);
        HibernateUtilities.closeSession(session);
    }

    public void getAllCourses() {
        session = HibernateUtilities.getSessionFactory().openSession();
        HibernateUtilities.beginTransaction(session);

        String hql = "FROM Course";
        List<Course> courseList = session.createQuery(hql, Course.class).getResultList();

        for (Course course : courseList) {
            System.out.println(course);
        }

        HibernateUtilities.commitTransaction(session);
        HibernateUtilities.closeSession(session);
    }

    public void saveTestData(Course course1, Course course2, Course course3, Course course4) {
        session = HibernateUtilities.getSessionFactory().openSession();
        HibernateUtilities.beginTransaction(session);

        session.save(course1);
        session.save(course2);
        session.save(course3);
        session.save(course4);

        HibernateUtilities.commitTransaction(session);
        HibernateUtilities.closeSession(session);
    }

}
