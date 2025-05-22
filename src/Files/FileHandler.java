package Files;

import java.io.*;
import java.util.Scanner;

import Members.CompetitiveMember;
import Members.Member;
import Package.*;
import java.time.LocalDate;
import Records.*;
import Records.Record;

public class FileHandler {
    Club club;
    RecordManager recordManager;

    public FileHandler(Club club) {
        this.club = club;
    }

    public void saveFile(String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path, false);
            PrintStream ps = new PrintStream(fos);
            if (path.equals("./ClubData/MemberInfo")) {
                ps.print(club);
                ps.close();
            }
            if (path.equals("./ClubData/MemberRecords")) {
                ps.print(recordManager);
                ps.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public void loadFile(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));
                while (scanner.hasNextLine()) {
                    String[] arr = scanner.nextLine().split(";");
                    //load member file
                    if (path.equals("./ClubData/MemberInfo")) {
                        if (!arr[0].equalsIgnoreCase("name")) {
                            String name = arr[0];
                            int age = Integer.parseInt(arr[1]);
                            String phoneNumber = arr[2];
                            boolean active = Boolean.parseBoolean(arr[3]);
                            boolean paid = Boolean.parseBoolean(arr[4]);
                            if (arr[3].equalsIgnoreCase("yes")) active = true;
                            if (arr[4].equalsIgnoreCase("yes")) paid = true;
                            if (arr.length == 5) {
                                Member member = new Member(name, age, phoneNumber, active, paid);
                                club.getMembers().add(member);
                            } else {
                                Discipline discipline = null;
                                switch (arr[5]) {
                                    case "Freestyle" -> discipline = Discipline.FREESTYLE;
                                    case "Butterfly" -> discipline = Discipline.BUTTERFLY;
                                    case "Breaststroke" -> discipline = Discipline.BREASTSTROKE;
                                    case "Backstroke" -> discipline = Discipline.BACKSTROKE;
                                    default -> System.out.println("No discipline");
                                }
                                String team = arr[6];

                                CompetitiveMember compMember = new CompetitiveMember(name, age, phoneNumber, active, paid, discipline, team);
                                club.getMembers().add(compMember);
                            }
                        }
                    } //load record file
                    else {
                        if (!arr[0].equalsIgnoreCase("type")) {

                        String type = arr[0];
                        String phoneNumber = arr[1];
                        Discipline discipline = Discipline.valueOf(arr[2]);
                        double time = Double.parseDouble(arr[3]);
                        LocalDate date = LocalDate.parse(arr[4]);
                        String team = arr[5];

                        Record record = new Record(phoneNumber, discipline, time, date, type, team);
                        recordManager.getRecords().add(record);
                        }
                    }
                }
            scanner.close();
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
}