import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

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

    public String getCourseByCode(String code){

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Course.class).addAnnotatedClass(Student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        String hql="FROM Course c WHERE c.code=:code";//:code ile kullanicidan aldigimiz string degiskeni hql sorgusunda kullandik.
        //String hql="FROM Course c WHERE c.code="+id; int degisken icin buna gerek yok.
        List<Course> courseList = session.createQuery(hql, Course.class).setParameter("code", code).getResultList();

//        for (Course course : courseList)
//        {
//            System.out.println(course);
//        }

        tx.commit();
        session.close();
        sf.close();
        return courseList.get(0).getCode();
    }

    public void removeCourse(String code){

       String codeDb= getCourseByCode(code);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Course.class).addAnnotatedClass(Student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        String hql="DELETE FROM Course c WHERE c.code=:codeDb";//:code ile kullanicidan aldigimiz string degiskeni hql sorgusunda kullandik.
        //String hql="FROM Course c WHERE c.code="+id; int degisken icin buna gerek yok.
        int deleteResult = session.createQuery(hql).setParameter("codeDb", codeDb).executeUpdate();

       System.out.println("deleteResult = " + deleteResult);
        tx.commit();
        session.close();
        sf.close();

    }

    public void getAllCourses(){

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Course.class).addAnnotatedClass(Student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        String hql="FROM Course";
        List<Course> courseList = session.createQuery(hql, Course.class).getResultList();

        for (Course course : courseList)
        {
            System.out.println(course);
        }

        tx.commit();
        session.close();
        sf.close();

    }

}
