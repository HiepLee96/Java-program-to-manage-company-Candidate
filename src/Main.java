import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Person> candidateList = new ArrayList<>();

    public static void showMenu(){
        System.out.println("+------------Menu----------+");
        System.out.println("|      1.Experienced       |");
        System.out.println("|      2.Fresher           |");
        System.out.println("|      3.Intern            |");
        System.out.println("|      4.Search            |");
        System.out.println("|      0.Exit              |");
        System.out.println("+--------------------------+");
        System.out.print("Your choice? ");
    }

    public static void main(String[] args){
        OperationToCandidate exercise2 = new OperationToCandidate();

        int userChoice;
        do {
            showMenu();
            userChoice = scanner.nextInt();
            scanner.nextLine();             //Xu ly chong troi lenh
            if (userChoice < 1 || userChoice > 4){
                System.out.println("Invalid option! Please pick again.");
            } else {
                switch (userChoice){
                    case 1 -> {
                        String continueOrNot = "Y";
                        while (continueOrNot.compareToIgnoreCase("Y") == 0){
                            exercise2.insertExperienced(candidateList);
                            System.out.print("Do you want to continue(Y/N)? ");
                            continueOrNot = scanner.next();
                            scanner.nextLine();
                        }
                        //Neu user nhap vao No thi in ra toan bo danh sach
                        System.out.println("================== EXPERIENCED CANDIDATE===================");
                        System.out.printf("%-16s | %-10s | %-16s | %-12s | %-24s | %-16s | %-16s\n", "Name",
                                "Birth year", "Address", "Phone number", "Email", "Experienced year", "Pro skill");
                        System.out.println("--------------------------------------------------------------------" +
                                "----------------------------------------------------------------");
                        for (int i = 0; i < candidateList.size(); i++){
                            if (candidateList.get(i).classification == 1){
                                System.out.println(candidateList.get(i));
                            }
                        }
                        System.out.println();
                    }
                    case 2 -> {
                        String continueOrNot = "Y";
                        while (continueOrNot.compareToIgnoreCase("Y") == 0){
                            exercise2.insertFresher(candidateList);
                            System.out.print("Do you want to continue(Y/N)? ");
                            continueOrNot = scanner.next();
                            scanner.nextLine();
                        }
                        //Neu user nhap vao No thi in ra toan bo danh sach
                        System.out.println("========================= FRESHER=========================");
                        System.out.printf("%-16s | %-10s | %-16s | %-12s | %-24s | %-16s | %-16s | %-20s\n", "Name",
                                "Birth year", "Address", "Phone number", "Email", "Graduation year",
                                "Graduation rank", "School name");
                        System.out.println("--------------------------------------------------------------------" +
                                "----------------------------------------------------------------");
                        for (int i = 0; i < candidateList.size(); i++){
                            if (candidateList.get(i).classification == 2){
                                System.out.println(candidateList.get(i));
                            }
                        }
                        System.out.println();
                    }
                    case 3 -> {
                        String continueOrNot = "Y";
                        while (continueOrNot.compareToIgnoreCase("Y") == 0){
                            exercise2.insertIntern(candidateList);
                            System.out.print("Do you want to continue(Y/N)? ");
                            continueOrNot = scanner.next();
                            scanner.nextLine();
                        }
                        //Neu user nhap vao No thi in ra toan bo danh sach
                        System.out.println("========================= FRESHER=========================");
                        System.out.printf("%-16s | %-10s | %-16s | %-12s | %-24s | %-16s | %-6s | %-20s\n", "Name",
                                "Birth year", "Address", "Phone number", "Email", "Specialization",
                                "Semester", "School name");
                        System.out.println("--------------------------------------------------------------------" +
                                "----------------------------------------------------------------");
                        for (int i = 0; i < candidateList.size(); i++){
                            if (candidateList.get(i).classification == 3){
                                System.out.println(candidateList.get(i));
                            }
                        }
                        System.out.println();
                    }
                    case 4 -> exercise2.searchCandidate(candidateList);
                }
            }
        } while (userChoice != 0);

    }
}
