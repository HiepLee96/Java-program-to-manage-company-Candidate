import java.net.IDN;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.regex.Pattern;

public class OperationToCandidate {
    private static Scanner scanner = new Scanner(System.in);
    private static String ID;
    private static String name;
    private static int birthYear = -1;
    private static String address;
    private static String phoneNumber;
    private static String email;

    private static int getYear(){
        Date date = new Date();
        String str = date.toString();
        String resultStr = "";
        for (int i = str.length()-4; i < str.length(); i++){
            resultStr += str.charAt(i);
        }
        int result = Integer.parseInt(resultStr);

        return result;
    }
    private static boolean checkEmail(String emailAddress) {
        String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9]+(\\.[A-Za-z0-9]+)$";
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    private static void clearAllVariableData(){
        ID = null;
        name = null;
        birthYear = -1;
        address = null;
        phoneNumber = null;
        email = null;
    }
    private static void insertGeneralData(){
        //General data
        System.out.print("Candidate ID? ");
        ID = scanner.nextLine();
        System.out.print("Candidate name? ");
        name = scanner.nextLine();
        System.out.print("candidate birth year? ");
        String birthYearStr;
        do {
            birthYearStr = scanner.nextLine();
            if (birthYearStr.length() != 4){        //Kiem tra chieu dai cua nam sinh
                System.out.println("Invalid data! Please enter again.");
            } else {
                //Kiem str nguoi dung nhap co chua ky tu chu so ko?
                boolean isDigit = true;
                for (int i = 0; i < birthYearStr.length(); i++){
                    if (Character.isLetter(birthYearStr.charAt(i))){
                        isDigit = false;
                    }
                }
                if (isDigit == false){              //Neu trong str co chua ky tu la thi bao loi
                    System.out.println("Invalid data! Please enter again.");
                } else {
                    //Kiem tra xem nam sinh do nguoi dung nhap vao co nam trong ko 1900 ~ nam hien tai ko?
                    int yearChecker = Integer.parseInt(birthYearStr);
                    if (yearChecker <= 1900 || yearChecker > getYear()){
                        System.out.println("Invalid data! Please enter again.");
                    } else {
                        birthYear = yearChecker;
                    }
                }
            }
        } while (birthYearStr.length() != 4 || birthYear == -1);
        System.out.print("Candidate address? ");
        address = scanner.nextLine();

        String phoneNumberStr;
        do {
            System.out.print("Candidate phone number? ");
            phoneNumberStr = scanner.nextLine();
            if (phoneNumberStr.length() < 10){     //Kiem tra chieu dai cua sdt
                System.out.println("Invalid data! Please enter again.");
            } else {
                //Kiem str nguoi dung nhap co chua ky tu chu so ko? Neu co chua ky tu la thi phoneNumber van bang -1
                boolean isDigit = true;
                for (int i = 0; i < phoneNumberStr.length(); i++){
                    if (Character.isLetter(phoneNumberStr.charAt(i))){
                        isDigit = false;
                    }
                }
                if (isDigit == false){              //Neu trong str co chua ky tu la thi bao loi
                    System.out.println("Invalid data! Please enter again.");
                } else {
                    phoneNumber = phoneNumberStr;
                }
            }

        } while (phoneNumberStr.length() < 10 || phoneNumber == null);
        do {
            System.out.print("Candidate email? ");
            email = scanner.nextLine();
            if (!checkEmail(email)){
                System.out.println("Invalid email! Please enter again.");
            }
        } while (!checkEmail(email));
    }


    public void insertExperienced(ArrayList<Person> candidateList){
        //input loai du lieu chung
        insertGeneralData();

        //Input du lieu cua nguoi co kinh nghiem
        System.out.print("Experienced year? ");
        int experienceYear;
        do {
            experienceYear = scanner.nextInt();
            scanner.nextLine();                              //Xu ly troi lenh
            if (experienceYear <= 0 || experienceYear > 100){
                System.out.println("Invalid data! Please enter again.");
            }
        } while (experienceYear <= 0 || experienceYear > 100);

        System.out.print("Pro skill? ");
        String proSkill = scanner.nextLine();

        ExperiencedCandidate newCandidate = new ExperiencedCandidate(ID, name, birthYear, address, phoneNumber, email,
                                            experienceYear, proSkill);
        candidateList.add(newCandidate);

        //Xoa tat ca du lieu trong bien de dung cho cac method sau
        clearAllVariableData();
    }

    public void insertFresher(ArrayList<Person> candidateList){
        //Input du lieu chung
        insertGeneralData();

        //Input du lieu rieng cua Fresher
        System.out.print("Graduation year? ");
        int graduationYear = -1;
        String graduationYearStr;
        do {
            graduationYearStr = scanner.nextLine();
            if (graduationYearStr.length() != 4){        //Kiem tra chieu dai cua nam sinh
                System.out.println("Invalid data! Please enter again.");
            } else {
                //Kiem str nguoi dung nhap co chua ky tu chu so ko?
                boolean isDigit = true;
                for (int i = 0; i < graduationYearStr.length(); i++){
                    if (Character.isLetter(graduationYearStr.charAt(i))){
                        isDigit = false;
                    }
                }
                if (isDigit == false){              //Neu trong str co chua ky tu la thi bao loi
                    System.out.println("Invalid data! Please enter again.");
                } else {
                    //Kiem tra xem nam sinh do nguoi dung nhap vao co nam trong ko 1900 ~ nam hien tai ko?
                    int yearChecker = Integer.parseInt(graduationYearStr);
                    if (yearChecker <= 1990 || yearChecker > getYear()){
                        System.out.println("Invalid data! Please enter again.");
                    } else {
                        graduationYear = yearChecker;
                    }
                }
            }
        } while (graduationYearStr.length() != 4 || birthYear == -1);
        System.out.println("Graduation rank? ");
        String graduationRank = null;
        int userChoice;
        do {
            System.out.println("1. Excellent");
            System.out.println("2. Good");
            System.out.println("3. Fair");
            System.out.println("4. Poor");
            userChoice = scanner.nextInt();
            scanner.nextLine();
            if (userChoice < 1 || userChoice > 4){
                System.out.println("Invalid option! Please pick again.");
            } else {
                switch (userChoice){
                    case 1 -> graduationRank = "Excellent";
                    case 2 -> graduationRank = "Good";
                    case 3 -> graduationRank = "Fair";
                    case 4 -> graduationRank = "Poor";
                }
            }
        } while (graduationRank == null);
        System.out.print("School name? ");
        String schoolName = scanner.nextLine();

        Fresher newFresher = new Fresher(ID, name, birthYear, address, phoneNumber, email, graduationYear,
                             graduationRank, schoolName);
        candidateList.add(newFresher);

        //Xoa data trong bien de khong anh huong toi cac lan su dung sau
        clearAllVariableData();
    }

    public void insertIntern(ArrayList<Person> candidateList){
        //Input du lieu chung
        insertGeneralData();

        //Input du lieu rieng cua Intern
        System.out.print("Specialization? ");
        String specialization = scanner.nextLine();
        System.out.print("Semester? ");
        int semester = scanner.nextInt();
        scanner.nextLine();
        System.out.print("School name? ");
        String schoolName = scanner.nextLine();

        Intern newIntern = new Intern(ID, name, birthYear, address, phoneNumber, email, specialization,
                           semester, schoolName);
        candidateList.add(newIntern);

        //Xoa data trong bien de khong anh huong toi cac lan su dung sau
        clearAllVariableData();
    }

    public void searchCandidate(ArrayList<Person> candidateList){
        //HIen thi toan bo danh sach ung vien co kinh nghiem
        System.out.println("========================EXPERIENCED CANDIDATE========================");
        for (int i = 0; i < candidateList.size(); i++){
            if (candidateList.get(i).classification == 1){
                System.out.println(candidateList.get(i).name);
            }
        }

        //HIen thi toan bo danh sach ung vien co Fresher
        System.out.println("==========================FRESHER CANDIDATE==========================");
        for (int i = 0; i < candidateList.size(); i++){
            if (candidateList.get(i).classification == 2){
                System.out.println(candidateList.get(i).name);
            }
        }

        //HIen thi toan bo danh sach ung vien co Intern
        System.out.println("==========================INTERN CANDIDATE==========================");
        for (int i = 0; i < candidateList.size(); i++){
            if (candidateList.get(i).classification == 3){
                System.out.println(candidateList.get(i).name);
            }
        }
        System.out.println();

        System.out.print("Enter candidate name? ");
        String name = scanner.nextLine().toLowerCase();
        System.out.print("Enter type of candidate? ");
        int typeCandidate = scanner.nextInt();
        scanner.nextLine();

        boolean isFound = false;
        for (int i = 0; i < candidateList.size(); i++){
            String str = candidateList.get(i).name.toLowerCase();

            if (str.contains(name) && candidateList.get(i).classification == typeCandidate){
                System.out.printf("%-16s | %-4d | %-16s | %-12s | %-24s | %d\n", candidateList.get(i).name,
                        candidateList.get(i).birthYear, candidateList.get(i).address, candidateList.get(i).phoneNumber,
                        candidateList.get(i).email, candidateList.get(i).classification);
                isFound = true;
            }
        }
        if (isFound == false){
            System.out.printf("There is no %s in the candidate list\n", name);
        }
    }
}
