import java.io.*;
import java.util.ArrayList;

public class Scrubber {


    public static void main(String[] args) {
        int bob = 0; //ayy my guy Bob

        ArrayList<Integer> ids = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            ids.add(i);
        }



        try {

            File raw = new File("./data2.txt");

            BufferedReader br = new BufferedReader(new FileReader(raw));
            BufferedWriter writer = new BufferedWriter(new FileWriter("./data2.txt", false));


            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);

                if(str.contains(",")){
                    int id = bob;
                    writer.append("\nStudent ID: " + id + "\n");
                    bob++;


                }



                 if(!str.contains("2000 - ") && !str.contains(".0000"))
                    if(!str.contains("Name") && !str.contains("Page"))
                        if(!str.contains("Homeroom") && !str.contains("House/Team"))
                            if(!str.contains("Grade") && !str.contains("Requests"))
                                if(!str.contains("Course") && !str.contains("Fee"))
                                    if(!str.contains("0 1") && !str.contains("1 0"))
                                        if(!str.equals(" 0") && !str.equals(" 1"))
                                            if(!str.contains("11/29/2017") && !str.contains("Detail"))
                                                if(str.length() > 8)
                                                    writer.append(str + "\n");

            }

            writer.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }


}

