/* ==============================
   2)  FinanceHandler
   ============================== */

package Finance;

import Package.Club;
import Members.Member;
import java.util.List;

public class FinanceHandler {

    private final Club club;

    private double cachedTotal;

    public FinanceHandler(Club club) {
        this.club = club;
        recalculate(); //
    }
    /* Metode der bruges til at regne på den totale sum*/
    /** Kaldes når medlemslisten ændres */

    public void recalculate() {
        double sum = 0;

        for (Member m : club.getMembers()){
            sum += m.getAnnualFee();
        }

        cachedTotal = sum;
    }

    /** Dette bliver kaldt for at få selve summen */
    public double getTotalAnnualIncome() {
        return cachedTotal;
    }
}
