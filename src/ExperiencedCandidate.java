public class ExperiencedCandidate extends Person {
    private int experienceYear;
    private String proSkill;

    public ExperiencedCandidate(String ID, String name, int birthYear, String address, String phoneNumber, String email,
                                int experienceYear, String proSkill){
        super(ID, name, birthYear, address, phoneNumber, email, 1);
        this.experienceYear = experienceYear;
        this.proSkill = proSkill;
    }

    @Override
    public String toString(){
        return String.format("%-16s | %-10d | %-16s | %-12s | %-24s | %-16d | %-16s", super.name, super.birthYear, super.address,
                             super.phoneNumber, super.email, this.experienceYear, this.proSkill);
    }

}
