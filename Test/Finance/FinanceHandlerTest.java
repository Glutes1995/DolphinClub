package Finance;
import Members.Member;
import Package.Club;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FinanceHandlerTest {
    Club club;

    FinanceHandler financeHandler = new FinanceHandler(club);

    @org.junit.jupiter.api.Test
    void testPassiveMemberFee() {
        Member passiveMember = new Member("Passive", 35, 20304050,false,true);
        double expectedPassiveFee = MembershipFee.PASSIVE.getValue();
        assertEquals(expectedPassiveFee, financeHandler.calculateAnnualMemberFee(passiveMember));
    }

    @Test
    void testSeniorDiscountFee() {
        Member seniorDiscountMember = new Member("SeniorDiscount", 65, 10404050,true,true);
        double expectedSeniorDiscountFee = MembershipFee.SENIOR.getValue() * (1 - MembershipFee.SENIOR_DISCOUNT.getValue());
        assertEquals(expectedSeniorDiscountFee, financeHandler.calculateAnnualMemberFee(seniorDiscountMember));
    }
}