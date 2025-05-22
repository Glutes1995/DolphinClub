package Finance;
import Files.FileHandler;
import Package.Club;
import Members.Member;
import java.util.ArrayList;

public class FinanceHandler {
    private Club club;
    private FileHandler fileHandler;

    public FinanceHandler(Club club) {
        this.club = club;
        this.fileHandler = new FileHandler(club);
    }

    public double calculateAnnualMemberFee(Member member) {
        int age = member.getAge();

        if (!member.isActive()) {
            return MembershipFee.PASSIVE.getValue();
        } else if (age < 18) {
            return MembershipFee.JUNIOR.getValue();
        } else if (age >= 60) {
            return MembershipFee.SENIOR.getValue() * (1 - MembershipFee.SENIOR_DISCOUNT.getValue());
            // 1000 * (1 - 0.25) = 1000 * 0.75 = 750 kr.
        } else {
            return MembershipFee.SENIOR.getValue();
        }
    }

    public double getTotalAnnualIncome() {
        double total = 0;
        for (Member member : club.getMembers()) {
                total += calculateAnnualMemberFee(member);
        }
        return total;
    }

    public ArrayList<Member> getMembersInDebt() {
        ArrayList<Member> debtors = new ArrayList<>();
        for (Member member : club.getMembers()) {
            if (!member.isPaid()) {
                debtors.add(member);
            }
        }
        return debtors;
    }

    public boolean registerPayment(String phoneNumber) {
        for (Member member : club.getMembers()) {
            if (String.valueOf(member.getPhoneNumber()).equals(phoneNumber)) {
                if (!member.isPaid()) {
                    member.setPaid(true);
                    fileHandler.saveFile("./ClubData/MemberInfo");
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
