package Controllers;

import java.util.InputMismatchException;
import java.util.Scanner;

import Package.Club;

public abstract class AbstractController implements ControllerInterface {
    protected Scanner scanner;
    protected Club club;

    public AbstractController(Scanner scanner, Club club) {
        this.scanner = scanner;
        this.club = club;
    }

    @Override
    public String getName() {
        System.out.println("Enter name:");
        return scanner.nextLine();
    }

    @Override
    public int getAge() {
        int age;
        System.out.println("Enter age:");
        while (true) {
            try {
                age = scanner.nextInt();
                scanner.nextLine();

                if (age >= 0 && age <= 99) {
                    break;
                } else {
                    System.out.println("Error! Members can only be 0-99.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error! Only numbers are allowed.");
                scanner.nextLine();
            }
        }
        return age;
    }

    @Override
    public String getPhoneNumber() {
        System.out.println("Enter phone number:");
        while (true) {
            String phoneNumber = scanner.nextLine().trim();

            boolean allDigits = true;
            for (int i = 0; i < phoneNumber.length(); i++) {
                char c = phoneNumber.charAt(i);
                if (c < '0' || c > '9') {
                    allDigits = false;
                    break;
                }
            }

            if (allDigits) {
                System.out.println("Phone number " + phoneNumber + " registered.");
                return phoneNumber;
            } else {
                System.out.println("Error! You can only enter digits.");
            }
        }
    }

    @Override
    public boolean selectMembershipType() {
        System.out.println("Does the member wish an active or passive membership? (1-2)");
        System.out.println("1. Active");
        System.out.println("2. Passive");
        boolean active = true;

        while (true) {
            try {
                int memChoice = scanner.nextInt();
                scanner.nextLine();

                if (memChoice == 1) {
                    active = true;
                    break;
                } else if (memChoice == 2) {
                    active = false;
                    break;
                } else {
                    System.out.println("Error! Only numbers 1-2 allowed.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error! Only numbers allowed!");
                scanner.nextLine();
            }
        }
        return active;
    }

    @Override
    public boolean selectPaymentStatus() {
        System.out.println("Is user paying now? 'yes' or 'no'");
        boolean paid = false;

        while (true) {
            String answer = scanner.nextLine().trim().toLowerCase();

            if (answer.equals("yes")) {
                paid = true;
                break;
            } else if (answer.equals("no")) {
                paid = false;
                break;
            } else {
                System.out.println("Error! Only 'yes' or 'no' is allowed.");
            }
        }
        return paid;
    }
}