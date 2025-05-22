package Controllers;
import Files.FileHandler;
import Package.Club;
import Members.Member;
import java.util.Scanner;

public class MemberController extends AbstractController {
    public MemberController(Scanner scanner, Club club) {
        super(scanner, club);
    }

    public void registerNewMember(FileHandler fileHandler) {
        String name = getName();
        int age = getAge();
        String phoneNumber = getPhoneNumber();
        boolean active = selectMembershipType();
        boolean paid = selectPaymentStatus();

        club.addMember(new Member(name, age, phoneNumber, active, paid));
        System.out.println("New member: " + name + " successfully registered.");

        fileHandler.saveFile("./ClubData/MemberInfo");
    }
}


