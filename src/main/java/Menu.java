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
                case 0:
                    exit = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
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

        System.out.println("Lütfen silmek istediğiniz kursun ID'sini giriniz...");
        String code=input.next();
        courseService.removeCourse(code);
    }



    private void listAllCourses() {
        courseService.getAllCourses();
    }

    private void addStudent() {
    }

    private void removeStudent() {
    }

    private void listStudent() {
    }


}
