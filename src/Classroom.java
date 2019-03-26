import java.util.ArrayList;

public class Classroom {

    private int id, wingId, maxStudents;
    private boolean open; //true is classrm available, false is unavailable.in use
    private int idOfClass;

    public Classroom(){
        this.id = id;
        this.wingId = wingId;
        this.maxStudents = maxStudents;
        this.open = open;
        this.idOfClass = idOfClass;



    }

    public int numStudents(ArrayList<Student> a){
        int students = 0;

//add students
        return students;

    }

    public boolean isOpen(ArrayList<Student> a){
        if(numStudents(a) >= maxStudents){
            open = false;
        }
        return open;
    }

    public int getID(){
        return id;
    }

    public int getwingID(){
        return wingId;
    }

    public int maxStudents(){
        return maxStudents;
    }


}
