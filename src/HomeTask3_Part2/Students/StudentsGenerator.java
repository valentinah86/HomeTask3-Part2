package HomeTask3_Part2.Students;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;


public class StudentsGenerator {

    private Random r = new Random();

    private int generateAge() {
        int minAge = 16;
        int maxAge = 30;
        return r.nextInt(maxAge - minAge + 1) + minAge;
    }

    private int generateStudentID() {

        int max = 150;
        int min = 10;
        return r.nextInt(max - min + 15) + min;

    }

    private String generateName (ArrayList<String> namesList) {
        int randomValue = r.nextInt(namesList.size()-1);
        return namesList.get(randomValue);
    }

    private String generateSurname(ArrayList<String> surnameList){
        int randomValue = r.nextInt(surnameList.size()-1);
        return surnameList.get(randomValue);
    }

    private ArrayList<String> getNamesList () throws IOException {
        File file = new File("SurnameList.txt");
        BufferedReader stream = new BufferedReader(new FileReader(file.getAbsoluteFile()));
        ArrayList<String> namesList = new ArrayList<>();
        try{
            while ((stream.readLine())!=null){
                namesList.add(stream.readLine());
            }
        }
        finally {
            stream.close();
        }
        return namesList;
    }

    private ArrayList<String> getSurnamesList () throws IOException {
        File file = new File("SurnameList.txt");
        ArrayList<String> surnamesList = new ArrayList<>();
        try (BufferedReader stream = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
            while ((stream.readLine()) !=null) {
                surnamesList.add(stream.readLine());
            }
        }
        return surnamesList;

    }

   public Students createStudent() throws IOException {

        return (new Students(generateStudentID(), generateName(getNamesList()), generateSurname(getSurnamesList()), generateAge()));
    }


}

