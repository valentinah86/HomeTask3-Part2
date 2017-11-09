package HomeTask3_Part2;

import HomeTask3_Part2.Students.Students;
import HomeTask3_Part2.Students.StudentsListGenerator;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Application {

    public static void main(String[] args) throws IOException {

        Actions actions = new Actions();
        StudentsListGenerator listGenerator = new StudentsListGenerator();
        Scanner s = new Scanner(System.in);
        ArrayList<Students> st;
        HashMap<Integer,Students> hashMap;
        Printer p = new Printer();

        System.out.println(
                "********************************************************\n" +
                        "*                       MENU                           *\n" +
                        "********************************************************\n" +
                        "Press 1 to sort students by Age\n" +
                        "Press 2 to filter list by 1'st letter in surname\n" +
                        "Press 3 to convert list to HashMap\n" +
                        "Press 4 to filter HashMap by Id\n" +
                        "Press 5 to calculate Average Age\n"+
                        "Press X to exit\n");

        System.out.println("Insert needed number of the Students in Group");

        String value = s.nextLine();
        if (value.equals("X")|| value.equals("x")){
            System.exit(0);
        } else {
        try{
            int number = Integer.parseInt(value);
            st = listGenerator.generateStudentsList(number);
        }
        catch (NumberFormatException e){throw new NumberFormatException(value);}

        p.writeResults("studentsList.txt", st.toString());
        System.out.println("List successfully created\n");


        while (!value.equals("X")||!value.equals("x")) {
            System.out.println("Select needed operation");
            value = s.nextLine();
            if (value.equals("X")||value.equals("x")){
                break;
            }
            else {

                try {
                    int state = Integer.parseInt(value);

                    switch (state) {

                        case 1: {
                            p.writeResults("sortedList.txt", actions.sortStudentsByAge(st).toString());
                            continue;
                        }
                        case 2: {
                            String filter = "";
                            System.out.println("Write needed filter");
                            filter = s.nextLine();
                            p.writeResults("filteredList.txt", actions.filterSurnameByFirstLetter(filter,st).toString());

                            continue;
                        }
                        case 3: {

                            hashMap = actions.convertStudentsListToMap(st);
                            p.writeResults("hashMap.txt",hashMap.toString());
                            continue;
                        }
                        case 4: {
                            int n = Integer.parseInt(value);
                            try {

                                hashMap = actions.convertStudentsListToMap(st);
                                HashMap filteredHashMap = actions.filterByID(hashMap);
                                p.writeResults("filteredMap.txt",filteredHashMap.toString());
                                continue;
                            }catch (NumberFormatException e) {
                                throw new NumberFormatException(value);

                            }

                        }
                        case 5: {

                            double average = actions.calculateAverageAge(st);
                            System.out.println("Average Age  = " + String.format("%.2f",average));
                            System.out.println("Students list \n");
                            p.readResults("studentsList.txt");

                        }


                    }


                } catch (IOError error) {
                    error.printStackTrace();
                }
            }

        }


    }


}
}
