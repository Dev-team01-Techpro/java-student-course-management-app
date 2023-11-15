import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StudentService {
    private Session session;

    public void addStudent(String name, String surname, int studentNumber, String department, Course course) {
        session = HibernateUtilities.getSessionFactory().openSession();
        HibernateUtilities.beginTransaction(session);

        Student student = new Student(name, surname, studentNumber, department, course);
        // student.getCourses().add(course);
        session.save(student);

        HibernateUtilities.commitTransaction(session);
        HibernateUtilities.closeSession(session);
    }

    public void removeStudent(int studentNumber) {
        session = HibernateUtilities.getSessionFactory().openSession();
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
    }

    public void getAllStudents() {
        session = HibernateUtilities.getSessionFactory().openSession();
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

    public Student getStudentByNumber(int studentNumber) {
        session = HibernateUtilities.getSessionFactory().openSession();
        HibernateUtilities.beginTransaction(session);

        String hql = "FROM Student s WHERE s.studentNumber = " + studentNumber;
        List<Student> student = session.createQuery(hql, Student.class).getResultList();

        HibernateUtilities.commitTransaction(session);
        HibernateUtilities.closeSession(session);
        return student.get(0);
    }

    public void saveTestData(Student student1, Student student2, Student student3, Student student4) {
        session = HibernateUtilities.getSessionFactory().openSession();
        HibernateUtilities.beginTransaction(session);

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);

        HibernateUtilities.commitTransaction(session);
        HibernateUtilities.closeSession(session);
    }
}
