import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {

    private ArrayList<Integer> studentId = new ArrayList<Integer>();
    private int[][] requestsTest = new int[studentId.size()][20];
    private ArrayList<Integer> requests = new ArrayList<Integer>();

    public Data() {

        this.studentId = studentId;

        for (int r = 0; r < requestsTest.length; r++) {
            for (int c = 0; c < requestsTest[0].length; c++) {
                requestsTest[r][c] = 0;
            }

        }
        this.requests = requests;

        try {
            Path path = Paths.get("./data2.txt");
            Scanner scanner = new Scanner(path);
            System.out.println("Read text file using Scanner");
            //read line by line
            while (scanner.hasNextLine()) {
                //process each line
                String line = scanner.nextLine();
                if (line.contains(":")) {
                    String IDString = line.substring(line.indexOf(":") + 2);
                    int IDNum = Integer.parseInt(IDString); //this turns the String into integer
                    studentId.add(IDNum);
                }

            }
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace(); 
        }
//      Test test studentId
        System.out.println(studentId);

    }

    public ArrayList<Integer> getId() {
        return studentId;
    } //returns an arraylist of Student ID #

    public int getStudentNum() {
        return studentId.size();
    } //returns number of students

}