package Finance;

import Package.Club;
import Members.Member;

public class FinanceHandler {

    private final Club club;      // referere til klubben

    public FinanceHandler(Club club) {
        this.club = club;
    }

     /* Beregner den forventede samlede årlige indtægt */

    public double getTotalAnnualIncome() {
        double sum = 0;

        for (Member m : club.getMembers()) {
            sum += m.getAnnualFee();   // getAnnualFee er på Member klassen,
        }
        return sum;
    }
}
