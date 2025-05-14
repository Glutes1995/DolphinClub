import java.util.InputMismatchException;
import java.util.Scanner;

// Måtte implementere denne klasse pga. DRY (Don't Repeat Yourself)
// Ellers ville der være duplicated kode i begge forrige controller klasse.....
// (ja ved det godt, endnu klasse lol)
// Men denne måde følger OOP.

public class BaseMemberController {
    protected Scanner scanner;

    public BaseMemberController(Scanner scanner) {
        this.scanner = scanner;
    }

    protected String getName() {
        System.out.println("Enter name:");
        return scanner.nextLine();
    }

    protected int getAge() {
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

    protected long getPhoneNumber() {
        long phoneNumber = 0;
        System.out.println("Enter phone number:");
        while (true) {
            try {
                phoneNumber = scanner.nextLong();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error! Only numbers allowed!");
                scanner.nextLine();
            }
        }
        return phoneNumber;
    }

    protected boolean selectMembershipType() {
        System.out.println("Does the member wish an active or passive membership?");
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

    protected boolean selectPaymentStatus() {
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
