package Jamms;

import java.util.ArrayList;

public class Competetive extends Member {
    Record record;
    ArrayList<Discipline> disciplines = new ArrayList<>();

    public Competetive(String name, int age, boolean active, boolean paid, Discipline discipline, Record record) {
        super(name, age, active, paid);
        disciplines.add(discipline);
        this.record = record;

    }

    @Override
    public String toString() {
        return name + " " + memberID + " " + disciplines + " " + record;
    }

}
