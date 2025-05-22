package Records;

import Members.*;
import Package.*;
import Controllers.*;
import Files.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class RecordManager {
    Scanner scanner;
    private Club club;
    private FileHandler fileHandler;
    private CompetitiveMemberController competitiveMemberController;
    private static final String FILE_PATH = "./ClubData/MemberRecords";
    private ArrayList<Record> records = new ArrayList<>();


    public RecordManager (Club club, Scanner scanner) {
        this.club = club;
        this.fileHandler = new FileHandler(club);
        this.scanner = scanner;
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    public String toString() {
        String info = "type;phoneNumber;discipline;timeInSeconds;date;team" + "\n";
        for (Record record : records) {
            info += record + "\n";
        }
        return info;
    }

    public void registerNewRecord() {
        System.out.println("Indtast telefonnummer på svømmeren:");
        String phone = scanner.nextLine();

        CompetitiveMember cm = competitiveMemberController.findCompetitiveMemberByPhone(phone);
        if (cm == null) {
            System.out.println("Medlem ikke fundet.");
            return;
        }

        System.out.println("Indtast tid i sekunder (fx 91.5):");
        double time = scanner.nextDouble();
        scanner.nextLine();

        LocalDate date = LocalDate.now();

        System.out.println("Er rekorden sat til træning eller konkurrence?");
        String type = scanner.nextLine();

        Record record = new Record(cm.getPhoneNumber(), cm.getDiscipline(), time, date, type, cm.getTeam());
        records.add(record);

        fileHandler.saveFile(FILE_PATH);
        System.out.println("Rekord gemt.");
    }

    public void showTop5PerDiscipline(Discipline valgtDisciplin) {
        // 1. Filtrér rekorder med den valgte disciplin
        ArrayList<Record> filteredByDiscipline = new ArrayList<>();
        for (Record r : records) {
            if (r.getDiscipline() == valgtDisciplin) {
                filteredByDiscipline.add(r);
            }
        }

        // 2. Opdel i junior og senior
        ArrayList<Record> junior = new ArrayList<>();
        ArrayList<Record> senior = new ArrayList<>();
        for (Record r : filteredByDiscipline) {
            if (r.getTeam().equalsIgnoreCase("junior")) {
                junior.add(r);
            } else if (r.getTeam().equalsIgnoreCase("senior")) {
                senior.add(r);
            }
        }

        // 3. Sortér efter tid
        junior.sort(Comparator.comparingDouble(Record::getTimeInSeconds));
        senior.sort(Comparator.comparingDouble(Record::getTimeInSeconds));

        // 4. Print JUNIOR top 5
        System.out.println("\nTop 5 Junior (" + valgtDisciplin.getDisplayName() + "):");
        for (int i = 0; i < Math.min(5, junior.size()); i++) {
            Record r = junior.get(i);
            String name = competitiveMemberController.findCompetitiveMemberByPhone(r.getPhoneNumber()).getName();  // 🔍 navn fundet
            System.out.println((i + 1) + ". " + name + " - " + r.getFormattedTime() + " (" + r.getDate() + ")");
        }

        // 5. Print SENIOR top 5
        System.out.println("\nTop 5 Senior (" + valgtDisciplin.getDisplayName() + "):");
        for (int i = 0; i < Math.min(5, senior.size()); i++) {
            Record r = senior.get(i);
            String name = competitiveMemberController.findCompetitiveMemberByPhone(r.getPhoneNumber()).getName();
            System.out.println((i + 1) + ". " + name + " - " + r.getFormattedTime() + " (" + r.getDate() + ")");
        }
    }
}
