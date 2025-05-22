package Records;

import Members.CompetitiveMember;
import Package.Discipline;
import Package.Club;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Record {

    private String phoneNumber;
    private Discipline discipline;
    private double timeInSeconds;
    private LocalDate date;
    private String type;
    private String team;

    public Record(String phoneNumber, Discipline discipline, double timeInSeconds, LocalDate date, String type, String team) {
        this.phoneNumber = phoneNumber;
        this.discipline = discipline;
        this.timeInSeconds = timeInSeconds;
        this.date = date;
        this.type = type;
        this.team = team;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public double getTimeInSeconds() {
        return timeInSeconds;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getTeam() {
        return team;
    }

    public String getFormattedTime() {
        int minutes = (int) timeInSeconds / 60;
        double seconds = timeInSeconds % 60;
        return String.format("%02d:%05.2f", minutes, seconds);
    }

    public void showRecords() {
        System.out.println("[" + type + "]" + discipline +
                " | Tid: " + getFormattedTime() +
                " | Dato: " + date +
                " | ID: " + phoneNumber +
                " | Team: " + team);
    }

    public String toString() {
        return type + ";" + phoneNumber + ";" + discipline + ";" +
                timeInSeconds + ";" + date + ";" + team;
    }
}