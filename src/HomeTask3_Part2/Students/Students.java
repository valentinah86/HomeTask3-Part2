package HomeTask3_Part2.Students;

public class Students {
    private int Id;
    private String Name;
    private String Surname;
    private int Age;

    public Students (int Id, String Name, String Surname, int Age){

        this.Id = Id;
        this.Name = Name;
        this.Surname = Surname;
        this.Age = Age;
    }

    public int getId() {
        return Id;
    }


    public String getName() {
        return Name;
    }



    public String getSurname (){
        return Surname;
    }


    public int getAge() {
        return Age;
    }



    @Override
    public String toString() {
        return (" \n | ID - " + this.getId() + "  " + this.getName() + "  " +  this.getSurname() + " | Age - " + this.getAge()+"  \n" );
    }

}

