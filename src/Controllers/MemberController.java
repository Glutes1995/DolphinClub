package Controllers;
import Files.FileHandler;
import Package.Club;
import Members.Member;
import java.util.Scanner;

public class MemberController extends AbstractController {

    private Club club;
    FileHandler fileHandler;

    public MemberController(Scanner scanner, Club club) {
        super(scanner);
        this.club = club;
        this.fileHandler = new FileHandler(club);
    }

    public void registerNewMember() {
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


