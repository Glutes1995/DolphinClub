package Jamms;

import java.util.ArrayList;

public class Competitive extends Member {
    ArrayList<Record> records;
    ArrayList<Discipline> disciplines;

    public Competitive(String name, int age, boolean active, boolean paid, ArrayList<Discipline> disciplines, ArrayList<Record> records) {
        super(name, age, active, paid);
        this.disciplines = disciplines;
        this.records = records;

    }

    @Override
    public String toString() {
        String discs = "Disciplines: ";
        String recs = "Records:\n";
        for (Discipline discipline : disciplines) {
            discs += discipline + " ";
        }
        for (Record record : records) {
            recs += record + "\n";
        }

        return "Member ID: " + memberID + "\n" +
                "Name: " + name + "\n" +
                discs + "\n" +
                recs;
    }

}
