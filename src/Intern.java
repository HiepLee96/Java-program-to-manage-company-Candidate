public class Intern extends Person{
    private String specialization;
    private int semester;
    private String schoolName;

    public Intern(String ID, String name, int birthYear, String address, String phoneNumber, String email,
                  String specialization, int semester, String schoolName){
        super(ID, name, birthYear, address, phoneNumber, email, 3);
        this.specialization = specialization;
        this.semester = semester;
        this.schoolName = schoolName;
    }

    public String toString(){
        return String.format("%-16s | %-10d | %-16s | %-12s | %-24s | %-16s | %-6d | %-20s", super.name, super.birthYear, super.address,
                super.phoneNumber, super.email, this.specialization, this.semester, this.schoolName);
    }
}
