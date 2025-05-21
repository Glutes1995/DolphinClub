package Members;
import Package.*;
import java.util.ArrayList;

public class CompetitiveMember extends Member {
    private ArrayList<Discipline> discipline;
    private String team;

    public CompetitiveMember(String name, int age, String phoneNumber, boolean active, boolean paid, ArrayList<Discipline> discipline, String team) {
        super(name, age, phoneNumber, active, paid);
        this.discipline = discipline;
        this.team = team;
    }

    @Override
    public String toString() {
        String isActive;
        String hasPaid;
        if (active) {
            isActive = "yes";
        } else {
            isActive = "no";
        }
        if (paid) {
            hasPaid = "yes";
        } else {
            hasPaid = "no";
        }
        return name + ";" + age + ";" + phoneNumber + ";" + isActive + ";" + hasPaid + ";" + discipline + ";" + team;
    }
}
