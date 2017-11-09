package HomeTask3_Part2.Students;

import java.io.IOException;
import java.util.ArrayList;

public class StudentsListGenerator {

    private StudentsGenerator generator = new StudentsGenerator();
    private ArrayList <Students> studentsList = new ArrayList<>();

    public ArrayList generateStudentsList(int value) throws IOException {
        ArrayList studentsList = new ArrayList<Students>();
        for (int i = 0; i < value; i++) {
            studentsList.add(generator.createStudent());
        }
        return studentsList;
    }

    public ArrayList getStudentsList() throws IOException {

           return studentsList;
    }

    @Override
    public String toString() {
        return ("List of students: \n" + studentsList + "\n");
    }
}
