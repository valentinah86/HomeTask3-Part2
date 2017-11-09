package HomeTask3_Part2;

import HomeTask3_Part2.Students.Students;
import HomeTask3_Part2.Students.StudentsListGenerator;

import java.io.*;
import java.util.*;


public class Actions {

    private Random r = new Random();
    private ArrayList <Students> studentsList;
    private HashMap<Integer, Students> stListToMap = new HashMap<>();
    private StudentsListGenerator listGenerator = new StudentsListGenerator();


    public ArrayList sortStudentsByAge(ArrayList<Students> studentsList) throws IOException {

        Comparator byAge = new Comparator <Students>() {

            @Override
            public int compare(Students o1, Students o2) {
                return Integer.compare(o1.getAge(),o2.getAge());
            }

        };

       Collections.sort(studentsList,byAge);


        return studentsList;
    }

    public ArrayList filterSurnameByFirstLetter(String letter, ArrayList<Students> studentsList) {

        ArrayList filteredList = new ArrayList<Students>();
        String surname;

        for (Students students : studentsList) {

            surname = students.getSurname().toString();
            char[] str = surname.toCharArray();
            char s = str[0];

            if (s == letter.toUpperCase().charAt(0)) {
                filteredList.add(students);
            }
        }

        return filteredList;
    }

    public double calculateAverageAge(ArrayList<Students> studentsList) throws IOException {

        double averageAge;
        int sum=0;

        for (Students student: studentsList ) {
            sum += student.getAge();
        }

        try {
            averageAge = sum / studentsList.size();

        } catch (ArithmeticException e) {
            throw new ArithmeticException();
        }

        return averageAge;
    }

    public HashMap <Integer,Students> convertStudentsListToMap (ArrayList<Students> studentsList){

        for (Students students: studentsList){
            stListToMap.put(r.nextInt(150), students);
        }

        return stListToMap;
    }

    public HashMap<Integer, Students> filterByID(HashMap<Integer, Students> stListToMap) {

        HashMap<Integer, Students> filteredMap = new HashMap<>();

        for (Map.Entry<Integer, Students> pair : stListToMap.entrySet()) {
            int value = pair.getValue().getId();
            if (value >= 100) {
                filteredMap.put(pair.getKey(), pair.getValue());
            }
        }
        return filteredMap;
    }


}
