package Members;
import Package.*;
import java.util.ArrayList;

public class CompetitiveMember extends Member {
    ArrayList<Discipline> discipline;
    String team;

    public CompetitiveMember(String name, int age, long phoneNumber, boolean active, boolean paid, ArrayList<Discipline> discipline, String team) {
        super(name, age, phoneNumber, active, paid);
        this.discipline = discipline;
        this.team = team;
    }

    @Override
    public String toString() {
        return "Members.CompetitiveMember{" +
                "discipline=" + discipline +
                ", team='" + team + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                ", active='" + active + '\'' +
                ", paid=" + paid +
                '}';
    }
}
