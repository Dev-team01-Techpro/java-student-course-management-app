import javax.persistence.Entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;
    @Column(name = "course_name")
    private String name;
    @Column(name = "course_code")
    private String code;
    @Column(name = "course_credit")
    private int credit;
    @Column(name = "course_department")
    private String department;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students = new ArrayList<>();

    public Course() {
    }

    public Course(String name, String code, int credit, String department) {
        this.name = name;
        this.code = code;
        this.credit = credit;
        this.department = department;
    }

    public Course(String name, String code, int credit, String department, List<Student> students) {
        this.name = name;
        this.code = code;
        this.credit = credit;
        this.department = department;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

   /* public void setId(Long id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", credit=" + credit +
                ", department='" + department + '\'' +
                ", students=" + students +
                '}';
    }
}
