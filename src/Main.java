import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

//    private ArrayList<Student> students;
    private MasterSchedule ms;

    public static void main(String[] args) {

        int score = 0;
        ArrayList<Student> students = new ArrayList<>();

        ArrayList<Integer> idPool = new ArrayList<>();
        for (int i = 0; i < 900; i++) {
            idPool.add(i);
        }

        try {
            Path path = Paths.get("./data2.txt");
            Scanner scanner = new Scanner(path);
            System.out.println("Read text file using Scanner");
            //read line by line
            while (scanner.hasNextLine()) {
                //process each line
                String line = scanner.nextLine();
                if (line.contains(":")) {
                    String IDString = ""+ idPool.remove((int)(Math.random()*idPool.size()));
                    int IDNum = Integer.parseInt(IDString); //this turns the String into integer
                    Student tempStudent = new Student();
                    tempStudent.setId(IDNum);

                    //add courses to student.

                    while((line = scanner.nextLine()).contains("-")){
                        tempStudent.addCourse(line);
                    }
                    students.add(tempStudent);
                }

            }
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Course> courseName = new ArrayList<>();

        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.get(i).getRequests().size(); j++) {
                Course a = new Course(students.get(i).getRequests().get(j).getName());
                if (!courseName.contains(a)) {
                    if (!courseName.contains(a))
                        courseName.add(a);
                }
            }
        }

        for (int i = 0; i < courseName.size(); i++) {
            for (int j = i + 1; j < courseName.size(); j++) {
                if (courseName.get(i).equals(courseName.get(j))) {
                    courseName.remove(j);
                    j--;
                }
            }
        }
//        Makes an arraylist of coursenames without repeats ENDS





        Population population = new Population(0, courseName);

        while(population.nextGen(students))

            population.display(students);

        //        MasterSchedule ms = new MasterSchedule(courseName);
//        //        for (int i = 0; i < ms.getStudents().size(); i++) {
////            ms.getStudents().get(i).makeStudentSchedule(masterSchedule);
////
////        }
////        System.out.println(students.get(0).makeStudentSchedule(masterSchedule));
//        for (int i = 0; i < students.size(); i++) {
//            students.get(i).resetPeriods(ms);
//        }
//        System.out.println(students);
//
////        for (int i = 0; i < ms.getStudents().size(); i++) {
////            ms.getStudents().get(i).resetPeriods(ms);
////        }
////        System.out.println(ms.getStudents());
//

    }

}
