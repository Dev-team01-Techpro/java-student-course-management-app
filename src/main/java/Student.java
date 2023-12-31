import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;
    @Column(name = "student_name", nullable = false)
    private String name;
    @Column(name = "student_surname", nullable = false)
    private String surname;
    @Column(name = "student_number", unique = true, nullable = false)
    private int studentNumber;
    @Column(name = "student_department")
    private String department;
    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses = new ArrayList<>();

    public Student() {
    }

    public Student(String name, String surname, int studentNumber, String department) {
        this.name = name;
        this.surname = surname;
        this.studentNumber = studentNumber;
        this.department = department;
    }

    public Student(String name, String surname, int studentNumber, String department, Course course) {
        this.name = name;
        this.surname = surname;
        this.studentNumber = studentNumber;
        this.department = department;
        this.courses.add(course);
    }

    public Long getId() {
        return id;
    }
//setid otomatik oluşacağı için setid kullanmıyoruz
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", studentNumber=" + studentNumber +
                ", department='" + department + '\'' +
//                ", courses=" + courses +
                '}';
    }
}

