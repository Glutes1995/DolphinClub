package Members;

import Package.*;

import java.util.ArrayList;

import Records.*;
import Package.Record;

public class CompetitiveMember extends Member {
    private Discipline discipline;
    private String team;

    public CompetitiveMember(String name, int age, String phoneNumber, boolean active, boolean paid, Discipline discipline, String team) {
        super(name, age, phoneNumber, active, paid);
        this.discipline = discipline;
        this.team = team;
    }
    
    public String getTeam() {
        return team;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    @Override
    public String toString() {
        return "CompetitiveMember{" +
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