import java.util.Scanner;

public class Menu {
    
    StudentService studentService=new StudentService();
    
    CourseService courseService=new CourseService();
    Scanner input= new Scanner(System.in);
    public void displayMenu() {
        
        boolean exit= true;

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
                    listCourse();
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
                    exit=false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

        }

    }

    private void listStudent() {
    }

    private void removeStudent() {
    }

    private void addStudent() {
    }

    private void listCourse() {
    }

    private void removeCourse() {
    }

    private void addCourse() {
        
    }

}
