import java.util.*;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class Population {

    //genetic algorithm population
    //takes in masterschedule chromosomes adds them to population

    private ArrayList<MasterSchedule> members;
    private int goal, size, generationNumber, generation;

    public Population(int goal, ArrayList<Course> courseName){

        this.members = new ArrayList<>();

        this.goal = goal;

        this.size = 20;

        this.generation = 0;

        this.generationNumber = 0;

        while(members.size()<size){

            MasterSchedule ms = new MasterSchedule(courseName);

            members.add(ms);

        }
    }

    public void sort(ArrayList<Student> stuList) {

        List list = Arrays.asList(members); //why is list unused??

        Collections.sort(members, new Comparator<MasterSchedule>() {

            public int compare(MasterSchedule o1, MasterSchedule o2) {

                return o1.totalCost(stuList, o1)-o2.totalCost(stuList, o2);

            }

        });

    }

    public void kill() {

        for (int i = members.size()/2; i < members.size(); i++) {

            members.set(i, members.get(i-members.size()/2)); //turns second half of sorted list into copy of first half

        }

    }

    public void mutate() {

        for (int i =members.size()/2; i < members.size(); i++) { //Possibly mutates a member of second half of population

            int random = (int)(Math.random()*5);

            if(random == 2 ) {

                int randomPeriodFrom = (int)(Math.random()*8);

                int randomClassFrom = (int)(Math.random()*members.get(i).getScheduleReal()[randomPeriodFrom].size());

                int randomPeriodTo = (int)(Math.random()*8);

                int randomClassTo = (int)(Math.random()*members.get(i).getScheduleReal()[randomPeriodTo].size());

                Course ClassFrom = members.get(i).getScheduleReal()[randomPeriodFrom].get(randomClassFrom);

                Course ClassTo = members.get(i).getScheduleReal()[randomPeriodTo].get(randomClassTo);

                members.get(i).getScheduleReal()[randomPeriodTo].set(randomClassTo, ClassFrom);

                members.get(i).getScheduleReal()[randomPeriodFrom].set(randomClassFrom, ClassTo);

            }

        }

    }

    public void display(ArrayList<Student> students) {

        for (int i = 0; i < members.size(); i++) {

            System.out.println("generation = "+ generation + ": " + members.get(i).display()); //TODO: let it not print memory

            System.out.println("Score: " + members.get(i).totalCost(students, members.get(i)));

            System.out.println();

            System.out.println();

            generation++;

        }

    }

    public boolean nextGen(ArrayList<Student> students) {

        int generation = 0;

        while(members.get(0).totalCost(students, members.get(0)) != 0) {  //This will likely be infinite
            //we'll need to store the best iteration of the schedule

            sort(students);

            kill();

            mutate();

            return false;

        }

        return true;
    }

}
