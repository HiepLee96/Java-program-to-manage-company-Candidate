public abstract class Person {
    public String ID;
    public String name;
    public int birthYear;
    public String address;
    public String phoneNumber;
    public String email;
    public int classification;

    public Person (String ID, String name, int birthYear, String address, String phoneNumber, String email, int classification){
        this.ID = ID;
        this.name = name;
        this.birthYear = birthYear;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.classification = classification;
    }


}
