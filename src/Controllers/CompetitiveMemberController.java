package Controllers;

import Package.Club;
import Package.Discipline;
import Members.CompetitiveMember;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CompetitiveMemberController extends AbstractController {

    private Club club;

    public CompetitiveMemberController(Scanner scanner, Club club) {
        super(scanner);
        this.club = club;
    }

    public void registerNewCompMember() {
        String name = getName();
        int age = getAge();
        long phoneNumber = getPhoneNumber();
        boolean active = selectMembershipType();
        boolean paid = selectPaymentStatus();
        ArrayList<Discipline> disciplines = selectDisciplines();
        String team = (age <= 18) ? "junior" : "senior";

        club.addMember(new CompetitiveMember(name, age, phoneNumber, active, paid, disciplines, team));
        System.out.println("New competitive member: " + name + " successfully registered.");
    }

    private ArrayList<Discipline> selectDisciplines() {
        ArrayList<Discipline> chosenDisciplines = new ArrayList<>();
        boolean keepChoosing = true;

        while (keepChoosing) {
            System.out.println("Choose a discipline:");
            System.out.println("1. Butterfly");
            System.out.println("2. Freestyle");
            System.out.println("3. Backstroke");
            System.out.println("4. Breaststroke");

            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error! Please enter a valid number.");
                scanner.nextLine();
                continue;
            }

            Discipline selected = null;
            switch (choice) {
                case 1:
                    selected = Discipline.BUTTERFLY;
                    break;
                case 2:
                    selected = Discipline.FREESTYLE;
                    break;
                case 3:
                    selected = Discipline.BACKSTROKE;
                    break;
                case 4:
                    selected = Discipline.BREASTSTROKE;
                    break;
                default:
                    System.out.println("Error! Please choose a number between 1 and 4.");
                    continue;
            }

            if (selected != null && !chosenDisciplines.contains(selected)) {
                chosenDisciplines.add(selected);
                System.out.println(selected.getDisplayName() + " added.");
            } else {
                System.out.println("That discipline is already selected.");
            }

            System.out.println("Do you want to add another discipline? (yes/no)");
            String answer = scanner.nextLine().toLowerCase().trim();
            if (answer.equals("no")) {
                keepChoosing = false;
            }
        }
        return chosenDisciplines;
    }
}
