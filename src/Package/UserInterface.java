package Package;

import Controllers.CompetitiveMemberController;
import Controllers.MemberController;
import Files.FileHandler;
import Finance.FinanceHandler;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner;
    Club club;
    MemberController memberController;
    CompetitiveMemberController competitiveMemberController;
    FinanceHandler financeHandler;
    FileHandler fileHandler;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.club = new Club();
        this.memberController = new MemberController(scanner, club);
        this.competitiveMemberController = new CompetitiveMemberController(scanner, club);
        this.financeHandler = new FinanceHandler(club);
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
            System.out.println("2. Load members file");
            System.out.println("3. View list of current members");
            System.out.println("4. Return to main menu");
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
                    case 2 -> fileHandler.loadFile();
                    case 3 -> club.displayMembers();
                    case 4 -> b = false;
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
            System.out.println("1. Show unpaid members");
            System.out.println("2. Show yearly payment overview");
            System.out.println("3. Return to main menu");

            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                switch (input) {
                    //case 1 -> unpaidMenu();          // mangler lige nu
                    case 2 -> System.out.println(
                            "Forventet årlig indtægt:" +
                                    financeHandler.getTotalAnnualIncome());
                    case 3 -> b = false;             // gør det muligt at vende tilbage
                    default -> System.out.println("Error! Only numbers 1-3 allowed.");
                }
            } catch (InputMismatchException e){
                System.out.println("Error! Only numbers allowed");
                scanner.nextLine();
            }
        }
    }

    public void swimmerMenu() {
        System.out.println();
        System.out.println("1. Top 5 display");
        System.out.println("2. Tournament results");
        System.out.println("3. Training results");
        System.out.println("4. Return to main menu");
    }
}
