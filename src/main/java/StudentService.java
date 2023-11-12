import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StudentService {

    public void addStudent(String name, String surname, int studentNumber, String department, Course course) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Course.class).addAnnotatedClass(Student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Student student = new Student(name, surname, studentNumber, department, course);
//       // student.getCourses().add(course);
        session.save(student);


        tx.commit();
        session.close();
        sf.close();


//        Session session = HibernateUtilities.openSession();
//        HibernateUtilities.beginTransaction(session);
//
//
//        Student student= new Student(name, surname, studentNumber, department, course);
//       // student.getCourses().add(course);
//        session.save(student);
//
//        HibernateUtilities.commitTransaction(session);
//        HibernateUtilities.closeSession(session);
//        HibernateUtilities.closeSessionFactory();


    }

    public void removeStudent(int studentNumber) {
        Session session = HibernateUtilities.openSession();
        HibernateUtilities.beginTransaction(session);

        String hqlQuery = "DELETE FROM Student s WHERE s.studentNumber = " + studentNumber;
        int delete = session.createQuery(hqlQuery).executeUpdate();

        if (delete > 0) {
            System.out.println("Kayit silindi !");
        } else {
            System.out.println("girmis oldugunuz numarada ogrenci bulunamadi...");
        }

        HibernateUtilities.commitTransaction(session);
        HibernateUtilities.closeSession(session);
        HibernateUtilities.closeSessionFactory();
    }

    public void getAllStudents() {
        Session session = HibernateUtilities.openSession();
        HibernateUtilities.beginTransaction(session);

        String hqlQuery = "FROM Student";
        List<Student> stdList = session.createQuery(hqlQuery, Student.class).getResultList();
        for (Student std : stdList) {
            System.out.println(std);

        }

        HibernateUtilities.commitTransaction(session);
        HibernateUtilities.closeSession(session);
        HibernateUtilities.closeSessionFactory();
    }

    public int getStudentByNumber(int studentNumber) {
        Session session = HibernateUtilities.openSession();
        HibernateUtilities.beginTransaction(session);


        HibernateUtilities.commitTransaction(session);
        HibernateUtilities.closeSession(session);
        HibernateUtilities.closeSessionFactory();
        return 0;
    }

    public void saveTestData(Student student1, Student student2, Student student3, Student student4) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Course.class).addAnnotatedClass(Student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);

        tx.commit();
        session.close();
        sf.close();
    }
}
