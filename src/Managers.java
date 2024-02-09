import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Managers {

    ArrayList<Student> students;

    Managers(){
        students = new ArrayList<>();
    }

    public void AddStudent(){

        Scanner input = new Scanner(System.in);
        System.out.print("Enter name :");
        String name = input.next();
        System.out.print("Enter id :");
        int id = input.nextInt();
        System.out.print("Enter age :");
        int age = input.nextInt();
        System.out.print("Enter program :");
        String program = input.next();

        Student obj = new Student( name, id, age, program);

        students.add(obj);

        /*String filepath = name+".json";
        File newFile = new File(filepath);

       try{
           newFile.createNewFile();
       }catch (Exception exception){
           System.out.println(exception);
       }

       try{
           FileWriter write = new FileWriter(filepath);
           write.write("\nName   : " + name+
           "\nID     : " + id+
           "\nAge    : " + age+
           "\nProgram: " + program);
           write.close();
       }catch (Exception exception){
           System.out.println(exception);

       }*/
    }

    public void deleteStudentById() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter id :");
        int id = input.nextInt();

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).id == id) {

                students.remove(i);
                System.out.println("STudent with ID " + id + " has been removed");
                return;
            }
        }
        // If no student with the given ID is found
        System.out.println("Student with ID " + id + " not found.");
    }
    public void displayStudentsDetails() {
        System.out.println("Details of all students:");
        for (Student student : students) {
            System.out.println("Name   : " + student.name);
            System.out.println("ID     : " + student.id);
            System.out.println("Age    : " + student.age);
            System.out.println("Program: " + student.program);
            System.out.println();
        }
    }



    public static void main(String[] args) {
        Managers manager = new Managers();
        manager.AddStudent();
    }
}
