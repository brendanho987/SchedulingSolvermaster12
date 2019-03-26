import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private int id, grade;
    private ArrayList<Course> requests, names;
    ArrayList<Course>[] masterSchedule;
    private ArrayList<Course> studentSchedule;
    private int cost;
    private Course[] schedule;
//    private MasterSchedule ms;

    //draw physical  array for masterSchedule;


    //list of course reqs;
    public Student(){
        requests = new ArrayList();
        studentSchedule = new ArrayList();
        this.masterSchedule = null;
        for(int i = 0; i<requests.size(); i++) {
            int coursenumber = requests.get(i).getCourseNumber();
            for (int j = 0; j < masterSchedule.length; j++) {
                for (int k = 0; k < masterSchedule[0].size(); k++)
                    if (coursenumber == masterSchedule[j].get(k).getCourseNumber()) {
                        studentSchedule.add(masterSchedule[j].get(k));

                    }
            }
        }

        this.cost = 0;

        ArrayList<Student> students = new ArrayList<>();

    }

    public Student(Student orig){
        this.requests = orig.getRequests();
        this.id = orig.getId();
        this.cost = orig.getCost();
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int i) {
        grade = i;
    }

    public int getId() {
        return id;
    }

    public void setId(int i) {
        id = i;
    }

    public int getCost(){
        return cost;
    }

    public void addCourse(String info) {
        requests.add(new Course(info));
    }

    public ArrayList<Course> getRequests() {
        return requests;
    }

    public Course[] makeStudentSchedule(MasterSchedule a){
        Course[] b = new Course[8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < a.getCourseNames().size(); j++) {
                if(i == a.getCourseNames().get(j).getPeriod() && requests.contains(a.getCourseNames().get(j))){
                    b[i] = a.getCourseNames().get(i);
                }
            }
        }
        return b;
    }

    public void setMasterSchedule(ArrayList<Course>[] masterSchedule) {
        this.masterSchedule = masterSchedule;
    }

    public int calcScoreStudent(Student a, MasterSchedule ms){
        int score = 0;
        int conflicts = 0;
        int fitted = 0;
        for(int i = 0; i<a.requests.size(); i++){
            for(int j = i+1; j<a.requests.size(); j++) {
                if (i != j && requests.get(i).getCourseNumber() == requests.get(j).getCourseNumber() && requests.get(i).getPeriod() == requests.get(j).getPeriod()) {
                    conflicts++;
                }
            }

        }
        score += conflicts * 100;
        score += fitted * 100;

        this.cost = score;
        return cost;
    }

    public void resetPeriods(MasterSchedule ms){
        for (int j = 0; j < requests.size(); j++) {
            for (int k = 0; k < ms.getCourseNames().size(); k++) {
                if (requests.get(j).equals(ms.getCourseNames().get(k))) {
                    int tempPer = ms.getCourseNames().get(k).getPeriod();
                    requests.get(j).setPeriod(tempPer);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", requests=" + requests +
                '}';
    }

}
