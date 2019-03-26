import java.util.ArrayList;

public class Course {
    /*
    Day 1 Notes
    private int id, period, code; //id would be specifically for that one class\
    //but the code is the number that tells you which course it is (number before the course names)
    private int level; //1:intro, 2:college, 3:honors, 4:AP, 5:standard (classes that don't have a level)
    private String courseName;
    //semester-based,full-year,quarter-long?;
    private boolean request;
    private ArrayList<Student> students;
     */

    private String name, courseNumberSt, level;
    private int period,courseNumberID;

    //level: introductory, college, honors, advanced (placement)
    //if index 0 to indexOf first [space] = intro, coll, honors, advanced, then set level to that string (index 0 to indexOf first [space]).
    //else, set level to "standard"

    public Course(String info){

        if(info.contains("-") && !info.contains("Wellness")) {

            int indexOfDash = info.indexOf("-");
            int indexOfFirstSpace = 0;


            courseNumberSt = info.substring(0, indexOfDash - 1);
            String a = courseNumberSt;
            courseNumberID = Integer.parseInt(a);
            name = info.substring(indexOfDash + 2);
            period = (int) (Math.random() * 8 + 1);

            boolean happy = false;
            if (!happy) {
                for (int i = 0; i < name.length() - 1; i++) {
                    if (name.substring(i, i + 1).equals(" ")) {
                        indexOfFirstSpace = i;
                        happy = true;
                    }
                }
            }

            if (info.substring(0, indexOfFirstSpace).contains("Introductory")) {
                level = "introductory";
            } else if (info.substring(0, indexOfFirstSpace).contains("College")) {
                level = "college";
            } else if (info.substring(0, indexOfFirstSpace).contains("Honors")) {
                level = "honors";
            } else if (info.substring(0, indexOfFirstSpace).contains("Advanced")) {
                level = "ap";
            } else {
                level = "standard";
            }

        }

        else{ //when Course is given a courseName e.g. takes in "AP Bio"
            name = info;
        }

    }

    public Course(Course orig){
        this.name = orig.getName();
        this.courseNumberID = orig.getCourseNumber();
        this.period = orig.getPeriod();
    }

    public String getName(){
        return name;
    }

    public int getPeriod(){return period;}

    public int setPeriod(int per){
        period = per;
        return period;
    }

    public String getLevel(){
        return level;
    }

    public int getCourseNumber(){
        return courseNumberID;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", courseNumber='" + courseNumberSt + '\'' +
                ", level='" + level + '\'' +
                ", period=" + period +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Course == false){
            return false;
        }
        Course other = (Course)obj;
        return other.getName().equals(this.getName());
    }

}



