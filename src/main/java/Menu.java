import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {

    StudentService studentService = new StudentService();

    CourseService courseService = new CourseService();
    Scanner input = new Scanner(System.in);

    public void displayMenu() {

        boolean exit = true;

        while (exit) {
            System.out.println("İşlem seçiniz:");
            System.out.println("1. Ders ekle");
            System.out.println("2. Ders sil");
            System.out.println("3. Dersleri listele");
            System.out.println("4. Öğrenci ekle");
            System.out.println("5. Öğrenci sil");
            System.out.println("6. Öğrencileri listele");
            System.out.println("7. Test verileri olustur");
            System.out.println("0. Çıkış");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    removeCourse();
                    break;
                case 3:
                    listAllCourses();
                    break;
                case 4:
                    addStudent();
                    break;
                case 5:
                    removeStudent();
                    break;
                case 6:
                    listStudent();
                    break;
                case 7:
                    saveTest();
                    break;
                case 0:
                    exit = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private void saveTest() {
        // Öğrenci sınıfı örneği oluşturma
        Student student1 = new Student("Ahmet", "Yılmaz", 111, "Bilgisayar Mühendisliği");
        Student student2 = new Student("Ayşe", "Kaya", 222, "Elektrik Elektronik Mühendisliği");
        Student student3 = new Student("Mehmet", "Öztürk", 333, "Makine Mühendisliği");
        Student student4 = new Student("Mustafa", "Yılmaz", 444, "Bilgisayar Mühendisliği");

        // Kurs oluştur
        Course course1 = new Course("Java'ya Giriş", "BM101", 3, "Bilgisayar Mühendisliği");
        Course course2 = new Course("Veritabanı Yönetimi", "BM201", 4, "Bilgisayar Mühendisliği");
        Course course3 = new Course("Elektrik Devreleri", "EE101", 3, "Elektrik Elektronik Mühendisliği");
        Course course4 = new Course("Yazılım Geliştirme", "BM301", 5, "Bilgisayar Mühendisliği");

        student1.getCourses().add(course1);
        student1.getCourses().add(course2);
        student1.getCourses().add(course3);

        courseService.saveTestData(course1, course2, course3, course4);
        studentService.saveTestData(student1, student2, student3, student4);
    }

    private void addCourse() {
        input.nextLine();
        System.out.println("Ders adı : ");
        String name = input.nextLine();

        System.out.println("Ders kodu : ");
        String code = input.nextLine();

        System.out.println("Ders kredisi : ");
        int credit = input.nextInt();
        input.nextLine();

        System.out.println("Ders Bölümü : ");
        String department = input.nextLine();

        courseService.addCourse(name, code, credit, department);
    }

    private void removeCourse() {
        System.out.println("Lütfen silmek istediğiniz kursun kodunu giriniz...");
        String code = input.next();
        courseService.removeCourse(code);
    }


    private void listAllCourses() {
        courseService.getAllCourses();
    }

    private void addStudent() {
      input.nextLine();
        System.out.println("Öğrenci Adı : ");
        String name = input.nextLine();

        System.out.println("Öğrenci Soyadı : ");
        String surname = input.nextLine();

        System.out.println("Öğrenci Numarası : ");
        int studentNumber = input.nextInt();
        input.nextLine();

        // Burada ogrenci nesnesiyle course nesnesi arasinda baglantiyi yapicak kismi yaziyoruz
        System.out.println("Kaydetmek istediginiz Bolum Kodu: ");
        String departmentCode = input.nextLine();

        Course course=courseService.getCourse(departmentCode);

        String department=course.getName();

        studentService.addStudent(name, surname, studentNumber, department, course);
    }

    private void removeStudent() {
        System.out.println("Lütfen silmek istediğiniz ogrencinin numarasini giriniz...");
        int studentNumber = input.nextInt();
        studentService.removeStudent(studentNumber);

    }

    private void listStudent() {

        studentService.getAllStudents();

    }


}
