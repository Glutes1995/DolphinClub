package Package;
import Controllers.CompetitiveMemberController;
import Controllers.MemberController;
import Files.FileHandler;
import Finance.FinanceHandler;
import Members.Member;
import Records.RecordManager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Club club;
    private MemberController memberController;
    private CompetitiveMemberController competitiveMemberController;
    private FinanceHandler financeHandler;
    private FileHandler fileHandler;
    private RecordManager recordManager;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.club = new Club();
        this.memberController = new MemberController(scanner, club);
        this.competitiveMemberController = new CompetitiveMemberController(scanner, club);
        this.financeHandler = new FinanceHandler(club);
        this.fileHandler = new FileHandler(club);
        this.recordManager = new RecordManager(club, scanner);
        fileHandler.loadFile("./ClubData/MemberInfo");
        /*
        fileHandler.loadFile("./ClubData/MemberRecords");
*/
    }

    public void startProgram() {
        System.out.println("Welcome to Dolphin Club's admin panel");

        while (true) {
            System.out.println("Enter username (admin): ");
            String username = scanner.nextLine();
            System.out.println("Enter password (123): ");
            String password = scanner.nextLine();

            if (username.equals("admin") && password.equals("123")) {
                break;
            } else {
                System.out.println("Wrong! Try again.");
            }
        }
        mainMenu();
    }

    public void mainMenu() {
        System.out.println();
        System.out.println("Choose (1-4)");

        while (true) {
            System.out.println();
            System.out.println("1. Member management");
            System.out.println("2. Financial overview");
            System.out.println("3. Swimmer statistics");
            System.out.println("4. Exit");

            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                switch (input) {
                    case 1 -> memberMenu();
                    case 2 -> financeMenu();
                    case 3 -> swimmerMenu();
                    case 4 -> {
                        System.out.println("...exiting...");
                        return;
                    }
                    default -> System.out.println("Error! Only numbers from 1-4 allowed.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error! Only numbers allowed.");
            }
        }
    }

    public void memberMenu() {

        boolean b = true;
        while (b) {
            System.out.println();
            System.out.println("1. Register new member");
            System.out.println("2. View list of current members");
            System.out.println("3. Return to main menu");
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                switch (input) {
                    case 1 -> {
                        while (true) {
                            System.out.println("Is the member a competitive swimmer? (yes or no)");
                            String answer = scanner.nextLine().trim().toLowerCase();

                            if (answer.equals("yes")) {
                                competitiveMemberController.registerNewCompMember();
                                break;
                            } else if (answer.equals("no")) {
                                memberController.registerNewMember();
                                break;
                            } else {
                                System.out.println("Error! Only 'yes' or 'no' is allowed.");
                            }
                        }
                    }
                    case 2 -> club.displayMembers();
                    case 3 -> b = false;
                    default -> System.out.println("Error! Only numbers from 1-4 allowed.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error! Only numbers allowed.");
                scanner.nextLine();
            }
        }
    }

    public void financeMenu() {
        boolean b = true;
        while (b) {
            System.out.println();
            System.out.println("1. Show members with outstanding payments");
            System.out.println("2. Register payment");
            System.out.println("3. View expected yearly income");
            System.out.println("4. Return to main menu");

            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                switch (input) {
                    case 1 -> {
                        ArrayList<Member> debtors = financeHandler.getMembersInDebt();
                        if (debtors.isEmpty()) {
                            System.out.println("There are no members in debt.");
                        } else {
                            for (Member debtor : debtors) {
                                System.out.println("Name: " + debtor.getName() + ", Phonenumber: " + debtor.getPhoneNumber() + ", Amount owed: "  + financeHandler.calculateAnnualMemberFee(debtor) + " kr.");
                            }
                        }
                    }
                   case 2-> {
                       System.out.println("Enter phone number for member:");
                       String phoneNumber = scanner.nextLine();
                       boolean success = financeHandler.registerPayment(phoneNumber);
                       if (success) {
                           System.out.println("Payment registered for phonenumber " + phoneNumber);
                       } else {
                           System.out.println("Error! Payment could not be registered for phonenumber " + phoneNumber);
                       }
                   }
                   case 3 -> System.out.println("Expected total income: " + financeHandler.getTotalAnnualIncome() + " kr.");
                   case 4 -> b = false;
                    default -> System.out.println("Error! Only numbers 1-3 allowed.");
                }
            } catch (InputMismatchException e){
                System.out.println("Error! Only numbers allowed");
                scanner.nextLine();
            }
        }
    }

    public void swimmerMenu() {
        boolean b = true;
        while (b) {
            System.out.println();
            System.out.println("1. Register new record");
            System.out.println("2. Show top 5 by discipline");
            System.out.println("3. Return to main menu.");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // fanger linjeskift

                switch (choice) {
                    case 1 -> recordManager.registerNewRecord();

                    case 2 -> { // recordManager.
                        // Her vælger brugeren en disciplin med tal
                        System.out.println("Choose discipline:");
                        System.out.println("1. Butterfly");
                        System.out.println("2. Freestyle");
                        System.out.println("3. Backstroke");
                        System.out.println("4. Breaststroke");

                        int disciplineChoice = scanner.nextInt();
                        scanner.nextLine(); // fanger linjeskift

                        Discipline valgt = null;

                        if (disciplineChoice == 1) valgt = Discipline.BUTTERFLY;
                        else if (disciplineChoice == 2) valgt = Discipline.FREESTYLE;
                        else if (disciplineChoice == 3) valgt = Discipline.BACKSTROKE;
                        else if (disciplineChoice == 4) valgt = Discipline.BREASTSTROKE;
                        else {
                            System.out.println("Invalid choice.");
                            break;
                        }

                        recordManager.showTop5PerDiscipline(valgt);
                    }

                    case 3 -> b = false;

                    default -> System.out.println("Only numbers from 1 to 3 are allowed.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error! Please enter a number.");
                scanner.nextLine(); // rydder scanner
            }
        }
    }
}
