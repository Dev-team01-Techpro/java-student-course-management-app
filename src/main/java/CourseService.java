import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CourseService {
    public void addCourse(String name, String code, int credit, String department) {
        Session session = HibernateUtilities.openSession();
        HibernateUtilities.beginTransaction(session);

        Course course = new Course(name, code, credit, department);
        session.save(course);

        HibernateUtilities.commitTransaction(session);
        HibernateUtilities.closeSession(session);
        HibernateUtilities.closeSessionFactory();
    }

    public String getCourseByCode(String code) {
        Session session = HibernateUtilities.openSession();
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
        HibernateUtilities.closeSessionFactory();
        return courseList.get(0).getCode();
    }

    public Course getCourse(String code) {
        Session session = HibernateUtilities.openSession();
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
        HibernateUtilities.closeSessionFactory();
        return courseList.get(0);
    }

    public void removeCourse(String code) {

        String codeDb = getCourseByCode(code);

        Session session = HibernateUtilities.openSession();
        HibernateUtilities.beginTransaction(session);

        String hql = "DELETE FROM Course c WHERE c.code=:codeDb";//:code ile kullanicidan aldigimiz string degiskeni hql sorgusunda kullandik.
        //String hql="FROM Course c WHERE c.code="+id; int degisken icin buna gerek yok.
        int deleteResult = session.createQuery(hql).setParameter("codeDb", codeDb).executeUpdate();

        System.out.println("deleteResult = " + deleteResult);
        HibernateUtilities.commitTransaction(session);
        HibernateUtilities.closeSession(session);
        HibernateUtilities.closeSessionFactory();
    }

    public void getAllCourses() {

        Session session = HibernateUtilities.openSession();
        HibernateUtilities.beginTransaction(session);

        String hql = "FROM Course";
        List<Course> courseList = session.createQuery(hql, Course.class).getResultList();

        for (Course course : courseList) {
            System.out.println(course);
        }

        HibernateUtilities.commitTransaction(session);
        HibernateUtilities.closeSession(session);
        HibernateUtilities.closeSessionFactory();
    }

    public void saveTestData(Course course1, Course course2, Course course3, Course course4) {
        Session session = HibernateUtilities.openSession();
        HibernateUtilities.beginTransaction(session);

        session.save(course1);
        session.save(course2);
        session.save(course3);
        session.save(course4);

        HibernateUtilities.commitTransaction(session);
        HibernateUtilities.closeSession(session);
        HibernateUtilities.closeSessionFactory();
    }
}
