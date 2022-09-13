public class Fresher extends Person {
    private int graduationYear;
    private String graduationRank;
    private String schoolName;

    public Fresher(String ID, String name, int birthYear, String address, String phoneNumber, String email,
                   int graduationYear, String graduationRank, String schoolName){
        super(ID, name, birthYear, address, phoneNumber, email, 2);
        this.graduationYear = graduationYear;
        this.graduationRank = graduationRank;
        this.schoolName = schoolName;
    }

    @Override
    public String toString(){
        return String.format("%-16s | %-10d | %-16s | %-12s | %-24s | %-16d | %-16s | %-20s", super.name, super.birthYear, super.address,
                super.phoneNumber, super.email, this.graduationYear, this.graduationRank, this.schoolName);
    }
}
